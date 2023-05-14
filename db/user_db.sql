-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2023 at 03:30 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `delivery`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_db`
--

CREATE TABLE `user_db` (
  `f_name` varchar(50) NOT NULL,
  `l_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `pass_word` varchar(50) NOT NULL,
  `con_pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_db`
--

INSERT INTO `user_db` (`f_name`, `l_name`, `email`, `user_name`, `pass_word`, `con_pass`) VALUES
('Aeron', 'Villafuerte', 'acegeverola@gmail.com', 'acegeverola', 'indang', 'indang'),
('Kyle', 'asd', 'klesdf', 'kyle@gmail.com', 'kylee', 'kylee'),
('Kryztel', 'Camello', 'kryztelcamello@gmail.com', 'kryztelcamello', 'zeze1', 'zeze1'),
('', '', '', 'shano@gmail.com', 'shnoasff', 'shnoasff'),
('', '', '', 'buangko@gmail.com', 'buangko', 'buangko'),
('Aeron', 'Geverola', 'aerongeverola@gmail.com', 'aerong', 'zxcv', 'zxcv'),
('aeron', 'geverola', 'acegeverola@gmail.com', 'aeronvg', 'indang', 'indang'),
('Judy', 'Tapere', 'judytapere259@gmail.com', 'juday', 'judayy', 'judayy'),
('kyle', 'kyle', 'kyle@gmail.com', 'kyle', 'kyle', 'kyle'),
('Mike', 'mike', 'mike', 'mike', 'mike', 'mike');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
