package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface ManagementRepo extends JpaRepository<Management, String> {

    @Query(value = "SELECT m.mt_id AS mtId, m.mt_name AS mtName, m.mt_email AS mtEmail, "
            + "m.mt_passwd AS mtPasswd, m.mt_gender AS mtGender, m.mt_blood_grup AS mtBloodGrup, "
            + "m.un_photo AS unPhoto, m.date_created AS dateCreated, c.cs_name AS campusName " + "FROM management m "
            + "JOIN campus c ON m.campus_id = c.cs_id", nativeQuery = true)
    List<Map<String, String>> findAllManagementWithCampusName();


}
