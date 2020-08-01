package com.regex.admin.web.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.sys.MenuDTO;
import com.regex.admin.common.dto.sys.UserDTO;
import com.regex.admin.service.sys.IMenuService;
import com.regex.admin.service.sys.IRoleMenuService;
import com.regex.admin.web.controller.BaseController;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;
import com.regex.admin.web.controller.vo.sys.MenuVO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * menu controller
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("sys/menu")
public class MenuController extends BaseController {
    
    @Autowired
    private IMenuService menuService;
    
    @Autowired
    private IRoleMenuService roleMenuService;
    
    /**
     * 
     * 功能描述: <br>
     * 展示menu列表
     *
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequiresPermissions("menu:show")
    @RequestMapping(value = {"show"})
    public String shwoMenu(Model model) {
        try {
            List<MenuDTO> menuShowList = getMenuList(0);
            model.addAttribute("menuShowList", menuShowList);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "sys/menu/show";
    }
    
    /**
     * 
     * 功能描述: <br>
     * 获取menu的树
     *
     * @param response
     * @param session
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequiresPermissions("menu:show")
    @RequestMapping(value = {"getMenuTree"})
    public void getMenuTreeJson(HttpServletResponse response, HttpSession session) {
        List<MenuVO> menuShowList = getMenuVOList(0);
        MenuVO menuVO = new MenuVO();
        menuVO.setId(0);
        menuVO.setName("根目录");
        menuVO.setSpread(true);
        menuVO.setChildren(menuShowList);
        List<MenuVO> menuVOList = new ArrayList<MenuVO>();
        menuVOList.add(menuVO);
        WebInfoFilter.flag = 1;
        AjaxUtil.ajaxJsonSucMessage(response, menuVOList);
    }
    
    @RequiresPermissions("menu:save")
    @RequestMapping(value = {"tosave"})
    public String tosave(String id, Model model, String parentId) {
        MenuVO menuParentVO = new MenuVO();
        if(StringUtils.isNotEmpty(id)) {
            MenuDTO menuDTO = menuService.getById(Long.parseLong(id));
            if(menuDTO.getParentId() != 0) {
                MenuDTO menuParent = menuService.getById(menuDTO.getParentId());
                menuParentVO.setId(menuDTO.getParentId());
                menuParentVO.setName(menuParent.getName());
            }
            model.addAttribute("menuDTO", menuDTO);
        } 
        if(StringUtils.isNotEmpty(parentId)) {
            MenuDTO menuParent = menuService.getById(Long.parseLong(parentId));
            menuParentVO.setId(menuParent.getId());
            menuParentVO.setName(menuParent.getName());
        }
        if(StringUtils.isEmpty(menuParentVO.getName())) {
            menuParentVO.setId(0);
            menuParentVO.setName("根目录");
        }
        model.addAttribute("menuParentVO", menuParentVO);
        return "sys/menu/save";
    }
    
    @RequiresPermissions("menu:save")
    @RequestMapping(value = {"save"})
    public String save(@ModelAttribute("menuDTO") MenuDTO menuDTO, Model model, HttpServletRequest request) {
        int n = 0;
        UserDTO user = getUser();
        try{
            if(StringUtils.isNotEmpty(menuDTO.getName())) {
                if(menuDTO.getId()==0) {
                    menuDTO.setIsDel("0");
                    menuService.insert(menuDTO);
                } else {
                    menuService.update(menuDTO);
                }
            } else {
                n = 2;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("n", n);
        request.getSession().removeAttribute("menuList");
        reloadAuthorizing(user.getLoginName());
        return "sys/menu/save";
    }
    
    @RequiresPermissions("menu:del")
    @RequestMapping("del")
    public void del(String id, HttpServletResponse response) {
    	int n = 0;
    	try {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", id);
        int count = menuService.getCountByParentId(map);
        if(count == 0) {
            menuService.del(Long.parseLong(id));
            roleMenuService.deleteByMenuId(Long.parseLong(id));
        } else {
            n = 2;
        }
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	WebInfoFilter.flag = 1;
        AjaxUtil.ajaxJsonSucMessage(response, n);
    }
    
    /**
     * 
     * 功能描述: <br>
     * 获取menu 树 type 3  及获取所有menu  目录、菜单、按钮
     *
     * @param parent
     * @param map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private List<MenuDTO> getMenuList(long parent) {
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        tmpMap.put("parentId", parent);
        tmpMap.put("type", "3");
        List<MenuDTO> menuTmpList = menuService.getMenuDTOByParentId(tmpMap);
        List<MenuDTO> menuList = null;
        if(null != menuTmpList && menuTmpList.size() != 0) {
            menuList = new ArrayList<MenuDTO>();
            for (MenuDTO menu : menuTmpList) {
                    List<MenuDTO> childMenuList = getMenuList(menu.getId());
                    if (null != childMenuList && childMenuList.size() != 0) {
                        menu.setChildMenu(childMenuList);
                    }
                    menuList.add(menu);
            }
        }
        return menuList;
    }
    
    public List<MenuVO> getMenuVOList(long parent) {
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        tmpMap.put("parentId", parent);
        tmpMap.put("type", "2");
        List<MenuDTO> menuTmpList = menuService.getMenuDTOByParentId(tmpMap);
        List<MenuVO> menuList = null;
        if(null != menuTmpList && menuTmpList.size() != 0) {
            menuList = new ArrayList<MenuVO>();
            for (MenuDTO menu : menuTmpList) {
                    List<MenuVO> childMenuList = getMenuVOList(menu.getId());
                    MenuVO menuVO = new MenuVO(menu);
                    if (null != childMenuList && childMenuList.size() != 0) {
                        menuVO.setChildren(childMenuList);
                    }
                    menuList.add(menuVO);
            }
        }
        return menuList;
    }

}
