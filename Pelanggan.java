package TugasBesar;

import java.util.List;

public class Pelanggan {
	private String nama;
    private String email;
    private String nomorTelpon;
    private List <String> pesanan;

    public Pelanggan(String nama, String email, String nomorTelpon, List<String> pesanan) {
        this.nama = nama;
        this.email = email;
        this.nomorTelpon = nomorTelpon;
        this.pesanan = pesanan;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNomorTelpon() {
        return nomorTelpon;
    }

    public void addPesanan (String pesan, int harga) {
       pesanan.add(pesan);
    }

    public List<String> getPesanan(){
        return pesanan;
    }
}
