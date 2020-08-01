package com.regex.admin.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.sys.UserDTO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 登录controller
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class LoginController extends BaseController {
    /**
     * 
     * 功能描述: <br>
     * 登录controller
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("login")
    public String login() {
        // 判断是否登录授权状态
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:main.htm";
        }
        return "login/login";
    }
    
    /**
     * 
     * 功能描述: <br>
     * 去登录
     *
     * @param loginName
     * @param password
     * @param request
     * @param response
     * @param session
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("tologin")
    public String toLogin(@ModelAttribute("loginName") String loginName, String password, HttpServletRequest request,
            HttpServletResponse response, HttpSession session, Model model) {
        int n = 0;
        if(StringUtils.isNotEmpty(loginName) && StringUtils.isNotEmpty(password)) {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            // 设置不记住用户。默认不记住，可删除
            token.setRememberMe(false);
            Subject subject = SecurityUtils.getSubject();
            try {
                // 去登录
                subject.login(token);
            } catch (UnknownAccountException ex) {
                n = 5;
            } catch (IncorrectCredentialsException ex) {
                n = 6;
            } catch (AuthenticationException e) {
                n = 4;
                e.printStackTrace();
            }
            // 验证是否成功登录的方法
            if (subject.isAuthenticated()) {
                PrincipalCollection principals = subject.getPrincipals();
                UserDTO user = (UserDTO) principals.getPrimaryPrincipal();
                session.setAttribute("user", user);
            }
        } else {
            n = 2;
        }
        if(n==0){
            return "redirect:main.htm"; 
        } else {
            model.addAttribute("n", n);
            return "login/login";
        }
//        AjaxUtil.ajaxJsonSucMessage(response, n);
    }
    
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
//        request.getSession().removeAttribute("user");
        return "redirect:" + getBasePath(request) + "login.htm";
    }
    

}
