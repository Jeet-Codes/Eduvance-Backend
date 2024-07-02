package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Otp {

    @Id
    private long id;
    private String otp;
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
}
