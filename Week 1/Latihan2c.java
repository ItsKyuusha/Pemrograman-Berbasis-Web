public class Latihan2c {
    public static void main(String[] args) {

        // Volume tabung
        double diameterTabung = 5;
        double tinggiTabung = 10;
        double volumeTabung = hitungVolumeTabung(diameterTabung, tinggiTabung);
        System.out.println("Volume tabung dengan diameter 5 dan tinggi 10: " + volumeTabung);
    }   

    // Fungsi untuk menghitung volume tabung
    public static double hitungVolumeTabung(double diameter, double tinggi) {
        double jariJari = diameter / 2;
        return Math.PI * jariJari * jariJari * tinggi;
    }
}
