package com.alina.clothe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by mkvitko on 3/30/16.
 */
public class ClotheCategory {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClotheCategory{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
