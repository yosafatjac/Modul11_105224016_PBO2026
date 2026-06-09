import java.util.ArrayList;
import java.util.List;

// Kelas pusat kontrol reservasi tiket kereta api
// Bertanggung jawab atas validasi, pencarian kereta, dan proses pemesanan
public class SistemReservasi {

    private List<KeretaApi> daftarKereta; // menyimpan semua data kereta yang tersedia

    public SistemReservasi() {
        daftarKereta = new ArrayList<>();
        // Data awal kereta diinisialisasi saat sistem pertama kali dijalankan
        daftarKereta.add(new KeretaApi("K01", "Argo Bromo",  "JKT - SBY", 50));
        daftarKereta.add(new KeretaApi("K02", "Parahyangan", "JKT - BDG", 15));
    }

    // Menampilkan seluruh jadwal kereta yang tersedia beserta sisa kursinya
    public void tampilkanJadwal() {
        System.out.println("\nJADWAL KERETA JAVA EXPRESS");
        System.out.printf("%-6s  %-20s  %-12s  %s%n",
                "Kode", "Nama Kereta", "Rute", "Sisa Kursi");
        for (KeretaApi k : daftarKereta) {
            System.out.printf("%-6s  %-20s  %-12s  %d kursi%n",
                    k.getKodeKereta(),
                    k.getNamaKereta(),
                    k.getRute(),
                    k.getSisaKursi());
        }
        System.out.println();
    }

    // Metode utama pemesanan tiket
    // Checked Exception dideklarasikan eksplisit di signature method
    public void pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
            throws RuteTidakDitemukanException, TiketHabisException {

        // Langkah 1: validasi NIK penumpang → melempar Unchecked Exception jika tidak valid
        validasiNIK(nik);

        // Langkah 2: cari kereta berdasarkan kode → melempar Checked Exception jika tidak ditemukan
        KeretaApi kereta = cariKereta(kodeKereta);

        // Langkah 3: cek ketersediaan kursi → melempar Checked Exception jika tidak cukup
        if (jumlahTiket > kereta.getSisaKursi()) {
            throw new TiketHabisException(kereta.getNamaKereta(), kereta.getSisaKursi());
        }

        // Langkah 4: semua validasi lolos, proses pemesanan dijalankan
        kereta.kurangiKursi(jumlahTiket);
        System.out.println("\nPemesanan berhasil!");
        System.out.printf("Penumpang  : %s%n", namaPenumpang);
        System.out.printf("NIK        : %s%n", nik);
        System.out.printf("Kereta     : %s%n", kereta.getNamaKereta());
        System.out.printf("Rute       : %s%n", kereta.getRute());
        System.out.printf("Jumlah     : %d tiket%n", jumlahTiket);
        System.out.printf("Sisa Kursi : %d kursi%n", kereta.getSisaKursi());
        System.out.println();
    }

    // Memvalidasi format NIK: harus tepat 16 karakter dan hanya berisi angka
    // Melempar DataPenumpangTidakValidException (Unchecked) jika tidak sesuai
    private void validasiNIK(String nik) {
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                    "NIK tidak valid! Harus tepat 16 karakter. "
                    + "NIK Anda memiliki " + nik.length() + " karakter.");
        }
        if (!nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException(
                    "NIK tidak valid! NIK hanya boleh mengandung angka.");
        }
    }

    // Mencari objek KeretaApi berdasarkan kode kereta (case-insensitive)
    // Melempar RuteTidakDitemukanException (Checked) jika kode tidak ditemukan
    private KeretaApi cariKereta(String kodeKereta) throws RuteTidakDitemukanException {
        for (KeretaApi k : daftarKereta) {
            if (k.getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                return k;
            }
        }
        // Hanya pass kodeKereta, bukan kalimat lengkap — pesan dibentuk di konstruktor exception
        throw new RuteTidakDitemukanException(kodeKereta);
    }
}