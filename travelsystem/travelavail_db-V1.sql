-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2025 at 09:00 PM
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
  `booking_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `booking_type` enum('FLIGHT','HOTEL','CAR_RENTAL') NOT NULL,
  `status` enum('UPCOMING','COMPLETED','CANCELLED','RESCHEDULED') NOT NULL DEFAULT 'UPCOMING',
  `booking_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `total_amount` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`booking_id`, `user_id`, `booking_type`, `status`, `booking_date`, `total_amount`) VALUES
(101, 1, 'FLIGHT', 'UPCOMING', '2023-10-25 09:00:00', 450.00),
(102, 1, 'FLIGHT', 'COMPLETED', '2023-09-15 04:50:00', 620.00),
(103, 2, 'FLIGHT', 'CANCELLED', '2023-10-10 03:15:00', 380.00),
(104, 3, 'FLIGHT', 'RESCHEDULED', '2023-10-18 10:50:00', 725.00),
(105, 4, 'FLIGHT', 'UPCOMING', '2023-11-05 03:45:00', 890.00),
(106, 5, 'FLIGHT', 'COMPLETED', '2023-08-22 06:00:00', 540.00),
(201, 1, 'HOTEL', 'UPCOMING', '2023-10-22 03:45:00', 1200.00),
(202, 2, 'HOTEL', 'COMPLETED', '2023-09-10 08:50:00', 850.00),
(203, 3, 'HOTEL', 'CANCELLED', '2023-10-05 06:00:00', 650.00),
(204, 1, 'HOTEL', 'RESCHEDULED', '2023-10-15 11:15:00', 980.00),
(205, 4, 'HOTEL', 'UPCOMING', '2023-11-01 04:30:00', 2200.00),
(206, 5, 'HOTEL', 'COMPLETED', '2023-08-18 07:45:00', 720.00),
(301, 1, 'CAR_RENTAL', 'UPCOMING', '2023-10-20 05:50:00', 275.50),
(302, 2, 'CAR_RENTAL', 'COMPLETED', '2023-09-05 04:45:00', 420.00),
(303, 3, 'CAR_RENTAL', 'CANCELLED', '2023-10-12 09:00:00', 180.00),
(304, 4, 'CAR_RENTAL', 'RESCHEDULED', '2023-10-18 04:15:00', 350.00),
(305, 5, 'CAR_RENTAL', 'UPCOMING', '2023-11-02 07:50:00', 195.00),
(306, 1, 'CAR_RENTAL', 'COMPLETED', '2023-08-28 10:40:00', 630.00);

-- --------------------------------------------------------

--
-- Table structure for table `carrental_bookings`
--

CREATE TABLE `carrental_bookings` (
  `booking_id` int(11) NOT NULL,
  `car_model` varchar(100) NOT NULL,
  `pickup_location` varchar(100) NOT NULL,
  `dropoff_location` varchar(100) DEFAULT NULL,
  `pickup_date` datetime NOT NULL,
  `dropoff_date` datetime NOT NULL,
  `rental_days` int(11) NOT NULL,
  `passengers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `carrental_bookings`
--

INSERT INTO `carrental_bookings` (`booking_id`, `car_model`, `pickup_location`, `dropoff_location`, `pickup_date`, `dropoff_date`, `rental_days`, `passengers`) VALUES
(301, 'Toyota Corolla', 'LAX Airport', 'LAX Airport', '2023-11-15 10:00:00', '2023-11-20 18:00:00', 5, 4),
(302, 'Ford Explorer', 'MIA Airport', 'Downtown Miami', '2023-09-10 09:00:00', '2023-09-15 17:00:00', 5, 2),
(303, 'Honda Odyssey', 'Orlando International', 'Orlando International', '2023-10-25 11:00:00', '2023-10-27 20:00:00', 2, 2),
(304, 'Mercedes-Benz E-Class', 'JFK Airport', 'Boston Downtown', '2023-11-22 14:00:00', '2023-11-24 12:00:00', 2, 3),
(305, 'Ford Mustang Convertible', 'Las Vegas Airport', 'Las Vegas Airport', '2023-11-10 12:00:00', '2023-11-12 15:00:00', 2, 1),
(306, 'Tesla Model 3', 'SFO Airport', 'SFO Airport', '2023-08-30 09:00:00', '2023-09-05 17:00:00', 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `flight_bookings`
--

CREATE TABLE `flight_bookings` (
  `booking_id` int(11) NOT NULL,
  `airline` varchar(100) NOT NULL,
  `flight_number` varchar(20) NOT NULL,
  `departure_airport` varchar(10) NOT NULL,
  `arrival_airport` varchar(10) NOT NULL,
  `departure_date` datetime NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `passengers` int(11) NOT NULL DEFAULT 1,
  `class` enum('ECONOMY','PREMIUM_ECONOMY','BUSINESS','FIRST') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight_bookings`
--

INSERT INTO `flight_bookings` (`booking_id`, `airline`, `flight_number`, `departure_airport`, `arrival_airport`, `departure_date`, `return_date`, `passengers`, `class`) VALUES
(101, 'Delta Airlines', 'DL1432', 'JFK', 'LAX', '2023-11-15 08:00:00', NULL, 1, 'ECONOMY'),
(102, 'Emirates', 'EK202', 'DXB', 'JFK', '2023-09-20 22:15:00', '2023-10-05 08:40:00', 2, 'BUSINESS'),
(103, 'United Airlines', 'UA891', 'ORD', 'SFO', '2023-10-25 06:30:00', NULL, 1, 'PREMIUM_ECONOMY'),
(104, 'Southwest', 'WN4321', 'DEN', 'MCO', '2023-11-10 11:20:00', '2023-11-17 18:45:00', 4, 'ECONOMY'),
(105, 'American Airlines', 'AA721', 'DFW', 'LGA', '2023-11-12 16:15:00', '2023-11-13 09:30:00', 1, 'FIRST'),
(106, 'Qatar Airways', 'QR115', 'CDG', 'DOH', '2023-08-25 13:50:00', '2023-09-10 07:25:00', 2, 'BUSINESS');

-- --------------------------------------------------------

--
-- Table structure for table `hotel_bookings`
--

CREATE TABLE `hotel_bookings` (
  `booking_id` int(11) NOT NULL,
  `hotel_name` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date NOT NULL,
  `rooms` int(11) NOT NULL DEFAULT 1,
  `room_type` varchar(50) NOT NULL,
  `guests` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel_bookings`
--

INSERT INTO `hotel_bookings` (`booking_id`, `hotel_name`, `city`, `check_in_date`, `check_out_date`, `rooms`, `room_type`, `guests`) VALUES
(201, 'Hilton Times Square', 'New York', '2023-11-10', '2023-11-15', 1, 'DELUXE_KING', 1),
(202, 'Marriott Waikiki Beach', 'Honolulu', '2023-09-15', '2023-09-20', 2, 'OCEAN_VIEW_SUITE', 4),
(203, 'The Ritz-Carlton', 'Chicago', '2023-10-20', '2023-10-22', 1, 'EXECUTIVE_SUITE', 2),
(204, 'Holiday Inn Express', 'Dallas', '2023-11-05', '2023-11-08', 1, 'STANDARD_QUEEN', 1),
(205, 'Four Seasons Bora Bora', 'Bora Bora', '2023-12-01', '2023-12-10', 1, 'OVERWATER_VILLA', 2),
(206, 'Sheraton Grand', 'Seattle', '2023-08-20', '2023-08-25', 3, 'DOUBLE_DOUBLE', 6);

-- --------------------------------------------------------

--
-- Table structure for table `moods`
--

CREATE TABLE `moods` (
  `mood_id` int(11) NOT NULL,
  `mood_name` enum('ADVENTURE','CHILL & RELAXATION','CULTURE & HISTORY','SOUL ESCAPE') NOT NULL,
  `destination` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `moods`
--

INSERT INTO `moods` (`mood_id`, `mood_name`, `destination`, `description`) VALUES
(1, 'ADVENTURE', 'Queenstown, New Zealand', 'Skydiving, bungee jumping, and jet boating in the adventure capital of the world.'),
(2, 'ADVENTURE', 'Great Barrier Reef, Australia', 'Scuba diving and snorkeling with vibrant marine life'),
(3, 'CHILL & RELAXATION', 'Male, Maldives', 'Luxury island resorts, white sandy beaches, and tranquil turquoise waters.'),
(4, 'CHILL & RELAXATION', 'Santorini, Greece', 'White-washed houses, breathtaking Aegean views, and calm island vibes.'),
(5, 'CHILL & RELAXATION', 'Kyoto, Japan', 'Tranquil temples, Zen gardens, and traditional tea houses.'),
(6, 'CHILL & RELAXATION', 'Banff, Canada', 'Peaceful lakes, scenic hiking, and relaxing hot springs.'),
(7, 'CULTURE & HISTORY', 'Rome, Italy', 'The Colosseum, Vatican City, and ancient Roman ruins.'),
(8, 'CULTURE & HISTORY', 'Kyoto, Japan', 'Traditional tea houses, temples, and samurai history.'),
(9, 'CULTURE & HISTORY', 'Beijing, China', 'The Great Wall, Forbidden City, and Summer Palace.'),
(10, 'CULTURE & HISTORY', 'London, England', 'British Museum, Tower of London, and Westminster Abbey'),
(11, 'SOUL ESCAPE', 'Shirakawa-go, Japan', 'Tranquil thatched-roof villages and a deep connection to nature.'),
(12, 'SOUL ESCAPE', 'Stonehenge, England', 'A prehistoric mystery with spiritual significance.'),
(13, 'SOUL ESCAPE', 'The Maldives', 'Overwater villas, infinity pools, and ultimate seclusion.'),
(14, 'SOUL ESCAPE', 'Jeju Island, South Korea', 'Volcanic landscapes, waterfalls, and temple retreats.'),
(15, 'ADVENTURE', 'Ella, Sri Lanka', 'Hike Ella Rock, Nine Arches Bridge, Little Adam\'s Peak, Scenic Train Ride'),
(16, 'ADVENTURE', 'Arugam Bay, Sri Lanka', 'Surfing, whale watching, lagoon safaris'),
(17, 'CULTURE & HISTORY', 'Sigiriya, Sri Lanka', 'Climb the Lion’s Rock, Explore the Frescoes, Water Gardens');

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `notification_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `booking_id` int(11) DEFAULT NULL,
  `message` text NOT NULL,
  `status` enum('Unread','Read') DEFAULT 'Unread',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `payment_method` enum('CARD','BANK_TRANSFER') NOT NULL,
  `payment_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` enum('PENDING','COMPLETED','FAILED','REFUNDED') NOT NULL DEFAULT 'PENDING',
  `transaction_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `booking_id`, `user_id`, `amount`, `payment_method`, `payment_date`, `status`, `transaction_id`) VALUES
(1, 101, 2, 450.00, 'BANK_TRANSFER', '2023-10-25 09:02:00', 'COMPLETED', 'PAY_123456789'),
(2, 201, 1, 1200.00, 'CARD', '2023-10-22 03:47:00', 'COMPLETED', 'PAY_987654321'),
(3, 301, 3, 275.50, 'CARD', '2023-10-20 05:52:00', 'COMPLETED', 'PAY_192837465'),
(4, 102, 2, 620.00, 'CARD', '2023-09-15 04:52:00', 'COMPLETED', 'PAY_564738291'),
(5, 202, 5, 850.00, 'BANK_TRANSFER', '2023-09-10 08:55:00', 'COMPLETED', 'PAY_918273645'),
(6, 302, 4, 420.00, 'BANK_TRANSFER', '2023-09-05 04:48:00', 'COMPLETED', 'PAY_657483920');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','TRAVELER') DEFAULT NULL,
  `status` enum('APPROVED','DEFAULT','PENDING','REJECTED') DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `firstname`, `lastname`, `password`, `role`, `status`, `created_at`, `image_url`) VALUES
(1, 'TA Admin', 'admin@travelavail.com', 'Travel', 'Admin', '$2a$10$50rjkF1FbX0xboF6Bzw3seWTHHYa9gLrDE.d6LklD0qBpn.PiEi2K', 'ADMIN', 'DEFAULT', '2025-04-04 00:25:32.000000', NULL),
(2, 'John Doe', 'johndoe@email.com', 'John', 'Doe', '$2a$10$HoAmlXwXFuckkKp36a0y8.0oScrmJ1U60ruExDPHdo9Fa1NtBrQ4O', 'TRAVELER', 'PENDING', '2025-04-04 00:26:44.000000', NULL),
(3, 'Mark Rease', 'markrease@gmail.com', 'Mark', 'Rease', '$2a$10$6FWXwbebL/O9kT0ybSZYi.CnmzVFI6Xi.MgWRqZgtDvUfFid.wx/C', 'TRAVELER', 'PENDING', '2025-04-04 00:27:17.000000', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `idx_booking_user` (`user_id`),
  ADD KEY `idx_booking_type` (`booking_type`),
  ADD KEY `idx_booking_status` (`status`);

--
-- Indexes for table `carrental_bookings`
--
ALTER TABLE `carrental_bookings`
  ADD PRIMARY KEY (`booking_id`);

--
-- Indexes for table `flight_bookings`
--
ALTER TABLE `flight_bookings`
  ADD PRIMARY KEY (`booking_id`) USING BTREE,
  ADD KEY `idx_flight_dates` (`departure_date`,`return_date`);

--
-- Indexes for table `hotel_bookings`
--
ALTER TABLE `hotel_bookings`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `idx_hotel_dates` (`check_in_date`,`check_out_date`);

--
-- Indexes for table `moods`
--
ALTER TABLE `moods`
  ADD PRIMARY KEY (`mood_id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`notification_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `booking_id` (`booking_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `booking_id` (`booking_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=307;

--
-- AUTO_INCREMENT for table `moods`
--
ALTER TABLE `moods`
  MODIFY `mood_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `notification_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `carrental_bookings`
--
ALTER TABLE `carrental_bookings`
  ADD CONSTRAINT `carrental_bookings_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`) ON DELETE CASCADE;

--
-- Constraints for table `flight_bookings`
--
ALTER TABLE `flight_bookings`
  ADD CONSTRAINT `flight_bookings_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`) ON DELETE CASCADE;

--
-- Constraints for table `hotel_bookings`
--
ALTER TABLE `hotel_bookings`
  ADD CONSTRAINT `hotel_bookings_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`) ON DELETE CASCADE;

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `notifications_ibfk_2` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
