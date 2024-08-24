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
        Degree degree1 = degreeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Degree", "id", id)
        );
        degree1.setName(degree.getName());
        degree1.setDescription(degree.getDescription());
        degree1.setDuration(degree.getDuration());

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
