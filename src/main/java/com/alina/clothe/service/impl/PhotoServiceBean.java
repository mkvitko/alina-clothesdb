package com.alina.clothe.service.impl;

import com.alina.clothe.service.PhotoService;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by mkvitko on 3/29/16.
 */
@Service
public class PhotoServiceBean implements PhotoService {
    private Logger LOGGER = Logger.getLogger(PhotoServiceBean.class);

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Value("${mongo.imagedb.name}")
    private String imageDB;

    @Value("${mongo.imagedb.namespace}")
    private String namespace;

    @Value("${mongo.imagedb.prefix}")
    private String prefix;

    @Override
    public ObjectId save(String photoPath, Date date) {
        if (!StringUtils.isEmpty(photoPath) && date != null) {
            File imageFile = new File(photoPath);
            // create a "photo" namespace
            GridFS gfsPhoto = new GridFS(mongoDbFactory.getDb(imageDB), namespace);
            try {
                // get image file from local drive
                GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
                // set a new filename for identify purpose
                gfsFile.setFilename(prefix + date.getTime());
                // save the image file into mongoDB
                gfsFile.save();

                return (ObjectId) gfsPhoto.findOne(gfsFile.getFilename()).getId();
            } catch (IOException ex) {
                LOGGER.warn("Something wrong!", ex);
            }
        }
        return null;
    }
}
