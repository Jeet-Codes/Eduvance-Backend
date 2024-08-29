package com.project.eduvance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eduvance.Entity.Branch;

public interface BranchRepo extends JpaRepository<Branch, String> {

}
