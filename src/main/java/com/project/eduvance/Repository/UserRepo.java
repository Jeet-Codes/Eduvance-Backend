package com.project.eduvance.Repository;


import com.project.eduvance.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {

    @Query("select u from User u where userEmail = :email and userPasswd = :pass")
    User findByUserIdAndUserPasswd(@Param("email") String email, @Param("pass") String pass);

    Optional<User> findByUserEmail(String UserEmail);
}