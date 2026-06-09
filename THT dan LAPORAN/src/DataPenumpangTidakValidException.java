// Unchecked Exception → extends RuntimeException
// Dilempar saat data penumpang (NIK) tidak memenuhi validasi
public class DataPenumpangTidakValidException extends RuntimeException {
    public DataPenumpangTidakValidException(String pesan) {
        super(pesan);
    }
}