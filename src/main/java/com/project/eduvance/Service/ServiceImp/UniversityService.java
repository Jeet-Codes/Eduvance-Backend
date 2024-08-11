package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.ApiResponse;
import com.project.eduvance.Dto.IdName;
import com.project.eduvance.Entity.University;
import com.project.eduvance.Repository.UniversityRepo;
import com.project.eduvance.Service.UniversityMethods;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class UniversityService implements UniversityMethods {
    @Autowired
    private UniversityRepo universityRepo;

    @Override
    public University createUniversity(University university) {
        String s = "UN";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        university.setUnId(s + UUID.randomUUID().toString().substring(0, 4) +t);
        University storedUn = universityRepo.save(university);
        return storedUn;
    }

    @Override
    public University updateUniversity(String unId, University university) {
        University storedUn = universityRepo.findById(unId).orElseThrow(
                () -> new RuntimeException("university not found" + unId)
        );
        storedUn.setUnName(university.getUnName());
        storedUn.setUnAddress(university.getUnAddress());
        storedUn.setUnPhone(university.getUnPhone());;
        storedUn.setUnFaxNumber(university.getUnFaxNumber());
        storedUn.setUnPhoto(university.getUnPhoto());
        storedUn.setUnLandlineNumber(university.getUnLandlineNumber());
        return universityRepo.save(storedUn);
    }

    @Override
    public ApiResponse deleteUniversity(String unId) {
        universityRepo.findById(unId).orElseThrow(
                () -> new RuntimeException("university not found" + unId)
        );
        universityRepo.deleteById(unId);
        return new ApiResponse("University having id"+unId+"deleted Successfully",HttpStatus.ACCEPTED);
    }

    @Override
    public University getUniversity(String unId) {

        return universityRepo.findById(unId).orElseThrow(
                () -> new RuntimeException("university not found" + unId)
        );
    }

    public List<IdName> getUniversityIds() {
        List<University> results = universityRepo.findAll();
//        System.out.println(results);
        List<IdName> idNames = results.stream()
                .map(result -> new IdName(result.getUnId(), result.getUnName()))
                .collect(Collectors.toList());
//        System.out.println(idNames.get(0).toString());
        return idNames;
    }

    @Override
    public List<University> getUniversities() {
        return universityRepo.findAll();
    }
}
