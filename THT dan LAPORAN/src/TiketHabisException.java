// Checked Exception → extends Exception
// Dilempar saat jumlah tiket yang dipesan melebihi sisa kursi
// Membawa informasi spesifik: nama kereta dan sisa kursi yang tersedia
public class TiketHabisException extends Exception {
    private String namaKereta;
    private int sisaKursi;

    public TiketHabisException(String namaKereta, int sisaKursi) {
        // Pesan error otomatis dibentuk dari nama kereta dan sisa kursi
        super("Tiket untuk kereta '" + namaKereta + "' tidak mencukupi. "
                + "Sisa kursi tersedia: " + sisaKursi);
        this.namaKereta = namaKereta;
        this.sisaKursi  = sisaKursi;
    }

    // Getter untuk mengakses info spesifik dari exception ini
    public String getNamaKereta() { return namaKereta; }
    public int getSisaKursi()     { return sisaKursi; }
}