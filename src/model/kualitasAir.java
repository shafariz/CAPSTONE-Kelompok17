package model;

import java.sql.Date;

public class kualitasAir {
    private int idKualitas;
    private Date tanggalUji;
    private double ph;
    private String statusKelayakan;
    private int idSumber;
    private String namaSumber;

    public String getNamaSumber() {
        return namaSumber;
    }

    public void setNamaSumber(String namaSumber) {
        this.namaSumber = namaSumber;
    }

    public int getIdKualitas() {
        return idKualitas;
    }

    public void setIdKualitas(int idKualitas) {
        this.idKualitas = idKualitas;
    }

    public Date getTanggalUji() {
        return tanggalUji;
    }

    public void setTanggalUji(Date tanggalUji) {
        this.tanggalUji = tanggalUji;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public String getStatusKelayakan() {
        return statusKelayakan;
    }

    public void setStatusKelayakan(String statusKelayakan) {
        this.statusKelayakan = statusKelayakan;
    }

    public int getIdSumber() {
        return idSumber;
    }

    public void setIdSumber(int idSumber) {
        this.idSumber = idSumber;
    }

}

