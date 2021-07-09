-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 09, 2021 at 09:19 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kidzania`
--

-- --------------------------------------------------------

--
-- Table structure for table `pengunjung`
--

CREATE TABLE `pengunjung` (
  `No_Kartu` int(10) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Saldo` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengunjung`
--

INSERT INTO `pengunjung` (`No_Kartu`, `Nama`, `Saldo`) VALUES
(123190143, 'Hisyam', 290000),
(123190163, 'Ersa', 14370000);

-- --------------------------------------------------------

--
-- Table structure for table `pilihan_pengunjung`
--

CREATE TABLE `pilihan_pengunjung` (
  `Id_Pilih` int(2) NOT NULL,
  `Nama_Pengunjung` varchar(25) NOT NULL,
  `Jumlah_anakA` int(2) NOT NULL,
  `Jumlah_Dewasa` int(2) NOT NULL,
  `Nama_Wahana` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rekap`
--

CREATE TABLE `rekap` (
  `No_Rekap` int(3) NOT NULL,
  `No_Kartu` int(10) NOT NULL,
  `Nama_Wahana` varchar(25) NOT NULL,
  `Total` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rekap`
--

INSERT INTO `rekap` (`No_Rekap`, `No_Kartu`, `Nama_Wahana`, `Total`) VALUES
(5, 123190163, 'Dental Clinic', 960000),
(6, 123190163, 'Tattoo Shop', 210000),
(7, 123190143, 'Fire Station', 210000),
(8, 123190163, 'Dental Clinic', 960000);

-- --------------------------------------------------------

--
-- Table structure for table `wahana`
--

CREATE TABLE `wahana` (
  `Id_Wahana` int(11) NOT NULL,
  `Nama_Wahana` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wahana`
--

INSERT INTO `wahana` (`Id_Wahana`, `Nama_Wahana`) VALUES
(1, 'Acting Academy'),
(2, 'Fire Station'),
(3, 'Dental Clinic'),
(4, 'Mini Market'),
(5, 'Tattoo Shop');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pengunjung`
--
ALTER TABLE `pengunjung`
  ADD PRIMARY KEY (`No_Kartu`);

--
-- Indexes for table `pilihan_pengunjung`
--
ALTER TABLE `pilihan_pengunjung`
  ADD PRIMARY KEY (`Id_Pilih`);

--
-- Indexes for table `rekap`
--
ALTER TABLE `rekap`
  ADD PRIMARY KEY (`No_Rekap`),
  ADD KEY `No_Kartu` (`No_Kartu`);

--
-- Indexes for table `wahana`
--
ALTER TABLE `wahana`
  ADD PRIMARY KEY (`Id_Wahana`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pilihan_pengunjung`
--
ALTER TABLE `pilihan_pengunjung`
  MODIFY `Id_Pilih` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `rekap`
--
ALTER TABLE `rekap`
  MODIFY `No_Rekap` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
