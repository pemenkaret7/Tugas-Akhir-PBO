package MODEL;

import ModelGson.ModelGSON;
import NODE.Admin;
import NODE.Kamar;
import NODE.Tamu;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class modelAdmin {
    public ArrayList<Admin> listStaff;

    ModelGSON<Admin> adminModelGSON ;

    public modelAdmin(){
        adminModelGSON = new ModelGSON<>("src/DATA/Admin.json");
        listStaff = new ArrayList<>();
        loadAdmin();
    }

    public void loadAdmin(){
        listStaff = adminModelGSON.readFromFile(new TypeToken<ArrayList<Admin>>() {}.getType());;
    }

    public void commit(){
        adminModelGSON.writeToFile(listStaff);
    }

    public void TambahAdmin(Admin admin){
        listStaff.add(admin);
        adminModelGSON.writeToFile(listStaff);
    }

    public int getLasIdAdmin(){
        int id = 0;
        if (listStaff != null) {
            for (Admin min : listStaff) {
                id = min.getID();
            }
        }
        return id;
    }

    public void ViewAlladmin(){
        for (int i = 0 ; i < listStaff.size();i++){
            listStaff.get(i).viewAdmin();
            System.out.println("==========");
        }
    }
}
