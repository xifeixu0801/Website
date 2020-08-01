package com.regex.admin.common.dto.web;
/**
 * 新闻类型
 * @author admin
 *
 */
public class NewsTypeDTO {
    private Long id;
    private java.util.Date updateTime;
    private java.util.Date createTime;
    private String isDel;
    private String type; // 类型名称
    public NewsTypeDTO() {
        super();
    }
    public NewsTypeDTO(Long id,java.util.Date updateTime,java.util.Date createTime,String isDel,String type) {
        super();
        this.id = id;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDel = isDel;
        this.type = type;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getIsDel() {
        return this.isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
