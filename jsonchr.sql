-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 12, 2016 at 10:35 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jsonchr`
--

-- --------------------------------------------------------

--
-- Table structure for table `lcf`
--

CREATE TABLE `lcf` (
  `user_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `time` varchar(200) NOT NULL,
  `date` varchar(200) NOT NULL,
  `ford` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lcf`
--

INSERT INTO `lcf` (`user_id`, `name`, `time`, `date`, `ford`, `content`, `image`) VALUES
(2, 'Workers Meeting', '12pm', '12/05/216', 'workers', 'make sure you are there cos its gonna be full of praise', '78223.jpg'),
(3, 'Workers Meeting', '12pmd', '12/05/216', 'workers', 'make sure you are there cos its gonna be full of praise', '8743.jpg'),
(4, 'Workers Meeting', '12pm', '12/05/216', 'workers', 'make sure you are there cos its gonna be full of praise', '78223.jpg'),
(6, 'All Workers Summit', '8PM-8AM', '20/16/2014', 'workers only', 'Pls let us not forget to come with all mony in other to make our request', '276481.jpg'),
(7, 'Workers meeting', 'd usual', 'd usual', 'Workers only', 'workers are to meet this saturday', '107613.jpg'),
(18, 'josh', 'josh', '1/16/2014', 'all ministers', 'josh', 'jhjh'),
(15, 'joj', 'lkl', 'klk', 'klk', 'mim', '51090.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lcf`
--
ALTER TABLE `lcf`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lcf`
--
ALTER TABLE `lcf`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
