package NODE;

public class Admin {
    private int ID;
    private String nama;
    private String pass;
    private String nip;

    public Admin(int ID,String nama, String pass, String nip) {
        this.nama = nama;
        this.pass = pass;
        this.nip = nip;
        this.ID = ID;
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

    public String getPass() {
        return pass;
    }


    public void viewAdmin(){
        System.out.println("STAFF KE - " + ID);
        System.out.println("Nama : " + nama);
        System.out.println("Pass : " + pass);
        System.out.println("NIP : " + nip);
    }
}
