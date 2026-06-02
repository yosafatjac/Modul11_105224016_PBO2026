import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Soal 1
        int[] hargaMenu = new int[3];

        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Masukkan harga menu ke-" + (i + 1) + ": ");
                hargaMenu[i] = input.nextInt();
                System.out.println("Harga berhasil disimpan.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harga harus berupa angka!");
                input.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Kapasitas memori harga sudah penuh!");
            }
        }

        // Soal 2 dan 3
        Pelanggan pelanggan = new Pelanggan();

        try {
            pelanggan.daftarMember(15);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            pelanggan.pesanKopi(10);
        } catch (KopiHabisException e) {
            System.out.println(e.getMessage());
        }

        // Soal 4 dan 5
        MesinKasir kasir = new MesinKasir();

        try {
            kasir.bayar(50000, 30000);
        } catch (UangKurangException e) {
            System.out.println(e.getMessage());
        }

        try {
            kasir.cetakStruk(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Terima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup.");
            input.close();
        }
    }
}