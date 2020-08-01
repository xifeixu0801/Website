package com.regex.admin.web.controller.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 图片上传Utils
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SaveUploadFile {
    /** 
     *  
     * @param formFile 上传的图片文件 
     * @param request 
     * @param saveName 保存的文件的名字 
     * @param ext 保存的文件的扩展名 
     * @return 
     * @throws FileNotFoundException 
     * @throws IOException 
     */  
    public static String savePic(MultipartFile formFile, HttpServletRequest request,  
      String saveName, String ext) throws FileNotFoundException,  
      IOException {  
     
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");  
     String savepath = "/image/brand/" + sdf.format(new Date());//构建图片保存的目录  
     //得到图片保存目录的真实路径  
     String realsavepath = request.getSession().getServletContext()  
       .getRealPath(savepath);  
     //创建文件目录  
     File logosavedir = new File(realsavepath);  
     //如果目录不存在就创建  
     if (!logosavedir.exists()) {
      logosavedir.mkdirs();  
     }  
     FileOutputStream fops = new FileOutputStream(new File(realsavepath,  
       saveName));  
     fops.write(formFile.getBytes());  
     fops.close();  
     
     return savepath + "/" + saveName;  
    }  
    
    /**
     * 
     * 功能描述: <br>
     * base64圖片上傳
     *
     * @param base64Img
     * @param request
     * @param saveName
     * @param ext
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String savePic(String base64Img, HttpServletRequest request,  
            String saveName, String ext) throws FileNotFoundException,  
            IOException {  
           
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");  
           String savepath = "/image/brand/" + sdf.format(new Date());//构建图片保存的目录  
           //得到图片保存目录的真实路径  
           String realsavepath = request.getSession().getServletContext()  
             .getRealPath(savepath);  
//           realsavepath = realsavepath + "/" + saveName;
           //创建文件目录  
           if(GenerateImage(base64Img, realsavepath, saveName)) {
               return savepath + "/" + saveName;  
           } else {
               return "";
           }
           
          }  
    
  //base64字符串转化成图片  
    public static boolean GenerateImage(String imgStr, String imgFilePath, String saveName) {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
          //创建文件目录  
            File logosavedir = new File(imgFilePath);  
            //如果目录不存在就创建  
            if (!logosavedir.exists()) {
             logosavedir.mkdirs();  
            }  
            //生成jpeg图片  
//            String imgFilePath = url;//新生成的图片  
//            FileOutputStream fops = new FileOutputStream(new File(imgFilePath,  
//                    saveName));  
//                  fops.write(b);  
//                  fops.close();  
            OutputStream out = new FileOutputStream(new File(imgFilePath,  
                    saveName));      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
            e.printStackTrace();
            return false;  
        }  
    }  
}
