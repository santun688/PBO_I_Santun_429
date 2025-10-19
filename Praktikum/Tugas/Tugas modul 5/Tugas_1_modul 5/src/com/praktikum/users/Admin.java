package com.praktikum.users;
import java.util.List;
import java.util.Scanner;
import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Barang;
import java.util.InputMismatchException;

public class Admin extends User implements AdminActions {
    private final String username, password;
    protected List<User> userList;
    Scanner scanner = new Scanner(System.in);//input dari pengguna do consol

    public Admin(String username, String password, String nama, String nim, List<User> userList) {
        super(nama, nim);
        this.username = username;
        this.password = password;
        this.userList = userList;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }

    public void manageItems() {
        int pilihan;
        do {
            System.out.println("\n<<< Kelola laporan Barang >>>");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilihan: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan == 1) {
                    for (int i = 0; i < LoginSystem.barangDilaporkan.size(); i++) {
                        Barang barang = LoginSystem.barangDilaporkan.get(i);
                        System.out.printf("%d. Nama: %s \n   Deskripsi: %s \n   Lokasi: %s \n   Status: %s%n\n", i + 1, barang.getNamaBarang(), barang.getDeskripsiBarang(), barang.getLokasi(), barang.getStatus());
                    }
                } else if (pilihan == 2) {
                    for (int i = 0; i < LoginSystem.barangDilaporkan.size(); i++) {
                        Barang barang = LoginSystem.barangDilaporkan.get(i);
                        if (barang.getStatus().equals("Reported")) {
                            System.out.printf("%d. Nama: %s \n   Deskripsi: %s%n", i, barang.getNamaBarang(), barang.getDeskripsiBarang());
                        }
                    }
                    System.out.print("Masukkan nomor barang: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Barang barang = LoginSystem.barangDilaporkan.get(index);
                        if (barang.getStatus().equals("Reported")) {
                            barang.setStatus("Telah diambil");
                            System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
                        } else {
                            System.out.println("Barang sudah ditandai sebelumnya.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                    }
                } else if (pilihan != 0) {
                    System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }


    public void manageUsers() {
        int pilihan = 0;
        do {
            System.out.println("\n<<< Kelola Mahasiswa >>>");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilihan: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan == 1) {
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();
                    LoginSystem.userList.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                } else if (pilihan == 2) {
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = scanner.nextLine();
                    boolean removed = LoginSystem.userList.removeIf(U -> U instanceof Mahasiswa && ((Mahasiswa) U).getNim().equals(nim));
                    System.out.println(removed ? "Mahasiswa dihapus." : "Mahasiswa tidak ditemukan.");
                } else if (pilihan != 0) {
                    System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        } while (pilihan != 0);
    }

    @Override
    public void displayAppMenu(){
        int pilihan = 0;
        do {
            System.out.println();
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Kelola Laporan barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan anda: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Input harus berupa angka!");
            }

            if (pilihan == 1){
                manageItems();
            } else if (pilihan == 2) {
                manageUsers();
            } else if (pilihan == 0){
                System.out.println("Logging out...");
            } else {
                System.out.println("Pilihan Tidak Valid");
            }
        } while (pilihan != 0);
    }
}
