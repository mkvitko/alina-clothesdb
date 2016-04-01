package com.alina.clothe.controller.dto;

import com.alina.clothe.entity.ClotheCategory;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by mkvitko on 4/1/16.
 */
public class ClotheInfoDTO {
    @Id
    private String id;

    private String name;

    private String categoryId;

    private Integer oldPrice;

    private Integer newPrice;

    private String urlToVKImage;

    private String imagePath;

    private Date addedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return categoryId;
    }

    public void setCategory(String category) {
        this.categoryId = category;
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
