package VIEW;

import CONTROLLER.*;
import MODEL.*;
import NODE.Admin;

import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        FITUR fitur = new FITUR();
        Scanner scan = new Scanner(System.in);

        int pilihan;
        awal:
        while (true){
            fitur.menu();
            pilihan = scan.nextInt(); scan.nextLine();
            switch (pilihan) {
                case 1:
                    fitur.addAdmin();
                    break;
                case 2:
                    System.out.println("MASUKKAN USERNAME ADMIN : ");
                    String nm = scan.nextLine();
                    System.out.println("MASUKKAN PASSWORD ADMIN : ");
                    String pw = scan.nextLine();
                        for (Admin adminLogin : modell.modelAdmin.listStaff) {
                            if (adminLogin.getNama().equals(nm)) {
                                if (adminLogin.getPass().equals(pw)) {
                                    boolean login = true;
                                    while (login) {
                                        fitur.menu1();
                                        int pilihanMenu = scan.nextInt();
                                        scan.nextLine();
                                        switch (pilihanMenu) {
                                            case 1:
                                                fitur.addKamar(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 2:
                                                fitur.InfoKAMAR(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 3:
                                                fitur.UpdateKamar(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 4:
                                                fitur.CEKIN(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 5:
                                                fitur.CEKOUT(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 6:
                                                fitur.LIHATRESERVASI(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 7:
                                                fitur.KamarTersedia(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 8:
                                                fitur.lihatdataTamu(adminLogin);
                                                modell.modelKamar.commit();
                                                modell.modelPemesanan.commit();
                                                break;
                                            case 9:
                                                System.out.println("Keluar dari menu");
                                                continue awal;
                                            default:
                                                System.out.println("Pilihan ga valid bang,ulangi");
                                        }
                                    }
                                }
                            }
                        }
                    System.out.println("Kata sandi salahh");
                    break;
                case 3:
                    System.out.println("anda keluar dari program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid bangg, ulangi nggeh");
            }
        }
    }
}
