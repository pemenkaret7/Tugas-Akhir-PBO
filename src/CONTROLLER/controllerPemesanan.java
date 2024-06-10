package CONTROLLER;
import MODEL.*;
import NODE.*;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class controllerPemesanan {

    controllerTamu controllerTamu = new controllerTamu();

    //LocalDate.parse buat konversi string tanggal jadi objek LocalDate
    //kelas LocalDate dari java.time di Java biasae pake format YYYY-MM-DD
    //untuk mengambil jarak hari antara tanggal cekin dan cekot
    public long JumlahMalam(String tglCheckin, String tglCheckout) {
        if (tglCheckin != null && tglCheckout != null) {
            return ChronoUnit.DAYS.between(LocalDate.parse(tglCheckin), LocalDate.parse(tglCheckout));
        } else {
            return 0;
        }
    }

    public void checkinPemesanan(String nama, String telp, String nik, String negara, int kodeKamar, String tglCheckin, String tglCheckout, String jenisPembayaran) {
        int idPemesanan = modell.modelPemesanan.getLasIdPESAN();
        Kamar kamar = modell.modelKamar.getKamarr(kodeKamar);
        idPemesanan++;

        System.out.println("kodeKamar=" + kodeKamar + ", tglCheckin=" + tglCheckin + ", tglCheckout=" + tglCheckout);

        if (kamar != null && kamar.getStatus()) {
            int total = (int) (kamar.getHarga() * JumlahMalam(tglCheckin, tglCheckout));
            modell.modelPemesanan.TambahPemesanan(idPemesanan, nama, telp, nik, negara, kamar, tglCheckin, tglCheckout, (int) JumlahMalam(tglCheckin, tglCheckout), jenisPembayaran, total);
            controllerTamu.addTamu(nama, telp, nik, negara, kamar);

            kamar.setStatus(false);

            modell.modelKamar.commit();
            modell.modelTamu.commit();
            modell.modelPemesanan.commit();
            System.out.println("Pemesanan berhasil ditambahkan bang!!");
            System.out.println(" ");
        } else {
            System.out.println("Kamar tidak tersedia bang!!");
            System.out.println(" ");
        }
    }


    public boolean checkoutPesanan(String namaPemesan, int kodeKamar) {
        Pemesanan pemesanan = modell.modelPemesanan.getNamaPemesan(namaPemesan);
        if (pemesanan != null) {
            Kamar kamar = modell.modelKamar.getKamarr(kodeKamar);
            if (kamar != null) {
                Boolean del = modell.modelPemesanan.delete(pemesanan.getID());
                if (del) {
                    kamar.setStatus(true);
                    modell.modelKamar.commit();
                    modell.modelPemesanan.commit();
                    System.out.println("Checkout berhasil!!!");
                    modell.modelPemesanan.viewAllPemesanan();
                    return true;
                }
//                else {
//                    System.out.println("pesanan belum dihapus");
//                }
            }
//            else {
//                System.out.println("kamar tidak ditemukan bang!!");
//            }
        }
//        else {
//            System.out.println("tidak ada pemesanan untuk tamu dengan nama ( " + namaPemesan + " )");
//        }
        return false;
    }

    public Pemesanan viewNamaPemesan(String nama) {
        return modell.modelPemesanan.getNamaPemesan(nama);
    }


}





