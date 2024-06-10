package VIEW;
import CONTROLLER.*;
import MODEL.*;
import NODE.Admin;
import NODE.Kamar;
import NODE.Pemesanan;

import java.util.Scanner;
public class FITUR {
    Scanner scan = new Scanner(System.in);
    controllerTamu conta = new controllerTamu();
    controllerPemesanan conpe = new controllerPemesanan();
    controllerKamar conkam = new controllerKamar();
    controllerAdmin conAD = new controllerAdmin();

    public void menu(){
        System.out.println(" ");
        System.out.println("======== HOTEL JAVA ==============");
        System.out.println("1. Daftar admin ");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print ("pilih : ");
    }

    public void menu1(){
        System.out.println(" ");
        System.out.println(" ============ WELCOME TO MENU ==============");
        System.out.println("1. Menambah data kamar baru");
        System.out.println("2. melihat info Seluruh kamar ");
        System.out.println("3. mengedit data kamar ");
        System.out.println("4. Reservasi kamar(check-in) ");
        System.out.println("5. Reservasi kamar(check-out) ");
        System.out.println("6. melihat detail reservasi ");
        System.out.println("7. melihat kamar yang tersedia ");
        System.out.println("8. melihat data tamu ");
        System.out.println("9. EXIT");
        System.out.print ("Pilih : ");
    }

    public void addAdmin(){
        System.out.println("MASUKKAN NAMA STAFF :");
        String nm = scan.nextLine();
        System.out.println("MASUKKAN PASSWORD (NIK) :");
        String pw = scan.nextLine();
        System.out.println("MASUKKAN NIP :");
        String nip = scan.nextLine();

        conAD.addAdmin(nm,pw,nip);
        modell.modelAdmin.ViewAlladmin();
    }

    public void addKamar(Admin admin){
        System.out.println("Masukkan jenis kamar : ");
        String jn=scan.nextLine();
        System.out.println("Masukkan harga per malamnya : ");
        int hg = scan.nextInt();

        conkam.addKamar(jn,hg);

    }

    public void InfoKAMAR(Admin admin){
        System.out.println("====== LIST KAMAR ======");
        modell.modelKamar.viewALLkamar();
    }

    public void UpdateKamar(Admin admin){
        System.out.println("====== menu UPDATE =====");
        System.out.println("1.jenis Kamar.");
        System.out.println("2.harga");
        System.out.println("3.kembali");
        System.out.print("pilih : ");
        int pil = scan.nextInt();
        scan.nextLine();
        switch (pil){
            case 1:
                modell.modelKamar.viewALLkamar();
                System.out.print("Masukkan kode kamar : ");
                int kd = scan.nextInt();
                scan.nextLine();
                Kamar kamar = modell.modelKamar.getKamarr(kd);
                if (kamar != null){
                    System.out.print("Masukkan jenis kamar barunya : ");
                    String jn = scan.nextLine();
                    conkam.updateJeniskamar(kd,jn);
                    System.out.println("SETELAH DIUPDATE : ");
                    modell.modelKamar.getKamarr(kd).viewKamar();
                    modell.modelKamar.commit();
                }else {
                    System.out.println("Kode kamar salah bang!!");
                }
                break;
            case 2:
                modell.modelKamar.viewALLkamar();
                System.out.print("Masukkan kode kamar : ");
                int id = scan.nextInt();
                scan.nextLine();
                Kamar kam = modell.modelKamar.getKamarr(id);
                if (kam != null){
                    System.out.print("masukkan harga terbarunya: ");
                int harga = scan.nextInt();
                conkam.updateHarga(id,harga);
                    System.out.println("SETELAH DIUPDATE : ");
                    modell.modelKamar.getKamarr(id).viewKamar();
                    modell.modelKamar.commit();
                }else {
                    System.out.println("Kode kamar salah bang!!");
                }
                break;
            default:
                System.out.println("pilihan tidak valid, anda kembali ke menu");
        }
    }

    public void CEKIN(Admin admin){
        System.out.println("== RESERVASI HOTEL ==");
        System.out.println("MASUKKAN NAMA TAMU : ");
        String nm = scan.nextLine();
        System.out.println("MASUKKAN NO.TELP : ");
        String tl = scan.nextLine();
        System.out.println("MASUKKAN NIK : ");
        String nik = scan.nextLine();
        System.out.println("MASUKKAN ASAL NEGARA : ");
        String neg = scan.nextLine();
        conkam.viewKamarKosong();
        System.out.println("MASUKKAN KODE KAMAR YANG AKAN DITEMPATI : ");
        int kode = scan.nextInt();
        scan.nextLine();
        System.out.println("CHECKIN HOTEL (YYYY-MM-DD) :");
        String cekin = scan.nextLine();
        System.out.println("CHECKOUT HOTEL (YYYY-MM-DD) : ");
        String cekout = scan.nextLine();
        System.out.println("JENIS PEMBAYARANNYA : ");
        String jn = scan.nextLine();
        conpe.checkinPemesanan(nm,tl,nik,neg,kode,cekin,cekout,jn);
    }

    public void CEKOUT(Admin admin){
        modell.modelPemesanan.viewAllPemesanan();
        System.out.println("MASUKKAN nama pemesanan : ");
        String nm = scan.nextLine();
        System.out.println("MASUKKAN KODE KAMAR : ");
        int kd = scan.nextInt();
        scan.nextLine();
        conpe.checkoutPesanan(nm,kd);
    }

    public void LIHATRESERVASI(Admin admin) {
        System.out.println("===== LIHAT RESERVASI ====");
        System.out.println("Masukkan NAMA TAMU : ");
        String nm = scan.nextLine();
        Pemesanan pemesanan = modell.modelPemesanan.getNamaPemesan(nm);
        if(pemesanan != null) {
            pemesanan.viewPesanan();
        }else{
            System.out.println("tidak ada reservasi untuk tamu dengan nama " + nm);
        }
    }


    public void KamarTersedia(Admin admin){
        System.out.println(" ======== LIST KAMAR KOSONG ========");
        conkam.viewKamarKosong();
    }

    public void lihatdataTamu(Admin admin){
        System.out.println("== LIST DATA TAMU ==");
        System.out.println("1.View all tamu");
        System.out.println("2. cari tamu (nama)");
        System.out.println("3. kembali");
        int pil = scan.nextInt();
        scan.nextLine();
        switch (pil){
            case 1 :
                modell.modelTamu.viewAllTAMU();
                break;
            case 2 :
                System.out.println("Masukkan Nama Tamu : ");
                String nm = scan.nextLine();
                modell.modelTamu.getNamaTamu(nm).viewTamu();
                break;
            default:
                System.out.println("pilihan tidak valid, anda kembali ke menu");
        }
    }

}
