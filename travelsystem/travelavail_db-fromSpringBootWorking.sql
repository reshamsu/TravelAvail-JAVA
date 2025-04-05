-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2025 at 09:04 PM
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
-- Database: `travelavail_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `booking_id` bigint(20) NOT NULL,
  `booking_type` enum('CAR_RENTAL','FLIGHT','HOTEL','NOT_SET') DEFAULT NULL,
  `booking_date` datetime(6) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `car_rental_id` bigint(20) DEFAULT NULL,
  `flight_id` bigint(20) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `mood_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `car_rental_bookings`
--

CREATE TABLE `car_rental_bookings` (
  `car_rental_id` bigint(20) NOT NULL,
  `car_model` varchar(255) DEFAULT NULL,
  `drop_location` varchar(255) DEFAULT NULL,
  `dropoff_date` datetime(6) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `passengers` int(11) NOT NULL,
  `pickup_date` datetime(6) DEFAULT NULL,
  `pickup_location` varchar(255) DEFAULT NULL,
  `rental_days` int(11) NOT NULL,
  `booking_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `flight_bookings`
--

CREATE TABLE `flight_bookings` (
  `flight_id` bigint(20) NOT NULL,
  `airline_class` varchar(255) DEFAULT NULL,
  `airline_name` varchar(255) DEFAULT NULL,
  `arrival_airport` varchar(255) DEFAULT NULL,
  `departure_airport` varchar(255) DEFAULT NULL,
  `departure_date` datetime(6) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `passengers` int(11) NOT NULL,
  `return_date` datetime(6) DEFAULT NULL,
  `booking_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hotel_bookings`
--

CREATE TABLE `hotel_bookings` (
  `hotel_id` bigint(20) NOT NULL,
  `checkin_date` datetime(6) DEFAULT NULL,
  `checkout_date` datetime(6) DEFAULT NULL,
  `guests` int(11) NOT NULL,
  `hotel_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `located_city` varchar(255) DEFAULT NULL,
  `rooms` int(11) NOT NULL,
  `booking_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `moods`
--

CREATE TABLE `moods` (
  `mood_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `mood_name` enum('ADVENTURE','CHILL_RELAXATION','CULTURE_HISTORY','SOUL_ESCAPE') DEFAULT NULL,
  `booking_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `notification_id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `status` enum('NEW','READ') DEFAULT NULL,
  `booking_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` bigint(20) NOT NULL,
  `payment_method` enum('BANK_TRANSFER','CREDIT_CARD') DEFAULT NULL,
  `status` enum('COMPLETED','FAILED','PENDING') DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  `booking_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','TRAVELER') DEFAULT NULL,
  `status` enum('APPROVED','DEFAULT','PENDING','REJECTED') DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `firstname`, `lastname`, `email`, `password`, `role`, `status`, `created_at`, `image_url`) VALUES
(1, 'Demo User', 'Demo', 'User', 'demouser@gmail.com', '$2a$10$jDom9CGLHCE6zmMldHLprOfeiJdwjdS0dlAWAHecSxAwRavQamR5C', 'TRAVELER', 'PENDING', '2025-04-06 00:06:58.000000', NULL),
(2, 'TA Admin', 'Ttravel', 'Admin', 'admin@travelavail.com', '$2a$10$jFF9a045Kct5Muy9x0QptuzxfMEbw9jSPEKAV1/4HC/n0z1triwcO', 'TRAVELER', 'PENDING', '2025-04-06 00:21:51.000000', NULL),
(3, 'John Doe', 'John', 'Doe', 'johndoe@gmail.com', '$2a$10$4O0ODBWXacGe9OwsWxb5M.zDHYWr4vhwUT4pBXC7dD/NvxLlmQXl6', 'TRAVELER', 'PENDING', '2025-04-06 00:27:10.000000', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `FK1oreufpl2kbk46jcbv0fkdfgt` (`car_rental_id`),
  ADD KEY `FKk4c32tis0t1ld43f0okjx2woo` (`flight_id`),
  ADD KEY `FKff9ts8hdnvg2x1a7rtljl9ta0` (`hotel_id`),
  ADD KEY `FKbj2rm1k66aj6xm3g9t6dfb1rj` (`mood_id`),
  ADD KEY `FKeyog2oic85xg7hsu2je2lx3s6` (`user_id`);

--
-- Indexes for table `car_rental_bookings`
--
ALTER TABLE `car_rental_bookings`
  ADD PRIMARY KEY (`car_rental_id`),
  ADD KEY `FKb8xbwa7b57h7tqcncx150itw0` (`booking_id`);

--
-- Indexes for table `flight_bookings`
--
ALTER TABLE `flight_bookings`
  ADD PRIMARY KEY (`flight_id`),
  ADD KEY `FKj675sy24doa091qwj5971gar8` (`booking_id`);

--
-- Indexes for table `hotel_bookings`
--
ALTER TABLE `hotel_bookings`
  ADD PRIMARY KEY (`hotel_id`),
  ADD KEY `FK1ari5wjhhhrq5qlrl9s5euhmv` (`booking_id`);

--
-- Indexes for table `moods`
--
ALTER TABLE `moods`
  ADD PRIMARY KEY (`mood_id`),
  ADD KEY `FKs0h52l6wdtho4rqch3pokg7f6` (`booking_id`),
  ADD KEY `FK5ep80wqsx06cvyumhs8fopms0` (`user_id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`notification_id`),
  ADD KEY `FK87r43mlyr9nnth3xbf0li1ij3` (`booking_id`),
  ADD KEY `FK9y21adhxn0ayjhfocscqox7bh` (`user_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `FKc52o2b1jkxttngufqp3t7jr3h` (`booking_id`),
  ADD KEY `FKj94hgy9v5fw1munb90tar2eje` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `booking_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `car_rental_bookings`
--
ALTER TABLE `car_rental_bookings`
  MODIFY `car_rental_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `flight_bookings`
--
ALTER TABLE `flight_bookings`
  MODIFY `flight_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hotel_bookings`
--
ALTER TABLE `hotel_bookings`
  MODIFY `hotel_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `moods`
--
ALTER TABLE `moods`
  MODIFY `mood_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `notification_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `FK1oreufpl2kbk46jcbv0fkdfgt` FOREIGN KEY (`car_rental_id`) REFERENCES `car_rental_bookings` (`car_rental_id`),
  ADD CONSTRAINT `FKbj2rm1k66aj6xm3g9t6dfb1rj` FOREIGN KEY (`mood_id`) REFERENCES `moods` (`mood_id`),
  ADD CONSTRAINT `FKeyog2oic85xg7hsu2je2lx3s6` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKff9ts8hdnvg2x1a7rtljl9ta0` FOREIGN KEY (`hotel_id`) REFERENCES `hotel_bookings` (`hotel_id`),
  ADD CONSTRAINT `FKk4c32tis0t1ld43f0okjx2woo` FOREIGN KEY (`flight_id`) REFERENCES `flight_bookings` (`flight_id`);

--
-- Constraints for table `car_rental_bookings`
--
ALTER TABLE `car_rental_bookings`
  ADD CONSTRAINT `FKb8xbwa7b57h7tqcncx150itw0` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`);

--
-- Constraints for table `flight_bookings`
--
ALTER TABLE `flight_bookings`
  ADD CONSTRAINT `FKj675sy24doa091qwj5971gar8` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`);

--
-- Constraints for table `hotel_bookings`
--
ALTER TABLE `hotel_bookings`
  ADD CONSTRAINT `FK1ari5wjhhhrq5qlrl9s5euhmv` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`);

--
-- Constraints for table `moods`
--
ALTER TABLE `moods`
  ADD CONSTRAINT `FK5ep80wqsx06cvyumhs8fopms0` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKs0h52l6wdtho4rqch3pokg7f6` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`);

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `FK87r43mlyr9nnth3xbf0li1ij3` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`),
  ADD CONSTRAINT `FK9y21adhxn0ayjhfocscqox7bh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `FKc52o2b1jkxttngufqp3t7jr3h` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`),
  ADD CONSTRAINT `FKj94hgy9v5fw1munb90tar2eje` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
