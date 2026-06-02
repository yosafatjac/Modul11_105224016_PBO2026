import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan pembilang: ");
            double pembilang = input.nextDouble();

            System.out.print("Masukkan penyebut: ");
            double penyebut = input.nextDouble();

            Kalkulator kalkulator = new Kalkulator();
            double hasil = kalkulator.bagi(pembilang, penyebut);

            System.out.println("Hasil pembagian: " + hasil);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");

        } finally {
            input.close();
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}