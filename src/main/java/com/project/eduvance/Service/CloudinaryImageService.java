package com.project.eduvance.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryImageService {

    public Map uploadImage(MultipartFile file);
}
