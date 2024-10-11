package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.DegreeDto;
import com.project.eduvance.Entity.Campus;
import com.project.eduvance.Entity.Degree;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.CampusRepo;
import com.project.eduvance.Repository.DegreeRepo;
import com.project.eduvance.Service.DegreeMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DegreeService implements DegreeMethods
{

    @Autowired
    private DegreeRepo degreeRepo;

    @Autowired
    private CampusRepo campusRepo;

    @Override
    public Degree createDegree(DegreeDto degree) {
        String s = "DG";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        degree.setId(s+ UUID.randomUUID().toString().substring(0,4).toUpperCase()+t);

        Campus campus = campusRepo.findById(degree.getCampus_id()).orElseThrow(
                () -> new ResourceNotFound("Id", "Campus is not found", degree.getCampus_id())
        );



        Degree storedDegree =new Degree();
        storedDegree.setCampus(campus);
        storedDegree.setId(degree.getId());
        storedDegree.setDegreeName(degree.getDegreeName());
        storedDegree.setDurationYears(degree.getDurationYears());
        storedDegree.setDegreeShortName(degree.getDegreeShortName());

        Degree saved = degreeRepo.save(storedDegree);

        return saved;
    }

    @Override
    public Degree updateDegree(String id, Degree degree) {
        Degree degree1 = degreeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Degree", "id", id)
        );
//        degree1.setName(degree.getName());
//        degree1.setDescription(degree.getDescription());
//        degree1.setDuration(degree.getDuration());

        Degree saved = degreeRepo.save(degree1);

        return saved;
    }

    @Override
    public Degree getDegree(String id) {
        Degree SavedDegree = degreeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Degree", "id", id)
        );

        return SavedDegree;
    }

    @Override
    public List<Degree> getAllDegree() {

        return degreeRepo.findAll();
    }

    @Override
    public void deleteDegree(String id) {

        degreeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Degree", "id", id)
        );
        degreeRepo.deleteById(id);

    }
}
