package com.regex.admin.common.dto.sys;

import java.io.Serializable;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 角色菜单关系DTO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RoleMenuDTO implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = -860062853995707679L;
    private long id;
    /**
     * 角色ID
     */
    private long roleId;
    /**
     * 菜单ID
     */
    private long menuId;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    public long getMenuId() {
        return menuId;
    }
    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

}
