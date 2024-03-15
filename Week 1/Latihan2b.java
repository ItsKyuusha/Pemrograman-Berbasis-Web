public class Latihan2b {
    public static void main(String[] args) {

        // Luas segitiga siku-siku
        double alasSegitiga = 6;
        double tinggiSegitiga = 8;
        double luasSegitiga = hitungLuasSegitiga(alasSegitiga, tinggiSegitiga);
        System.out.println("Luas segitiga siku-siku dengan alas 6 dan tinggi 8: " + luasSegitiga);

    }

    // Fungsi untuk menghitung luas segitiga siku-siku
    public static double hitungLuasSegitiga(double alas, double tinggi) {
        return 0.5 * alas * tinggi;
    }
}
