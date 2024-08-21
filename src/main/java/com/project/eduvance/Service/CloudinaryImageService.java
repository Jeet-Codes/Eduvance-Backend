package com.project.eduvance.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryImageService {

    Map uploadImage(MultipartFile file);
    String userImageUpload(String id,Map data);
}
