package com.project.eduvance.Controllers;

import com.project.eduvance.Entity.Management;

import com.project.eduvance.Service.ServiceImp.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/eduvance/admin/management")
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    @PostMapping
    public ResponseEntity<Management> createManagement(@RequestBody Management management) {
        Management createdMt = managementService.createManagement(management);
        return new ResponseEntity<>(createdMt, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Management> getManagement(@PathVariable String id) {
        Management storedMt = managementService.getManagement(id);
        return new ResponseEntity<>(storedMt, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Management>> getManagements() {
        List<Management> allManagement = managementService.getAllManagement();
        return new ResponseEntity<>(allManagement, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Management> updateManagement(@PathVariable String id,@RequestBody Management management) {
        Management updatedMt = managementService.updateManagement(id, management);
        return  new ResponseEntity<>(updatedMt, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteManagement(@PathVariable String id) {
        managementService.deleteManagement(id);
        return new ResponseEntity<>("Management having id: "+id+" deleted Successfully !",HttpStatus.FOUND);
    }
}
