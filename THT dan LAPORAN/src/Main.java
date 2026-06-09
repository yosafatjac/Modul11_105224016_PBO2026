import java.util.InputMismatchException;
import java.util.Scanner;

// Kelas utama program — titik masuk aplikasi JAVA EXPRESS
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemReservasi reservasi = new SistemReservasi();
        boolean isRunning = true;

        System.out.println("Selamat datang di JAVA EXPRESS");
        System.out.println("Sistem Pemesanan Tiket Kereta Api");

        try {
            while (isRunning) {
                // Tampilkan menu utama setiap iterasi
                System.out.println("\nMenu Utama");
                System.out.println("1. Lihat Jadwal Kereta");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");

                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine(); // bersihkan newline setelah nextInt()

                    switch (pilihan) {
                        case 1:
                            reservasi.tampilkanJadwal();
                            break;
                        case 2:
                            prosesPemesanan(scanner, reservasi);
                            break;
                        case 3:
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Masukkan angka 1, 2, atau 3.");
                    }

                } catch (InputMismatchException e) {
                    // Pengguna memasukkan huruf/simbol saat memilih menu
                    System.out.println("Input tidak valid! Harap masukkan angka.");
                    scanner.nextLine(); // WAJIB: bersihkan buffer agar tidak terjebak infinite loop
                }
            }
        } finally {
            // Blok ini dijamin selalu tereksekusi saat program keluar,
            // baik karena pilihan user (case 3) maupun karena exception tak tertangkap
            System.out.println("\nTerima kasih telah menggunakan JAVA EXPRESS.");
            System.out.println("Sampai jumpa!");
            scanner.close(); // tutup Scanner untuk melepas resource
        }
    }

    // Menangani seluruh alur input dan proses pemesanan tiket
    // Semua exception dari SistemReservasi ditangkap di sini
    private static void prosesPemesanan(Scanner scanner, SistemReservasi reservasi) {
        System.out.println("\nForm Pemesanan Tiket");

        try {
            System.out.print("Kode Kereta    : ");
            String kode = scanner.nextLine().trim().toUpperCase(); // normalisasi ke huruf kapital

            System.out.print("NIK Penumpang  : ");
            String nik = scanner.nextLine().trim();

            System.out.print("Nama Penumpang : ");
            String nama = scanner.nextLine().trim();

            System.out.print("Jumlah Tiket   : ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // bersihkan buffer setelah nextInt()

            // Serahkan ke SistemReservasi untuk diproses
            reservasi.pesanTiket(kode, nik, nama, jumlah);

        } catch (InputMismatchException e) {
            // Pengguna memasukkan huruf saat mengisi jumlah tiket
            System.out.println("Jumlah tiket harus berupa angka!");
            scanner.nextLine(); // bersihkan buffer

        } catch (DataPenumpangTidakValidException e) {
            // Unchecked Exception: NIK tidak sesuai format
            System.out.println("Data tidak valid: " + e.getMessage());

        } catch (RuteTidakDitemukanException e) {
            // Checked Exception: kode kereta tidak ada dalam sistem
            System.out.println("Rute tidak ditemukan: " + e.getMessage());

        } catch (TiketHabisException e) {
            // Checked Exception: kursi tidak cukup untuk jumlah yang dipesan
            System.out.println("Tiket tidak mencukupi: " + e.getMessage());
            System.out.println("Coba kurangi jumlah tiket atau pilih kereta lain.");
        }
    }
}