package model;

public class Admin extends Pengguna {
    private String email;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void setIdDaerah(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
