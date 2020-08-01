package com.regex.admin.common.dto.sys;

import java.io.Serializable;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 用户角色DTO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserRoleDTO implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = 624089767855894452L;
    private long id;
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 角色ID
     */
    private long roleId;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

}
