package model;


// Class entitas CatatanHarian.
// Jurnal harian yang diisi pengasuh untuk memantau kegiatan anak selama berada di daycare.

public class CatatanHarian {
    private String idCatatan;
    private String idAnak;
    private String tanggal;
    private String aktivitas;

    public CatatanHarian(String idCatatan, String idAnak, String tanggal, String aktivitas) {
        this.idCatatan = idCatatan;
        this.idAnak = idAnak;
        this.tanggal = tanggal;
        this.aktivitas = aktivitas;
    }

    public String getIdCatatan() {
        return idCatatan;
    }

    public void setIdCatatan(String idCatatan) {
        this.idCatatan = idCatatan;
    }

    public String getIdAnak() {
        return idAnak;
    }

    public void setIdAnak(String idAnak) {
        this.idAnak = idAnak;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAktivitas() {
        return aktivitas;
    }

    public void setAktivitas(String aktivitas) {
        this.aktivitas = aktivitas;
    }

//    
    public String toString() {
        return "ID Catatan: " + idCatatan
                + " | ID Anak: " + idAnak
                + " | Tanggal: " + tanggal
                + " | Aktivitas: " + aktivitas;
    }
}
