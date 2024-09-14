package com.project.eduvance.Controllers;

import java.util.List;

import com.project.eduvance.Dto.List.SchoolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.eduvance.Dto.SchoolDto;
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
		return new ResponseEntity<>(scDto, HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<SchoolResponse> getAllSchool() {

		return schoolService.listSchool();

	}


	@PostMapping("/withDegree/{id}")
	public ResponseEntity addSchoolWithDegree(@RequestBody SchoolDto schoolDto,@PathVariable String id) {
		Object added = schoolService.addSchoolWithDegree(schoolDto, id);
		return new ResponseEntity(added,HttpStatus.OK);
	}
}
