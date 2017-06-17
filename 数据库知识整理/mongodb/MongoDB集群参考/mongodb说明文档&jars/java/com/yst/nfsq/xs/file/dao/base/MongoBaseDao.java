/*
 * 项目名:      农夫山泉小瓶水系统
 * 文件名:      MongoBaseDao.java
 * 类名:        MongoBaseDao
 *
 * 版权声明:
 *      本系统的所有内容，包括源码、页面设计，文字、图像以及其他任何信息，
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有。
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权所有
 */
package com.yst.nfsq.xs.file.dao.base;

import java.util.List;

/**
 * 类名: MongoBaseDao
 * 描述: mongoDB操作base接口
 * @author mupowang
 * 
 */
public interface MongoBaseDao {
    /**
     * 
     * 描述:返回文档数目
     * 
     * @return
     */
    public long getDocumentCount();

    /**
     * 
     * 描述:增加一个文档记录
     * 
     * @param pojo
     */
    public boolean addDocument(Object pojo);

    /**
     * 
     * 描述:删除一个文档记录
     * 
     * @param field
     * @param value
     */
    public boolean delDocument(String field, String value);

    /**
     * 
     * 描述:更新一个文档记录
     *
     * @param field
     * @param value
     * @param clazz
     */
    public <T> void updateDocument(String field, String value, Object pojo);

    /**
     * 
     * 描述:查找一个文档记录 getDocument("photoId", "1",Photo.class)
     * 
     * @param field
     * @param value
     * @param clazz
     * @return
     */
    public <T> T getDocument(String field, String value, Class<T> clazz);

    /**
     * 
     * 描述:查找多个文档记录
     * 
     * @param field
     * @param value
     * @param clazz
     * @return
     */
    public <T> List<T> getDocuments(String field, String value, Class<T> clazz);
}
