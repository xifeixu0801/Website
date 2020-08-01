package com.regex.admin.common.dto.web;
/**
 * 招聘
 * @author admin
 *
 */
public class RecruitDTO {
    private Long id;
    private String jobAddress; // 工作地址
    private String jobDemand; // 工作要求
    private java.util.Date updateTime;
    private String jobName; // 工作名称
    private java.util.Date createTime;
    private java.util.Date publishTime; //发布时间
    private String isDel;
    private String detial; // 详情
    public RecruitDTO() {
        super();
    }
    public RecruitDTO(Long id,String jobAddress,String jobDemand,java.util.Date updateTime,String jobName,java.util.Date createTime,java.util.Date publishTime,String isDel,String detial) {
        super();
        this.id = id;
        this.jobAddress = jobAddress;
        this.jobDemand = jobDemand;
        this.updateTime = updateTime;
        this.jobName = jobName;
        this.createTime = createTime;
        this.publishTime = publishTime;
        this.isDel = isDel;
        this.detial = detial;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobAddress() {
        return this.jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getJobDemand() {
        return this.jobDemand;
    }

    public void setJobDemand(String jobDemand) {
        this.jobDemand = jobDemand;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getPublishTime() {
        return this.publishTime;
    }

    public void setPublishTime(java.util.Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getIsDel() {
        return this.isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getDetial() {
        return this.detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }

}
