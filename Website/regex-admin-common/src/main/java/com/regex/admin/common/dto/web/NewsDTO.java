package com.regex.admin.common.dto.web;
/**
 * 新闻dto
 * @author admin
 *
 */
public class NewsDTO {
    private Long id;
    private String keywords;// 关键词 seo用
    private java.util.Date createTime;
    private String description;// 描述seo用
    private String source;// 来源
    private String detial;// 详情
    private Integer sort; // 排序
    private String title; // 标题
    private String type; // 类型
    private String isTop; // 是否置顶
    private java.util.Date updateTime;
    private String isDel;
    private String picUrl;
    private Integer readCount; // 阅读数量
    public NewsDTO() {
        super();
    }
    public NewsDTO(Long id,String keywords,java.util.Date createTime,String description,String source,String detial,Integer sort,String title,String type,String isTop,java.util.Date updateTime,String isDel,String picUrl,Integer readCount) {
        super();
        this.id = id;
        this.keywords = keywords;
        this.createTime = createTime;
        this.description = description;
        this.source = source;
        this.detial = detial;
        this.sort = sort;
        this.title = title;
        this.type = type;
        this.isTop = isTop;
        this.updateTime = updateTime;
        this.isDel = isDel;
        this.picUrl = picUrl;
        this.readCount = readCount;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsTop() {
        return this.isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDel() {
        return this.isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getReadCount() {
        return this.readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

}
