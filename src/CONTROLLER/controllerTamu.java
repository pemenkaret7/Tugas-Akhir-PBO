package CONTROLLER;
import MODEL.*;
import NODE.*;


public class controllerTamu {
    public void addTamu(String nama, String telp, String nik, String negara, Kamar kamar){
    int id = modell.modelTamu.getLasIdTamu();
    id++;
        Tamu tamu = new Tamu(id,nama,telp,nik,negara,kamar);
        modell.modelTamu.TambahTAMU(tamu);
        modell.modelTamu.commit();
    }

    public Tamu ViewDataTamu(String nama) {
        return modell.modelTamu.getNamaTamu(nama);
    }
}

