import java.util.Scanner;
class Admin {
    String NIMakhir = "429";
    private final String username = "santun";
    private final String password = "coy";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username + NIMakhir) && inputPassword.equals(password + NIMakhir);
    }
}

