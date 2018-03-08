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

    public static void main(String[] args){
	PhotoDao photoDao = new PhotoDaoImpl();
	
	//��mongodb�в���һ������
	Photo photo = new Photo();
	
	photo.setContent("content".getBytes());
	photo.setPhotoId("photoId");
	photo.setFileName("fileName");
	
	photoDao.addPhoto(photo);
	
	//��mongodb�в���һ������
	//getPhoto���������������ԣ�һ��Ϊ�ֶ���������һ��Ϊ�ֶ�����ֵ�磺Ҫȡ��photoId="photoId",��������
	Photo photo2 = photoDao.getPhoto("photoId", "photoId");
	System.out.println(photo2.getFileName());
	
	//��mongodb��ɾ��һ������
	//delPhoto���������������ԣ�һ��Ϊ�ֶ���������һ��Ϊ�ֶ�����ֵ�磺Ҫɾ��photoId="photoId",��������
	photoDao.delPhoto("photoId", "photoId");
	
    }
}
