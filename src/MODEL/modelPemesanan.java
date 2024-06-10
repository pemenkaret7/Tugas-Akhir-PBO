package MODEL;

import ModelGson.ModelGSON;
import NODE.Admin;
import NODE.Kamar;
import NODE.Pemesanan;
import NODE.Tamu;
import com.google.gson.reflect.TypeToken;

import java.time.LocalDate;
import java.util.ArrayList;

public class modelPemesanan {
    public ArrayList<Pemesanan> daftarPemesanan ;

    ModelGSON<Pemesanan> pemesananModelGSON;

    public modelPemesanan(){
        pemesananModelGSON = new ModelGSON<>("src/DATA/Pemesanan.json");
        daftarPemesanan = new ArrayList<>();
        loadPEMESANAN();
    }

    public void loadPEMESANAN(){
        daftarPemesanan = pemesananModelGSON.readFromFile(new TypeToken<ArrayList<Pemesanan>>() {}.getType());
    }

    public void commit(){
        pemesananModelGSON.writeToFile(daftarPemesanan);
    }


    public void TambahPemesanan(int ID, String nama,String telp,String nik,String negara,Kamar nomorKamar, String tglCheckin, String tglCheckout, int jumlahMalam, String jenisPembayaranr, int total){
        daftarPemesanan.add(new Pemesanan(ID,nama,telp,nik,negara,nomorKamar, tglCheckin, tglCheckout, jumlahMalam, jenisPembayaranr, total));
        pemesananModelGSON.writeToFile(daftarPemesanan);
    }

    public int getLasIdPESAN(){
        int id = 0;
        if (daftarPemesanan != null) {
            for (Pemesanan pesan : daftarPemesanan) {
                id = pesan.getID();
            }
        }
        return id;
    }

    public Pemesanan getNamaPemesan(String nama) {
        for (Pemesanan pesan : daftarPemesanan) {
            if (pesan.getNama().equals(nama)) {
                return pesan;
            }
        }
        return null;
    }

    public Pemesanan getidPesan(int kode){
        for (Pemesanan pesan: daftarPemesanan){
            if(pesan.getID() == kode){
                return pesan;
            }
        }
        System.out.println("ID PEMESANAN TIDAK ADA!!");
        return null;
    }

    public boolean delete(int kode){
        Pemesanan pesan = getidPesan(kode);
        if (pesan != null){
            daftarPemesanan.remove(pesan);
            return true;
        }
        return false;
    }

    public void viewAllPemesanan (){
        for (int i = 0 ; i < daftarPemesanan.size() ; i++){
            loadPEMESANAN();
            daftarPemesanan.get(i).viewPesanan();
            System.out.println("=============");
        }
    }

}