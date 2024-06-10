package MODEL;

import ModelGson.ModelGSON;
import NODE.Kamar;
import NODE.Pemesanan;
import NODE.Tamu;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class modelTamu {
    public ArrayList<Tamu> daftartamu ;

    ModelGSON<Tamu> tamuModelGSON;

    public modelTamu(){
    tamuModelGSON = new ModelGSON<>("src/DATA/Tamu.json");
    daftartamu = new ArrayList<>();
    loadTamu();
    }

    public void loadTamu(){
        daftartamu = tamuModelGSON.readFromFile(new TypeToken<ArrayList<Tamu>>() {}.getType());;
    }

    public void commit(){
        tamuModelGSON.writeToFile(daftartamu);
    }

    public void TambahTAMU(Tamu tamu){
        daftartamu.add(tamu);
        tamuModelGSON.writeToFile(daftartamu);
    }
    public Tamu getNamaTamu(String nama) {
        for (Tamu tamu : daftartamu) {
            if (tamu.getName().equals(nama)) {
                return tamu;
            }
        }
        System.out.println("Nama TAMU TIDAK ADA !!");
        return null;
    }

    public int getLasIdTamu(){
        int id = 0;
        if (daftartamu != null) {
            for (Tamu tam : daftartamu) {
                id = tam.getID();
            }
        }
        return id;
    }
    public void viewAllTAMU(){
        for (int i=0; i < daftartamu.size();i++){
                loadTamu();
                daftartamu.get(i).viewTamu();
                System.out.println("===========");
        }
    }

}
