package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Entity.Degree;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.DegreeRepo;
import com.project.eduvance.Service.DegreeMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DegreeService implements DegreeMethods
{

    @Autowired
    private DegreeRepo degreeRepo;

    @Override
    public Degree createDegree(Degree degree) {

        Degree save = degreeRepo.save(degree);
        return save;
    }

    @Override
    public Degree updateDegree(String id, Degree degree) {
        degreeRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Degree",id);
        )

        return null;
    }

    @Override
    public Degree getDegree(String id) {
        return null;
    }

    @Override
    public List<Degree> getAllDegree() {
        return List.of();
    }

    @Override
    public void deleteDegree(String id) {

    }
}
