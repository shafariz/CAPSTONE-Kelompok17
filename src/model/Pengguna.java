package model;

public class Pengguna {
    private int idPengguna;
    private String nama;
    private String username;
    private String password;
    private int idDaerah;

    public int getIdDaerah() { 
        return idDaerah; }
    public void setIdDaerah(int idDaerah) { 
        this.idDaerah = idDaerah; }
    
    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
