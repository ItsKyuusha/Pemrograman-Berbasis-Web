//database berdasarkan sc pak harkespan(kode_brg, nama brg, satuan, stok, stok_min)

package javadb;

import java.sql.*;

public class JavaDB {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/contoh";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    public static void main(String[] args) {
        insert();
        //update("brg17", "Mie Goreng Aceh", "Pack", 50, 2);
        //delete("brg17");
        show();
    }

    public static void insert() {
        String kode_brg = "brg17";
        String nama_brg = "Mie Rebus";
        String satuan = "Bungkus";
        int stok = 30;
        int stok_min = 1;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO barang (kode_brg,nama_brg,satuan,stok,stok_min) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kode_brg);
            ps.setString(2, nama_brg);
            ps.setString(3, satuan);
            ps.setInt(4, stok);
            ps.setInt(5, stok_min);

            ps.execute();

            stmt.close();
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

            rs = stmt.executeQuery("SELECT * FROM barang");
            int i = 1;
            while (rs.next()) {
                System.out.println("Data ke-" + i);
                System.out.println("Kode Barang: " + rs.getString("kode_brg"));
                System.out.println("Nama Barang: " + rs.getString("nama_brg"));
                System.out.println("Satuan: " + rs.getString("satuan"));
                System.out.println("Stok: " + rs.getInt("stok"));
                System.out.println("Stok minimal: " + rs.getInt("stok_min"));
                i++;
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(String kode_brg, String nama_brg, String satuan, int stok, int stok_min) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "UPDATE barang SET nama_brg = ?, satuan = ?, stok = ?, stok_min = ? WHERE kode_brg = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nama_brg);
            ps.setString(2, satuan);
            ps.setInt(3, stok);
            ps.setInt(4, stok_min);
            ps.setString(5, kode_brg);

            ps.executeUpdate();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(String kode_brg) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "DELETE FROM barang WHERE kode_brg = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode_brg);

            ps.executeUpdate();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
