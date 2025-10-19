public class Barang {
    private final String nama;
    private int stok;

    public Barang(String nama, int stok){//contraktor
        this.nama = nama;
        this.stok =stok;
    }

    public String getNama(){
        return nama;
    }

    public int getStok (){
        return stok;
    }

    public void setStok(int stok){
        this.stok = stok;
    }
}
