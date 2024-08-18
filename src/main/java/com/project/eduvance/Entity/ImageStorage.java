package com.project.eduvance.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ImageStorage {
    @Id
    @Column(name = "imageName")
    private String Name;
    @Column(name = "imagePath")
    private String Path;

    private String userId;
    @Column(name = "imageType")
    private String Type;

}
