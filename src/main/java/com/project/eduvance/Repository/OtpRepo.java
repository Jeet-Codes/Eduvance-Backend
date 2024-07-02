package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepo extends JpaRepository<Otp, Long> {
    Otp findByEmail(String Email);
}
