-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2024 at 05:14 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `ID_MAHASISWA` int(11) DEFAULT NULL,
  `NAMA_LENGKAP` varchar(50) DEFAULT NULL,
  `TEMPAT` varchar(20) DEFAULT NULL,
  `TANGGAL_LAHIR` date DEFAULT NULL,
  `JENIS_KELAMIN` varchar(20) DEFAULT NULL,
  `AGAMA` varchar(20) DEFAULT NULL,
  `KEWARGANEGARAAN` varchar(20) DEFAULT NULL,
  `NO_TELP` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `ASAL_SEKOLAH` varchar(20) DEFAULT NULL,
  `NAMA_WALI` varchar(50) DEFAULT NULL,
  `PENDIDIKAN_WALI` varchar(20) DEFAULT NULL,
  `PROFESI_WALI` varchar(20) DEFAULT NULL,
  `NO_TELP_WALI` varchar(20) DEFAULT NULL,
  `PRODI` varchar(20) DEFAULT NULL,
  `FAKULTAS` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`ID_MAHASISWA`, `NAMA_LENGKAP`, `TEMPAT`, `TANGGAL_LAHIR`, `JENIS_KELAMIN`, `AGAMA`, `KEWARGANEGARAAN`, `NO_TELP`, `EMAIL`, `ALAMAT`, `ASAL_SEKOLAH`, `NAMA_WALI`, `PENDIDIKAN_WALI`, `PROFESI_WALI`, `NO_TELP_WALI`, `PRODI`, `FAKULTAS`) VALUES
(2, 'AVITYA ZOOGY PRAMANA', 'kudus', '2024-07-07', 'Laki - Laki', 'Islam', 'WNI', '087', 'avit@gmail.com', 'kudus', 'sma kudus', 'tarno', 's1', 'pedagang', '076', 'DKV', 'FIK'),
(1, 'david sugiartto', 'demak', '2024-07-01', 'Laki - Laki', 'Islam', 'WNI', '0888', 'kyuu@gmail.com', 'semarang', 'man demak', 'fulan', 'sma', 'wiraswasta', '0999', 'Akuntansi', 'FIK');

-- --------------------------------------------------------

--
-- Table structure for table `matkul`
--

CREATE TABLE `matkul` (
  `KODE_MATKUL` varchar(20) DEFAULT NULL,
  `NAMA_MATKUL` varchar(20) DEFAULT NULL,
  `DOSEN` varchar(50) DEFAULT NULL,
  `KODE_PRODI` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `matkul`
--

INSERT INTO `matkul` (`KODE_MATKUL`, `NAMA_MATKUL`, `DOSEN`, `KODE_PRODI`) VALUES
('A11-01', 'Struktur Data', 'Dr. Budi Santoso', 'A11'),
('A11-02', 'Algoritma dan Pemrog', 'Prof. Dian Surya', 'A11'),
('A11-03', 'Basis Data', 'Dr. Anita Rahayu', 'A11'),
('A11-04', 'Jaringan Komputer', 'Prof. Ahmad Yudha', 'A11'),
('A11-05', 'Pemrograman Berorien', 'Dr. Indra Gunawan', 'A11'),
('A12-01', 'Dasar-Dasar Desain', 'Prof. Dinda Permatasari', 'A12'),
('A12-02', 'Tipografi', 'Dr. Candra Wijaya', 'A12'),
('A12-03', 'Ilustrasi Digital', 'Dr. Fira Azahra', 'A12'),
('A12-04', 'Desain Web', 'Prof. Johan Setiawan', 'A12'),
('A12-05', 'Fotografi', 'Dr. Maya Fitriani', 'A12'),
('A13-01', 'Sistem Informasi Man', 'Prof. Irfan Prabowo', 'A13'),
('A13-02', 'Analisis dan Desain ', 'Dr. Retno Wulandari', 'A13'),
('A13-03', 'Pengantar Teknologi ', 'Dr. Dini Kartika', 'A13'),
('A13-04', 'E-Business', 'Prof. Andi Suryono', 'A13'),
('A13-05', 'Basis Data', 'Dr. Arif Wibowo', 'A13'),
('B11-01', 'Pengantar Manajemen', 'Prof. Bambang Sumantri', 'B11'),
('B11-02', 'Manajemen Keuangan', 'Dr. Rina Nurfitriani', 'B11'),
('B11-03', 'Manajemen Sumber Day', 'Dr. Andi Gunawan', 'B11'),
('B11-04', 'Manajemen Pemasaran', 'Prof. Lina Susanti', 'B11'),
('B11-05', 'Perilaku Organisasi', 'Dr. Hana Damayanti', 'B11'),
('B12-01', 'Akuntansi Dasar', 'Prof. Hadi Santoso', 'B12'),
('B12-02', 'Akuntansi Keuangan', 'Dr. Ratna Dewi', 'B12'),
('B12-03', 'Akuntansi Biaya', 'Prof. M. Farhan', 'B12'),
('B12-04', 'Audit', 'Dr. Siti Rahayu', 'B12'),
('B12-05', 'Sistem Informasi Aku', 'Prof. Adi Wijaya', 'B12'),
('C11-01', 'Dasar-Dasar Kesehata', 'Prof. Siti Aminah', 'C11'),
('C11-02', 'Epidemiologi', 'Dr. Budi Susilo', 'C11'),
('C11-03', 'Kesehatan Lingkungan', 'Dr. Maya Sari', 'C11'),
('C11-04', 'Gizi Masyarakat', 'Prof. Joko Susanto', 'C11'),
('C11-05', 'Promosi Kesehatan', 'Dr. Rini Wulandari', 'C11'),
('C12-01', 'Dasar-Dasar Rekam Me', 'Prof. Ida Fitriani', 'C12'),
('C12-02', 'Manajemen Informasi ', 'Dr. Dini Puspitasari', 'C12'),
('C12-03', 'Kodefikasi Penyakit', 'Dr. Anwar Sadat', 'C12'),
('C12-04', 'Statistik Kesehatan', 'Prof. Endang Suhartini', 'C12'),
('C12-05', 'Etika Profesi Rekam ', 'Dr. Siti Hidayah', 'C12'),
('D11-01', 'Pengantar Teknik Ind', 'Prof. Haryono Budiman', 'D11'),
('D11-02', 'Rancangan Sistem Ker', 'Dr. Rudi Santoso', 'D11'),
('D11-03', 'Statistik Industri', 'Dr. Dian Kusuma', 'D11'),
('D11-04', 'Manajemen Operasi', 'Prof. Susanto', 'D11'),
('D11-05', 'Sistem Produksi', 'Dr. Ari Wijaya', 'D11'),
('D12-01', 'Dasar-Dasar Teknik M', 'Prof. Slamet Riyadi', 'D12'),
('D12-02', 'Sistem dan Komponen ', 'Dr. Indra Gunawan', 'D12'),
('D12-03', 'Teknologi Mesin', 'Dr. Wahyu Susanto', 'D12'),
('D12-04', 'Manajemen Bengkel', 'Prof. Ahmad Jaya', 'D12'),
('D12-05', 'Elektronika Kendaraa', 'Dr. Dwi Putra', 'D12'),
('E11-01', 'Pengantar Sastra Jep', 'Prof. Yuki Tanaka', 'E11'),
('E11-02', 'Tata Bahasa Jepang', 'Dr. Kazuko Mori', 'E11'),
('E11-03', 'Budaya dan Masyaraka', 'Dr. Hiroshi Suzuki', 'E11'),
('E11-04', 'Terjemahan Jepang-In', 'Prof. Aiko Sato', 'E11'),
('E11-05', 'Keterampilan Berbica', 'Dr. Kenji Yamamoto', 'E11'),
('E12-01', 'Pengantar Sastra Ing', 'Prof. Emily Watson', 'E12'),
('E12-02', 'Tata Bahasa Inggris', 'Dr. John Smith', 'E12'),
('E12-03', 'Keterampilan Menulis', 'Dr. Sarah Brown', 'E12'),
('E12-04', 'Kesusastraan Inggris', 'Prof. Michael Johnson', 'E12'),
('E12-05', 'Terjemahan Inggris-I', 'Dr. Lisa Anderson', 'E12');

-- --------------------------------------------------------

--
-- Table structure for table `prodi`
--

CREATE TABLE `prodi` (
  `KODE_PRODI` varchar(20) DEFAULT NULL,
  `NAMA_PRODI` varchar(20) DEFAULT NULL,
  `FAKULTAS` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prodi`
--

INSERT INTO `prodi` (`KODE_PRODI`, `NAMA_PRODI`, `FAKULTAS`) VALUES
('A11', 'Teknik Informatika', 'FIK'),
('A12', 'DKV', 'FIK'),
('A13', 'Sistem Informasi', 'FIK'),
('B11', 'Manajemen', 'FEB'),
('B12', 'Akuntansi', 'FEB'),
('C11', 'Kesehatan Masyarakat', 'FKes'),
('C12', 'Rekam Medis', 'FKes'),
('D11', 'Teknik Industri', 'FT'),
('D12', 'Teknik Mesin', 'FT'),
('E11', 'Sastra Jepang', 'FIB'),
('E12', 'Sastra Inggris', 'FIB');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
