/*
 * 项目名:      农夫山泉小瓶水系统
 * 文件名:      MongoDBEnvironment.java
 * 类名:        MongoDBEnvironment
 *
 * 版权声明:
 *      本系统的所有内容，包括源码、页面设计，文字、图像以及其他任何信息，
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有。
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权所有
 */
package com.yst.nfsq.xs.file;

import java.util.ArrayList;
import java.util.List;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.yst.nfsq.xs.file.utils.BaseConstants;
import com.yst.nfsq.xs.utils.ApplicationContext;

/**
 * 类名: MongoDBContext 
 * 描述: mongoDB初始化功能类
 * @author mupowang
 * 
 */
public class MongoDBContext {


    // 集群路由ip地址
    private static String[]            MONGO_HOSTS      = null;

    // 集群路由的端口号
    private static int                 MONGO_PORT;

    // 集群路由server地址
    private static List<ServerAddress> SERVER_ADDRESSES = new ArrayList<>();

    // 主机最大连接数
    private static int                 CONNECTIONS_PERHOST;

    // 最大线程队列数
    private static int                 THREADS_ALLOWED;

    // mongoDB连接客户端
    private static MongoClient         MONGO_CLIENT     = null;

    // mongoDB连接池配置
    private static MongoClientOptions  OPTIONS          = null;

    static {
        MONGO_HOSTS = ApplicationContext.getProperty(BaseConstants.MONGO_HOST).split(",");
        MONGO_PORT = Integer.parseInt(ApplicationContext.getProperty(BaseConstants.MONGO_PORT));
        CONNECTIONS_PERHOST = Integer.parseInt(ApplicationContext.getProperty(BaseConstants.CONNECTIONS_PERHOST));
        THREADS_ALLOWED = Integer.parseInt(ApplicationContext.getProperty(BaseConstants.THREADS_ALLOWED));

        try {
            for (String host : MONGO_HOSTS) {
                SERVER_ADDRESSES.add(new ServerAddress(host, MONGO_PORT));
            }

            Builder builder = new Builder();
            builder.connectionsPerHost(CONNECTIONS_PERHOST);
            builder.threadsAllowedToBlockForConnectionMultiplier(THREADS_ALLOWED);
            OPTIONS = builder.build();

            MONGO_CLIENT = new MongoClient(SERVER_ADDRESSES, OPTIONS);
            MONGO_CLIENT.setReadPreference(ReadPreference.secondaryPreferred());
            MONGO_CLIENT.setWriteConcern(WriteConcern.JOURNAL_SAFE);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * 
     * MongoDBContext构造函数
     * 
     */
    private MongoDBContext() {

    }

    /**
     * 
     * 描述:获取mongoDB连接池
     *
     * @return
     */
    public static synchronized MongoClient getMongoClient() {
        return MONGO_CLIENT;
    }

}
