package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtpRepo extends JpaRepository<Otp, Long> {

    @Query("SELECT o FROM Otp o WHERE o.email = :email ORDER BY o.createdAt DESC")
    List<Otp> findByEmailSortedByDate(@Param("email") String email);
}