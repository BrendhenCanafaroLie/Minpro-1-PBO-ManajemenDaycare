package helper;

import java.util.Scanner;

// Class helper/validator.
// Menampung seluruh logika validasi input agar data yang masuk

public class InputValidator {

    // Memastikan input tidak kosong
    public static String ambilTeksWajibIsi(Scanner pemindai, String pesan) {
        String masukan;
        while (true) {
            System.out.print(pesan);
            masukan = pemindai.nextLine().trim();
            if (!masukan.isEmpty()) {
                return masukan;
            }
            System.out.println("Input tidak boleh kosong! Silakan coba lagi.");
        }
    }

    // Memastikan input berupa angka bulat positif (misal: untuk umur)
    public static int ambilAngkaPositif(Scanner pemindai, String pesan) {
        while (true) {
            System.out.print(pesan);
            String masukan = pemindai.nextLine().trim();
            try {
                int nilai = Integer.parseInt(masukan);
                if (nilai > 0) {
                    return nilai;
                }
                System.out.println("Angka harus lebih besar dari 0!");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    // Memastikan input nomor HP berupa angka dengan panjang 8-15 digit.
    // Catatan: karena disimpan sebagai tipe angka (long), angka 0 di
    // paling depan (misal 081234567890) akan hilang menjadi 81234567890.
    public static long ambilNomorHp(Scanner pemindai, String pesan) {
        while (true) {
            System.out.print(pesan);
            String masukan = pemindai.nextLine().trim();
            if (masukan.length() < 8 || masukan.length() > 15) {
                System.out.println("Nomor HP harus terdiri dari 8-15 digit!");
                continue;
            }
            try {
                return Long.parseLong(masukan);
            } catch (NumberFormatException e) {
                System.out.println("Nomor HP harus berupa angka!");
            }
        }
    }

    // Memastikan format tanggal YYYY-MM-DD
    public static String ambilTanggal(Scanner pemindai, String pesan) {
        String masukan;
        while (true) {
            System.out.print(pesan);
            masukan = pemindai.nextLine().trim();
            if (masukan.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return masukan;
            }
            System.out.println("Format tanggal salah! Gunakan format YYYY-MM-DD (contoh: 2026-09-07).");
        }
    }

    // Memastikan pilihan menu berada dalam rentang yang valid
    public static int ambilPilihanMenu(Scanner pemindai, String pesan, int minimum, int maksimum) {
        while (true) {
            System.out.print(pesan);
            String masukan = pemindai.nextLine().trim();
            try {
                int nilai = Integer.parseInt(masukan);
                if (nilai >= minimum && nilai <= maksimum) {
                    return nilai;
                }
                System.out.println("Pilihan harus antara " + minimum + " - " + maksimum + "!");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
}
