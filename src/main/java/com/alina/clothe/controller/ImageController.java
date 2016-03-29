package com.alina.clothe.controller;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by mkvitko on 3/29/16.
 */
@Controller
public class ImageController {

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Value("${mongo.imagedb.name}")
    private String imageDB;

    @Value("${mongo.imagedb.namespace}")
    private String namespace;


    @RequestMapping("/photo/{imageId}")
    protected void getPhoto(@PathVariable("imageId") ObjectId imageId, HttpServletResponse response)
            throws ServletException, IOException {
        if (imageId != null) {
            GridFS gfsPhoto = new GridFS(mongoDbFactory.getDb(imageDB), namespace);

            GridFSDBFile imageForOutput = gfsPhoto.find(imageId);
            if (imageForOutput != null) {
                response.setContentType("image/jpg");
                OutputStream os = response.getOutputStream();
                imageForOutput.writeTo(os);
            }
//            BufferedImage image = ImageIO.read(imageForOutput.getInputStream());
//            byte[] photo = ((DataBufferByte) image.getData().getDataBuffer()).getData();

//            outputImage(response, photo);
        }
    }

    private void outputImage(HttpServletResponse response, byte[] photo) throws IOException {
        if (photo != null && photo.length != 1){
            response.setContentType("image/jpg");
            OutputStream os = response.getOutputStream();
            try (BufferedOutputStream bos = new BufferedOutputStream(os)) {
                bos.write(photo, 0, photo.length);
            }
        }
        else{
            response.setContentType("image/jpg");
            String path = getClass().getClassLoader().getResource("no-image.jpg").getPath();
            File file = new File(path);
            BufferedImage input = ImageIO.read(file);
            OutputStream os = response.getOutputStream();
            ImageIO.write(input, "JPG", os);
        }
    }

}
