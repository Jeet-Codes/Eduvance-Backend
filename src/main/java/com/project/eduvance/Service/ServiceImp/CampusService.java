package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.CampusDto;
import com.project.eduvance.Entity.Campus;
import com.project.eduvance.Entity.University;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.CampusRepo;
import com.project.eduvance.Repository.UniversityRepo;
import com.project.eduvance.Repository.UserRepo;
import com.project.eduvance.Service.CampusMethods;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CampusService implements CampusMethods {

    @Autowired
    private CampusRepo campusRepo;

    private UniversityRepo unoRepo;


    @Override
    public Campus createCampus(CampusDto resCampus) {
        //retrieve the json
//        String  csName = map.get("csName");
//        String  uniId = map.get("universityId");
//        Integer  estd = Integer.parseInt(map.get("csESTD"));
//        String  state = map.get("csState");
//        String  addess = map.get("csAddress");
//        String  phone = map.get("csPhone");
//        String  landline = map.get("csLandlineNumber");

        // fetch the university via university  id
        University university = unoRepo.findById(resCampus.getUnId()).
                orElseThrow(()-> new ResourceNotFound("University Doesnot Exist"));
        // create campus object
        Campus campus = new Campus();
        String s = "CS";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        campus.setCsId(s + UUID.randomUUID().toString().substring(0, 4).toUpperCase() + t);
        campus.setCsName(resCampus.getCsName());
        campus.setCsAddress(resCampus.getCsAddress());
        campus.setCsESTD(resCampus.getCsESTD());
        campus.setCsState(resCampus.getCsState());
        campus.setCsLandlineNumber(resCampus.getCsLandlineNumber());
        campus.setCsPhone(resCampus.getCsPhone());
        //university added into campus
        campus.setUniversity(university);



        Campus storedCampus = campusRepo.save(campus);

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
        storedCampus.setCsPhoto(campus.getCsPhoto());
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
    public List<Map<String, String>> getAllCampus() {
        List<Campus> campuses = campusRepo.findAll();
        List<Map<String, String>> result = new ArrayList();

        for (Campus campus : campuses) {
            Map<String, String> campusData = new HashMap();
            campusData.put("csId", campus.getCsId());
            campusData.put("csName", campus.getCsName());
            campusData.put("csESTD", campus.getCsESTD().toString());
            campusData.put("csState", campus.getCsState());
            campusData.put("csAddress", campus.getCsAddress());
            campusData.put("csPhone", campus.getCsPhone());
            campusData.put("csLandlineNumber", campus.getCsLandlineNumber());
            campusData.put("csDateOfJoin", campus.getCsDateOfJoin().toString());
            campusData.put("unPhoto", campus.getCsPhoto());


//	            System.out.print(campus.getUniversity().getUnName());
            campusData.put("universityName", campus.getUniversity().getUnName());

            result.add(campusData);
        }

        return result;

    }


    @Override
    public Campus getCampus(String csId) {
//        campusRepo.findById(csId).orElseThrow(()->new ResourceNotFound("Campus not found"+csId));
        return campusRepo.findById(csId).orElseThrow(
                ()->new ResourceNotFound("Campus not found"+csId)
        );
    }
}
