package javadb;

import java.sql.*;
import java.util.Scanner;

public class Koneksi {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/latjava";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPilih operasi: ");
            System.out.println("1. Insert");
            System.out.println("2. Show");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Input pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    insert(scanner);
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    System.out.print("Masukkan ID Buku yang ingin diupdate: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    update(scanner, updateId);
                    break;
                case 4:
                    System.out.print("Masukkan ID Buku yang ingin dihapus: ");
                    int deleteId = scanner.nextInt();
                    delete(deleteId);
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void insert(Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String judul_buku = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahun_terbit = scanner.nextInt();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan penulis: ");
        String penulis = scanner.nextLine();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO buku (judul_buku, tahun_terbit, stok, penulis) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, judul_buku);
            ps.setInt(2, tahun_terbit);
            ps.setInt(3, stok);
            ps.setString(4, penulis);

            ps.executeUpdate();

            ps.close();
            conn.close();
            System.out.println("Data berhasil ditambahkan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM buku");
            int i = 1;
            while (rs.next()) {
                System.out.println("\nData ke-" + i);
                System.out.println("ID Buku: " + rs.getInt("id_buku"));
                System.out.println("Judul Buku: " + rs.getString("judul_buku"));
                System.out.println("Tahun Terbit: " + rs.getInt("tahun_terbit"));
                System.out.println("Stok: " + rs.getInt("stok"));
                System.out.println("Penulis: " + rs.getString("penulis"));
                i++;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Scanner scanner, int id_buku) {
        System.out.print("Masukkan judul buku baru: ");
        String judul_buku = scanner.nextLine();
        System.out.print("Masukkan tahun terbit baru: ");
        int tahun_terbit = scanner.nextInt();
        System.out.print("Masukkan stok baru: ");
        int stok = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan penulis baru: ");
        String penulis = scanner.nextLine();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE buku SET judul_buku = ?, tahun_terbit = ?, stok = ?, penulis = ? WHERE id_buku = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, judul_buku);
            ps.setInt(2, tahun_terbit);
            ps.setInt(3, stok);
            ps.setString(4, penulis);
            ps.setInt(5, id_buku);

            ps.executeUpdate();

            ps.close();
            conn.close();
            System.out.println("Data berhasil diupdate.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id_buku) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM buku WHERE id_buku = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_buku);

            ps.executeUpdate();

            ps.close();
            conn.close();
            System.out.println("Data berhasil dihapus.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
