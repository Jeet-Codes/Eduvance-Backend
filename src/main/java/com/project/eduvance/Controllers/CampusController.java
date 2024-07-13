package com.project.eduvance.Controllers;

import com.project.eduvance.Entity.Campus;
import com.project.eduvance.Service.ServiceImp.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/eduvance/admin/campus")
public class CampusController {
    @Autowired
    private CampusService campusService;

    @PostMapping
    public ResponseEntity<Campus> addCampus(@RequestBody Campus campus) {
        Campus createcampus=campusService.createCampus(campus);
        return new ResponseEntity<>(createcampus, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Campus>> getAllCampus() {
        List<Campus> campus=campusService.getAllCampus();
        return new ResponseEntity<>(campus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campus> getCampusById(@PathVariable String id) {
        Campus storedCampus=campusService.getCampus(id);
        return new ResponseEntity<>(storedCampus, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campus> updateCampus(@PathVariable String id,@RequestBody Campus campus) {
        Campus updatecampus=campusService.updateCampus(id, campus);
        return new ResponseEntity<>(updatecampus, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCampus(@PathVariable String id) {
        campusService.deleteCampus(id);
        return new ResponseEntity<>("Campus having id: "+id+" deleted Successfully !",HttpStatus.OK);
    }



}
