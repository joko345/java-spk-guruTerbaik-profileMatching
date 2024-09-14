-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2024 at 10:49 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spktugasakhir`
--

-- --------------------------------------------------------

--
-- Table structure for table `awaltabel`
--

CREATE TABLE `awaltabel` (
  `nilaiAwal` varchar(24) NOT NULL,
  `idGuru` varchar(24) DEFAULT NULL,
  `namaGuru` varchar(24) NOT NULL,
  `nilaiDisiplin` int(24) NOT NULL,
  `nilaiKomitmen` int(24) NOT NULL,
  `nilaiLoyal` int(24) NOT NULL,
  `nilaiPrestasi` int(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `awaltabel`
--

INSERT INTO `awaltabel` (`nilaiAwal`, `idGuru`, `namaGuru`, `nilaiDisiplin`, `nilaiKomitmen`, `nilaiLoyal`, `nilaiPrestasi`) VALUES
('A0001', '00001', 'Alvin Ashar', 2, 3, 1, 4),
('A0002', '00002', 'Ayu Lestari', 1, 2, 4, 3),
('A0003', '00003', 'Bagas Haji', 4, 3, 2, 1),
('A0004', '00004', 'Bila Gemini', 2, 2, 1, 4),
('A0005', '00005', 'Wahyu Rido', 4, 2, 3, 1),
('A0006', '00006', 'Febrian Uso', 1, 4, 2, 5),
('A0007', '00007', 'Johan Pluto', 2, 1, 5, 2),
('A0008', '00008', 'Panji Alam', 10, 8, 10, 7),
('A0009', '00009', 'Riyan Haji', 7, 8, 9, 12),
('A0010', '00010', 'Mawar Indri', 8, 7, 6, 9);

-- --------------------------------------------------------

--
-- Table structure for table `cftabel`
--

CREATE TABLE `cftabel` (
  `idcf` varchar(24) NOT NULL,
  `idGap` varchar(24) DEFAULT NULL,
  `idKelas` varchar(24) DEFAULT NULL,
  `namaGuru` varchar(24) NOT NULL,
  `nilaiDisiplin` int(24) NOT NULL,
  `nilaiKomitmen` int(24) NOT NULL,
  `totalMateri` double NOT NULL,
  `nilaiLoyal` int(24) NOT NULL,
  `nilaiPrestasi` int(24) NOT NULL,
  `nilaiCore` float NOT NULL,
  `nilaiSecond` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cftabel`
--

INSERT INTO `cftabel` (`idcf`, `idGap`, `idKelas`, `namaGuru`, `nilaiDisiplin`, `nilaiKomitmen`, `totalMateri`, `nilaiLoyal`, `nilaiPrestasi`, `nilaiCore`, `nilaiSecond`) VALUES
('C0001', 'G0001', 'K0001', 'Alvin Ashar', 4, 5, 4, 3, 5, 7.8, 3.2),
('C0002', 'G0002', 'K0002', 'Ayu Lestari', 3, 4, 4, 5, 5, 6.6, 4),
('C0003', 'G0003', 'K0003', 'Bagas Haji', 5, 5, 5, 4, 3, 9, 2.8),
('C0004', 'G0004', 'K0004', 'Bila Gemini', 4, 4, 2, 3, 5, 6, 3.2),
('C0005', 'G0005', 'K0005', 'Wahyu Rido', 5, 4, 3, 5, 3, 7.2, 3.2),
('C0006', 'G0006', 'K0006', 'Febrian Uso', 3, 5, 2, 4, 4, 6, 3.2),
('C0007', 'G0007', 'K0007', 'Johan Pluto', 4, 3, 3, 4, 4, 6, 3.2),
('C0008', 'G0008', 'K0008', 'Panji Alam', 7, 5, 5, 7, 2, 10.2, 3.6),
('C0009', 'G0009', 'K0009', 'Riyan Haji', 2, 5, 3, 6, 9, 6, 6),
('C0010', 'G0010', 'K0010', 'Mawar Indri', 5, 2, 5, 3, 6, 7.2, 3.6);

-- --------------------------------------------------------

--
-- Table structure for table `gaptabel`
--

CREATE TABLE `gaptabel` (
  `idGap` varchar(24) NOT NULL,
  `nilaiAwal` varchar(24) DEFAULT NULL,
  `idGuru` int(24) DEFAULT NULL,
  `namaGuru` varchar(24) NOT NULL,
  `nilaiDisiplin` int(24) NOT NULL,
  `nilaiKomitmen` int(24) NOT NULL,
  `nilaiLoyal` int(24) NOT NULL,
  `nilaiPrestasi` int(24) NOT NULL,
  `nilaiGap` int(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gaptabel`
--

INSERT INTO `gaptabel` (`idGap`, `nilaiAwal`, `idGuru`, `namaGuru`, `nilaiDisiplin`, `nilaiKomitmen`, `nilaiLoyal`, `nilaiPrestasi`, `nilaiGap`) VALUES
('G0001', 'A0001', 1, 'Alvin Ashar', -1, 0, -2, 1, 3),
('G0002', 'A0002', 2, 'Ayu Lestari', -2, -1, 1, 0, 3),
('G0003', 'A0003', 3, 'Bagas Haji', 1, 0, -1, -2, 3),
('G0004', 'A0004', 4, 'Bila Gemini', -1, -1, -2, 1, 3),
('G0005', 'A0005', 5, 'Wahyu Rido', 1, -1, 0, -2, 3),
('G0006', 'A0006', 6, 'Febrian Uso', -2, 1, -1, 2, 3),
('G0007', 'A0007', 7, 'Johan Pluto', -1, -2, 2, -1, 3),
('G0008', 'A0008', 8, 'Panji Alam', 7, 5, 7, 4, 3),
('G0009', 'A0009', 9, 'Riyan Haji', 4, 5, 6, 9, 3),
('G0010', 'A0010', 10, 'Mawar Indri', 5, 4, 3, 6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `gurutabel`
--

CREATE TABLE `gurutabel` (
  `idGuru` varchar(24) NOT NULL,
  `namaGuru` varchar(24) NOT NULL,
  `usiaGuru` int(24) NOT NULL,
  `kelamin` varchar(24) NOT NULL,
  `lamaMengajar` int(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gurutabel`
--

INSERT INTO `gurutabel` (`idGuru`, `namaGuru`, `usiaGuru`, `kelamin`, `lamaMengajar`) VALUES
('00001', 'Alvin Ashar', 30, 'Laki - Laki', 1),
('00002', 'Ayu Lestari', 23, 'Perempuan', 4),
('00003', 'Bagas Haji', 25, 'Laki - Laki', 2),
('00004', 'Bila Gemini', 34, 'Perempuan', 1),
('00005', 'Wahyu Rido', 22, 'Laki - Laki', 3),
('00006', 'Febrian Uso', 43, 'Laki - Laki', 2),
('00007', 'Johan Pluto', 55, 'Laki - Laki', 5),
('00008', 'Panji Alam', 57, 'Laki - Laki', 10),
('00009', 'Riyan Haji', 20, 'Laki - Laki', 9),
('00010', 'Mawar Indri', 36, 'Perempuan', 6);

-- --------------------------------------------------------

--
-- Table structure for table `kelastabel`
--

CREATE TABLE `kelastabel` (
  `idKelas` varchar(24) NOT NULL,
  `namaKelas` varchar(24) NOT NULL,
  `idGuru` varchar(24) DEFAULT NULL,
  `opiniKelas` int(24) NOT NULL,
  `totalKuis` int(24) NOT NULL,
  `totalMateri` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelastabel`
--

INSERT INTO `kelastabel` (`idKelas`, `namaKelas`, `idGuru`, `opiniKelas`, `totalKuis`, `totalMateri`) VALUES
('K0001', '10A_2024', '00001', 18, 5, 4),
('K0002', '10A_2023', '00002', 19, 5, 4),
('K0003', '10A_2022', '00003', 20, 5, 5),
('K0004', '10B_2024', '00004', 6, 5, 2),
('K0005', '10B_2023', '00005', 10, 5, 3),
('K0006', '10B_2022', '00006', 9, 5, 2),
('K0007', '10C_2024', '00007', 12, 5, 3),
('K0008', '10C_2023', '00008', 20, 5, 5),
('K0009', '10C_2024', '00009', 10, 5, 3),
('K0010', '10D_2921', '00010', 21, 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(24) NOT NULL,
  `password` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `normaltable`
--

CREATE TABLE `normaltable` (
  `idGap` varchar(24) DEFAULT NULL,
  `nilaiAwal` varchar(24) DEFAULT NULL,
  `idGuru` int(24) NOT NULL,
  `namaGuru` varchar(24) NOT NULL,
  `nilaiDisiplin` int(24) NOT NULL,
  `nilaiKomitmen` int(24) NOT NULL,
  `nilaiLoyal` int(24) NOT NULL,
  `nilaiPrestasi` int(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `normaltable`
--

INSERT INTO `normaltable` (`idGap`, `nilaiAwal`, `idGuru`, `namaGuru`, `nilaiDisiplin`, `nilaiKomitmen`, `nilaiLoyal`, `nilaiPrestasi`) VALUES
('G0001', 'A0001', 1, 'Alvin Ashar', 4, 5, 3, 5),
('G0002', 'A0002', 2, 'Ayu Lestari', 3, 4, 5, 5),
('G0003', 'A0003', 3, 'Bagas Haji', 5, 5, 4, 3),
('G0004', 'A0004', 4, 'Bila Gemini', 4, 4, 3, 5),
('G0005', 'A0005', 5, 'Wahyu Rido', 5, 4, 5, 3),
('G0006', 'A0006', 6, 'Febrian Uso', 3, 5, 4, 4),
('G0007', 'A0007', 7, 'Johan Pluto', 4, 3, 4, 4),
('G0008', 'A0008', 8, 'Panji Alam', 7, 5, 7, 2),
('G0009', 'A0009', 9, 'Riyan Haji', 2, 5, 6, 9),
('G0010', 'A0010', 10, 'Mawar Indri', 5, 2, 3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `peringkattable`
--

CREATE TABLE `peringkattable` (
  `idRank` varchar(24) DEFAULT NULL,
  `idcf` varchar(24) NOT NULL,
  `idTotal` varchar(24) NOT NULL,
  `idGuru` varchar(24) NOT NULL,
  `namaGuru` varchar(24) NOT NULL,
  `nilaiDisiplin` int(11) NOT NULL,
  `nilaiKomitmen` int(11) NOT NULL,
  `totalMateri` int(11) NOT NULL,
  `nilaiLoyal` int(11) NOT NULL,
  `nilaiPrestasi` int(11) NOT NULL,
  `nilaiCore` double NOT NULL,
  `nilaiSecond` double NOT NULL,
  `totalAkhir` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peringkattable`
--

INSERT INTO `peringkattable` (`idRank`, `idcf`, `idTotal`, `idGuru`, `namaGuru`, `nilaiDisiplin`, `nilaiKomitmen`, `totalMateri`, `nilaiLoyal`, `nilaiPrestasi`, `nilaiCore`, `nilaiSecond`, `totalAkhir`) VALUES
('P0008', 'C0008', 'T0008', '00008', 'Panji Alam', 7, 5, 5, 7, 2, 10.2, 3.6, 7.56),
('P0003', 'C0003', 'T0003', '00003', 'Bagas Haji', 5, 5, 5, 4, 3, 9, 2.8, 6.52),
('P0009', 'C0009', 'T0009', '00009', 'Riyan Haji', 2, 5, 3, 6, 9, 6, 6, 6),
('P0001', 'C0001', 'T0001', '00001', 'Alvin Ashar', 4, 5, 4, 3, 5, 7.8, 3.2, 5.96),
('P0010', 'C0010', 'T0010', '00010', 'Mawar Indri', 5, 2, 5, 3, 6, 7.2, 3.6, 5.76),
('P0005', 'C0005', 'T0005', '00005', 'Wahyu Rido', 5, 4, 3, 5, 3, 7.2, 3.2, 5.6),
('P0006', 'C0006', 'T0005', '00006', 'Febrian Uso', 3, 5, 2, 4, 4, 7.2, 3.2, 5.6),
('P0002', 'C0002', 'T0002', '00002', 'Ayu Lestari', 3, 4, 4, 5, 5, 6.6, 4, 5.56),
('P0007', 'C0007', 'T0007', '00007', 'Johan Pluto', 4, 3, 3, 4, 4, 6, 3.2, 4.88),
('P0004', 'C0004', 'T0004', '00004', 'Bila Gemini', 4, 4, 2, 3, 5, 6, 3.2, 4.88);

-- --------------------------------------------------------

--
-- Table structure for table `ranktabel`
--

CREATE TABLE `ranktabel` (
  `idRank` varchar(24) NOT NULL,
  `idcf` varchar(24) DEFAULT NULL,
  `idTotal` varchar(24) DEFAULT NULL,
  `idGuru` varchar(24) DEFAULT NULL,
  `namaGuru` varchar(24) NOT NULL,
  `nilaiDisiplin` int(24) NOT NULL,
  `nilaiKomitmen` int(24) NOT NULL,
  `totalMateri` int(24) NOT NULL,
  `nilaiLoyal` int(24) NOT NULL,
  `nilaiPrestasi` int(24) NOT NULL,
  `nilaiCore` double NOT NULL,
  `nilaiSecond` double NOT NULL,
  `totalakhir` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ranktabel`
--

INSERT INTO `ranktabel` (`idRank`, `idcf`, `idTotal`, `idGuru`, `namaGuru`, `nilaiDisiplin`, `nilaiKomitmen`, `totalMateri`, `nilaiLoyal`, `nilaiPrestasi`, `nilaiCore`, `nilaiSecond`, `totalakhir`) VALUES
('P0001', 'C0001', 'T0001', '00001', 'Alvin Ashar', 4, 5, 4, 3, 5, 7.8, 3.2, 5.96),
('P0002', 'C0002', 'T0002', '00002', 'Ayu Lestari', 3, 4, 4, 5, 5, 6.6, 4, 5.56),
('P0003', 'C0003', 'T0003', '00003', 'Bagas Haji', 5, 5, 5, 4, 3, 9, 2.8, 6.52),
('P0004', 'C0004', 'T0004', '00004', 'Bila Gemini', 4, 4, 2, 3, 5, 6, 3.2, 4.88),
('P0005', 'C0005', 'T0005', '00005', 'Wahyu Rido', 5, 4, 3, 5, 3, 7.2, 3.2, 5.6),
('P0006', 'C0006', 'T0005', '00006', 'Febrian Uso', 3, 5, 2, 4, 4, 7.2, 3.2, 5.6),
('P0007', 'C0007', 'T0007', '00007', 'Johan Pluto', 4, 3, 3, 4, 4, 6, 3.2, 4.88),
('P0008', 'C0008', 'T0008', '00008', 'Panji Alam', 7, 5, 5, 7, 2, 10.2, 3.6, 7.56),
('P0009', 'C0009', 'T0009', '00009', 'Riyan Haji', 2, 5, 3, 6, 9, 6, 6, 6),
('P0010', 'C0010', 'T0010', '00010', 'Mawar Indri', 5, 2, 5, 3, 6, 7.2, 3.6, 5.76);

-- --------------------------------------------------------

--
-- Table structure for table `totaltabel`
--

CREATE TABLE `totaltabel` (
  `idTotal` varchar(24) NOT NULL,
  `idcf` varchar(24) NOT NULL,
  `nilaiCore` float NOT NULL,
  `nilaiSecond` float NOT NULL,
  `persenCF` float NOT NULL,
  `persenSF` float NOT NULL,
  `totalakhir` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `totaltabel`
--

INSERT INTO `totaltabel` (`idTotal`, `idcf`, `nilaiCore`, `nilaiSecond`, `persenCF`, `persenSF`, `totalakhir`) VALUES
('T0001', 'C0001', 7.8, 3.2, 60, 40, 5.96),
('T0002', 'C0002', 6.6, 4, 60, 40, 5.56),
('T0003', 'C0003', 9, 2.8, 60, 40, 6.52),
('T0004', 'C0004', 6, 3.2, 60, 40, 4.88),
('T0005', 'C0005', 7.2, 3.2, 60, 40, 5.6),
('T0006', 'C0006', 6, 3.2, 60, 40, 4.88),
('T0007', 'C0007', 6, 3.2, 60, 40, 4.88),
('T0008', 'C0008', 10.2, 3.6, 60, 40, 7.56),
('T0009', 'C0009', 6, 6, 60, 40, 6),
('T0010', 'C0010', 7.2, 3.6, 60, 40, 5.76);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `awaltabel`
--
ALTER TABLE `awaltabel`
  ADD PRIMARY KEY (`nilaiAwal`),
  ADD KEY `awaltabel_ibfk_1` (`idGuru`);

--
-- Indexes for table `cftabel`
--
ALTER TABLE `cftabel`
  ADD PRIMARY KEY (`idcf`),
  ADD KEY `cftabel_ibfk_1` (`idGap`),
  ADD KEY `cftabel_ibfk_2` (`idKelas`);

--
-- Indexes for table `gaptabel`
--
ALTER TABLE `gaptabel`
  ADD PRIMARY KEY (`idGap`),
  ADD KEY `gaptabel_ibfk_2` (`nilaiAwal`);

--
-- Indexes for table `gurutabel`
--
ALTER TABLE `gurutabel`
  ADD PRIMARY KEY (`idGuru`);

--
-- Indexes for table `kelastabel`
--
ALTER TABLE `kelastabel`
  ADD PRIMARY KEY (`idKelas`),
  ADD KEY `idGuru` (`idGuru`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `normaltable`
--
ALTER TABLE `normaltable`
  ADD KEY `idGap` (`idGap`);

--
-- Indexes for table `peringkattable`
--
ALTER TABLE `peringkattable`
  ADD KEY `peringkattable_ibfk_1` (`idRank`);

--
-- Indexes for table `ranktabel`
--
ALTER TABLE `ranktabel`
  ADD PRIMARY KEY (`idRank`),
  ADD KEY `ranktabel_ibfk_1` (`idcf`),
  ADD KEY `idTotal` (`idTotal`),
  ADD KEY `idGuru` (`idGuru`);

--
-- Indexes for table `totaltabel`
--
ALTER TABLE `totaltabel`
  ADD PRIMARY KEY (`idTotal`),
  ADD KEY `totaltabel_ibfk_1` (`idcf`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `awaltabel`
--
ALTER TABLE `awaltabel`
  ADD CONSTRAINT `awaltabel_ibfk_1` FOREIGN KEY (`idGuru`) REFERENCES `gurutabel` (`idGuru`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cftabel`
--
ALTER TABLE `cftabel`
  ADD CONSTRAINT `cftabel_ibfk_1` FOREIGN KEY (`idGap`) REFERENCES `gaptabel` (`idGap`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cftabel_ibfk_2` FOREIGN KEY (`idKelas`) REFERENCES `kelastabel` (`idKelas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `gaptabel`
--
ALTER TABLE `gaptabel`
  ADD CONSTRAINT `gaptabel_ibfk_2` FOREIGN KEY (`nilaiAwal`) REFERENCES `awaltabel` (`nilaiAwal`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kelastabel`
--
ALTER TABLE `kelastabel`
  ADD CONSTRAINT `kelastabel_ibfk_1` FOREIGN KEY (`idGuru`) REFERENCES `gurutabel` (`idGuru`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `normaltable`
--
ALTER TABLE `normaltable`
  ADD CONSTRAINT `normaltable_ibfk_1` FOREIGN KEY (`idGap`) REFERENCES `gaptabel` (`idGap`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `peringkattable`
--
ALTER TABLE `peringkattable`
  ADD CONSTRAINT `peringkattable_ibfk_1` FOREIGN KEY (`idRank`) REFERENCES `ranktabel` (`idRank`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `ranktabel`
--
ALTER TABLE `ranktabel`
  ADD CONSTRAINT `ranktabel_ibfk_1` FOREIGN KEY (`idcf`) REFERENCES `cftabel` (`idcf`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `ranktabel_ibfk_2` FOREIGN KEY (`idTotal`) REFERENCES `totaltabel` (`idTotal`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `ranktabel_ibfk_3` FOREIGN KEY (`idGuru`) REFERENCES `gurutabel` (`idGuru`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `totaltabel`
--
ALTER TABLE `totaltabel`
  ADD CONSTRAINT `totaltabel_ibfk_1` FOREIGN KEY (`idcf`) REFERENCES `cftabel` (`idcf`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
