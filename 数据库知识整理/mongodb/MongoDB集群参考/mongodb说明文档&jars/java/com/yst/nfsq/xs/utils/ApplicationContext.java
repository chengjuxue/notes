/*
 * 项目名:      农夫山泉小瓶水系统
 * 文件名:      ApplicationContext.java
 * 类名:        ApplicationContext
 *
 * 版权声明:
 *      本系统的所有内容，包括源码、页面设计，文字、图像以及其他任何信息，
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有。
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权所有
 */
package com.yst.nfsq.xs.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 类名: ApplicationContext 描述: 加载配置文件
 * 
 * @author mupowang
 * 
 */
public class ApplicationContext {

    private static Properties applicationProperties = new Properties();


    static {
	// Check system property for the the current environment. If no
	// RUNTIME_ENVIRONMENT defined, use default.
	
	

	// If the configuration for the environment does not exist, use default.
	try {
	    InputStream inStream = ApplicationContext.class
		    .getResourceAsStream("/mongo.properties");
	    applicationProperties.load(inStream);
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
    }

    /**
     * @param key
     * @return
     */
    public static String getProperty(String key) {
	return applicationProperties.getProperty(key);
    }

}
