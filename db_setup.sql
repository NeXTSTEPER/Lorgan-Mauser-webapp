

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lorgan_mauser`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `USER_NAME` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `ACTIVE` bit(1) NOT NULL,
  `ENCRYTED_PASSWORD` varchar(128) COLLATE latin1_general_ci NOT NULL,
  `USER_ROLE` varchar(20) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`USER_NAME`, `ACTIVE`, `ENCRYTED_PASSWORD`, `USER_ROLE`) VALUES
('User', b'1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE'),
('Manager', b'1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `ID` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `AMOUNT` double NOT NULL,
  `CUSTOMER_ADDRESS` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `CUSTOMER_EMAIL` varchar(128) COLLATE latin1_general_ci NOT NULL,
  `CUSTOMER_NAME` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `CUSTOMER_PHONE` varchar(128) COLLATE latin1_general_ci NOT NULL,
  `ORDER_DATE` datetime NOT NULL,
  `ORDER_NUM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;



-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `ID` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `AMOUNT` double NOT NULL,
  `PRICE` double NOT NULL,
  `QUANITY` int(11) NOT NULL,
  `ORDER_ID` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `PRODUCT_ID` varchar(20) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;



-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `CODE` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `IMAGE` longblob,
  `NAME` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `PRICE` double NOT NULL,
  `CREATE_DATE` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;


--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`USER_NAME`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ORDER_UK` (`ORDER_NUM`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ORDER_DETAIL_ORD_FK` (`ORDER_ID`),
  ADD KEY `ORDER_DETAIL_PROD_FK` (`PRODUCT_ID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`CODE`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `ORDER_DETAIL_ORD_FK` FOREIGN KEY (`ORDER_ID`) REFERENCES `orders` (`ID`),
  ADD CONSTRAINT `ORDER_DETAIL_PROD_FK` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `products` (`CODE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
