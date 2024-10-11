package com.project.eduvance.Controllers;

import com.project.eduvance.Dto.DegreeDto;
import com.project.eduvance.Entity.Degree;
import com.project.eduvance.Service.ServiceImp.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/degree")
@CrossOrigin("*")
public class DegreeController {

    @Autowired
    private DegreeService degreeService;


    @PostMapping("/create")
    public ResponseEntity<Degree> addDegree(@RequestBody DegreeDto degree){
        Degree saved = degreeService.createDegree(degree);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Degree> updateDegree(@PathVariable String id, @RequestBody Degree degree){
        Degree updated = degreeService.updateDegree(id, degree);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Degree> getDegree(@PathVariable String id){
        Degree degree = degreeService.getDegree(id);
        return new ResponseEntity<>(degree, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Degree>> getAllDegree(){
        List<Degree> degrees = degreeService.getAllDegree();
        return new ResponseEntity<>(degrees, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDegree(@PathVariable String id){
        degreeService.deleteDegree(id);
        return new ResponseEntity<>("Degree having"+id+" is deleted Successfully",HttpStatus.OK);
    }



}
