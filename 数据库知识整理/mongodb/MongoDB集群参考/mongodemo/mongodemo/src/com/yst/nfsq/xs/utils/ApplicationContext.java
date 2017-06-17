/*
 * ��Ŀ��:      ũ��ɽȪСƿˮϵͳ
 * �ļ���:      ApplicationContext.java
 * ����:        ApplicationContext
 *
 * ��Ȩ����:
 *      ��ϵͳ���������ݣ�����Դ�롢ҳ����ƣ����֡�ͼ���Լ������κ���Ϣ��
 *      ��δ������˵�������Ȩ����ũ��ɽȪ�ɷ����޹�˾���С�
 *
 *      Copyright (c) 2013 ũ��ɽȪ�ɷ����޹�˾
 *      ��Ȩ����
 */
package com.yst.nfsq.xs.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * ����: ApplicationContext ����: ���������ļ�
 * 
 * @author mupowang
 * 
 */
public class ApplicationContext {

    private static Properties applicationProperties = new Properties();

    static {

        try {
            ClassLoader loader = ApplicationContext.class.getClassLoader();
            // ͨ���������װ������ȡ�����ļ�
            InputStream inStream = loader.getResourceAsStream("com/yst/nfsq/xs/mongo.properties");
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
