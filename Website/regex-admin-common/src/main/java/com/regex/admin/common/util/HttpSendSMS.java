package com.regex.admin.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * httpUtils
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SuppressWarnings("deprecation")
public class HttpSendSMS {
	      
	      
	  /**
	   * 请求 http 接口 
	   * @param url url 
	   * @param map 参数
	   * @return json 对象
	   */
	   public static String sendSms(String url, Map<String, Object> map){  
			HttpClient httpclient = new DefaultHttpClient();  
	        String smsUrl= url;  
	        HttpPost httppost = new HttpPost(smsUrl);  
	        String strResult = "";  
	          
	        try {  
	                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
	                JSONObject jobj = new JSONObject();  
	                for (String pKey : map.keySet()) {
	                    jobj.put(pKey, map.get(pKey));  
	                    nameValuePairs.add(new BasicNameValuePair(pKey, map.get(pKey).toString()));  
	                }
	                
	                httppost.addHeader("Content-type", "application/x-www-form-urlencoded");  
	                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8")); 
	                  
	                HttpResponse response = httpclient.execute(httppost);  
	                if (response.getStatusLine().getStatusCode() == 200) {  
	                    /*读返回数据*/  
	                    String conResult = EntityUtils.toString(response  
	                            .getEntity()); 
	                    strResult = conResult;
	                } else {  
	                    strResult +="";  
	                }  
	        } catch (ClientProtocolException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	          
	        return strResult;  
	    }  
	      
}
