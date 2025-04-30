import java.util.Scanner;

public class Mahasiswa extends User {

    // Constructor Mahasiswa
    public Mahasiswa(String nama, String nim) {
        super(nama, nim); // Menggunakan constructor dari superclass (User)
    }

    // Override method login() untuk Mahasiswa
    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String inputNama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String inputNim = scanner.nextLine();

        return inputNama.equals(getNama()) && inputNim.equals(getNim());
    }

    // Override method displayInfo() untuk Mahasiswa
    @Override
    public void displayInfo() {
        System.out.println("Login Sukses sebagai Mahasiswa!");
        super.displayInfo(); // Memanggil displayInfo() dari superclass
    }
}
