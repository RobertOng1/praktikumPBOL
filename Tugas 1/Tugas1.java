import java.util.Scanner;

public class Tugas1{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        int nim = scanner.nextInt();
        System.out.print("Nama: " + nama + "\nNIM: " + nim);
    }
}