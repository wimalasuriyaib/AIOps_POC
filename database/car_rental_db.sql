-- --------------------------------------------------------
-- Host:                         52.2.166.75
-- Server version:               8.0.34-0ubuntu0.20.04.1 - (Ubuntu)
-- Server OS:                    Linux
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for car_rental_db
CREATE DATABASE IF NOT EXISTS `car_rental_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `car_rental_db`;

-- Dumping structure for table car_rental_db.t_cars
CREATE TABLE IF NOT EXISTS `t_cars` (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `make` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `year` int NOT NULL,
  `license_plate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `location_uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `per_hour_rate` decimal(10,2) NOT NULL,
  `per_day_rate` decimal(10,2) NOT NULL,
  `leasing_rate` decimal(10,2) NOT NULL,
  `car_description` varchar(255) DEFAULT NULL,
  `mileage` bigint DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  `seats` int DEFAULT NULL,
  `luggage` int DEFAULT NULL,
  `fuel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table car_rental_db.t_cars: ~0 rows (approximately)
/*!40000 ALTER TABLE `t_cars` DISABLE KEYS */;
INSERT INTO `t_cars` (`id`, `car_code`, `make`, `model`, `year`, `license_plate`, `availability`, `image_url`, `location_uuid`, `per_hour_rate`, `per_day_rate`, `leasing_rate`, `car_description`, `mileage`, `transmission`, `seats`, `luggage`, `fuel`) VALUES
	(1, '45f6f72c-6f6a-4b36-9d33-954ccb62be0a', 'Lexus', 'Lexus 2022', 2022, 'BGH 9072', 1, 'assets/img/lexus1.jpg', '71d45ae7-92f5-4621-9d3d-1e407967a79f', 12.99, 111.12, 4243.98, 'A small river named Duden flows by their place and supplies it with the necessary regelialia.', 12120, 'Manul', 5, 5, 'Petrol');
/*!40000 ALTER TABLE `t_cars` ENABLE KEYS */;

-- Dumping structure for table car_rental_db.t_locations
CREATE TABLE IF NOT EXISTS `t_locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `location_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `location_uuid` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table car_rental_db.t_locations: ~7 rows (approximately)
/*!40000 ALTER TABLE `t_locations` DISABLE KEYS */;
INSERT INTO `t_locations` (`id`, `location_name`, `location_address`, `location_uuid`) VALUES
	(1, 'Wellawaya', 'Wellwaya Road Wellwaya', '71d45ae7-92f5-4621-9d3d-1e407967a79f'),
	(2, 'Colombo', 'Colombo Road Colombo', '5fbf593f-cf44-4562-825a-6b932b117587'),
	(3, 'Kandy', 'Kandy Road Kandy', 'a62414fd-c56e-4de0-9409-f7b7f5a7c71d'),
	(4, 'Jaffna', 'Jaffna Road Jaffna', '5e1a43cc-b67b-4e98-b0bb-6ae33535180e'),
	(5, 'Gampaha', 'Gampaha Road Gampaha', '5056fb9b-bbbc-404d-964b-a50bc26235f2'),
	(6, 'Galle', 'Galle Road Galle', 'cde00356-1321-4bbc-b648-afcbd9f3dfcf'),
	(7, 'Matara', 'Matara Road Matara', '34043148-d701-4f11-9525-5fb965be2f2d');
/*!40000 ALTER TABLE `t_locations` ENABLE KEYS */;

-- Dumping structure for table car_rental_db.t_reservations
CREATE TABLE IF NOT EXISTS `t_reservations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reservation_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `reservation_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `reservation_car_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `car_quantity` bigint NOT NULL,
  `total_cost` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table car_rental_db.t_reservations: ~2 rows (approximately)
/*!40000 ALTER TABLE `t_reservations` DISABLE KEYS */;
INSERT INTO `t_reservations` (`id`, `reservation_number`, `start_date`, `end_date`, `reservation_status`, `reservation_car_code`, `car_quantity`, `total_cost`) VALUES
	(1, 'd2b42c10-6f31-4604-be5e-8cd146cb2411', '2023-09-13', '2023-09-21', '2', '45f6f72c-6f6a-4b36-9d33-954ccb62be0a', 2, 888.96),
	(2, '1ca01598-c2bd-4885-a5ab-69c8dc3aab62', '2023-09-06', '2023-09-21', '0', '45f6f72c-6f6a-4b36-9d33-954ccb62be0a', 1, 1666.80);
/*!40000 ALTER TABLE `t_reservations` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
