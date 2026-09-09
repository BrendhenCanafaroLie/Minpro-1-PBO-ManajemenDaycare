package service;

import model.CatatanHarian;
import helper.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

// Class logic/service untuk entitas CatatanHarian.
// Menampung seluruh fungsi CRUD dan menyimpan data menggunakan ArrayList.
// Bergantung pada AnakService untuk memvalidasi relasi ID Anak.

public class CatatanHarianService {
    private ArrayList<CatatanHarian> daftarCatatan;
    private AnakService anakService;
    private int penghitungId;

    public CatatanHarianService(AnakService anakService) {
        this.daftarCatatan = new ArrayList<>();
        this.anakService = anakService;
        this.penghitungId = 1;
    }

    // CREATE
    public void tambahCatatan(Scanner pemindai) {
        System.out.println("\n--- Input Laporan Kegiatan Harian ---");

        if (anakService.getDaftarAnak().isEmpty()) {
            System.out.println("Belum ada data anak! Daftarkan anak terlebih dahulu.");
            return;
        }

        String idAnak;
        while (true) {
            idAnak = InputValidator.ambilTeksWajibIsi(pemindai, "ID Anak: ");
            if (anakService.cariAnak(idAnak) != null) {
                break;
            }
            System.out.println("ID Anak tidak ditemukan! Silakan masukkan ID yang terdaftar.");
        }

        String tanggal = InputValidator.ambilTanggal(pemindai, "Tanggal (YYYY-MM-DD): ");
        String aktivitas = InputValidator.ambilTeksWajibIsi(pemindai, "Aktivitas: ");

        String idCatatan = "C" + penghitungId++;
        CatatanHarian catatan = new CatatanHarian(idCatatan, idAnak, tanggal, aktivitas);
        daftarCatatan.add(catatan);
        System.out.println("Catatan harian berhasil ditambahkan dengan ID " + idCatatan + "!");
    }

    // READ (riwayat aktivitas per anak, menggunakan perulangan)
    public void tampilkanRiwayatAnak(Scanner pemindai) {
        System.out.println("\n--- Riwayat Aktivitas Harian Anak ---");
        String idAnak = InputValidator.ambilTeksWajibIsi(pemindai, "Masukkan ID Anak: ");
        if (anakService.cariAnak(idAnak) == null) {
            System.out.println("Data anak dengan ID tersebut tidak ditemukan!");
            return;
        }

        boolean ada = false;
        for (CatatanHarian c : daftarCatatan) {
            if (c.getIdAnak().equalsIgnoreCase(idAnak)) {
                System.out.println(c);
                ada = true;
            }
        }
        if (!ada) {
            System.out.println("Belum ada catatan harian untuk anak ini.");
        }
    }

    public CatatanHarian cariCatatan(String idCatatan) {
        for (CatatanHarian c : daftarCatatan) {
            if (c.getIdCatatan().equalsIgnoreCase(idCatatan)) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public void perbaruiCatatan(Scanner pemindai) {
        System.out.println("\n--- Edit Laporan Aktivitas Harian ---");
        String id = InputValidator.ambilTeksWajibIsi(pemindai, "Masukkan ID Catatan yang akan diedit: ");
        CatatanHarian catatan = cariCatatan(id);
        if (catatan == null) {
            System.out.println("Catatan dengan ID tersebut tidak ditemukan!");
            return;
        }
        System.out.println("Data ditemukan -> " + catatan);

        String tanggal = InputValidator.ambilTanggal(pemindai, "Tanggal Baru (YYYY-MM-DD): ");
        String aktivitas = InputValidator.ambilTeksWajibIsi(pemindai, "Aktivitas Baru: ");

        catatan.setTanggal(tanggal);
        catatan.setAktivitas(aktivitas);
        System.out.println("Catatan harian berhasil diperbarui!");
    }

    // DELETE
    public void hapusCatatan(Scanner pemindai) {
        System.out.println("\n--- Hapus Laporan Aktivitas Harian ---");
        String id = InputValidator.ambilTeksWajibIsi(pemindai, "Masukkan ID Catatan yang akan dihapus: ");
        CatatanHarian catatan = cariCatatan(id);
        if (catatan == null) {
            System.out.println("Catatan dengan ID tersebut tidak ditemukan!");
            return;
        }
        daftarCatatan.remove(catatan);
        System.out.println("Catatan harian berhasil dihapus!");
    }

    public ArrayList<CatatanHarian> getDaftarCatatan() {
        return daftarCatatan;
    }
}
