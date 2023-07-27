package TugasBesar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore("data_pelanggan.txt");
        toyStore.loadData();


        DaftarMainan daftarMainan = new DaftarMainan(toyStore);

        Scanner scanner = new Scanner(System.in);

        int pilih;
        boolean hasData = !toyStore.getPelanggans().isEmpty();
        List<String > pesanan = new ArrayList<>();

        do {
            System.out.println("1. Masukkan Data Pelanggan");
            System.out.println("2. Hapus Data Pelanggan");
            System.out.println("3. Atur Ulang Data Pelanggan");
            if (hasData) {
                System.out.println("4. Tampilkan Data Pelanggan");
                System.out.println("5. Tampilkan Daftar Mainan");
            }
            System.out.println("6. Keluar");
            System.out.print("Masukkan Pilihan Anda (1, 2, 3, 4, 5, atau 6): ");
            pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("Masukkan Data Tentang Pelanggan :");
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nomor Telpon: ");
                    String nomorTelpon = scanner.nextLine();

                    toyStore.addPelanggan(new Pelanggan(nama, email, nomorTelpon, pesanan));
                    hasData = true;
                    break;
                case 2:
                    System.out.print("Masukkan Nomor Telpon Dari Pelanggan Yang Akan Dihapus: ");
                    String namaUntukDihapus = scanner.nextLine();
                    toyStore.removePelangganBynomorTelpon(namaUntukDihapus);
                    break;
                case 3:
                    toyStore.resetData();
                    hasData = false;
                    break;
                case 4:
                    toyStore.displayData();
                    break;
                case 5:
                    daftarMainan.tampilkanDaftarMainan();
                    break;
                case 6:
                    System.out.println("Keluar Dari Program.");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid. Silahkan Coba Lagi.");
                    break;
            }
            toyStore.saveData();
        } while (pilih != 6);
    }
}
