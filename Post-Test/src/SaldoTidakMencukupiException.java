public class SaldoTidakMencukupiException extends Exception {
    private double kekuranganSaldo;

    public SaldoTidakMencukupiException(double kekuranganSaldo) {
        super("Saldo tidak mencukupi!");
        this.kekuranganSaldo = kekuranganSaldo;
    }

    public double getKekuranganSaldo() {
        return kekuranganSaldo;
    }
}