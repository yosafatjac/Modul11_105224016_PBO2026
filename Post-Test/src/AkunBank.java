public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;

    private static final double LIMIT_TRANSFER_HARIAN = 10000000;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalTransferHariIni() {
        return totalTransferHariIni;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException(kekurangan);
        }

        saldo -= nominal;
        System.out.println("Tarik tunai berhasil sebesar Rp " + nominal);
        System.out.println("Sisa saldo: Rp " + saldo);
    }

    public void transfer(AkunBank tujuan, double nominal) 
            throws SaldoTidakMencukupiException, BatasTransferHarianException {

        if (totalTransferHariIni + nominal > LIMIT_TRANSFER_HARIAN) {
            throw new BatasTransferHarianException(
                "Transfer gagal! Total transfer hari ini melebihi limit Rp " + LIMIT_TRANSFER_HARIAN
            );
        }

        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException(kekurangan);
        }

        saldo -= nominal;
        tujuan.saldo += nominal;
        totalTransferHariIni += nominal;

        System.out.println("Transfer berhasil sebesar Rp " + nominal);
        System.out.println("Ke rekening: " + tujuan.getNomorRekening());
        System.out.println("Sisa saldo: Rp " + saldo);
    }
}