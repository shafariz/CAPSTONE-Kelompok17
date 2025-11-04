package model;

public class Warga extends Pengguna {
    private int idDaerah;
    private String nomorTelepon;

    @Override
    public int getIdDaerah() {
        return idDaerah;
    }

    @Override
    public void setIdDaerah(int idDaerah) {
        this.idDaerah = idDaerah;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}
