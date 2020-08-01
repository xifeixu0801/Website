package com.regex.admin.web.controller.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.AppendObjectRequest;
import com.aliyun.oss.model.AppendObjectResult;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.regex.admin.common.util.PropertiesUtils;
/**
 * 
 * @author ocean
 *
 */
public class OssManage {
	
	private static Logger LOGGER = LoggerFactory.getLogger(OssManage.class);
    public static  String ACCESS_KEY_ID  = "LTAIZhfSzf38E4A0";
    public static  String  ACCESS_KEY_SECRET = "tDAAu19oX1ccicZBPZkKML046v4Q1D";
    public static  String  ENDPOINT = "oss-cn-shanghai.aliyuncs.com";
    public static  String  BUCKETNAME = "regex";
    public static  String  BUCKETNAME_VIDEO = "regex";
    public static String OUT_OF_DATE = "5*3600*1000";
    private  OSSClient client  = null;
    private  ObjectMetadata meta = null;
    static PropertiesUtils propertiesUtils = new PropertiesUtils("properties/setting-web.properties");
    static{
        try {
            ACCESS_KEY_ID  = propertiesUtils.readProperty("OSS_ACCESS_KEY_ID");
            ACCESS_KEY_SECRET = propertiesUtils.readProperty("OSS_ACCESS_KEY_SECRET");
            ENDPOINT = propertiesUtils.readProperty("OSS_ENDPOINT");
             BUCKETNAME = propertiesUtils.readProperty("OSS_BUCKETNAME");
             BUCKETNAME_VIDEO = propertiesUtils.readProperty("OSS_BUCKETNAME_VIDEO");
             OUT_OF_DATE = propertiesUtils.readProperty("OSS_OUT_OF_DATE");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
     
    public void init(){
         // 初始化一个OSSClient
            client = new OSSClient(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            meta = new ObjectMetadata();
    }
     
    /**
     * @Description: 上传文件到OSS文件服务器
     * @param content  文件流
     * @param key    上传为OSS文件服务器的唯一标识
     * @param mimeType  文档类型
     * @throws Exception 
     * @ReturnType:String   OSSObject的ETag值。
    */
    public String  uploadFile(MultipartFile file,String key,String mimeType) throws Exception{
        //进行初始化
        init();
            // 必须设置ContentLength
//            meta.setContentType(mimeType);
            // 上传Object.
            LOGGER.error("*****************上传图片到oss服务器开始*****************" + key);
            PutObjectResult result = client.putObject(BUCKETNAME, key, new ByteArrayInputStream(file.getBytes()), meta);
            LOGGER.error("*****************上传图片到oss服务器结束*****************" + key);
            return result.getETag();
    }
     
 
 
    /**
     * @Description: 根据key获取oss服务器上的图片地址
     * @param key
     * @return 
     * @ReturnType:String
    */
    public String getImgURl(String key){
        init();
        Date expires = new Date (new Date().getTime() + Integer.parseInt(OUT_OF_DATE)); // 30 minute to expire
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        if(key.startsWith("msplatform")){
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME, key);
        }else {
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME_VIDEO, key);
        }
        generatePresignedUrlRequest.setExpiration(expires);
        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }
    /**
     * @Description:根据key获取oss服务器上的ipa文件地址
     * @param key
     * @return 
     * @ReturnType:String
     */
    public String getIpaURl(String key){
        init();
        Date expires = new Date(new Date().getTime()+ 10*365*24*3600*1000);
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        if(key.startsWith("msplatform")){
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME, key);
        }else {
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME_VIDEO, key);
        }
        generatePresignedUrlRequest.setExpiration(expires);
        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }
     
    /**
     * @Description: 根据key获取oss服务器上的图片地址
     * @param key
     * @return 
     * @ReturnType:String
    */
    public InputStream  getObject(String key){
        init();
        OSSObject object = null;
        if(key.startsWith("msplatform")){
            object= client.getObject(BUCKETNAME, key);
        }else{
            object= client.getObject(BUCKETNAME_VIDEO, key);
        }
        object.getObjectMetadata().getContentType();
        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();
         
     
        return objectContent;
    }
     
     
    /**
     * @Description:删除文件
     * @param key  OSS文件服务器上文件的唯一标识
     * @ReturnType:void
    */
    public void deleteFile(String key){
        init();
        client.deleteObject(BUCKETNAME, key);
    }
     
     
    /**
     * @Description: 断点上传文件到OSS文件服务器
     * @param content  文件流
     * @param key    上传为OSS文件服务器的唯一标识
     * @param position 位置
    */
    public String  appendObjectFile(MultipartFile file,String key,int position,String mimeType) throws Exception{
           //进行初始化
            init();
            // 必须设置ContentLength
            meta.setContentLength(position);
            meta.setContentType(mimeType);
            meta.setCacheControl("no-cache");
            meta.setContentEncoding("utf-8");
            // 上传
            LOGGER.error("*****************断点上传图片到oss服务器开始*****************" + key);
            AppendObjectRequest appendObjectRequest = new AppendObjectRequest(BUCKETNAME, key, new ByteArrayInputStream(file.getBytes()), meta);
            appendObjectRequest.setPosition(Long.valueOf(position));
            AppendObjectResult appendObjectResult =client.appendObject(appendObjectRequest);
            LOGGER.error("*****************断点上传图片到oss服务器结束*****************" + key);
            return appendObjectResult.getNextPosition().toString();
    }
     
}
