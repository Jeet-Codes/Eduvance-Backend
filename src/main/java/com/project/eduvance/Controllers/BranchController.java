package com.project.eduvance.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.eduvance.Dto.BranchDto;
import com.project.eduvance.Entity.Branch;
import com.project.eduvance.Service.ServiceImp.BranchService;

@RestController
@RequestMapping("/eduvance/branch")
@CrossOrigin("*")
public class BranchController {
	@Autowired
	private BranchService branchService;

	@PostMapping
	public ResponseEntity<BranchDto> addBranchWithSchool(@RequestBody BranchDto branchDto) {

		BranchDto resBranchDto = branchService.insertBranch(branchDto);
		return new ResponseEntity<BranchDto>(resBranchDto, HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<Branch> getAllBranch(){
		return branchService.listBranch();
	}

}
