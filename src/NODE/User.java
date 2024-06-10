package NODE;

public abstract class User {
    private String name;
    private String nik;

    public User(String name, String nik) {
        this.name = name;
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

}
