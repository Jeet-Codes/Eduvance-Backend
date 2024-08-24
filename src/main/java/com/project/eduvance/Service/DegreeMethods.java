package com.project.eduvance.Service;

import com.project.eduvance.Entity.Degree;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DegreeMethods {

    Degree createDegree(Degree degree);

    Degree updateDegree(String id,Degree degree);

    Degree getDegree(String id);

    List<Degree> getAllDegree();

    void deleteDegree(String id);
}
