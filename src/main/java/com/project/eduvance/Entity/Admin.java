package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
public class Admin {
    @Id
    private String adminId;
    private String adminEmail;
    private String adminPasswd;
}
