package TugasBesar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ToyStore {
    private List<Pelanggan> pelanggans;
    private String filename;

    public ToyStore(String filename) {
        this.filename = filename;
        pelanggans = new ArrayList<>();
    }

    public void addPelanggan(Pelanggan pelanggan) {
        pelanggans.add(pelanggan);
    }

    public void removePelangganBynomorTelpon(String nomorTelpon) {
        Iterator<Pelanggan> iterator = pelanggans.iterator();
        while (iterator.hasNext()) {
            Pelanggan pelanggan = iterator.next();
            if (pelanggan.getNomorTelpon().equals(nomorTelpon)) {
                iterator.remove();
                System.out.println("Pelanggan Dihapus.");
                return;
            }
        }
        System.out.println("Pelanggan Tidak Ditemukan.");
    }

    public void resetData() {
        pelanggans.clear();
        System.out.println("Semua Data Pelanggan Telah Direset.");
    }

    public void saveData() {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Pelanggan pelanggan : pelanggans) {
                StringBuilder sb = new StringBuilder();
                sb.append(pelanggan.getNama()).append(",");
                sb.append(pelanggan.getEmail()).append(",");
                sb.append(pelanggan.getNomorTelpon());
                for (String pesan : pelanggan.getPesanan()) {
                    sb.append(",").append(pesan);
                }
                writer.println(sb.toString());
            }
            System.out.println("Data Berhasil Disimpan.");
        } catch (FileNotFoundException e) {
            System.out.println("Terjadi Error Saat Menyimpan Data.");
        }
    }

    public void loadData() {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    String nama = data[0];
                    String email = data[1];
                    String nomorTelpon = data[2];
                    List<String> pesanan = new ArrayList<>();
                    if (data.length > 3) {
                        for (int i = 3; i < data.length; i++) {
                            pesanan.add(data[i]);
                        }
                    }
                    if (!nomorTelpon.startsWith("+62")) {
                        nomorTelpon = "+62" + nomorTelpon;
                    }
                    Pelanggan pelanggan = new Pelanggan(nama, email, nomorTelpon, pesanan);
                    pelanggans.add(pelanggan);
                }
            }
            System.out.println("Data Berhasil  Dimuat.");
        } catch (FileNotFoundException e) {
            System.out.println("Terjadi Error Saat Memuat Data.");
        }
    }

    public void displayData() {
        int index = 1;
        for (Pelanggan pelanggan : pelanggans) {
            System.out.println("Data " + index + ":");
            System.out.println("Nama: " + pelanggan.getNama());
            System.out.println("Email: " + pelanggan.getEmail());
            System.out.println("Nomor Telpon: " + pelanggan.getNomorTelpon());
            List<String> pesanan = pelanggan.getPesanan();
            if (pesanan.isEmpty()) {
                System.out.println("Pesanan : ");
                for (String pesan : pesanan ) {
                    System.out.println("- " + pesan);
                }
            }
            System.out.println("=========================");
            index++;
        }
    }

    public List<Pelanggan> getPelanggans() {
        return pelanggans;
    }
}
