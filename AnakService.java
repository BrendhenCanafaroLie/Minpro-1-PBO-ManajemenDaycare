package service;

import model.Anak;
import util.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class logic/service untuk entitas Anak.
 * Menampung seluruh fungsi CRUD dan menyimpan data menggunakan ArrayList.
 * Bergantung pada OrangTuaService untuk memvalidasi relasi ID Orang Tua.
 */
public class AnakService {
    private ArrayList<Anak> daftarAnak;
    private OrangTuaService orangTuaService;

    public AnakService(OrangTuaService orangTuaService) {
        this.daftarAnak = new ArrayList<>();
        this.orangTuaService = orangTuaService;
    }

    // CREATE
    public void tambahAnak(Scanner scanner) {
        System.out.println("\n--- Daftarkan Anak Baru ---");

        if (orangTuaService.getDaftarOrangTua().isEmpty()) {
            System.out.println("Belum ada data orang tua! Daftarkan orang tua terlebih dahulu.");
            return;
        }

        String id = InputValidator.getNonEmptyString(scanner, "ID Anak: ");
        if (cariAnak(id) != null) {
            System.out.println("Gagal! ID Anak sudah digunakan.");
            return;
        }
        String nama = InputValidator.getNonEmptyString(scanner, "Nama Anak: ");
        int umur = InputValidator.getPositiveInt(scanner, "Umur Anak: ");
        String catatanKesehatan = InputValidator.getNonEmptyString(
                scanner, "Catatan Kesehatan/Alergi (isi '-' jika tidak ada): ");

        String idOrangTua;
        while (true) {
            idOrangTua = InputValidator.getNonEmptyString(scanner, "ID Orang Tua/Wali: ");
            if (orangTuaService.cariOrangTua(idOrangTua) != null) {
                break;
            }
            System.out.println("ID Orang Tua tidak ditemukan! Silakan masukkan ID yang terdaftar.");
        }

        Anak anak = new Anak(id, nama, umur, catatanKesehatan, idOrangTua);
        daftarAnak.add(anak);
        System.out.println("Data anak berhasil didaftarkan!");
    }

    // READ (perulangan untuk menampilkan data)
    public void tampilkanSemuaAnak() {
        System.out.println("\n--- Daftar Anak yang Sedang Dititip ---");
        if (daftarAnak.isEmpty()) {
            System.out.println("Belum ada anak yang dititipkan.");
            return;
        }
        for (int i = 0; i < daftarAnak.size(); i++) {
            System.out.println((i + 1) + ". " + daftarAnak.get(i));
        }
    }

    public Anak cariAnak(String id) {
        for (Anak a : daftarAnak) {
            if (a.getIdAnak().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    // UPDATE
    public void updateAnak(Scanner scanner) {
        System.out.println("\n--- Update Data Anak ---");
        String id = InputValidator.getNonEmptyString(scanner, "Masukkan ID Anak yang akan diupdate: ");
        Anak anak = cariAnak(id);
        if (anak == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan!");
            return;
        }
        System.out.println("Data ditemukan -> " + anak);

        String nama = InputValidator.getNonEmptyString(scanner, "Nama Baru: ");
        int umur = InputValidator.getPositiveInt(scanner, "Umur Baru: ");
        String catatanKesehatan = InputValidator.getNonEmptyString(
                scanner, "Catatan Kesehatan/Alergi Baru: ");

        anak.setNamaAnak(nama);
        anak.setUmur(umur);
        anak.setCatatanKesehatan(catatanKesehatan);
        System.out.println("Data anak berhasil diperbarui!");
    }

    // DELETE
    public void hapusAnak(Scanner scanner) {
        System.out.println("\n--- Hapus Data Anak ---");
        String id = InputValidator.getNonEmptyString(scanner, "Masukkan ID Anak yang akan dihapus: ");
        Anak anak = cariAnak(id);
        if (anak == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan!");
            return;
        }
        daftarAnak.remove(anak);
        System.out.println("Data anak berhasil dihapus dari sistem daycare!");
    }

    public ArrayList<Anak> getDaftarAnak() {
        return daftarAnak;
    }
}
