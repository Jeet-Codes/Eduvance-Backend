package com.project.eduvance.Controllers;

import com.project.eduvance.Entity.Admin;
import com.project.eduvance.Service.AdminMethods;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/eduvance/admin")
@AllArgsConstructor
public class AdminController {
    private AdminMethods adminMethods;
    // add admin rest api
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin admin1 = adminMethods.createAdmin(admin);
        return  new ResponseEntity<>(admin1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmin(){
        List<Admin> admins = adminMethods.getAllAdmin();
        return ResponseEntity.ok(admins);
    }
    @GetMapping("{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") String id){
        Admin admin =  adminMethods.getAdminById(id);
        return ResponseEntity.ok(admin);

    }
    @PutMapping("{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id,@RequestBody Admin admin) {
        Admin admin1 = adminMethods.updateAdmin(id,admin);
        return ResponseEntity.ok(admin1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
        adminMethods.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully of id");
    }

}
