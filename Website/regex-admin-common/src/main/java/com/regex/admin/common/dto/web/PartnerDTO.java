package com.regex.admin.common.dto.web;
/**
 * 合作伙伴
 * @author admin
 *
 */
public class PartnerDTO {
    private Long id;
    private java.util.Date updateTime;
    private java.util.Date createTime;
    private String name; // 合作伙伴名称
    private String isDel; // 
    private String logo;// 合作伙伴logo
    private Integer sort; // 排序
    public PartnerDTO() {
        super();
    }
    public PartnerDTO(Long id,java.util.Date updateTime,java.util.Date createTime,String name,String isDel,String logo,Integer sort) {
        super();
        this.id = id;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.name = name;
        this.isDel = isDel;
        this.logo = logo;
        this.sort = sort;
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

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
