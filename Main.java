import service.OrangTuaService;
import service.AnakService;
import service.CatatanHarianService;
import util.InputValidator;

import java.util.Scanner;

/**
 * Class entry point program Sistem Manajemen Daycare.
 * Menampilkan menu utama, menerima pilihan menu dari inputan pengguna,
 * dan mengarahkan ke submenu masing-masing entitas.
 * Program terus berjalan (perulangan) sampai pengguna memilih menu Keluar.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OrangTuaService orangTuaService = new OrangTuaService();
        AnakService anakService = new AnakService(orangTuaService);
        CatatanHarianService catatanHarianService = new CatatanHarianService(anakService);

        System.out.println("=================================================");
        System.out.println("   SELAMAT DATANG DI SISTEM MANAJEMEN DAYCARE");
        System.out.println("=================================================");

        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuUtama();
            int pilihan = InputValidator.getMenuChoice(scanner, "Pilih menu (1-4): ", 1, 4);

            switch (pilihan) {
                case 1:
                    menuOrangTua(scanner, orangTuaService);
                    break;
                case 2:
                    menuAnak(scanner, anakService);
                    break;
                case 3:
                    menuCatatanHarian(scanner, catatanHarianService);
                    break;
                case 4:
                    berjalan = false;
                    System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen Daycare. Sampai jumpa!");
                    break;
            }
        }

        scanner.close();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n=========== MENU UTAMA ===========");
        System.out.println("1. Menu Data Orang Tua");
        System.out.println("2. Menu Data Anak");
        System.out.println("3. Menu Catatan Harian");
        System.out.println("4. Keluar");
        System.out.println("===================================");
    }

    private static void menuOrangTua(Scanner scanner, OrangTuaService service) {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n----- Menu Data Orang Tua -----");
            System.out.println("1. Tambah Data Orang Tua");
            System.out.println("2. Tampilkan Semua Orang Tua");
            System.out.println("3. Update Data Orang Tua");
            System.out.println("4. Hapus Data Orang Tua");
            System.out.println("5. Kembali ke Menu Utama");

            int pilihan = InputValidator.getMenuChoice(scanner, "Pilih menu (1-5): ", 1, 5);
            switch (pilihan) {
                case 1:
                    service.tambahOrangTua(scanner);
                    break;
                case 2:
                    service.tampilkanSemuaOrangTua();
                    break;
                case 3:
                    service.updateOrangTua(scanner);
                    break;
                case 4:
                    service.hapusOrangTua(scanner);
                    break;
                case 5:
                    kembali = true;
                    break;
            }
        }
    }

    private static void menuAnak(Scanner scanner, AnakService service) {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n----- Menu Data Anak -----");
            System.out.println("1. Daftarkan Anak Baru");
            System.out.println("2. Tampilkan Semua Anak");
            System.out.println("3. Update Data Anak");
            System.out.println("4. Hapus Data Anak");
            System.out.println("5. Kembali ke Menu Utama");

            int pilihan = InputValidator.getMenuChoice(scanner, "Pilih menu (1-5): ", 1, 5);
            switch (pilihan) {
                case 1:
                    service.tambahAnak(scanner);
                    break;
                case 2:
                    service.tampilkanSemuaAnak();
                    break;
                case 3:
                    service.updateAnak(scanner);
                    break;
                case 4:
                    service.hapusAnak(scanner);
                    break;
                case 5:
                    kembali = true;
                    break;
            }
        }
    }

    private static void menuCatatanHarian(Scanner scanner, CatatanHarianService service) {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n----- Menu Catatan Harian -----");
            System.out.println("1. Input Laporan Kegiatan Harian");
            System.out.println("2. Lihat Riwayat Aktivitas Anak");
            System.out.println("3. Edit Laporan Aktivitas Harian");
            System.out.println("4. Hapus Laporan Aktivitas Harian");
            System.out.println("5. Kembali ke Menu Utama");

            int pilihan = InputValidator.getMenuChoice(scanner, "Pilih menu (1-5): ", 1, 5);
            switch (pilihan) {
                case 1:
                    service.tambahCatatan(scanner);
                    break;
                case 2:
                    service.tampilkanRiwayatAnak(scanner);
                    break;
                case 3:
                    service.updateCatatan(scanner);
                    break;
                case 4:
                    service.hapusCatatan(scanner);
                    break;
                case 5:
                    kembali = true;
                    break;
            }
        }
    }
}
