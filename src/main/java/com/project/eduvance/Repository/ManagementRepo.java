package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface ManagementRepo extends JpaRepository<Management, String> {

    @Query(value = "SELECT m.mt_id mtId, m.mt_name mtName, m.mt_email mtEmail, "
            + "m.mt_passwd  mtPasswd, m.mt_gender  mtGender, m.mt_blood_grup  mtBloodGrup, "
            + "m.mt_photo  unPhoto, m.date_created  dateCreated, c.cs_name  campusName " + "FROM management m "
            + "JOIN campus c ON m.campus_id = c.cs_id", nativeQuery = true)
    List<Map<String, String>> findAllManagementWithCampusName();


}
