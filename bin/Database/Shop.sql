-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 14, 2017 at 09:25 AM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `displayname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `password`, `displayname`, `role`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 1),
('nvan', 'e10adc3949ba59abbe56e057f20f883e', 'Nguyễn Văn An', 0),
('tmhieu', 'f1ce92f87aef5c1a6497f41da6f1b8de', 'Trương Minh Hiếu', 0);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `method` int(1) NOT NULL COMMENT 'Payment methods',
  `checkin` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date checkin order ',
  `checkout` datetime DEFAULT NULL COMMENT 'Date chekout order',
  `total_price` double NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT 'Payment status'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bill_id`, `id_customer`, `method`, `checkin`, `checkout`, `total_price`, `status`) VALUES
(6, 9, 1, '2017-11-13 23:50:26', NULL, 4500000, 0),
(7, 10, 1, '2017-11-13 23:51:11', NULL, 45000000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bill_info`
--

CREATE TABLE `bill_info` (
  `bill_info_id` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `id_bill` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bill_info`
--

INSERT INTO `bill_info` (`bill_info_id`, `id_product`, `id_bill`, `amount`) VALUES
(1, 3, 6, 1),
(2, 10, 7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Samsung'),
(2, 'Apple'),
(4, 'Asus'),
(7, 'Oppo'),
(8, 'Sony');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `customer_phonenumber` varchar(13) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_name`, `customer_address`, `customer_phonenumber`) VALUES
(9, 'Trương Minh Hiếu', 'An giang', '01689777911'),
(10, 'Trương Thái Trung', 'An giang', '0907049783');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `product_price` double NOT NULL,
  `product_description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `product_image` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_price`, `product_description`, `product_image`, `amount`, `category_id`) VALUES
(1, 'Galaxy J7', 5700000, 'Galaxy J7', 'samsung-galaxy-j7-prime-9-300x300.jpg', 0, 1),
(2, 'IPHONE 6 32 GB', 22000000, 'IPHONE 6 32 GB', 'iphone-6s-32gb-400x450.png', 190, 2),
(3, 'Galaxy A5 (2018)', 4500000, 'Galaxy A5 (2018)', 'galaxy-a5-2017-3-400x400.png', 55, 1),
(5, 'Oppo F3', 5000000, 'Oppo F3', 'oppo-f3-plus-vang-dong-1-300x300.png', 50, 7),
(6, 'Oppo F1s', 4900000, 'Oppo F1s', 'oppo-f1s-2017-daidiencopy-300x300.jpg', 30, 7),
(7, 'Galaxy J3 pro', 2300000, 'Galaxy J3 pro', 'samsung-galaxy-j3-2017-2-400x460.png', 20, 1),
(8, 'Galaxy S8', 19000000, 'Galaxy S8', 'samsung-galaxy-s8-plus-tim-khoi-400-400x460.png', 40, 1),
(9, 'Galaxy Note 8', 2500000, 'Galaxy Note 8', 'samsung-galaxy-note8-1-400x460.png', 30, 1),
(10, 'Galaxy note 5', 15000000, 'Galaxy note 5', 'samsung-galaxy-note-5-2-400x460.png', 197, 1),
(11, 'Iphone 8 plus', 18000000, 'Iphone 8 plus', 'iphone-8-plus-256gb2-300x300.jpg', 100, 2),
(12, 'IPHONE 7 256GB', 19000000, 'IPHONE 7 256GB', 'iphone-7-256gb-5-400x460.png', 100, 2),
(13, 'Xperia XZ Dual', 7000000, 'Xperia XZ Dual', 'sony-xperia-xz-1-400x460.png', 30, 8),
(14, 'Xperia XZS', 4950000, 'Xperia XZS', 'sony-xperia-xzs-16-300x300.jpg', 150, 8),
(15, 'Zenfone 2 Go', 1900000, 'Zenfone 2 Go', 'asus-zenfone-2-go-zb500kg-400-400x460.png', 70, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_id`),
  ADD KEY `fk_idCustomer` (`id_customer`);

--
-- Indexes for table `bill_info`
--
ALTER TABLE `bill_info`
  ADD PRIMARY KEY (`bill_info_id`),
  ADD KEY `fk_idBill` (`id_bill`) USING BTREE,
  ADD KEY `fk_idProduct` (`id_product`) USING BTREE;

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `category_id` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `bill_info`
--
ALTER TABLE `bill_info`
  MODIFY `bill_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `bill_info`
--
ALTER TABLE `bill_info`
  ADD CONSTRAINT `bill_info_ibfk_1` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`bill_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `bill_info_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
