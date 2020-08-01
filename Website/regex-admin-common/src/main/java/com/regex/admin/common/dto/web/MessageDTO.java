package com.regex.admin.common.dto.web;
/**
 * 留言dto
 * @author admin
 *
 */
public class MessageDTO {
    private Long id;
    private java.util.Date updateTime;
    private java.util.Date createTime;
    private String ip;
    private String name; // 留言名称
    private String isDel;
    private String tel; // 留言电话
    private String email; // 留言邮箱
    private String content; // 留言内容
    public MessageDTO() {
        super();
    }
    public MessageDTO(Long id,java.util.Date updateTime,java.util.Date createTime,String ip,String name,String isDel,String tel,String email,String content) {
        super();
        this.id = id;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.ip = ip;
        this.name = name;
        this.isDel = isDel;
        this.tel = tel;
        this.email = email;
        this.content = content;
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

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
