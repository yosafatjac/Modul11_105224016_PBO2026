public class Kalkulator {
    public double bagi(double pembilang, double penyebut) {
        if (penyebut == 0) {
            throw new ArithmeticException("Penyebut tidak boleh 0!");
        }
        return pembilang / penyebut;
    }
}