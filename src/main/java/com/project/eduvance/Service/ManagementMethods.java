package com.project.eduvance.Service;

import com.project.eduvance.Entity.Management;

import java.util.List;

public interface ManagementMethods {
    Management createManagement(Management management);
    Management getManagement(String mtId);
    Management updateManagement(String mtId,Management management);
    void deleteManagement(String mtId);
    List<Management> getAllManagement();
}
