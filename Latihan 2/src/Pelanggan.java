public class Pelanggan {
    private int stokKopi = 5;

    public void daftarMember(int umur) {
        if (umur < 17) {
            throw new IllegalArgumentException(
                "Maaf, umur Anda belum mencukupi untuk menjadi Member VIP"
            );
        }

        System.out.println("Berhasil daftar Member VIP.");
    }

    public void pesanKopi(int jumlahPesanan) {
        if (jumlahPesanan > stokKopi) {
            throw new KopiHabisException("Error: Stok kopi tidak cukup!");
        }

        stokKopi -= jumlahPesanan;
        System.out.println("Pesanan kopi berhasil.");
    }
}