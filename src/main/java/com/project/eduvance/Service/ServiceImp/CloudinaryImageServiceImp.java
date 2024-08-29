package com.project.eduvance.Service.ServiceImp;

import com.cloudinary.Cloudinary;
import com.project.eduvance.Entity.Campus;
import com.project.eduvance.Entity.Management;
import com.project.eduvance.Entity.University;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.*;
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

    @Autowired
    private ManagementRepo managementRepo;

    @Autowired
    private UniversityRepo universityRepo;

    @Autowired
    private CampusRepo campusRepo;

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private StudentRepo studentRepo;




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


    @Override
    public String userImageUpload(String id,Map data){
        String url=data.get("url").toString();
        String subString=id.substring(0,2);
        if(subString.equals("MT")){
            Management find=managementRepo.findById(id).orElseThrow(
                        ()->new ResourceNotFound("Management","id",id));
            find.setMtPhoto(url);
            managementRepo.save(find);
            return url;
        } else if (subString.equals("CS")) {
            Campus find=campusRepo.findById(id).orElseThrow(
                    ()->new ResourceNotFound("Campus","id",id)
            );
            find.setCsPhoto(url);
            campusRepo.save(find);
            return url;
        }else if (subString.equals("UN")){
            University find=universityRepo.findById(id).orElseThrow(
                    ()->new ResourceNotFound("University","id",id)
            );
            find.setUnPhoto(url);
            universityRepo.save(find);
            return url;
        }else{
            return null;
        }
    }

}
