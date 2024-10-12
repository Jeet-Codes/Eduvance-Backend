package com.project.eduvance.Service;

import java.util.List;

import com.project.eduvance.Dto.BranchDto;
import com.project.eduvance.Dto.List.BranchResponse;
import com.project.eduvance.Entity.Branch;

public interface BranchMethods {

   BranchDto insertBranch(BranchDto branchDto);

   List<BranchResponse> listBranch();

   List<Branch> getBranchesByUniversityId(String universityId);
}
