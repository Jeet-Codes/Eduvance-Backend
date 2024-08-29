package com.project.eduvance.Service.ServiceImp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

	@Override
	public SchoolDto addSchool(SchoolDto school) {
		// TODO Auto-generated method stub
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
	public List<School> listSchool() {
		// TODO Auto-generated method stub
		return schoolRepository.findAll();
	}

}
