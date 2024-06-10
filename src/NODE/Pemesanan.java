package NODE;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class Pemesanan {
    private int ID;
   private String nama;
   private String telp;
   private String nik;
   private String negara;
    private Kamar Kamar;
    protected String tglCheckin;
    private String tglCheckout;
    private int jumlahMalam;
    private String jenisPembayaran;
    private int totharga;




    public Pemesanan(int ID,String nama,String telp,String nik,String negara,Kamar Kamar,String tglCheckin, String tglCheckout, int jumlahMalam, String jenisPembayaran, int totharga) {
       this.ID = ID;
        this.nama= nama;
       this.telp = telp;
       this.nik = nik;
       this.negara = negara;
        this.Kamar = Kamar;
        this.jenisPembayaran = jenisPembayaran;
        this.tglCheckin = tglCheckin;
        this.tglCheckout = tglCheckout;
        this.jumlahMalam = jumlahMalam;
        this.totharga = totharga;
    }

    public int getID() {
        return ID;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Kamar getKamar() {
        return Kamar;
    }

    public void setKamar(Kamar nomorKamar) {
        this.Kamar = nomorKamar;
    }

    public String getTglCheckin() {
        return tglCheckin;
    }

    public String getTglCheckout() {
        return tglCheckout;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public int getTotharga() {
        return totharga;
    }



    public void viewPesanan() {
        System.out.println("====================");
        System.out.println("NAMA TAMU : " + nama);
        System.out.println("Nomor telp : " + telp);
        System.out.println("Nomor NIK : " + nik);
        System.out.println("NEGARA ASAL : " + negara);
        System.out.println("Nomor Kamar: " + Kamar.getKodeKamar() + ", Jenis Kamar: " + Kamar.getJeniskamar());
        System.out.println("Harga permalam Kamar: " + Kamar.getHarga());
        System.out.println("Tanggal Check-in: " + tglCheckin);
        System.out.println("Tanggal Check-out: " + tglCheckout);
        System.out.println("Jumlah Malam Menginap: " + jumlahMalam + " Malam");
        System.out.println("Total Harga Kamar: " + totharga + " , Dengan jenis Pembayaran : " + jenisPembayaran);
        System.out.println("===================");
    }

}
