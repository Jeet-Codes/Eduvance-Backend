package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.ManagementDto;
import com.project.eduvance.Entity.Campus;
import com.project.eduvance.Entity.Management;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.CampusRepo;
import com.project.eduvance.Repository.ManagementRepo;
import com.project.eduvance.Repository.UserRepo;
import com.project.eduvance.Service.ManagementMethods;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ManagementService implements ManagementMethods {
    @Autowired
    private ManagementRepo managementRepo;

    @Autowired
    private UserRepo userRepo;

    private CampusRepo camRepo;

    @Override
    public Management createManagement(ManagementDto dto) {

        Campus campus = camRepo.findById(dto.getCampusId())
                .orElseThrow(() -> new ResourceNotFound("Campus Doesn't exist with this id" + dto.getCampusId()));

        // ready the Management Object
        Management mng = new Management();
        String s = "MT";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        mng.setMtId(s + UUID.randomUUID().toString().substring(0, 4).toUpperCase() + t);
        mng.setMtName(dto.getMtName());
        mng.setMtEmail(dto.getMtEmail());
        mng.setMtPasswd(dto.getMtPasswd());
        mng.setMtPhone(dto.getMtPhone());
        mng.setMtBloodGrup(dto.getMtBloodGrup());
        mng.setMtGender(dto.getMtGender());
        mng.setMtPhoto(dto.getMtPhoto());
        mng.setCampus(campus);
        // save Management Object
        Management storedManagement = managementRepo.save(mng);

        //Saving the Data in the User Database
        User mtUser = User.builder()
                .userId(storedManagement.getMtId())
                .userName(storedManagement.getMtName())
                .userPasswd(storedManagement.getMtPasswd())
                .userEmail(storedManagement.getMtEmail())
                .build();
        userRepo.save(mtUser);

        return storedManagement;
    }

    @Override
    public Management getManagement(String mtId) {
        return managementRepo.findById(mtId).orElseThrow(
                () -> new RuntimeException("Management not found"+mtId)
        );
    }

    @Override
    public Management updateManagement(String mtId, Management management) {
        User user=userRepo.findById(mtId).orElseThrow(
                () -> new RuntimeException("Management not found"+mtId)
        );
        Management storedManagement = managementRepo.findById(mtId).orElseThrow(
                () -> new RuntimeException("Management not found"+mtId)
        );
        user.setUserEmail(management.getMtEmail());
        user.setUserPasswd(management.getMtPasswd());
        userRepo.save(user);
        storedManagement.setMtEmail(management.getMtEmail());
        storedManagement.setMtPasswd(management.getMtPasswd());
        storedManagement.setMtPhone(management.getMtPhone());
        storedManagement.setMtPhoto(management.getMtPhoto());
        managementRepo.save(storedManagement);


        return storedManagement;
    }

    @Override
    public void deleteManagement(String mtId) {
        userRepo.findById(mtId).orElseThrow(
                ()->new RuntimeException("Management not found"+mtId)
        );
        managementRepo.findById(mtId).orElseThrow(
                () -> new RuntimeException("Management not found"+mtId)
        );
        userRepo.deleteById(mtId);
        managementRepo.deleteById(mtId);


    }

    @Override
    public List<Map<String, String>> getAllManagement() {
        return managementRepo.findAllManagementWithCampusName();
    }
}
