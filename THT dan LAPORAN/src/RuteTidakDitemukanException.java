// Checked Exception → extends Exception
// Dilempar saat kode kereta yang dicari tidak ada dalam sistem
public class RuteTidakDitemukanException extends Exception {
    public RuteTidakDitemukanException(String kodeKereta) {
        super("Rute dengan kode kereta '" + kodeKereta + "' tidak ditemukan dalam sistem.");
    }
}