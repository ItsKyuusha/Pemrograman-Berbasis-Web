//database berdasarkan data tugas & id sudah auto increment (id_buku, judul_buku, tahun_terbit, stok, penulis)

package javadb;

import java.sql.*;

public class JavaDB3 {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/latjava";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        //insert();
        //show();
        //update(1, "Mie Goreng Aceh", 2023, 50, "Penulis Baru");
        //show();
        delete(2);
        show();
    }

    public static void insert() {
        String judul_buku = "Pergi";
        int tahun_terbit = 2024;
        int stok = 30;
        String penulis = "TereLiye";
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
                System.out.println("Data ke-" + i);
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

    public static void update(int id_buku, String judul_buku, int tahun_terbit, int stok, String penulis) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
