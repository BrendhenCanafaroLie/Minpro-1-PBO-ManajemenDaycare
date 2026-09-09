package model;


// Class entitas Anak.
// Menyimpan data anak yang dititipkan di daycare.
// Atribut idOrangTua menghubungkan anak dengan data wali 

public class Anak {
    private String idAnak;
    private String namaAnak;
    private int umur;
    private String catatanKesehatan;
    private String idOrangTua;

    public Anak(String idAnak, String namaAnak, int umur, String catatanKesehatan, String idOrangTua) {
        this.idAnak = idAnak;
        this.namaAnak = namaAnak;
        this.umur = umur;
        this.catatanKesehatan = catatanKesehatan;
        this.idOrangTua = idOrangTua;
    }

    public String getIdAnak() {
        return idAnak;
    }

    public void setIdAnak(String idAnak) {
        this.idAnak = idAnak;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getCatatanKesehatan() {
        return catatanKesehatan;
    }

    public void setCatatanKesehatan(String catatanKesehatan) {
        this.catatanKesehatan = catatanKesehatan;
    }

    public String getIdOrangTua() {
        return idOrangTua;
    }

    public void setIdOrangTua(String idOrangTua) {
        this.idOrangTua = idOrangTua;
    }

    
    public String toString() {
        return "ID: " + idAnak
                + " | Nama: " + namaAnak
                + " | Umur: " + umur + " tahun"
                + " | Catatan Kesehatan: " + catatanKesehatan
                + " | ID Orang Tua: " + idOrangTua;
    }
}
