package com.project.eduvance.Controllers;

import com.project.eduvance.Service.CloudinaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/cloudinary/upload")
public class ImageController {

    @Autowired
    private CloudinaryImageService cloudinaryImageService;

    @PostMapping
    public ResponseEntity<Map> upload(@RequestParam("image") MultipartFile file) {
        Map data = this.cloudinaryImageService.uploadImage(file);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @PostMapping("/{id}")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable String id) {
        Map data = this.cloudinaryImageService.uploadImage(file);
        String URL = this.cloudinaryImageService.userImageUpload(id, data);
        return new ResponseEntity<>(URL, HttpStatus.OK);
    }

}
