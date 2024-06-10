package NODE;

public class Tamu extends User{
    private int ID;
    private String telp;
    private String negara;
    private Kamar kamar;


    public Tamu(int ID,String nama, String telp, String nik,String negara,Kamar kamar) {
       super(nama,nik);
        this.ID = ID;
        this.telp = telp;
        this.negara = negara;
        this.kamar = kamar;
    }




    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void viewTamu(){
        System.out.println("TAMU KE - "+ID);
        System.out.println("NAMA : " + getName());
        System.out.println("NO.TELEPON : "+ telp);
        System.out.println("NIK : " + getNik());
        System.out.println("NEGARA ASAL : "+negara);
        System.out.println("BERADA DI KAMAR (" + kamar.getKodeKamar() + ") Berjenis kamar : " + kamar.getJeniskamar());
    }

}
