package com.alina.clothe.entity;

import org.springframework.data.annotation.Id;

import java.io.File;

/**
 * Created by mkvitko on 3/22/16.
 */
public class ClotheInfo {

    @Id
    private String id;

    private String name;

    private Integer oldPrice;

    private Integer newPrice;

//    private File image;

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

//    public File getImage() {
//        return image;
//    }
//
//    public void setImage(File image) {
//        this.image = image;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + " OldPrice: " + oldPrice + " NewPrice: " + newPrice;
    }
}
