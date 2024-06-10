package NODE;

public class Kamar {
    private int kodeKamar;
    private String jeniskamar;
    private int hargapermalam;
    private boolean status;

    public Kamar(int kodeKamar,String jeniskamar, int harga, boolean status) {
        this.kodeKamar = kodeKamar;
        this.jeniskamar = jeniskamar;
        this.hargapermalam = harga;
        this.status = status;
    }

    public String getJeniskamar() {
        return jeniskamar;
    }

    public void setJeniskamar(String jeniskamar) {
        this.jeniskamar = jeniskamar;
    }

    public int getKodeKamar() {
        return kodeKamar;
    }

    public int getHarga() {
        return hargapermalam;
    }

    public void setHarga(int harga) {
        this.hargapermalam = harga;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void viewKamar(){
        System.out.println("Jenis Kamar : " + jeniskamar);
        System.out.println("Kode kamar : " + kodeKamar);
        System.out.println("Harga : " + hargapermalam);
        System.out.println("Status Kamar :" + status);
    }
}
