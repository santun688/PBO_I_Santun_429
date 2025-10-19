import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manajemenstok {
    public static void main(String[] args){
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        daftarBarang.add(new Barang("celana", 55));
        daftarBarang.add(new Barang("Baju", 56));

        boolean running = true;

        while(running){
            System.out.println("\nMENU MENAJEMEN STOK");
            System.out.println("1. tambah barang baru");
            System.out.println("2. tampilkan semua barang");
            System.out.println("3. kurangi stok barang");
            System.out.println("4. hapus barang dari daftar");
            System.out.println("0. keluar");
            System.out.print("Pilih opsi: ");
            InputMismatchException Scenner;

            String pilihan = input.nextLine();

            switch (pilihan){
                case "1":
                    System.out.print("masukkan nama barang: ");
                    String nama = input.nextLine();

                    try {
                        System.out.print("masukkan stok awal: ");
                        int stok = Integer.parseInt(input.nextLine());

                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println( nama + " dengan stok " + stok +" berhasil ditambahkan.:)");
                    }catch (NumberFormatException e) {
                        System.out.println("Input stok harus berupa anggka!!!");
                    }
                    break;

                case "2":
                    if (daftarBarang.isEmpty()){
                        System.out.println("stok barang kosong sayangggg.");
                    }else {
                        System.out.println("\n====DAFTAR BARANG====");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + "\n   Stok: " + b.getStok());
                        }
                    }

                    break;

                case "3":
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi stok.");
                        break;
                    }

                    System.out.println("\n***** Daftar Barang ***** ");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + "\n   Stok: " + b.getStok());
                    }

                    try {
                        System.out.print("Masukkan indeks barang yang ingin dikurangi stoknya: ");
                        int indeks = Integer.parseInt(input.nextLine());

                        Barang barangDipilih = daftarBarang.get(indeks);

                        System.out.print("Masukkan jumlah yang ingin diambil: ");
                        int jumlahDiambil = Integer.parseInt(input.nextLine());

                        if (jumlahDiambil > barangDipilih.getStok()) {
                            throw new StoktidakcukupException("Stok untuk " + barangDipilih.getNama() +
                                    " hanya tersisa " + barangDipilih.getStok());
                        }

                        barangDipilih.setStok(barangDipilih.getStok() - jumlahDiambil);
                        System.out.println("Stok " + barangDipilih.getNama() + " berhasil dikurangi. stok tersisa " + barangDipilih.getStok() + ".");

                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka yaa.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid.");
                    } catch (StoktidakcukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "4":
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dihapus.");
                        break;
                    }

                    System.out.println("\nDaftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + "\n   Stok: " + b.getStok());
                    }

                    try {
                        System.out.print("Masukkan indeks barang yang ingin dihapus: ");
                        int indeksHapus = input.nextInt();
                        input.nextLine(); // consume newline
                        Barang removed = daftarBarang.remove(indeksHapus);
                        System.out.println("Barang \n" + removed.getNama() + " telah dihapus dari daftar.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        input.nextLine(); // clear buffer
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid.");
                    }
                    break;

                case "0":
                    System.out.println("Terima kasih sayangkuuu, programnya telah berakhir, seperti hubungan kamu dengan dia.");
                    running = false;
                    break;

                default:
                    System.out.println("Opsi tidak valid sayangkuu, coba yang valid-valid aja.");
                    break;
            }
        }

        input.close();

    }

}
