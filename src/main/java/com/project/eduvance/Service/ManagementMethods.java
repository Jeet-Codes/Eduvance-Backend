package com.project.eduvance.Service;

import com.project.eduvance.Dto.LoginMtResponse;
import com.project.eduvance.Dto.ManagementDto;
import com.project.eduvance.Entity.Management;

import java.util.List;
import java.util.Map;

public interface ManagementMethods {
    Management createManagement(ManagementDto dto);
    Management getManagement(String mtId);
    Management updateManagement(String mtId,Management management);
    void deleteManagement(String mtId);
    List<Map<String, String>> getAllManagement();

    LoginMtResponse getLoginMt(String mtId);


}
