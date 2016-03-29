package com.alina.clothe.service;

import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created by mkvitko on 3/29/16.
 */

public interface PhotoService {
    ObjectId save(String photoPath, Date date);
}
