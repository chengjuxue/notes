/*
 * 项目�?      农夫山泉小瓶水系�?
 * 文件�?      MongoDBCollection.java
 * 类名:        MongoDBCollection
 *
 * 版权声明:
 *      本系统的�?��内容，包括源码�?页面设计，文字�?图像以及其他任何信息�?
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有�?
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权�?��
 */
package com.yst.nfsq.xs.enums;

/**
 * 类名: MongoDBCollection 描述: TODO
 * 
 * @author mupowang
 * 
 */
public enum MongoCollectionName {
    PHOTO("photo"), ATTACHMENT("attachment");

    private String colName;

    private MongoCollectionName(String colName) {
	this.colName = colName;
    }

    public String getColName() {
	return colName;
    }

    public void setColName(String colName) {
	this.colName = colName;
    }

    public String toString() {

	return this.getColName();
    }
}
