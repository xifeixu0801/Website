package com.regex.admin.web.controller.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * SpringContextUtil
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         this.applicationContext = applicationContext;
    }

    public static ApplicationContext  getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    public static Object getBean(Class c){
        return applicationContext.getBean(c);
    }
}
