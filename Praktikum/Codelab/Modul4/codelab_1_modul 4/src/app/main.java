package app;

import perpustakaan.*;

public class main{
    public static void main(String[] args) {
        // Membuat objek buku
        NonFiksi buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Fiksi buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        // Menampilkan info buku
        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        // Membuat anggota
        Anggota anggota1 = new Anggota("santun", "ID :I429");
        Anggota anggota2 = new Anggota("MARSYA", "ID :I440");

        // Menampilkan info anggota
        anggota1.displayInfo();
        anggota2.displayInfo();
        System.out.println();

        // Anggota meminjam buku
        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);
        System.out.println();

        // Anggota mengembalikan buku
        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}