package TugasBesar;

import java.util.Scanner;

public class DaftarMainan {
    private ToyStore toyStore;
    private Scanner scanner;

    public DaftarMainan(ToyStore toyStore){
        this.toyStore = toyStore;
        scanner = new Scanner(System.in);
    }
    public void tampilkanDaftarMainan() {
        int pilihan;
        do{
            System.out.println("Daftar Mainan: ");
            System.out.println("1. Rubik");
            System.out.println("2. Hot Wheels");
            System.out.println("3. Kembali");
            System.out.println("Pilih (1, 2, atau 3) : ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    pilihDaftarMainan("Rubik", 15000);
                    break;
                case 2:
                    pilihDaftarMainan("Hotwheels", 25000);
                    break;
                case 3:
                    System.out.println("Kembali ke Menu Utama");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia. Silahkan Coba Lagi.");
                    break;
            }
        } while (pilihan != 3);
    }

private void pilihDaftarMainan (String daftarMainan, int harga){
    System.out.println("Nama Pelanggan: ");
    String namaPelanggan = scanner.nextLine();
    Pelanggan pelanggan = findPelangganByNama(namaPelanggan);

    if (pelanggan != null) {
        System.out.println("Pesanan Diterima!");
        System.out.println("Mainan Yang Dipesan: " + daftarMainan);
        System.out.println("Harga: Rp." + harga);

        System.out.println("Masukkan Jumlah Yang Harus Dibayar: ");
        int pembayaran = scanner.nextInt();
        scanner.nextLine();

        int kembalian = pembayaran - harga;
        if (kembalian < 0) {
            System.out.println("Maaf Uang Anda Tidak Cukup. ");
        } else {
            System.out.println("Terima Kasih Telah Berbelanja");
            System.out.println("Kembalian Anda: Rp." + kembalian);

            pelanggan.addPesanan(daftarMainan, harga);
            toyStore.saveData();
        }
    } else {
        System.out.println("Pelanggan Tidak Ditemukan");
    }
}

    private Pelanggan findPelangganByNama (String nama) {
        for (Pelanggan pelanggan : toyStore.getPelanggans()) {
            if (pelanggan.getNama().equals(nama)) {
                return pelanggan;
            }
        }
        return null;
    }
}
