import NODE.*;
import MODEL.*;
import java.time.LocalDate;
import java.util.ArrayList;
import CONTROLLER.*;
import VIEW.*;



public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now() ;
        modelKamar kamar = new modelKamar();

        modelPemesanan pesan = new modelPemesanan();
        modelTamu tamu = new modelTamu();
        ArrayList<Kamar> listkamar = new ArrayList<>();
        ArrayList<Tamu> listtamu = new ArrayList<>();
        ArrayList<Pemesanan> listpesan = new ArrayList<>();
        controllerTamu conta = new controllerTamu();
        controllerKamar conkam = new controllerKamar();
        controllerAdmin conmin = new controllerAdmin();
        controllerPemesanan controllerPemesanan = new controllerPemesanan();
        FITUR fitur = new FITUR();
        Admin admin = modell.modelAdmin.listStaff.get(1);

//        fitur.addKamar(admin);
//        conkam.addKamar("priva",1000,false);
//        conkam.addKamar("kelo,pok",1000,true);
//        conkam.addKamar("dduo",1000,false);
//        conkam.updateJeniskamar(2,"peivasi");
//        modell.modelKamar.commit();

//
//        Tamu tamu1 = new Tamu(1,"popo","0888","217","indonesia","pap@kdkd",);
//        Tamu tamu2 = new Tamu(2,"kos","084","111","indonesia","not@ddd",kam1);
//        Tamu tamu3 = new Tamu(3,"arr","0344","023","indonesia","kil@1233",kam3);

//        Pemesanan pesan1 = new Pemesanan(tamu1,kam1,kam1,1000,date,date.plusWeeks(1),"Qriss");
//        Pemesanan pesan2 = new Pemesanan(tamu2,kam2,kam2,1000,date,date.plusWeeks(1),"Qriss");
//        Pemesanan pesan3 = new Pemesanan(tamu3,kam3,kam3,1000,date,date.plusWeeks(1),"Qriss");
//
//        listtamu.add(tamu2);
//        listtamu.add(tamu1);
//        listtamu.add(tamu3);
//        listkamar.add(kam1);
//        listkamar.add(kam2);
//        listkamar.add(kam3);

//        conta.addTamu("popo","0888","217","indonesia","pap@kdkd",kamar.getKamarr(2));

//        tamu2.viewTamu();
//        kam1.viewKamar();

//        kamar.updateStatusKamar("102",true);
//        kamar.updateHarga("102",100000000);
//        kamar.viewKamarKosong();
//        System.out.println("------------------------------");
//        kamar.viewALLkamar();
//        tamu.TambahTAMU("popo","082","011110","Indonesia","Pes@gmaol");
//        pesan.TambahPemesanan(,1000,1,date);
//        listpesan.add(pesan1);
//        listpesan.add(pesan2);
//        listpesan.add(pesan3);
//            controllerPemesanan.viewNamaPemesan("bebek");
//        Pemesanan pe = new Pemesanan("pan","23","233","indo",kamar.getKamarr(2),kamar.getKamarr(2),2000,"qriss");
//        controllerPemesanan.checkinPemesanan("rere","jkk","56","omi",1, "2024-01-20", "2024-01-22", "qriss");
//      controllerPemesanan.checkoutPemesanan(1,1);
//      controllerPemesanan.checkoutPesanan(,1);
//        modell.modelPemesanan.commit();
//        pesan.commit();
//conmin.cekUsername(admin.getNama());
//        System.out.println("\t\tpesanan");
//        pesan.viewAllPemesanan();
//        System.out.println("\t\tKAMAR");
////        kamar.viewALLkamar();
//
//        System.out.println("\t\tKAMAR KOSONG");
//        conkam.viewKamarKosong();
//        tamu.viewAllTAMU();
//        pesan.viewAllPemesanan();
    }
}