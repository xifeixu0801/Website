package com.regex.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.regex.admin.common.dto.sys.UserDTO;
import com.regex.admin.service.login.OAuth2ShiroRealm;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * BaseController
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseController {
    /**
     * 
     * 功能描述: <br>
     * 刷新权限
     * 重新赋值权限(在比如:给一个角色临时添加一个权限,需要调用此方法刷新权限,否则还是没有刚赋值的权限) 
     * @param username 用户名
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    protected void reloadAuthorizing(String username){  
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        OAuth2ShiroRealm shiroRealm = (OAuth2ShiroRealm)rsm.getRealms().iterator().next();  
        Subject subject = SecurityUtils.getSubject();   
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        //第一个参数为用户名,第二个参数为realmName,test想要操作权限的用户   
        SimplePrincipalCollection principals = new SimplePrincipalCollection(username,realmName);   
        subject.runAs(principals);   
        shiroRealm.getAuthorizationCache().remove(subject.getPrincipals());   
        subject.releaseRunAs();  
    }  
    /**
     * 
     * 功能描述: <br>
     * 获取用户
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    protected UserDTO getUser() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        UserDTO user = (UserDTO) principals.getPrimaryPrincipal();
        return user;
    }
    
    /**
     * 
     * 功能描述: <br>
     * 获取系统路径
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    protected String getBasePath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/";
    }

}
