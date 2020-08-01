package com.regex.admin.web.controller.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
/**
 * 去除富文本中HTML
 * @author ocean
 *
 */
public class HTMLSpiritUtil {
	
	public static String delHTMLTag(String htmlStr){ 
	    htmlStr = StringEscapeUtils.unescapeHtml(htmlStr);
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    } 
	
	public static void main (String args[]) {
	    String html = StringEscapeUtils.unescapeHtml("&lt;span style=&quot;white-space: normal;&quot;&gt;周星驰拍电影有个原则就是：宁缺毋滥。由于处处追求完美，所以电影拍摄速度非常慢，别的导演几个月拍一部电影，周星驰要3年才拍完，星爷的粉丝们真的是各种等待各种期盼啊！星爷承诺在四年内为公司挣得10.4亿，所以现在已经加快电影的拍摄进度。&lt;/span&gt;&lt;span style=&quot;white-space: normal;&quot;&gt;周星驰拍电影有个原则就是：宁缺毋滥。由于处处追求完美，所以电影拍摄速度非常慢，别的导演几个月拍一部电影，周星驰要3年才拍完，星爷的粉丝们真的是各种等待各种期盼啊！星爷承诺在四年内为公司挣得10.4亿，所以现在已经加快电影的拍摄进度。&lt;/span&gt;度非常慢，别的导演几个月拍一部电影，周星驰要3年才拍完，星爷的粉丝们真的是各种等待各种期盼啊！星爷承诺在四年内为公司挣得10.4亿，所以现在已经加快电影的拍摄进度。&lt;/p&gt;");
	    System.out.println(html);
	    String s = delHTMLTag(html);
	    System.out.println(s);
	}
	
}
