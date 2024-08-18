package com.project.eduvance.Service.ServiceImp;

import com.cloudinary.Cloudinary;
import com.project.eduvance.Service.CloudinaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageServiceImp implements CloudinaryImageService {

    @Autowired
    private Cloudinary  cloudinary;


    @Override
    public Map uploadImage(MultipartFile file) {
        try {
            Map data = this.cloudinary.uploader().upload(file.getBytes(),Map.of());
            String name=data.get("url").toString();
            System.out.println(name+"\n"+" This is the URL");
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Image Upload Error");

        }

    }
}
