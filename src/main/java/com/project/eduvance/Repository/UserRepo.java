package com.project.eduvance.Repository;


import com.project.eduvance.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findByUserIdAndUserPasswd(String UserId, String UserPasswd);
    Optional<User> findByUserEmail(String UserEmail);
}