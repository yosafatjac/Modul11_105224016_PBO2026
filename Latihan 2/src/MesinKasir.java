public class MesinKasir {

    public void bayar(int totalBelanja, int uangDiberikan) throws UangKurangException {
        if (uangDiberikan < totalBelanja) {
            throw new UangKurangException("Error: Uang pembayaran kurang!");
        }

        System.out.println("Pembayaran berhasil.");
    }

    public void cetakStruk(boolean statusPrinter) throws Exception {
        if (statusPrinter == false) {
            throw new Exception("Printer error: Kertas struk habis!");
        }

        System.out.println("Struk berhasil dicetak.");
    }
}