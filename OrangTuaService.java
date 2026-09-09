package service;

import model.OrangTua;
import util.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class logic/service untuk entitas OrangTua.
 * Menampung seluruh fungsi CRUD (Create, Read, Update, Delete)
 * dan menyimpan data menggunakan ArrayList.
 */
public class OrangTuaService {
    private ArrayList<OrangTua> daftarOrangTua;

    public OrangTuaService() {
        this.daftarOrangTua = new ArrayList<>();
    }

    // CREATE
    public void tambahOrangTua(Scanner scanner) {
        System.out.println("\n--- Tambah Data Orang Tua ---");
        String id = InputValidator.getNonEmptyString(scanner, "ID Orang Tua: ");
        if (cariOrangTua(id) != null) {
            System.out.println("Gagal! ID Orang Tua sudah digunakan.");
            return;
        }
        String nama = InputValidator.getNonEmptyString(scanner, "Nama Orang Tua: ");
        String noHp = InputValidator.getPhoneNumber(scanner, "No HP: ");
        String alamat = InputValidator.getNonEmptyString(scanner, "Alamat: ");

        OrangTua orangTua = new OrangTua(id, nama, noHp, alamat);
        daftarOrangTua.add(orangTua);
        System.out.println("Data orang tua berhasil ditambahkan!");
    }

    // READ (perulangan untuk menampilkan data)
    public void tampilkanSemuaOrangTua() {
        System.out.println("\n--- Daftar Orang Tua Terdaftar ---");
        if (daftarOrangTua.isEmpty()) {
            System.out.println("Belum ada data orang tua.");
            return;
        }
        for (int i = 0; i < daftarOrangTua.size(); i++) {
            System.out.println((i + 1) + ". " + daftarOrangTua.get(i));
        }
    }

    // Helper pencarian, dipakai lintas class (misal oleh AnakService)
    public OrangTua cariOrangTua(String id) {
        for (OrangTua ot : daftarOrangTua) {
            if (ot.getIdOrangTua().equalsIgnoreCase(id)) {
                return ot;
            }
        }
        return null;
    }

    // UPDATE
    public void updateOrangTua(Scanner scanner) {
        System.out.println("\n--- Update Data Orang Tua ---");
        String id = InputValidator.getNonEmptyString(scanner, "Masukkan ID Orang Tua yang akan diupdate: ");
        OrangTua orangTua = cariOrangTua(id);
        if (orangTua == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan!");
            return;
        }
        System.out.println("Data ditemukan -> " + orangTua);

        String nama = InputValidator.getNonEmptyString(scanner, "Nama Baru: ");
        String noHp = InputValidator.getPhoneNumber(scanner, "No HP Baru: ");
        String alamat = InputValidator.getNonEmptyString(scanner, "Alamat Baru: ");

        orangTua.setNamaOrangTua(nama);
        orangTua.setNoHp(noHp);
        orangTua.setAlamat(alamat);
        System.out.println("Data orang tua berhasil diperbarui!");
    }

    // DELETE
    public void hapusOrangTua(Scanner scanner) {
        System.out.println("\n--- Hapus Data Orang Tua ---");
        String id = InputValidator.getNonEmptyString(scanner, "Masukkan ID Orang Tua yang akan dihapus: ");
        OrangTua orangTua = cariOrangTua(id);
        if (orangTua == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan!");
            return;
        }
        daftarOrangTua.remove(orangTua);
        System.out.println("Data orang tua berhasil dihapus!");
    }

    public ArrayList<OrangTua> getDaftarOrangTua() {
        return daftarOrangTua;
    }
}
