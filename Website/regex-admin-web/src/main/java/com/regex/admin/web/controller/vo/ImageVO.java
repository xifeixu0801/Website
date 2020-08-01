package com.regex.admin.web.controller.vo;

import java.io.Serializable;

public class ImageVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3587840900072738821L;

	/**
	 * 
	 */
	

	private String imageName;
	
	private String imageUrl;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
