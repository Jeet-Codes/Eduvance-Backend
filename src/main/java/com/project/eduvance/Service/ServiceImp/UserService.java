package com.project.eduvance.Service.ServiceImp;


import com.project.eduvance.Entity.*;
import com.project.eduvance.Dto.ApiResponse;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.*;
import com.project.eduvance.Service.UserMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserMethods {
    @Autowired
    private UserRepo userRepo;
//
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private ManagementRepo managementRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ApiResponse login(String userId, String password) {
        User byUserIdAndUserPasswd = userRepo.findByUserIdAndUserPasswd(userId, password);
        if (byUserIdAndUserPasswd != null) {
            ApiResponse loginSuccessfully = new ApiResponse("login Successfully", true, HttpStatus.ACCEPTED, byUserIdAndUserPasswd);
            return loginSuccessfully;
        }else {
            return new ApiResponse("login failed", false, HttpStatus.NOT_FOUND, null);
        }
    }

    @Override
    public ApiResponse forgot(String email,String password) {
        Optional<User> byUserEmail = userRepo.findByUserEmail(email);
        // OTP Verification
        if (byUserEmail.isPresent()) {
            User user = byUserEmail.get();
            user.setUserPasswd(password);
            User save = userRepo.save(user);
            String userId = save.getUserId();
            String substring = userId.substring(0, 2);
//            System.out.println(substring);

//            if(substring.equals("AD")) {
////                Admin find=adminRepo.findById(userId).orElseThrow(
////                        ()->new ResourceNotFound("Admin","id",userId));
////                find.setAdminPasswd(save.getUserPasswd());
////                adminRepo.save(find);
////            }
            switch (substring) {
                case "ST" -> {
                    Student stud = studentRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Student", "id", userId));
                    stud.setPassword(save.getUserPasswd());
                    studentRepo.save(stud);
                }
                case "FT" -> {
                    Faculty find = facultyRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Faculty", "id", userId));
//                System.out.println(find);
                    find.setPassword(save.getUserPasswd());
                    facultyRepo.save(find);
                }
                case "MT" -> {
                    Management find = managementRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Management", "id", userId));
                    find.setMtPasswd(save.getUserPasswd());
                    managementRepo.save(find);
                }
                default -> {
                    Admin find = adminRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Admin", "id", userId));
                    find.setAdminPasswd(save.getUserPasswd());
                    adminRepo.save(find);
                }

            }
           return new ApiResponse("Updated Successfully", true, HttpStatus.ACCEPTED, save);
        } else {
            ApiResponse userNotPresent = ApiResponse.builder()
                    .message("user not present")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
            return userNotPresent;
        }
    }

    @Override
    public boolean userExists(String email) {
        Optional<User> byUserEmail = userRepo.findByUserEmail(email);
        if (byUserEmail.isPresent()) {
            User user = byUserEmail.get();
            String userId = user.getUserId();
            String substring = userId.substring(0, 2);
            switch (substring) {
                case "AD" -> {
                    Admin find = adminRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Admin", "id", userId));

                    return !find.getAdminEmail().isBlank();
                }
                case "MT" -> {
                    Management find = managementRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Management", "id", userId)
                    );
                    return !find.getMtEmail().isBlank();
                }
                case "ST" -> {
                    Student find = studentRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Student", "id", userId)
                    );
                    return !find.getEmail().isBlank();

                }
                default -> {
                    Faculty find = facultyRepo.findById(userId).orElseThrow(
                            () -> new ResourceNotFound("Faculty", "id", userId)
                    );
                    return !find.getEmail().isBlank();
                }
            }

        }
        return false;
    }
}
