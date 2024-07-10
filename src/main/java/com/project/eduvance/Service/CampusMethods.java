package com.project.eduvance.Service;

import com.project.eduvance.Entity.Campus;

import java.util.List;

public interface CampusMethods {
    Campus createCampus(Campus campus);

    Campus updateCampus(String csId,Campus campus);

    void deleteCampus(String csId);

    List<Campus> getAllCampus();

    Campus getCampus(String csId);


}

