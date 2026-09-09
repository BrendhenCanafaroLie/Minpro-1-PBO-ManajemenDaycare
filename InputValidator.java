package util;

import java.util.Scanner;

/**
 * Class helper/validator.
 * Menampung seluruh logika validasi input agar data yang masuk
 * ke sistem selalu valid (nilai tambah: validasi input).
 */
public class InputValidator {

    // Memastikan input tidak kosong
    public static String getNonEmptyString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong! Silakan coba lagi.");
        }
    }

    // Memastikan input berupa angka bulat positif (misal: untuk umur)
    public static int getPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Angka harus lebih besar dari 0!");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    // Memastikan format nomor HP valid (8-15 digit angka)
    public static String getPhoneNumber(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.matches("[0-9+]{8,15}")) {
                return input;
            }
            System.out.println("Nomor HP tidak valid! Gunakan 8-15 digit angka (boleh diawali +).");
        }
    }

    // Memastikan format tanggal YYYY-MM-DD
    public static String getDate(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return input;
            }
            System.out.println("Format tanggal salah! Gunakan format YYYY-MM-DD (contoh: 2026-09-07).");
        }
    }

    // Memastikan pilihan menu berada dalam rentang yang valid
    public static int getMenuChoice(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Pilihan harus antara " + min + " - " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
}
