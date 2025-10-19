package com.pratikum.main;

import java.util.Scanner;
import com.pratikum.users.User;
import com.pratikum.users.Admin;
import com.pratikum.users.Mahasiswa;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menambahkan pilihan untuk memilih peran
        System.out.println("=== Sistem Login ===");
        System.out.println("1. Mahasiswa");
        System.out.println("2. Admin");
        System.out.print("Pilih peran (1/2): ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();  // Konsumsi newline setelah input angka

        User[] users = {
                new Admin("santun", "coy429"),
                new Mahasiswa("santun", "202410370110429")
        };

        User loggedInUser = null;

        if (roleChoice == 1) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Cek login untuk Mahasiswa
            for (User user : users) {
                if (user instanceof Mahasiswa && user.login(username, password)) {
                    loggedInUser = user;
                    break;
                }
            }
        } else if (roleChoice == 2) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Cek login untuk Admin
            for (User user : users) {
                if (user instanceof Admin && user.login(username, password)) {
                    loggedInUser = user;
                    break;
                }
            }
        } else {
            System.out.println("Pilihan peran tidak valid!");
            return;
        }

        if (loggedInUser != null) {
            System.out.println("Login berhasil!");
            loggedInUser.displayAppMenu(); // Polymorphism
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
