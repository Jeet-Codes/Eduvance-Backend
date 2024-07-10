package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ManagementRepo extends JpaRepository<Management, String> {
}
