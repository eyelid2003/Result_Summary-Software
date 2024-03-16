-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2023 at 05:53 AM
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
-- Database: `final`
--

CREATE DATABASE `final`;
use `final`;
-- --------------------------------------------------------

--
-- Table structure for table `general`
--


CREATE TABLE `general` (
  `sem` varchar(100) NOT NULL,
  `stuaddgirl` varchar(100) NOT NULL,
  `stuaddboy` varchar(100) NOT NULL,
  `pass1agirl` varchar(100) NOT NULL,
  `pass1aboy` varchar(100) NOT NULL,
  `passdisgirl` varchar(100) NOT NULL,
  `passdisboy` varchar(100) NOT NULL,
  `pass1divgirl` varchar(100) NOT NULL,
  `pass1divboy` varchar(100) NOT NULL,
  `pass2divgirl` varchar(100) NOT NULL,
  `pass2divboy` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `obc`
--

CREATE TABLE `obc` (
  `sem` varchar(100) NOT NULL,
  `stuaddgirl` varchar(100) NOT NULL,
  `stuaddboy` varchar(100) NOT NULL,
  `pass1agirl` varchar(100) NOT NULL,
  `pass1aboy` varchar(100) NOT NULL,
  `passdisgirl` varchar(100) NOT NULL,
  `passdisboy` varchar(100) NOT NULL,
  `pass1divgirl` varchar(100) NOT NULL,
  `pass1divboy` varchar(100) NOT NULL,
  `pass2divgirl` varchar(100) NOT NULL,
  `pass2divboy` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sc`
--

CREATE TABLE `sc` (
  `sem` varchar(100) NOT NULL,
  `stuaddgirl` varchar(100) NOT NULL,
  `stuaddboy` varchar(100) NOT NULL,
  `pass1agirl` varchar(100) NOT NULL,
  `pass1aboy` varchar(100) NOT NULL,
  `passdisgirl` varchar(100) NOT NULL,
  `passdisboy` varchar(100) NOT NULL,
  `pass1divgirl` varchar(100) NOT NULL,
  `pass1divboy` varchar(100) NOT NULL,
  `pass2divgirl` varchar(100) NOT NULL,
  `pass2divboy` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `st`
--

CREATE TABLE `st` (
  `sem` varchar(100) NOT NULL,
  `stuaddgirl` varchar(100) NOT NULL,
  `stuaddboy` varchar(100) NOT NULL,
  `pass1agirl` varchar(100) NOT NULL,
  `pass1aboy` varchar(100) NOT NULL,
  `passdisgirl` varchar(100) NOT NULL,
  `passdisboy` varchar(100) NOT NULL,
  `pass1divgirl` varchar(100) NOT NULL,
  `pass1divboy` varchar(100) NOT NULL,
  `pass2divgirl` varchar(100) NOT NULL,
  `pass2divboy` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sub`
--

CREATE TABLE `sub` (
  `subcode` varchar(100) NOT NULL,
  `roll` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `cast` varchar(100) NOT NULL,
  `gen` varchar(100) NOT NULL,
  `grade` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
