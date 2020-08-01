package com.regex.admin.web.controller.vo.sys;

import java.io.Serializable;
import java.util.List;

import com.regex.admin.common.dto.sys.MenuDTO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 菜单VO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MenuVO implements Serializable {
    /**
     */
    private static final long serialVersionUID = -8593686828147762335L;
    /**
     * id
     */
    private long id;
    /**
     * name
     */
    private String name;
    /**
     * 
     */
    private String alias;
    /**
     * 子节点
     */
    private List<MenuVO> children;
    /**
     * 是否展开
     */
    private boolean spread = true;

    public MenuVO(){}
    
    public MenuVO(MenuDTO menuDTO) {
        this.id=menuDTO.getId();
        this.alias=menuDTO.getPerms();
        this.name=menuDTO.getName();
                
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

}
