package com.project.eduvance.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDto {
	private String branchName;
	private String branchDesc;
	private String schoolId;

}
