package com.project.eduvance.Service.ServiceImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.project.eduvance.Repository.BranchRepo;
import com.project.eduvance.Repository.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.eduvance.Dto.BranchDto;
import com.project.eduvance.Entity.Branch;
import com.project.eduvance.Entity.School;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Service.BranchMethods;

@Service
public class BranchService implements BranchMethods {
	@Autowired
	private BranchRepo branchRepository;
	@Autowired
	private SchoolRepo schoolRepository;

	@Override
	public BranchDto insertBranch(BranchDto branchDto) {
		String s = "BR";
		String t = String.valueOf(new Date().getTime()).substring(7, 12);
		// get the school object
		Optional<School> school = Optional.of(schoolRepository.findById(branchDto.getSchoolId())
				.orElseThrow(() -> new ResourceNotFound("School Not Found with Id : " + branchDto.getSchoolId())));

		Branch branch = new Branch();
		branch.setId(s + UUID.randomUUID().toString().substring(0, 4) + t);
		branch.setName(branchDto.getBranchName());
		branch.setDescription(branchDto.getBranchDesc());
		branch.setSchool(school.get());
		Branch br = branchRepository.save(branch);

		return new BranchDto(br.getName(), br.getDescription(), br.getSchool().getId());
	}

	@Override
	public List<Branch> listBranch() {
		// TODO Auto-generated method stub
		return branchRepository.findAll();
	}

}
