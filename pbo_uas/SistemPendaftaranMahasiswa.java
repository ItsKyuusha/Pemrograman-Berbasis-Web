import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SistemPendaftaranMahasiswa extends JFrame {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/javauas";
    static final String USER = "root";
    static final String PASS = "";

    private Connection connection;
    private JTextField namaMahasiswaField, nimMahasiswaField;
    private JTextArea outputArea;

    public SistemPendaftaranMahasiswa() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Pengaturan GUI
            setTitle("Sistem Pendaftaran Mahasiswa");
            setSize(400, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(4, 2));

            // Input Mahasiswa
            namaMahasiswaField = new JTextField();
            nimMahasiswaField = new JTextField();
            JButton addMahasiswaButton = new JButton("Tambah Mahasiswa");
            addMahasiswaButton.addActionListener(new AddMahasiswaListener());

            add(new JLabel("Nama Mahasiswa:"));
            add(namaMahasiswaField);
            add(new JLabel("NIM:"));
            add(nimMahasiswaField);
            add(addMahasiswaButton);

            // Output area
            outputArea = new JTextArea();
            add(new JScrollPane(outputArea));

            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class AddMahasiswaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nama = namaMahasiswaField.getText();
            String nim = nimMahasiswaField.getText();
            try {
                String sql = "INSERT INTO mahasiswa (nama, nim) VALUES (?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, nama);
                ps.setString(2, nim);
                ps.executeUpdate();
                ps.close();
                outputArea.append("Mahasiswa ditambahkan: " + nama + "\n");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemPendaftaranMahasiswa::new);
    }
}
