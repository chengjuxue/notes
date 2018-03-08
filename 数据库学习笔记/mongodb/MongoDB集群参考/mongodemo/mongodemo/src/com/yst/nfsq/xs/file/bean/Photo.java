/*
 * 项目名:      农夫山泉小瓶水系统
 * 文件名:      Photo.java
 * 类名:        Photo
 *
 * 版权声明:
 *      本系统的所有内容，包括源码、页面设计，文字、图像以及其他任何信息，
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有。
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权所有
 */
package com.yst.nfsq.xs.file.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名: Photo 
 * 描述: 照片实体类
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
     * Photo构造函数
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
