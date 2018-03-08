
package com.yst.nfsq.xs.file.dao.impl;

import java.util.List;

import com.yst.nfsq.xs.enums.MongoCollectionName;
import com.yst.nfsq.xs.file.bean.Photo;
import com.yst.nfsq.xs.file.dao.PhotoDao;
import com.yst.nfsq.xs.file.dao.base.impl.MongoBaseDaoImpl;

/**
 * 类名: PhotoDaoImpl
 * 
 * @author mupowang
 * 
 */

public class PhotoDaoImpl extends MongoBaseDaoImpl implements PhotoDao {

    public PhotoDaoImpl() {
        super(MongoCollectionName.PHOTO.toString());
    }

    @Override
    public long getPhotoCount() {
        return this.getDocumentCount();
    }

    @Override
    public boolean addPhoto(Photo photo) {
        return this.addDocument(photo);
    }

    @Override
    public boolean delPhoto(String field, String value) {
        return this.delDocument(field, value);
    }

    @Override
    public void updatePhoto(String field, String value, Photo photo) {
        this.updateDocument(field, value, photo);
    }

    @Override
    public Photo getPhoto(String field, String value) {
        return this.getDocument(field, value, Photo.class);
    }

    @Override
    public List<Photo> getPhotos(String field, String value) {
        return this.getDocuments(field, value, Photo.class);
    }

}
