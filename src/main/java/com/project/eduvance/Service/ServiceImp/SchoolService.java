package com.project.eduvance.Service.ServiceImp;

import java.util.*;

import com.project.eduvance.Dto.List.SchoolResponse;
import com.project.eduvance.Entity.Degree;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.DegreeRepo;
import com.project.eduvance.Repository.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.eduvance.Dto.SchoolDto;
import com.project.eduvance.Entity.School;
import com.project.eduvance.Service.SchoolMethods;

@Service
public class SchoolService implements SchoolMethods {

	@Autowired
	private SchoolRepo schoolRepository;


	@Autowired
	private DegreeRepo degreeRepo;

	@Override
	public SchoolDto addSchool(SchoolDto school) {
		// This is OLD One Code for Adding School Without Degree
		String s = "SC";
		String t = String.valueOf(new Date().getTime()).substring(10, 13);
		School newSchool = new School();
		newSchool.setId(s + UUID.randomUUID().toString().substring(0, 4) + t);
		newSchool.setDescription(school.getSchoolDescription());
		newSchool.setName(school.getSchoolName());
		School returnedSchool = schoolRepository.save(newSchool);
		return new SchoolDto(returnedSchool.getName(),returnedSchool.getDescription());
	}

	@Override
	public Object addSchoolWithDegree(SchoolDto school, String id) {
		String s = "SC";
		String t = String.valueOf(new Date().getTime()).substring(10, 13);
		School newSchool = new School();
		newSchool.setId(s + UUID.randomUUID().toString().substring(0, 4) + t);
		newSchool.setDescription(school.getSchoolDescription());
		newSchool.setName(school.getSchoolName());

		Degree found = degreeRepo.findById(id).orElseThrow(
				() -> new ResourceNotFound("Degree", "id", id)
		);

		// assign child to parent
		newSchool.setDegree(found);

		School saved = schoolRepository.save(newSchool);

		SchoolDto returnedSchool = new SchoolDto(saved.getId(), saved.getName(), saved.getDescription());

		return returnedSchool;
	}

	@Override
	public List<SchoolResponse> listSchool() {
		// Fetch all schools from the repository
		List<School> all = schoolRepository.findAll();

		// Create a list to store the responses
		List<SchoolResponse> schoolResponses = new ArrayList<>();

		// Map each School entity to a SchoolResponse DTO
		for (School school : all) {
			SchoolResponse response = new SchoolResponse();
			response.setId(school.getId());
			response.setSchoolName(school.getName());

			// You can map other fields if needed, like description or branches
			// response.setDescription(school.getDescription());
			// response.setBranches(school.getBranches()); // If branches are needed in the response

			schoolResponses.add(response);
		}

		// Return the list of SchoolResponse objects
		return schoolResponses;
	}

	@Override
	public List<School> getSchoolsByUniversityId(String universityId) {

		return schoolRepository.findSchoolsByUniversityId(universityId);
	}

}
