package com.regex.admin.common.dto.web;
public class AboutUsDTO {
    private Long id;
    private java.util.Date updateTime;
    private String keywords; // 关键字
    private java.util.Date createTime;
    private String name;
    private String isDel;
    private String description; //  描述
    private String detial;
    private Integer sort;
    private String picUrl;
    public AboutUsDTO() {
        super();
    }
    public AboutUsDTO(Long id,java.util.Date updateTime,String keywords,java.util.Date createTime,String name,String isDel,String description,String detial,Integer sort,String picUrl) {
        super();
        this.id = id;
        this.updateTime = updateTime;
        this.keywords = keywords;
        this.createTime = createTime;
        this.name = name;
        this.isDel = isDel;
        this.description = description;
        this.detial = detial;
        this.sort = sort;
        this.picUrl = picUrl;
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

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsDel() {
        return this.isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetial() {
        return this.detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

}
