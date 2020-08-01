package com.regex.admin.common.dto.jms;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息数据
 * @author ocean
 *
 */
public class MQDatas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8331031825576469403L;

	private long id;

	private String isDel;

	private Date createTime;

	private Date updateTime;

	private String data;//消息内容
	
	private String type;//消息类型
	
	private String source;//来源，1 plat 2 push
	
	private String status;//状态是否已读   0未读，1已读
	
	private String dataClassName;//class name
	
	private String parameter;//如果要给指定的人发则存放对应的信息,以list

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataClassName() {
		return dataClassName;
	}

	public void setDataClassName(String dataClassName) {
		this.dataClassName = dataClassName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
