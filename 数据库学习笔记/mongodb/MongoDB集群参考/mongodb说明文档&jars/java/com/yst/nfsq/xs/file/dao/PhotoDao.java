/*
 * 项目名:      农夫山泉小瓶水系统
 * 文件名:      PhotoDao.java
 * 类名:        PhotoDao
 *
 * 版权声明:
 *      本系统的所有内容，包括源码、页面设计，文字、图像以及其他任何信息，
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有。
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权所有
 */
package com.yst.nfsq.xs.file.dao;

import java.util.List;

import com.yst.nfsq.xs.file.bean.Photo;

/**
 * 类名: PhotoDao
 * @author mupowang
 * 
 */
public interface PhotoDao {
    /**
     * 
     * 描述:获取照片数量
     * 
     * @return
     */
    public long getPhotoCount();

    /**
     * 
     * 描述:增加一个照片
     * 
     * @param pojo
     */
    public boolean addPhoto(Photo photo);

    /**
     * 
     * 描述:删除一个照片
     * 
     * @param field
     * @param value
     */
    public boolean delPhoto(String field, String value);

    /**
     * 
     * 描述:更新一个照片
     * 
     * @param field
     * @param value
     * @param photo
     */
    public void updatePhoto(String field, String value, Photo photo);

    /**
     * 
     * 描述:查找一个照片 getDocument("fileId", "1")
     * 
     * @param field
     * @param value
     * @return
     */
    public Photo getPhoto(String field, String value);

    /**
     * 
     * 描述:查找多个照片
     * 
     * @param field
     * @param value
     * @return
     */
    public List<Photo> getPhotos(String field, String value);
}
