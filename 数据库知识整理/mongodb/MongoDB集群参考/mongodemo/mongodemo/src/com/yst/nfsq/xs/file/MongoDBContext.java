/*
 * ��Ŀ��:      ũ��ɽȪСƿˮϵͳ
 * �ļ���:      MongoDBEnvironment.java
 * ����:        MongoDBEnvironment
 *
 * ��Ȩ����:
 *      ��ϵͳ���������ݣ�����Դ�롢ҳ����ƣ����֡�ͼ���Լ������κ���Ϣ��
 *      ��δ������˵�������Ȩ����ũ��ɽȪ�ɷ����޹�˾���С�
 *
 *      Copyright (c) 2013 ũ��ɽȪ�ɷ����޹�˾
 *      ��Ȩ����
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
 * ����: MongoDBContext 
 * ����: mongoDB��ʼ��������
 * @author mupowang
 * 
 */
public class MongoDBContext {


    // ��Ⱥ·��ip��ַ
    private static String[]            MONGO_HOSTS      = null;

    // ��Ⱥ·�ɵĶ˿ں�
    private static int                 MONGO_PORT;

    // ��Ⱥ·��server��ַ
    private static List<ServerAddress> SERVER_ADDRESSES = new ArrayList<>();

    // �������������
    private static int                 CONNECTIONS_PERHOST;

    // ����̶߳�����
    private static int                 THREADS_ALLOWED;

    // mongoDB���ӿͻ���
    private static MongoClient         MONGO_CLIENT     = null;

    // mongoDB���ӳ�����
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
     * MongoDBContext���캯��
     * 
     */
    private MongoDBContext() {

    }

    /**
     * 
     * ����:��ȡmongoDB���ӳ�
     *
     * @return
     */
    public static synchronized MongoClient getMongoClient() {
        return MONGO_CLIENT;
    }

}
