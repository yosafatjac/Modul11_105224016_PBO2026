public class Main {
    public static void main(String[] args) {
        AkunBank akun1 = new AkunBank("98923472", 5000000);
        AkunBank akun2 = new AkunBank("98294734", 2000000);

        try {
            System.out.println("\n=== Sistem ATM Digital ===");
            System.out.println("Nomor Rekening: " + akun1.getNomorRekening());
            System.out.println("Saldo awal: Rp " + akun1.getSaldo());
            System.out.println();

            System.out.println("Nasabah mencoba menarik uang...");
            akun1.tarikTunai(5000000);

            System.out.println();

            System.out.println("Nasabah mencoba menarik uang lagi...");
            akun1.tarikTunai(1000000);

        } catch (SaldoTidakMencukupiException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Kekurangan saldo sebesar Rp " + e.getKekuranganSaldo());

        } catch (Exception e) {
            System.out.println("Terjadi error umum: " + e.getMessage());

        } finally {
            System.out.println();
            System.out.println("Sesi transaksi ATM Anda telah diakhiri. Kartu dikeluarkan otomatis.");
        }

        System.out.println();

        try {
            System.out.println("=== Sesi Transfer ATM Digital ===");
            System.out.println("Nasabah mencoba transfer dalam jumlah besar...");
            akun1.transfer(akun2, 11000000);

        } catch (SaldoTidakMencukupiException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Kekurangan saldo sebesar Rp " + e.getKekuranganSaldo());

        } catch (BatasTransferHarianException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println();
            System.out.println("Sesi transaksi ATM Anda telah diakhiri. Kartu dikeluarkan otomatis.");
        }
    }
}