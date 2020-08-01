package com.regex.admin.common.dto.web;
/**
 * banner
 * @author admin
 *
 */
public class BannerDTO {
    private Long id;
    private java.util.Date updateTime;
    private java.util.Date createTime;
    private String isDel;
    private String bannerUrl;
    private Integer sort;// 排序
    private String title;// 标题
    private String url; // url
    public BannerDTO() {
        super();
    }
    public BannerDTO(Long id,java.util.Date updateTime,java.util.Date createTime,String isDel,String bannerUrl,Integer sort,String title,String url) {
        super();
        this.id = id;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDel = isDel;
        this.bannerUrl = bannerUrl;
        this.sort = sort;
        this.title = title;
        this.url = url;
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

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
