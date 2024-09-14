package com.project.eduvance.Service.ServiceImp;

import java.util.*;

import com.project.eduvance.Dto.List.BranchResponse;
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
		branch.setName(branchDto.getName());
		branch.setDescription(branchDto.getDesc());
		branch.setSchool(school.get());
		Branch br = branchRepository.save(branch);

		return new BranchDto(br.getName(), br.getDescription(), br.getSchool().getId());
	}

	@Override
	public List<BranchResponse> listBranch() {
		// TODO Auto-generated method stub
		List<Branch> branches = branchRepository.findAll();
		List<BranchResponse> branchResponses = new ArrayList<BranchResponse>();
		for (Branch branch : branches) {
			BranchResponse response = new BranchResponse();
			response.setBranchId(branch.getId());
			response.setBranchName(branch.getName());

			// Add the mapped BranchResponse to the list
			branchResponses.add(response);
		}
		return branchResponses;
	}

	public List<Branch> listBranches() {
		return branchRepository.findAll();
	}

}
