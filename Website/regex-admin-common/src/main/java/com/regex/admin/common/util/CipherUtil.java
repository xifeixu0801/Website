package com.regex.admin.common.util;

import java.security.MessageDigest;
/**
 * MD5加密Util
 * @author ocean
 *
 */
public class CipherUtil {

	   private final static String[]   hexDigits= { "0", "1", "2", "3", "4" , "5" , "6" , "7" , "8" , "9" , "a" , "b" , "c" , "d" , "e" , "f" };
	   /**
	    *
	    * 功能描述: <br>    对字符串进行 MD5加密
	    * 〈功能详细描述�??
	    *
	    * @param originString    待加密的字符�?
	    * @return   加密后的字符�?
	    */
	   public static String encodeByMD5(String originString) {
	      if (originString != null) {
	          try {
	             // 创建具有指定算法名称的信息摘�?
	            MessageDigest md = MessageDigest.getInstance("MD5");
	             // 使用指定的字节数组对摘要进行�?后更新，然后完成摘要计算
	             byte[] results = md.digest(originString.getBytes());
	             // 将得到的字节数组变成字符串返�?
	            String resultString = byteArrayToHexString(results);
	             return resultString;
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }
	      }
	      return null;
	   }
	   
	   /**
	    *
	    * 功能描述: <br>转换字节数组为十六进制字符串
	    * 〈功能详细描述�??
	    *
	    * @param b  字节数组
	    * @return   十六进制字符�?
	    */
	   private static String byteArrayToHexString( byte[] b) {
	      StringBuffer resultSb = new StringBuffer();
	      for (int i = 0; i < b. length; i++) {
	         resultSb.append( byteToHexString(b[i]));
	      }
	      return resultSb.toString();
	   }

	   /**
	    *
	    * 功能描述: <br>
	    * 〈功能详细描述�?�将�?个字节转化成十六进制形式的字符串
	    *
	    * @param b
	    * @return
	    */
	   private static String byteToHexString( byte b) {
	      int n = b;
	      if (n < 0)
	         n = 256 + n;
	      int d1 = n / 16;
	      int d2 = n % 16;
	      return hexDigits[d1] + hexDigits[d2];
	   }
	   
	   /**
	    *
	    * 功能描述: <br>
	    * 〈功能详细描述�?�验证输入的密码是否正确
	    *
	    * @param password  加密后的密码
	    * @param inputString  输入的字符串
	    * @return 验证结果，TRUE:正确 FALSE:错误
	    */
	   public static boolean validatePassword(String password, String inputString) {
	      if (password.equals(encodeByMD5(inputString))) {
	          return true;
	      } else {
	          return false;
	      }
	   }

	}

