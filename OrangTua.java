package model;

/**
 * Class entitas OrangTua.
 * Menyimpan data wali yang mendaftarkan atau menjemput anak.
 * Menerapkan encapsulation: seluruh atribut bersifat private,
 * akses hanya melalui getter dan setter (access modifier).
 */
public class OrangTua {
    private String idOrangTua;
    private String namaOrangTua;
    private String noHp;
    private String alamat;

    public OrangTua(String idOrangTua, String namaOrangTua, String noHp, String alamat) {
        this.idOrangTua = idOrangTua;
        this.namaOrangTua = namaOrangTua;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public String getIdOrangTua() {
        return idOrangTua;
    }

    public void setIdOrangTua(String idOrangTua) {
        this.idOrangTua = idOrangTua;
    }

    public String getNamaOrangTua() {
        return namaOrangTua;
    }

    public void setNamaOrangTua(String namaOrangTua) {
        this.namaOrangTua = namaOrangTua;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "ID: " + idOrangTua
                + " | Nama: " + namaOrangTua
                + " | No HP: " + noHp
                + " | Alamat: " + alamat;
    }
}
