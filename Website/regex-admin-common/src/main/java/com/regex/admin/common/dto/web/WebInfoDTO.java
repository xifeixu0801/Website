package com.regex.admin.common.dto.web;
/**
 * 网站信息dto
 * @author admin
 *
 */
public class WebInfoDTO {
    private Long id;
    private String address;// 地址
    private String keywords;// 关键词
    private String wxPic;// 微信二维码
    private String footer;// 页尾
    private String description;//  描述
    private String header;// 头部
    private String tel;// 联系电话
    private String title;// 网站标题
    private String lx;//x 坐标
    private String ly;//y 坐标
    private String email;// 邮箱
    public WebInfoDTO() {
        super();
    }
    public WebInfoDTO(Long id,String address,String keywords,String wxPic,String footer,String description,String header,String tel,String title,String lx,String ly,String email) {
        super();
        this.id = id;
        this.address = address;
        this.keywords = keywords;
        this.wxPic = wxPic;
        this.footer = footer;
        this.description = description;
        this.header = header;
        this.tel = tel;
        this.title = title;
        this.lx = lx;
        this.ly = ly;
        this.email = email;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getWxPic() {
        return this.wxPic;
    }

    public void setWxPic(String wxPic) {
        this.wxPic = wxPic;
    }

    public String getFooter() {
        return this.footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLx() {
        return this.lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getLy() {
        return this.ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
