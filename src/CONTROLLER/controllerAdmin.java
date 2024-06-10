package CONTROLLER;
import MODEL.*;
import NODE.*;

import java.util.List;

public class controllerAdmin {
    public void addAdmin(String nama, String pass, String nip) {
        int Id = modell.modelAdmin.getLasIdAdmin();
        Id++;
        if (cekUsername(nama)) {
            System.out.println("Username telah digunakan");
        } else if (cekPass(pass)) {
            System.out.println("Password telah digunakan");
        } else {
            Admin admin = new Admin(Id, nama, pass, nip);
            modell.modelAdmin.TambahAdmin(admin);
            modell.modelAdmin.commit();
            System.out.println("Username dan password ditambahkan!!");
        }
    }


    public boolean cekUsername(String username) {
        List<Admin> admins = modell.modelAdmin.listStaff;
        if (admins != null) {
            for (Admin admin : admins) {
                if (admin.getNama().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cekPass(String pass) {
        List<Admin> admins = modell.modelAdmin.listStaff;
        if (admins != null) {
            for (Admin admin : admins) {
                if (admin.getPass().equals(pass)) {
                    return true;
                }
            }
        }
        return false;
    }
}
