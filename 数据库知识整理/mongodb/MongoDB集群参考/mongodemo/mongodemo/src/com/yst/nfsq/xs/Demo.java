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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

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

    public static void main(String[] args) {

        //        Demo.addPhoto();
        //        Demo.getCount();
        //        Demo.getPhoto();
        //        Demo.delPhoto();

    }

    //获取图片数量
    public static long getCount() {

        PhotoDao photoDao = new PhotoDaoImpl();
        return photoDao.getPhotoCount();
    }

    //删除一张图片
    public static void delPhoto() {
        PhotoDao photoDao = new PhotoDaoImpl();
        photoDao.delPhoto("photoId", "85fe5b40-8877-4360-8161-48b5bc0a7729");

    }

    //获取一张图片
    public static Photo getPhoto() {

        PhotoDao photoDao = new PhotoDaoImpl();
        return photoDao.getPhoto("photoId", "85fe5b40-8877-4360-8161-48b5bc0a7729");

    }

    //增加一张图片
    public static void addPhoto() {
        PhotoDao photoDao = new PhotoDaoImpl();

        InputStream inputStream;
        byte[] content = null;
        File file = new File("f://pic/nf.jpg");

        try {
            inputStream = new FileInputStream(file);
            content = new byte[inputStream.available()];
            while (inputStream.read(content) > 0) {
                inputStream.read(content);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Photo photo = new Photo();

        photo.setContent(content);
        photo.setPhotoId(UUID.randomUUID().toString());
        photo.setFileName("test");

        photoDao.addPhoto(photo);

    }
}
