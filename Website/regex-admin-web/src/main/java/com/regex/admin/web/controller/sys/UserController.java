package com.regex.admin.web.controller.sys;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.sys.RoleDTO;
import com.regex.admin.common.dto.sys.UserDTO;
import com.regex.admin.common.dto.sys.UserRoleDTO;
import com.regex.admin.common.util.CipherUtil;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.sys.IRoleService;
import com.regex.admin.service.sys.IUserRoleService;
import com.regex.admin.service.sys.IUserService;
import com.regex.admin.web.controller.BaseController;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

@Controller
@RequestMapping("sys/user")
public class UserController extends BaseController {
	
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserRoleService userRoleService;
	
	@Autowired
    private IRoleService roleService;
	
	
	@RequestMapping("userlist")
	public String user(Model model,Page<UserDTO> page) {
		try {
			Page<UserDTO> result = userService.selectAll(page);
			model.addAttribute("result",result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "sys/user/userlist";
	}
	
	
	@RequestMapping("insert")
	public String insert(Model model) {
		List<RoleDTO> roleDTOs=roleService.selectAll();	
		model.addAttribute("roleDTOs",roleDTOs);
		return "sys/user/adduser";
	}
	
	@RequestMapping("adduser")
	public void addUser(Model model,UserDTO userDTO, String oldPassword, String roleId,
			HttpServletResponse response) {
		int n = 0;
		try {
		if(userDTO.getPassword().equals(oldPassword)) {
				if(StringUtils.isNotEmpty(userDTO.getLoginName())) {
					UserDTO checkUser = userService.getUserByLoginName(userDTO.getLoginName());
					if(checkUser == null) {
						String password= CipherUtil.encodeByMD5(userDTO.getPassword());	
						userDTO.setPassword(password);
						userDTO.setCreateTime(new Date());
						userDTO.setUpdateTime(new Date());
						PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
						UserDTO user = (UserDTO) principals.getPrimaryPrincipal();
						userDTO.setCreateUser((int)user.getId());
						userDTO.setIsDel("0");
						userService.insert(userDTO);
						
						UserDTO userDTO1 = userService.getUserByLoginName(userDTO.getLoginName());
						UserRoleDTO userRoleDTO = new UserRoleDTO();
						userRoleDTO.setRoleId(Long.parseLong(roleId));
						userRoleDTO.setUserId(userDTO1.getId());
						userRoleService.insert(userRoleDTO);
						n = 1;
					} else {
						n = 4;
					}
				} else {
					n = 3;
				}
		} else {
			n = 2;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	
	@RequestMapping("changePwd")
	public String changePwd(Model model) {
		
		/*UserDTO userDTO = getUser();
		model.addAttribute("userDTO",userDTO);*/
		
		return "sys/user/changePwd";
	}
	
	@RequestMapping("changeUser")
	public String changeuser(Model model, String id) {
		
		UserDTO userDTO = userService.selectById(Long.parseLong(id));
		List<RoleDTO> roleDTOs=roleService.selectAll();	
		UserRoleDTO userRoleDTO = userRoleService.selectById(Long.parseLong(id));
		
		model.addAttribute("userRoleDTO",userRoleDTO);
		model.addAttribute("userDTO",userDTO);
		model.addAttribute("roleDTOs",roleDTOs);

		return "sys/user/changeuser";
	}
	
	@RequestMapping("updatePwd")
	public void updatePwd(Model model,HttpServletResponse response,String pwd,String newpwd,String confirm) {
		
		UserDTO userDTO = getUser();
		String oldpwd = userDTO.getPassword();//旧密码  
		String password= CipherUtil.encodeByMD5(pwd);	
		try{  
			int n = 0;
            if(oldpwd.equals(password)){ //旧密码与原密码一致  
                if(newpwd.equals(confirm)){//判断输入的两个新密码是否一致  
                    if(!(CipherUtil.encodeByMD5(newpwd).equals(oldpwd))){//如果新密码与原密码不同，执行更新密码操作  
                    	UserDTO userDTO1 = new UserDTO();
                    	userDTO1.setPassword(CipherUtil.encodeByMD5(newpwd));
                    	userDTO1.setId(userDTO.getId());
                    	 n =  userService.updatePwd(userDTO1); // 修改成功
                    }else if((CipherUtil.encodeByMD5(newpwd).equals(oldpwd))){  
                         n= 2; //新密码旧密码一致
                    }  
                }else{//抛出异常  
                      n = 3; //两次密码输入不一致
                }  
            }else{//抛出异常  
                 n = 4; // 旧密码错误
            }  
            WebInfoFilter.flag = 1;
            AjaxUtil.ajaxJsonSucMessage(response, n);
        }catch(Exception e){  
        	e.printStackTrace();
	}
}
	@RequestMapping("updateUser")
	public void UpdateUser(UserDTO userDTO,String id, String roleId, HttpServletResponse response,HttpSession session) {
		
		try {
		int n = 0;
		userDTO.setId(Long.parseLong(id));
		userDTO.setUpdateTime(new Date());
		n = userService.updateUser(userDTO);
		UserRoleDTO userRoleDTO = new UserRoleDTO();
		userRoleDTO.setRoleId(Long.parseLong(roleId));
		userRoleDTO.setUserId(Long.parseLong(id));
		userRoleService.update(userRoleDTO);
		if(n !=0) {
		session.removeAttribute("user");
		session.setAttribute("user", userDTO);
		
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("refresh")
	public void refresh(HttpServletResponse response) {
		
		UserDTO userDTO = getUser();
		reloadAuthorizing(userDTO.getLoginName());
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, null);
	}
	
	@RequestMapping("deleteUser")
	public void deleteUser(String id,HttpServletResponse response) {
		
		int n = 0;
		n=userService.deleteUser(Long.parseLong(id));
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	@RequestMapping("user")
	public String user(Model model) {
		UserDTO userDTO = getUser();		
		UserRoleDTO userRoleDTO = userRoleService.selectById(userDTO.getId());
		RoleDTO roleDTO = roleService.getById(userRoleDTO.getRoleId());
		model.addAttribute("userDTO",userDTO);
		model.addAttribute("roleDTO",roleDTO);
		return "sys/user/user";
	}
	
	@RequestMapping("resetPassword")
    public void resetPassword(String id, HttpServletResponse response) {
        String password= CipherUtil.encodeByMD5(Contant.FIRST_PASSWORD);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password", password);
        map.put("id", id);
        userService.resetPassword(map);
        WebInfoFilter.flag = 1;
        AjaxUtil.ajaxJsonSucMessage(response, 1);
    }
}
