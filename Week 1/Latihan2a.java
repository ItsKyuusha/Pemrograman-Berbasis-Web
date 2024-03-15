public class Latihan2a {
    public static void main(String[] args) {
        // Keliling lingkaran
        double diameterLingkaran = 10;
        double kelilingLingkaran = hitungKelilingLingkaran(diameterLingkaran);
        System.out.println("Keliling lingkaran dengan diameter 10: " + kelilingLingkaran);

    }

    // Fungsi untuk menghitung keliling lingkaran
    public static double hitungKelilingLingkaran(double diameter) {
        return Math.PI * diameter;
    }
}
