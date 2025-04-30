public class Main {
    public static void main(String[] args) {

        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 44);

        System.out.println("STATUS AWAL:");
        System.out.println(brimstone.getNama() + " memiliki Kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki Kesehatan: " + viper.getKesehatan() + "\n");

        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}