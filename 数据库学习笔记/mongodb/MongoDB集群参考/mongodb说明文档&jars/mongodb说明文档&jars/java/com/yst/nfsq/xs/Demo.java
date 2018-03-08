/*
 * 项目名:      农夫山泉小瓶水系统
 * 文件名:      Demo.java
 * 类名:        Demo
 *
 * 版权声明:
 *      本系统的所有内容，包括源码、页面设计，文字、图像以及其他任何信息，
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有。
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权所有
 */
package com.yst.nfsq.xs;

import com.yst.nfsq.xs.file.bean.Photo;
import com.yst.nfsq.xs.file.dao.PhotoDao;
import com.yst.nfsq.xs.file.dao.impl.PhotoDaoImpl;


/**
 * 类名:		Demo
 * 描述:		TODO
 * @author 	mupowang
 *
 */
public class Demo {

    public static void main(String[] args){
	PhotoDao photoDao = new PhotoDaoImpl();
	
	//向mongodb中插入一条数据
	Photo photo = new Photo();
	
	photo.setContent("content".getBytes());
	photo.setPhotoId("photoId");
	photo.setFileName("fileName");
	
	photoDao.addPhoto(photo);
	
	//向mongodb中查找一条数据
	//getPhoto方法包括两个属性，一个为字段属性名，一个为字段属性值如：要取得photoId="photoId",方法如下
	Photo photo2 = photoDao.getPhoto("photoId", "photoId");
	System.out.println(photo2.getFileName());
	
	//向mongodb中删除一条数据
	//delPhoto方法包括两个属性，一个为字段属性名，一个为字段属性值如：要删除photoId="photoId",方法如下
	photoDao.delPhoto("photoId", "photoId");
	
    }
}
