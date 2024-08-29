package com.project.eduvance.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.eduvance.Dto.SchoolDto;
import com.project.eduvance.Entity.School;
import com.project.eduvance.Service.ServiceImp.SchoolService;

@RestController
@RequestMapping("/eduvance/school")
@CrossOrigin("*")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;

	@PostMapping
	public ResponseEntity<SchoolDto> addSchool(@RequestBody SchoolDto schoolDto) {
		SchoolDto scDto = schoolService.addSchool(schoolDto);
		return new ResponseEntity<SchoolDto>(scDto, HttpStatus.OK);
	}

	@GetMapping
	public List<School> getAllSchool() {

		return schoolService.listSchool();

	}

}
