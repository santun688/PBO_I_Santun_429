import java.util.Scanner;

public class Admin extends User {
    String NIM;
    private String username;
    private String password;


    // Constructor Admin
    public Admin(String nama, String nim, String username, String password, String NIM) {
        super(nama, nim); // Menggunakan constructor dari superclass (User)
        this.username = username;
        this.password = password;
        this.NIM = NIM;
    }

    // Override method login() untuk Admin
    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String inputPassword = scanner.nextLine();

        return inputUsername.equals(username + NIM) && inputPassword.equals(password + NIM);
    }

    // Override method displayInfo() untuk Admin
    @Override
    public void displayInfo() {
        System.out.println("Login Sukses sebagai Admin!");// Memanggil displayInfo() dari superclass
    }
}
