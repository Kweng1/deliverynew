-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2023 at 11:17 AM
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
-- Table structure for table `attendance_form`
--

CREATE TABLE `attendance_form` (
  `af_name` varchar(50) NOT NULL,
  `al_name` varchar(50) NOT NULL,
  `a_email` varchar(100) NOT NULL,
  `a_time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer_order`
--

CREATE TABLE `customer_order` (
  `o_id` int(11) NOT NULL,
  `c_id` int(50) NOT NULL,
  `p_id` int(50) NOT NULL,
  `cu_quant` int(200) NOT NULL,
  `cu_price` int(200) NOT NULL,
  `cu_tp` int(200) NOT NULL,
  `cu_status` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_order`
--

INSERT INTO `customer_order` (`o_id`, `c_id`, `p_id`, `cu_quant`, `cu_price`, `cu_tp`, `cu_status`) VALUES
(14, 11, 5, 3, 300, 900, 'PENDING'),
(20, 15, 8, 5, 500, 2500, 'DELIVERED'),
(21, 19, 8, 1, 500, 500, 'PENDING'),
(22, 12, 8, 2, 500, 1000, 'PENDING'),
(23, 16, 6, 2, 200, 400, 'PENDING'),
(24, 13, 6, 1, 200, 200, 'PENDING'),
(25, 13, 9, 2, 12, 24, 'PENDING'),
(26, 23, 7, 2, 300, 600, 'PENDING'),
(27, 23, 8, 1, 500, 500, 'PENDING'),
(28, 24, 7, 1, 300, 300, 'PENDING');

-- --------------------------------------------------------

--
-- Table structure for table `customer_tbl`
--

CREATE TABLE `customer_tbl` (
  `c_id` int(20) NOT NULL,
  `c_name` varchar(50) NOT NULL,
  `c_add` varchar(50) NOT NULL,
  `c_con` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_tbl`
--

INSERT INTO `customer_tbl` (`c_id`, `c_name`, `c_add`, `c_con`) VALUES
(11, 'rin', 'talisay', '09297830328'),
(12, 'ran', 'tanke', '09064633163'),
(13, 'ren', 'mingla', '09325953301'),
(15, 'ren', 'tanke', '09064633163'),
(16, 'kyle', 'minglanilla', '09297830328'),
(17, 'kenneth', 'tanke', '09064633163'),
(18, 'mike', 'poblacion', '09325953301'),
(19, 'ernest', 'cansojong', '09064633163'),
(20, 'tan', 'Talisay', '09064633163'),
(21, 'TEST', 'TEST', '123546'),
(22, 'har', 'ila', '098653'),
(23, 'indang', 'argao', '0987653'),
(24, 'aicee', 'argao', '09876543');

-- --------------------------------------------------------

--
-- Table structure for table `product_tbl`
--

CREATE TABLE `product_tbl` (
  `p_id` int(200) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `p_price` int(50) NOT NULL,
  `img_pc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_tbl`
--

INSERT INTO `product_tbl` (`p_id`, `p_name`, `p_price`, `img_pc`) VALUES
(5, 'hawaiian', 300, 'src/image/des.jpg'),
(6, 'cheese', 200, 'src/image/cheese.jpg'),
(7, 'burnt', 300, 'src/image/burnt.jpg'),
(8, 'newyork', 500, 'src/image/nypizza.jpg'),
(9, 'TEST', 12, 'src/image/abin.png');

-- --------------------------------------------------------

--
-- Table structure for table `user_db`
--

CREATE TABLE `user_db` (
  `f_name` varchar(50) NOT NULL,
  `l_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `pass_word` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_db`
--

INSERT INTO `user_db` (`f_name`, `l_name`, `email`, `user_name`, `pass_word`) VALUES
('Aeron', 'Villafuerte', 'acegeverola@gmail.com', 'acegeverola', 'indang'),
('Kyle', 'asd', 'klesdf', 'kyle@gmail.com', 'kylee'),
('Kryztel', 'Camello', 'kryztelcamello@gmail.com', 'kryztelcamello', 'zeze1'),
('', '', '', 'shano@gmail.com', 'shnoasff'),
('', '', '', 'buangko@gmail.com', 'buangko'),
('Aeron', 'Geverola', 'aerongeverola@gmail.com', 'aerong', 'zxcv'),
('aeron', 'geverola', 'acegeverola@gmail.com', 'aeronvg', 'indang'),
('kyle', 'isidoro', 'isidorokyle123@gmail.com', 'kyle', 'kyle'),
('mike', 'mike', 'mike@mike.com', 'mike', 'mike'),
('john', 'john', 'john123@gmail.com', 'john', 'john'),
('ernest', 'ernest', 'ernest@gmail.com', 'ernest', 'ernest'),
('ryan', 'ryan', 'ryan@gmail.com', 'ryan', 'ryan1'),
('kenneth', 'isidoro', 'kenneth@gmail.com', 'kenneth', 'kenneth1'),
('ernest', 'ernest', 'ernest', 'erning', '61a3c22a310f6b6328941b54bab34d646e3ccd15a67504c7403ddef7d80f0e43'),
('botoy', 'botoy', 'botoy', 'botoy', 'abf466b62a6705d4ef4a5616b88ed7ca3b1b6959c4638330e5f7c4e008d58300'),
('iro', 'iro', 'iro', 'iro', 'iro1'),
('boy', 'boy', 'boy', 'boy', 'boy2'),
('init', 'init', 'init', 'init', 'init1'),
('ering', 'ering', 'ering', 'ering', 'ering1'),
('lamaw', 'lamaw', 'lamaw', 'lamaw', 'lamaw1'),
('ken', 'ken', 'ken', 'ken', 'ken1'),
('aeron', 'aeron', 'aeron', 'aeron', 'aeron1'),
('ero', 'ero', 'ero', 'ero', '89672feebddaf95ca85357e2d2ea305e688407c2c74cf2bd124d765eb83d7858'),
('', '', '', '', ''),
('dog', 'dog', 'dog', 'dog', 'dog'),
('ikit', 'ikit', 'ikit', 'ikit', '8088d1bb9a6ec1639f1ea9266657a052cd60de9dfec0af09fe52b5094e5cb92b'),
('ern', 'ern', 'ern', 'ern', '981bf06968595931d093e5c34a521c907c17cc192880d3451eb21e4cae406003'),
('rin', 'rin', 'rin', 'rin', 'df0142fe6afa9f3055afbfde89eb899f1bdcfadad4911c93efeb1a1f568d9858'),
('nin', 'nin', 'nin', 'nin', '915a7d6479eff6a63bab5ce232d32d5710e7890e6b312a8612753bded7ebbdf0'),
('ran', 'ran', 'ran', 'ran', '591ca0fb7d8f8847e6d5e7fa2c35d654be2babde6665f4cdb672c88529de51c6'),
('TEST', 'TEST', 'TEST', 'TEST', '94ee059335e587e501cc4bf90613e0814f00a7b08bc7c648fd865a2af6a22cc2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_order`
--
ALTER TABLE `customer_order`
  ADD PRIMARY KEY (`o_id`),
  ADD KEY `customer_order` (`c_id`),
  ADD KEY `p_id` (`p_id`);

--
-- Indexes for table `customer_tbl`
--
ALTER TABLE `customer_tbl`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `product_tbl`
--
ALTER TABLE `product_tbl`
  ADD PRIMARY KEY (`p_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_order`
--
ALTER TABLE `customer_order`
  MODIFY `o_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `customer_tbl`
--
ALTER TABLE `customer_tbl`
  MODIFY `c_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `product_tbl`
--
ALTER TABLE `product_tbl`
  MODIFY `p_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_order`
--
ALTER TABLE `customer_order`
  ADD CONSTRAINT `customer_order` FOREIGN KEY (`c_id`) REFERENCES `customer_tbl` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `customer_order_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `product_tbl` (`p_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
