package com.regex.admin.common.dto.sys;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 角色DTO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RoleDTO implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = -2395196134950816536L;
    private long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 权限编码
     */
    private String roleCode;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建者ID
     */
    private long createUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    
    public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public long getCreateUserId() {
        return createUserId;
    }
    public void setCreateUserId(long createUserId) {
        this.createUserId = createUserId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
