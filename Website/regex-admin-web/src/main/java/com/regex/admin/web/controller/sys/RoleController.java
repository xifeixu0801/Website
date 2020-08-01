package com.regex.admin.web.controller.sys;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.sys.MenuDTO;
import com.regex.admin.common.dto.sys.RoleDTO;
import com.regex.admin.common.dto.sys.RoleMenuDTO;
import com.regex.admin.common.dto.sys.UserDTO;
import com.regex.admin.common.util.QueryParam;
import com.regex.admin.common.util.QueryResult;
import com.regex.admin.service.sys.IMenuService;
import com.regex.admin.service.sys.IRoleMenuService;
import com.regex.admin.service.sys.IRoleService;
import com.regex.admin.service.sys.IUserRoleService;
import com.regex.admin.web.controller.BaseController;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;
import com.regex.admin.web.controller.vo.sys.MenuTreeVO;

@Controller
@RequestMapping("sys/role")
public class RoleController extends BaseController {
    
    @Autowired
    private IRoleMenuService roleMenuService;
    
    @Autowired
    private IRoleService roleService;
    
    @Autowired
    private IMenuService menuService;
    
    @Autowired
    private IUserRoleService userRoleService;
    
    @RequiresPermissions("role:show")
    @RequestMapping("show")
    public String show(QueryParam param, Model model) {
        QueryResult<RoleDTO> result = roleService.getPageByParam(param);
        model.addAttribute("result", result);
        return "sys/role/show";
    }
    
    @RequiresPermissions("role:save")
    @RequestMapping("tosave")
    public String toSave(String id, Model model) {
        String roleMenuIds = "";
        if(StringUtils.isNotEmpty(id)) {
            RoleDTO roleDTO  = roleService.getById(Long.parseLong(id));
            model.addAttribute("roleDTO", roleDTO);
            List<RoleMenuDTO> roleMenuDTOList = roleMenuService.getRoleMenuListByRoleId(Long.parseLong(id));
            for(RoleMenuDTO roleMenuDTO : roleMenuDTOList) {
                roleMenuIds = roleMenuIds + roleMenuDTO.getMenuId() + ",";
            }
        }
        model.addAttribute("roleMenuIds", roleMenuIds);
        return "sys/role/input";
    }
    
    @RequiresPermissions("role:save")
    @RequestMapping(value = {"getMenuZTree"})
    public void getMenuZTreeJson(HttpServletResponse response, HttpSession session) {
        List<MenuTreeVO> datas = getMenuZTreeList();
        WebInfoFilter.flag = 1;
        AjaxUtil.ajaxJsonSucMessage(response, datas);
    }
    
    /**
     * 
     * 功能描述: <br>
     * 校验角色名称是否存在
     *
     * @param roleName
     * @param id
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequiresPermissions("role:save")
    @RequestMapping(value = {"checkRoleName"})
    public void checkRoleName(String roleName, String id, HttpServletResponse response) {
        if(checkRoleName(roleName, id)) {
        	WebInfoFilter.flag = 1;
            AjaxUtil.ajaxJsonSucMessage(response, 1);
        } else {
        	WebInfoFilter.flag = 1;
            AjaxUtil.ajaxJsonSucMessage(response, 2);
        }
    }
    
    /**
     * 
     * 功能描述: <br>
     * 保存角色
     *
     * @param roleName
     * @param id
     * @param menuIds
     * @param remark
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequiresPermissions("role:save")
    @RequestMapping(value = {"save"})
    public void save(String roleName, String roleCode, String id, String menuIds, String remark,
            HttpServletResponse response, HttpServletRequest request) {
        int n = 0;
        UserDTO user = getUser();
        try {
            if(checkRoleName(roleName, id)) {
                if(StringUtils.isNotEmpty(roleName)) {
                    RoleDTO roleDTO = new RoleDTO();
                    roleDTO.setRoleName(roleName);
                    roleDTO.setRemark(remark);
                    roleDTO.setRoleCode(roleCode);
                    Map<String, Object> checkMap = new HashMap<String, Object>();
                    checkMap.put("id", id);
                    checkMap.put("roleCode", roleCode);
                    int checkCount = roleService.checkRoleCode(checkMap);
                    if(checkCount > 0) {
                    	n = 4;
                    } else {
                    	if("0".equals(id)) {
                    		roleDTO.setCreateTime(new Date());
                    		roleDTO.setCreateUserId(user.getId());
                    		n = roleService.insert(roleDTO);
                    	} else {
                    		roleDTO.setId(Long.parseLong(id));
                    		n = roleService.update(roleDTO);
                    	}
                    	String[] menuIdArr = menuIds.split(",");
                    	roleMenuService.del(roleDTO.getId());
                    	RoleMenuDTO roleMenuDTO = new RoleMenuDTO();
                    	roleMenuDTO.setRoleId(roleDTO.getId());
                    	for(String menuId : menuIdArr) {
                    		if(StringUtils.isNotEmpty(menuId)) {
                    			roleMenuDTO.setMenuId(Long.parseLong(menuId));
                    			roleMenuService.insert(roleMenuDTO);
                    		}
                    	}
                    }
                } else {
                    n = 3;
                }
            } else {
                n = 2;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        // 刷新用户权限及菜单session
        request.getSession().removeAttribute("menuList");
        reloadAuthorizing(user.getLoginName());
        WebInfoFilter.flag = 1;
        AjaxUtil.ajaxJsonSucMessage(response, n);
    }
    
    /**
     * 
     * 功能描述: <br>
     * 删除角色
     *
     * @param id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequiresPermissions("role:del")
    @RequestMapping(value = {"del"})
    public void del(String id, HttpServletResponse response) {
        int count = userRoleService.getByRoleId(Long.parseLong(id));
        if(count == 0) {
            roleService.del(Long.parseLong(id));
            roleMenuService.del(Long.parseLong(id));
            WebInfoFilter.flag = 1;
            AjaxUtil.ajaxJsonSucMessage(response, 0);
        } else {
        	WebInfoFilter.flag = 1;
            AjaxUtil.ajaxJsonSucMessage(response, 1);
        }
    }
    
    private boolean checkRoleName(String roleName, String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("roleName", roleName);
        map.put("id", id);
        int n = roleService.getRoleByName(map);
        if(n == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public List<MenuTreeVO> getMenuZTreeList() {
        List<MenuDTO> menuDTOList = menuService.getByParam();
        List<MenuTreeVO> menuZTreeVOList = new ArrayList<MenuTreeVO>();
        for(MenuDTO menuDTO : menuDTOList) {
            MenuTreeVO menuTreeVO = new MenuTreeVO(menuDTO);
            menuZTreeVOList.add(menuTreeVO);
        }
        return menuZTreeVOList;
    }

}
