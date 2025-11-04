package model;

public class sumberAir {
    private int idSumber;
    private String namaSumber;
    private String jenisSumber;
    private String status; 
    private String lokasi;

    public int getIdSumber() { return idSumber; }
    public void setIdSumber(int idSumber) { this.idSumber = idSumber; }

    public String getNamaSumber() { return namaSumber; }
    public void setNamaSumber(String namaSumber) { this.namaSumber = namaSumber; }

    public String getJenisSumber() { return jenisSumber; }
    public void setJenisSumber(String jenisSumber) { this.jenisSumber = jenisSumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
}
