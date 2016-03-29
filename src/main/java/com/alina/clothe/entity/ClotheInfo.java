package com.alina.clothe.entity;

import com.mongodb.gridfs.GridFSDBFile;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.File;
import java.util.Date;

/**
 * Created by mkvitko on 3/22/16.
 */
public class ClotheInfo {

    @Id
    private String id;

    private String name;

    private Integer oldPrice;

    private Integer newPrice;

    private ObjectId imageId;

    private String urlToVKImage;

    private String imagePath;

    private Date addedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public ObjectId getImageId() {
        return imageId;
    }

    public void setImageId(ObjectId imageId) {
        this.imageId = imageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlToVKImage() {
        return urlToVKImage;
    }

    public void setUrlToVKImage(String urlToVKImage) {
        this.urlToVKImage = urlToVKImage;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + " OldPrice: " + oldPrice + " NewPrice: " + newPrice +
                " URL to VK image: " + urlToVKImage;
    }
}
