package com.regex.admin.common.dto.sys;

import java.io.Serializable;
import java.util.Date;

public class LogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4027534952260155006L;
	
     private long id;
     
     private String name;
     
     private long customerId;
     
     private String type;
     
     private String content;
     
     private Date createTime;
     
     private String params;

	public long getId() {
		return id;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


     
     
     
}
