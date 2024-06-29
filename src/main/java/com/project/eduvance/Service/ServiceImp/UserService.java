package com.project.eduvance.Service.ServiceImp;


import com.project.eduvance.Entity.Admin;
import com.project.eduvance.Dto.ApiResponse;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.AdminRepo;
import com.project.eduvance.Repository.UserRepo;
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
//    @Autowired
//    private StudentRepo studentRepo;
//
//    @Autowired
//    private FacultyRepo facultyRepo;
//
//    @Autowired
//    private MangementRepo mangementRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ApiResponse login(String userId, String password) {
        Optional<User> byUserIdAndUserPasswd = userRepo.findByUserIdAndUserPasswd(userId, password);
        if (byUserIdAndUserPasswd.isPresent()) {
            ApiResponse loginSucessfully = new ApiResponse("login sucessfully", true, HttpStatus.ACCEPTED, byUserIdAndUserPasswd.get());
            return loginSucessfully;
        }else {
            return new ApiResponse("login failed", false, HttpStatus.NOT_FOUND, null);
        }
    }

    @Override
    public ApiResponse forgot(String email,String password) {
        Optional<User> byUserEmail = userRepo.findByUserEmail(email);
        if (byUserEmail.isPresent()) {
            User user = byUserEmail.get();
            user.setUserPasswd(password);
            User save = userRepo.save(user);
            String userId = save.getUserId();
            String substring = userId.substring(0, 2);
//            System.out.println(substring);
//            if(substring.equals("ST")) {
//                Student stud = studentRepo.findById(userId).orElseThrow(
//                        ()->new ResourceNotFound("Student","id",userId));
//                stud.setStPasswd(save.getUserPasswd());
//                studentRepo.save(stud);
//            }else if(substring.equals("FT")){
//                Faculty find=facultyRepo.findById(userId).orElseThrow(
//                        ()->new ResourceNotFound("Faculty","id",userId));
////                System.out.println(find);
//                find.setFacultyPasswd(save.getUserPasswd());
//                facultyRepo.save(find);
//            }else if(substring.equals("MT")){
//                Management find=mangementRepo.findById(userId).orElseThrow(
//                        ()->new ResourceNotFound("Management","id",userId));
//                find.setMtPasswd(save.getUserPasswd());
//                mangementRepo.save(find);
//            }else{
//                Admin find=adminRepo.findById(userId).orElseThrow(
//                        ()->new ResourceNotFound("Admin","id",userId));
//                find.setAdminPasswd(save.getUserPasswd());
//                adminRepo.save(find);
//            }
            if(substring.equals("ST")) {
                Admin find=adminRepo.findById(userId).orElseThrow(
                        ()->new ResourceNotFound("Admin","id",userId));
                find.setAdminPasswd(save.getUserPasswd());
                adminRepo.save(find);
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
}
