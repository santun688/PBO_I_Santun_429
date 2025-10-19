import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek Admin dan Mahasiswa untuk contoh
        Admin admin = new Admin("santun", "202410370110429", "santun", "coy", "429");
        Mahasiswa mahasiswa = new Mahasiswa("santun", "202410370110429");

        System.out.println("Selamat datang di Sistem Login!");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        boolean loginSukses = false;

        switch (pilihan) {
            case 1:
                loginSukses = admin.login();
                if (loginSukses) {
                    admin.displayInfo();
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
                break;
            case 2:
                loginSukses = mahasiswa.login();
                if (loginSukses) {
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
}
