
package com.yst.nfsq.xs.file.dao.base.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.WriteResult;
import com.yst.nfsq.xs.file.MongoDBContext;
import com.yst.nfsq.xs.file.dao.base.MongoBaseDao;
import com.yst.nfsq.xs.file.utils.BaseConstants;
import com.yst.nfsq.xs.utils.ApplicationContext;

/**
 *  MongoBaseDaoImpl 
 * @author mupowang
 * 
 */
public class MongoBaseDaoImpl implements MongoBaseDao {

    private String        collectionName;

    private static Jongo  JONGO_ENTITY = null;

    private static String MONGODB_NAME = null;

    static {

        MONGODB_NAME = ApplicationContext.getProperty(BaseConstants.MONGO_DBNAME);
        JONGO_ENTITY = new Jongo(MongoDBContext.getMongoClient().getDB(MONGODB_NAME));
    }

    protected MongoBaseDaoImpl(String collectionName) {

        this.collectionName = collectionName;
    }

    @Override
    public boolean addDocument(Object pojo) {

        MongoCollection collection = JONGO_ENTITY.getCollection(collectionName);
        WriteResult result = collection.save(pojo);

        return result.getError() == null ? true : false;
    }

    @Override
    public boolean delDocument(String field, String value) {

        MongoCollection collection = JONGO_ENTITY.getCollection(collectionName);
        WriteResult result = collection.remove("{" + field + ": '" + value + "'}");
        return result.getError() == null ? true : false;
    }

    @Override
    public <T> void updateDocument(String field, String value, Object pojo) {
        // TODO
        this.delDocument(field, value);
        this.addDocument(pojo);

    }

    @Override
    public <T> T getDocument(String field, String value, Class<T> clazz) {

        MongoCollection collection = JONGO_ENTITY.getCollection(collectionName);

        T one = collection.findOne("{" + field + ": '" + value + "'}").as(clazz);
        return one;
    }

    @Override
    public <T> List<T> getDocuments(String field, String value, Class<T> clazz) {

        List<T> list = new ArrayList<T>();
        MongoCollection collection = JONGO_ENTITY.getCollection(collectionName);
        Iterable<T> all = collection.find("{" + field + ": '" + value + "'}").as(clazz);
        Iterator<T> iterator = all.iterator();
        while (iterator.hasNext()) {
            T t = (T) iterator.next();
            list.add(t);

        }
        return list;
    }

    @Override
    public long getDocumentCount() {

        MongoCollection collection = JONGO_ENTITY.getCollection(collectionName);
        return collection.count();
    }

}
