// Kelas model yang merepresentasikan satu objek kereta api
public class KeretaApi {
    private String kodeKereta;  
    private String namaKereta;  
    private String rute;        
    private int sisaKursi;      

    // Konstruktor menerima kapasitas awal sebagai sisa kursi
    public KeretaApi(String kodeKereta, String namaKereta, String rute, int kapasitas) {
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
        this.rute = rute;
        this.sisaKursi = kapasitas;
    }

    // Getter untuk mengakses data kereta
    public String getKodeKereta() { return kodeKereta; }
    public String getNamaKereta() { return namaKereta; }
    public String getRute()       { return rute; }
    public int getSisaKursi()     { return sisaKursi; }

    // Mengurangi sisa kursi setelah pemesanan berhasil
    // Validasi jumlah sudah dilakukan di SistemReservasi sebelum method ini dipanggil
    public void kurangiKursi(int jumlah) {
        this.sisaKursi -= jumlah;
    }

    // Representasi teks objek kereta untuk ditampilkan di jadwal
    @Override
    public String toString() {
        return String.format("%-6s  %-20s  %-12s  %d kursi",
                kodeKereta, namaKereta, rute, sisaKursi);
    }
}