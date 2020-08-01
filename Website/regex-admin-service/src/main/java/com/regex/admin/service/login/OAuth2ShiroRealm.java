package com.regex.admin.service.login;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regex.admin.common.dto.sys.MenuDTO;
import com.regex.admin.common.dto.sys.RoleDTO;
import com.regex.admin.common.dto.sys.RoleMenuDTO;
import com.regex.admin.common.dto.sys.UserDTO;
import com.regex.admin.common.dto.sys.UserRoleDTO;
import com.regex.admin.service.sys.IMenuService;
import com.regex.admin.service.sys.IRoleMenuService;
import com.regex.admin.service.sys.IRoleService;
import com.regex.admin.service.sys.IUserRoleService;
import com.regex.admin.service.sys.IUserService;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * shiro 登录认证realm类
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class OAuth2ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    
    @Autowired
    private IUserRoleService userRoleService;
    
    @Autowired
    private IRoleMenuService roleMenuService;
    
    @Autowired
    private IRoleService roleService;
    
    @Autowired
    private IMenuService menuService;
    
    public static final String HASH_ALGORITHM = "MD5";
    public static final int HASH_INTERATIONS = 1;
    
    public OAuth2ShiroRealm(){
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户
        UserDTO user = (UserDTO) super.getAvailablePrincipal(principals);//userService.getUserByLoginName(currentLoginName);
        // 添加角色权限
        List<String> roleList = new ArrayList<String>();
        // 获取用户菜单权限
        List<String> permissionList = new ArrayList<String>();
        if(null != user){
            List<UserRoleDTO> userRoleList = userRoleService.getByUserId(user.getId());
            List<RoleMenuDTO> roleMenuDTOList = new ArrayList<RoleMenuDTO>();
            for(UserRoleDTO userRoleDTO : userRoleList) {
                roleMenuDTOList.addAll(roleMenuService.getRoleMenuListByRoleId(userRoleDTO.getRoleId()));
                RoleDTO roleDTO = roleService.getById(userRoleDTO.getRoleId());
            	roleList.add(roleDTO.getRoleCode());
            }
            for(RoleMenuDTO roleMenu : roleMenuDTOList) {
                MenuDTO menu = menuService.getById(roleMenu.getMenuId());
                if (StringUtils.isNotBlank(menu.getPerms())){
                    // 添加基于Permission的权限信息
                    for (String permission : StringUtils.split(menu.getPerms(),",")){
                        permissionList.add(permission);
                    }
                }
            }
            SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
            simpleAuthorInfo.addRoles(roleList);
            simpleAuthorInfo.addStringPermissions(permissionList);
            return simpleAuthorInfo;
        } else {
            throw new AuthorizationException();
        }

    }

    /**
     * 认证(登录时调用)
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        // 与数据库中用户名和密码进行比对
        UserDTO user = userService.getUserByLoginName(token.getUsername());
        if (null != user) {
            // 账号锁定
            if (!"0".equals(user.getIsDel())) {
                throw new LockedAccountException("账号已被锁定,请联系管理员");
            }
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        } 
            return null;
    }
    

     /**
     * 设定Password校验的Hash算法与迭代次数.
     */
     @PostConstruct
     public void initCredentialsMatcher() {
     HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(HASH_ALGORITHM);
     matcher.setHashIterations(HASH_INTERATIONS);
     setCredentialsMatcher(matcher);
     }
     
     /**
      * 
      * 功能描述: <br>
      * 清楚缓存
      *
      * @see [相关类/方法](可选)
      * @since [产品/模块版本](可选)
      */
     public void clearCached() {
         PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
         super.clearCache(principals);
         }

}