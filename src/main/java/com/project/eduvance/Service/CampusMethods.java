package com.project.eduvance.Service;

import com.project.eduvance.Dto.CampusDto;
import com.project.eduvance.Entity.Campus;

import java.util.List;
import java.util.Map;

public interface CampusMethods {
    Campus createCampus(CampusDto resCampus);

    Campus updateCampus(String csId,Campus campus);

    void deleteCampus(String csId);

    List<Map<String, String>> getAllCampus();

    Campus getCampus(String csId);


}

