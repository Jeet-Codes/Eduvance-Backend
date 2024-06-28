package com.project.eduvance.Service;



import com.project.eduvance.Entity.Admin;

import java.util.List;

public interface AdminMethods {
    Admin createAdmin(Admin admin);

    //get the particular Admin
    Admin getAdminById(String id);

    //List of Admins
    List<Admin> getAllAdmin();

    //Delete the Admin
    void deleteAdmin(String id);

    //update the admin
    Admin updateAdmin(String id,Admin updatedAdmin);
}
