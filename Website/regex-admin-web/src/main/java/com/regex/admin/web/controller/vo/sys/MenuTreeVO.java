package com.regex.admin.web.controller.vo.sys;

import java.io.Serializable;

import com.regex.admin.common.dto.sys.MenuDTO;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * menu ZTree VO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MenuTreeVO implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = -1569988043304291027L;
    /**
     * id
     */
    private long id;
    /**
     * parentID
     */
    private long pId;
    /**
     * 名称
     */
    private String name;
    
    public MenuTreeVO(){ }
    
    public MenuTreeVO(MenuDTO menuDTO) {
        this.id = menuDTO.getId();
        this.pId = menuDTO.getParentId();
        this.name = menuDTO.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
