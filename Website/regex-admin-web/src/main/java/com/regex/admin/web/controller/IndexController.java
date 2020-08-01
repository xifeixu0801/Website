package com.regex.admin.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.regex.admin.common.dto.sys.MenuDTO;
import com.regex.admin.common.dto.sys.RoleMenuDTO;
import com.regex.admin.common.dto.sys.UserDTO;
import com.regex.admin.common.dto.sys.UserRoleDTO;
import com.regex.admin.common.dto.web.NewsDTO;
import com.regex.admin.common.dto.web.PartnerDTO;
import com.regex.admin.common.dto.web.ProductDTO;
import com.regex.admin.common.dto.web.WebInfoDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.common.util.QRCodeUtil;
import com.regex.admin.service.sys.IMenuService;
import com.regex.admin.service.sys.IRoleMenuService;
import com.regex.admin.service.sys.IUserRoleService;
import com.regex.admin.service.web.INewsService;
import com.regex.admin.service.web.IPartnerService;
import com.regex.admin.service.web.IProductService;
import com.regex.admin.service.web.IWebInfoService;
import com.regex.admin.web.controller.utils.SaveUploadFile;
import com.regex.admin.web.controller.vo.ImageVO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * index controller 
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class IndexController {

	private static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleMenuService roleMenuService;
    
    @Autowired
	private IProductService productService;

    @Autowired
	private IPartnerService partnerService;

    @Autowired
    private IMenuService menuService;
    
    @Autowired
	private INewsService newsService;
    
    @Autowired
    protected IWebInfoService webInfoService;
    
    @RequestMapping("index")
    public String index(Model model) {
    	Assist assist = new Assist();
		assist.setOrder(Assist.order("sort", true));
        assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
        assist.setRequires(Assist.andEq("type", "0"));
        assist.setRowSize(4);
        assist.setStartRow(0);
        List<ProductDTO> productList = productService.selectProductDTO(assist);
        model.addAttribute("productList", productList);
        
        Assist assist1 = new Assist();
        assist1.setOrder(Assist.order("sort", true));
        assist1.setOrder(Assist.order("create_time", false));
        assist1.setRequires(Assist.andNeq("is_del", "1"));
        assist1.setRowSize(8);
        assist1.setStartRow(0);
		List<PartnerDTO> partnerList = partnerService.selectPartnerDTO(assist1);
		model.addAttribute("partnerList", partnerList);
		
		Assist assist2 = new Assist();
		assist2.setOrder(Assist.order("sort", true));
        assist2.setOrder(Assist.order("create_time", false));
        assist2.setRequires(Assist.andNeq("is_del", "1"));
        assist2.setRequires(Assist.andEq("type", "1"));
        assist2.setRowSize(6);
        assist2.setStartRow(0);
		List<NewsDTO> newsList1 = newsService.selectNewsDTO(assist2);
		model.addAttribute("newsList1", newsList1);
		
		Assist assist3 = new Assist();
		assist3.setOrder(Assist.order("sort", true));
		assist3.setOrder(Assist.order("create_time", false));
		assist3.setRequires(Assist.andNeq("is_del", "1"));
		assist3.setRequires(Assist.andEq("type", "2"));
		assist3.setRowSize(6);
		assist3.setStartRow(0);
		List<NewsDTO> newsList2 = newsService.selectNewsDTO(assist3);
		model.addAttribute("newsList2", newsList2);
		
		Assist assist4 = new Assist();
		assist4.setOrder(Assist.order("sort", true));
		assist4.setOrder(Assist.order("create_time", false));
		assist4.setRequires(Assist.andNeq("is_del", "1"));
		assist4.setRequires(Assist.andEq("type", "1"));
		assist4.setRowSize(4);
		assist4.setStartRow(0);
        List<ProductDTO> sucProductList = productService.selectProductDTO(assist4);
        model.addAttribute("sucProductList", sucProductList);
		
		WebInfoDTO webInfoDTO = webInfoService.selectWebInfoDTOById(1l);
		model.addAttribute("webInfoDTO", webInfoDTO);
        return "web/index";
    }
    
    @RequestMapping("adminIndex")
    public String adminIndex() {
        return "index";
    }

    /**
     * 
     * 功能描述: <br>
     * 系统主界面
     *
     * @param model
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("main")
    public String main(Model model, HttpServletRequest request) {
        try {
            PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
            UserDTO user = (UserDTO) principals.getPrimaryPrincipal();
            List<UserRoleDTO> userRoleList = userRoleService.getByUserId(user.getId());
            List<RoleMenuDTO> roleMenuDTOList = new ArrayList<RoleMenuDTO>();
            for(UserRoleDTO userRoleDTO : userRoleList) {
                roleMenuDTOList.addAll(roleMenuService.getRoleMenuListByRoleId(userRoleDTO.getRoleId()));
            }
            Map<Long, Object> map = new HashMap<Long, Object>();
            for (RoleMenuDTO roleMenu : roleMenuDTOList) {
                map.put(roleMenu.getMenuId(), "1");
            }
            // 获取菜单并设置session
            @SuppressWarnings("unchecked")
            List<MenuDTO> menuList = (List<MenuDTO>) request.getSession().getAttribute("menuList");
            if(menuList == null || menuList.size() == 0) {
                menuList = getMenuList(0, map);
                request.getSession().setAttribute("menuList", menuList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "main";
    }

    /**
     * 
     * 功能描述: <br>
     * 
     *  遍历获取菜单 不获取按钮。只获取目录和菜单
     * @param parent
     * @param map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private List<MenuDTO> getMenuList(long parent, Map<Long, Object> map) {
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        tmpMap.put("parentId", parent);
        tmpMap.put("type", "2");
        List<MenuDTO> menuTmpList = menuService.getMenuDTOByParentId(tmpMap);
        List<MenuDTO> menuList = null;
        if(null != menuTmpList && menuTmpList.size() != 0) {
            menuList = new ArrayList<MenuDTO>();
            for (MenuDTO menu : menuTmpList) {
                if (null != map.get(menu.getId())) {
                    List<MenuDTO> childMenuList = getMenuList(menu.getId(), map);
                    if (null != childMenuList && childMenuList.size() != 0) {
                        menu.setChildMenu(childMenuList);
                    }
                    menuList.add(menu);
                }
            }
        }
        return menuList;
    }
    /**
     * 
     * 功能描述: <br>
     * 404 not found
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("404")
    public String error404() {
        return "error/404";
    }
    /**
     * 
     * 功能描述: <br>
     * 500 403 exception
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("error")
    public String error() {
        return "error/500";
    }
    /**
     * 
     * 功能描述: <br>
     * forbidden
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("forbidden")
    public String forbidden() {
        return "error/forbidden";
    }
    
    @RequiresRoles("menu:showlist")
    @RequestMapping(value = {"show"})
    public String shwoMenu(Model model) {
        return "sys/menu/show";
    }
    
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
	@ResponseBody
	public String uploadImage(MultipartFile fileField, HttpServletResponse response,
	        HttpServletRequest request) {
 		String fileName=fileField.getOriginalFilename();
		UUID.randomUUID();
		String fileNameArray[] = fileName.split("\\.");
		fileName = UUID.randomUUID() + "." + fileNameArray[fileNameArray.length - 1];
		String url = "";
		try {
		    url = SaveUploadFile.savePic(fileField, request, fileName, "");
		} catch (Exception e) {
			LOGGER.error("upload is fail!");
		}
		LOGGER.error(url);
		ImageVO imageVO = new ImageVO();
		imageVO.setImageName(fileName);
		imageVO.setImageUrl(url);
		String s = JSON.toJSONString(imageVO);
		System.out.println(s);
		return s;
	}
    
    /**
     * 生成二维码
     * @param response
     * @param request
     * @param url
     */
    @RequestMapping("getQrCodeImg.do")
    public void getImg(HttpServletResponse response, HttpServletRequest request, String url) {
        url = "http://www.baidu.com"; //ValidateCodeUtil.generateTextCode(3, 4, "I10O");
//        MemberDTO member = getUser(request);
//        if(StringUtils.isEmpty(url)) {
//            url = member.getId();
//        }
        BufferedImage buffImg = null;
        try {
            buffImg = QRCodeUtil.encode(url, "" , "", true);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");

        ServletOutputStream sos;
        try {
            sos = response.getOutputStream();
            ImageIO.write(buffImg, "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
