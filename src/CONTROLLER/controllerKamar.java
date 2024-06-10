package CONTROLLER;
import MODEL.*;
import NODE.*;

import java.util.ArrayList;
import java.util.List;


public class controllerKamar {
    public void addKamar(String jeniskamar, int harga) {
        int kode = modell.modelKamar.getLasKODEKamar();
        kode++;
        boolean status = true;
        Kamar kamar = new Kamar(kode, jeniskamar, harga, status);
        modell.modelKamar.Tambahkamar(kamar);
        modell.modelKamar.commit();
        System.out.println("Kamar suda ditambahkan!!");
    }

//    public boolean updateStatusKamar(int kode, boolean status) {
//            Kamar kam = modell.modelKamar.getKamarr(kode);
//            if (kam != null) {
//                kam.setStatus(status);
//                System.out.println("status diperbaruii!!!");
//                return true;
//            }
//        return false;
//    }

        public boolean updateJeniskamar ( int kode, String jenis){
            Kamar kam = modell.modelKamar.getKamarr(kode);
            if (kam != null) {
                kam.setJeniskamar(jenis);
                modell.modelKamar.commit();
                System.out.println("jenis kamar diperbarui!!");
                return true;
            }
            return false;
        }


        public boolean updateHarga ( int kode, int harga){
            Kamar kam = modell.modelKamar.getKamarr(kode);
            if (kam != null) {
                kam.setHarga(harga);
                modell.modelKamar.commit();
                System.out.println("harga diperbarui!!");
                return true;
            }
            return false;
        }

    public List<Kamar> viewKamarKosong() {
        List<Kamar> kamars = new ArrayList<>();
        for (Kamar kamar : modell.modelKamar.kamarList) {
            if (kamar.getStatus()) {
                kamars.add(kamar);
            }
        }
        return kamars;
    }

}




