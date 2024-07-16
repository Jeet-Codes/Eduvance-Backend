package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Entity.Management;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Repository.ManagementRepo;
import com.project.eduvance.Repository.UserRepo;
import com.project.eduvance.Service.ManagementMethods;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ManagementService implements ManagementMethods {
    @Autowired
    private ManagementRepo managementRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Management createManagement(Management management) {
        String s="MT";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        management.setMtId(s + UUID.randomUUID().toString().substring(0, 4) +t);

        Management storedManagement = managementRepo.save(management);
        User user=userRepo.save(
                new User(storedManagement.getMtId(),storedManagement.getMtName(),storedManagement.getMtPasswd(),storedManagement.getMtPasswd())
        );
        userRepo.save(user);
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
        storedManagement.setUnPhoto(management.getUnPhoto());
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
    public List<Management> getAllManagement() {
        return managementRepo.findAll();
    }
}
