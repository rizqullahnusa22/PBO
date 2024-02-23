import java.util.Scanner;

public class LibraryLoginSystem {
    // Data mahasiswa (username dan password)
    private static final String[] mahasiswaUsernames = {"mahasiswa1", "mahasiswa2", "mahasiswa3"};
    private static final String[] mahasiswaPasswords = {"password1", "password2", "password3"};

    // Data admin (hanya satu admin)
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("Selamat datang di sistem login library!");
            System.out.println("Silakan masukkan username dan password:");

            // Meminta input username dan password dari pengguna
            System.out.print("Username: ");
            String usernameInput = scanner.nextLine();
            System.out.print("Password: ");
            String passwordInput = scanner.nextLine();

            // Memeriksa apakah pengguna adalah admin
            if (isAdmin(usernameInput, passwordInput)) {
                System.out.println("Login berhasil sebagai admin.");
                isLoggedIn = true;
                // Tambahkan logika untuk aksi admin di sini
            } else if (isMahasiswa(usernameInput, passwordInput)) {
                System.out.println("Login berhasil sebagai mahasiswa.");
                isLoggedIn = true;
                // Tambahkan logika untuk aksi mahasiswa di sini
            } else {
                System.out.println("Username atau password salah. Silakan coba lagi.\n");
            }
        }
    }

    // Method untuk memeriksa apakah login sebagai admin
    private static boolean isAdmin(String username, String password) {
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    // Method untuk memeriksa apakah login sebagai mahasiswa
    private static boolean isMahasiswa(String username, String password) {
        for (int i = 0; i < mahasiswaUsernames.length; i++) {
            if (username.equals(mahasiswaUsernames[i]) && password.equals(mahasiswaPasswords[i])) {
                return true;
            }
        }
        return false;
    }
}
