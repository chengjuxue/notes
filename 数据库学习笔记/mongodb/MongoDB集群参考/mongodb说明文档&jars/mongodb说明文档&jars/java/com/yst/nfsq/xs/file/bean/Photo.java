/*
 * ��Ŀ��:      ũ��ɽȪСƿˮϵͳ
 * �ļ���:      Photo.java
 * ����:        Photo
 *
 * ��Ȩ����:
 *      ��ϵͳ���������ݣ�����Դ�롢ҳ����ƣ����֡�ͼ���Լ������κ���Ϣ��
 *      ��δ������˵�������Ȩ����ũ��ɽȪ�ɷ����޹�˾���С�
 *
 *      Copyright (c) 2013 ũ��ɽȪ�ɷ����޹�˾
 *      ��Ȩ����
 */
package com.yst.nfsq.xs.file.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * ����: Photo 
 * ����: ��Ƭʵ����
 * @author mupowang
 * 
 */
public class Photo implements Serializable {

    private static final long serialVersionUID = -7463298614638260219L;

    private String            photoId;

    private String            fileName;

    private byte[]            content;

    private Long              fileLength;

    private Date              startDate;

    private Date              endDate;

    public Photo() {}

    /**
     * Photo���캯��
     * 
     * @param photoId
     * @param fileName
     * @param content
     * @param fileLength
     * @param startDate
     * @param endDate
     */
    public Photo(String photoId, String fileName, byte[] content, Long fileLength, Date startDate, Date endDate) {
        super();
        this.photoId = photoId;
        this.fileName = fileName;
        this.content = null == content ? null : content;
        this.fileLength = fileLength;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = null == content ? null : content;
    }

    public Long getFileLength() {
        return fileLength;
    }

    public void setFileLength(Long fileLength) {
        this.fileLength = fileLength;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
