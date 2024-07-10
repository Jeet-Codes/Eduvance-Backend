package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Entity.Campus;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.CampusRepo;
import com.project.eduvance.Repository.UserRepo;
import com.project.eduvance.Service.CampusMethods;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CampusService implements CampusMethods {

    @Autowired
    private CampusRepo campusRepo;


    @Override
    public Campus createCampus(Campus campus) {
        String s="CS";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        campus.setCsId(s+ UUID.randomUUID().toString().substring(0,4)+t);
        Campus storedCampus=campusRepo.save(campus);

        return storedCampus;
    }

    @Override
    public Campus updateCampus(String csId, Campus campus) {
        Campus storedCampus=campusRepo.findById(csId).orElseThrow(
                ()->new ResourceNotFound("Campus not found"+csId)
        );
        storedCampus.setCsName(campus.getCsName());
        storedCampus.setCsAddress(campus.getCsAddress());
        storedCampus.setCsPhone(campus.getCsPhone());
        storedCampus.setCsLandlineNumber(campus.getCsLandlineNumber());
        storedCampus.setUnPhoto(campus.getUnPhoto());
        return campusRepo.save(storedCampus);
    }

    @Override
    public void deleteCampus(String csId) {
        campusRepo.findById(csId).orElseThrow(
                ()->new ResourceNotFound("Campus not found"+csId)
        );
        campusRepo.deleteById(csId);
    }

    @Override
    public List<Campus> getAllCampus() {
        return campusRepo.findAll();
    }

    @Override
    public Campus getCampus(String csId) {
//        campusRepo.findById(csId).orElseThrow(()->new ResourceNotFound("Campus not found"+csId));
        return campusRepo.findById(csId).orElseThrow(
                ()->new ResourceNotFound("Campus not found"+csId)
        );
    }
}
