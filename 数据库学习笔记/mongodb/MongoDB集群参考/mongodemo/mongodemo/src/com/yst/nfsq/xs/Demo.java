/*
 * ��Ŀ��:      ũ��ɽȪСƿˮϵͳ
 * �ļ���:      Demo.java
 * ����:        Demo
 *
 * ��Ȩ����:
 *      ��ϵͳ���������ݣ�����Դ�롢ҳ����ƣ����֡�ͼ���Լ������κ���Ϣ��
 *      ��δ������˵�������Ȩ����ũ��ɽȪ�ɷ����޹�˾���С�
 *
 *      Copyright (c) 2013 ũ��ɽȪ�ɷ����޹�˾
 *      ��Ȩ����
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
 * ����:		Demo
 * ����:		TODO
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

    //��ȡͼƬ����
    public static long getCount() {

        PhotoDao photoDao = new PhotoDaoImpl();
        return photoDao.getPhotoCount();
    }

    //ɾ��һ��ͼƬ
    public static void delPhoto() {
        PhotoDao photoDao = new PhotoDaoImpl();
        photoDao.delPhoto("photoId", "85fe5b40-8877-4360-8161-48b5bc0a7729");

    }

    //��ȡһ��ͼƬ
    public static Photo getPhoto() {

        PhotoDao photoDao = new PhotoDaoImpl();
        return photoDao.getPhoto("photoId", "85fe5b40-8877-4360-8161-48b5bc0a7729");

    }

    //����һ��ͼƬ
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
