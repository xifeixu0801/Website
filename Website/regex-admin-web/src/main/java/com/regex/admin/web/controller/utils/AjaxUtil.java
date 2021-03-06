package com.regex.admin.web.controller.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
/**
 * ajax输出工具类
 * @author ocean
 *
 */
public class AjaxUtil {

	static Logger log = LoggerFactory.getLogger(AjaxUtil.class);
	public static final String VIEW = "view";
	public static final String LIST = "list";
	public static final String STATUS = "status";
	public static final String WARN = "warn";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final String MESSAGES = "messages";
	public static final String CONTENT = "content";

	/**
	 * AJAX输出，返回null
	 * 
	 * @param content
	 * @param type
	 * @return
	 */
	public static String ajax(HttpServletResponse response, String content, String type) {
		try {
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			log.error("IOException:", e);
		}
		return null;
	}


	/**
	 * AJAX输出文本，返回null
	 * 
	 * @param text
	 * @return
	 */
	public static String ajaxText(HttpServletResponse response, String text) {
		return ajax(response,text, "text/plain");
	}

	/**
	 * AJAX输出HTML，返回null
	 * 
	 * @param html
	 * @return
	 */
	public static String ajaxHtml(HttpServletResponse response,String html) {
		return ajax(response,html, "text/html");
	}

	/**
	 * AJAX输出XML，返回null
	 * 
	 * @param xml
	 * @return
	 */
	public static String ajaxXml(HttpServletResponse response,String xml) {
		return ajax(response,xml, "text/xml");
	}

	/**
	 * 根据字符串输出JSON，返回null
	 * 
	 * @param jsonString
	 * @return
	 */
	public static String ajaxJson(HttpServletResponse response,String jsonString) {
		return ajax(response,jsonString, "text/html");
	}

	/**
	 * 根据Map输出JSON，返回null
	 * 
	 * @param jsonMap
	 * @return
	 */
	public static String ajaxJson(HttpServletResponse response, Map<String, Object> jsonMap) {
		return ajax(response,JSON.toJSONString(jsonMap), "text/html");
	}
	
	
	/**
	 * 输出JSON成功消息，返回null
	 * 
	 * @param message
	 * @return
	 */
	public static String ajaxJsonSucMessage(HttpServletResponse response, Object message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, message);
		return ajax(response,JSON.toJSONString(jsonMap), "text/xml");
	}
	
	/**
	 * 输出JSON警告消息，返回null
	 * 
	 * @param message
	 * @return
	 */
	public static String ajaxJsonWarMessage(HttpServletResponse response, Object message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		return ajax(response,JSON.toJSONString(jsonMap), "text/xml");
	}
	
	/**
	 * 输出JSON错误消息，返回null
	 * 
	 * @param message
	 * @return
	 */
	public static String ajaxJsonErrMessage(HttpServletResponse response, Object message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGE, message);
		return ajax(response,JSON.toJSONString(jsonMap), "text/xml");
	}
	
	/**
	 * 设置页面不缓存
	 */
	public void setResponseNoCache(HttpServletResponse response) {
		response.setHeader("progma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
	}
}
