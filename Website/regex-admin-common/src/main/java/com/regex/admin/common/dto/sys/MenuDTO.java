package com.regex.admin.common.dto.sys;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * menuDTO 菜单
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MenuDTO implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = -2227151497463920304L;
    private long id;
    /**
     * 父菜单ID，一级菜单为0
     */
    private long parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private int type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private int orderNum = 10;
    /**
     * 删除标记 0 未删除 1 删除
     */
    private String isDel;
    /**
     * 子目录
     */
    private List<MenuDTO> childMenu;
    
    public List<MenuDTO> getChildMenu() {
        return childMenu;
    }
    public void setChildMenu(List<MenuDTO> childMenu) {
        this.childMenu = childMenu;
    }
    public String getIsDel() {
        return isDel;
    }
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getParentId() {
        return parentId;
    }
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPerms() {
        return perms;
    }
    public void setPerms(String perms) {
        this.perms = perms;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public int getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

}
