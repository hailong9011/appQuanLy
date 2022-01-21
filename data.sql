-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.6.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for quanlyhoclieu
CREATE DATABASE IF NOT EXISTS `quanlyhoclieu` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_bin */;
USE `quanlyhoclieu`;

-- Dumping structure for table quanlyhoclieu.bai_hoc
CREATE TABLE IF NOT EXISTS `bai_hoc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `word` varchar(200) COLLATE utf8mb3_bin DEFAULT NULL,
  `slide` varchar(200) COLLATE utf8mb3_bin DEFAULT NULL,
  `bai_tap` varchar(200) COLLATE utf8mb3_bin DEFAULT NULL,
  `create_at` date NOT NULL,
  `update_at` date DEFAULT NULL,
  `ten_bai` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  `id_hoc_lieu` bigint(20) NOT NULL,
  `video` varchar(200) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_bai_hoc_hoc_lieu` (`id_hoc_lieu`),
  CONSTRAINT `FK_bai_hoc_hoc_lieu` FOREIGN KEY (`id_hoc_lieu`) REFERENCES `hoc_lieu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- Dumping data for table quanlyhoclieu.bai_hoc: ~9 rows (approximately)
/*!40000 ALTER TABLE `bai_hoc` DISABLE KEYS */;
INSERT INTO `bai_hoc` (`id`, `word`, `slide`, `bai_tap`, `create_at`, `update_at`, `ten_bai`, `id_hoc_lieu`, `video`) VALUES
	(33, '', '', '', '2021-12-30', '2022-01-02', 'Bài 1', 28, ''),
	(34, 'C:\\Users\\hailo\\Downloads\\Documents\\danh-sach-thi-lan2-hk2-cn-ngay-26-12-2021.pdf', NULL, NULL, '2021-12-30', '2022-01-01', 'Bài 2', 28, NULL),
	(35, 'C:\\Users\\hailo\\Downloads\\Documents\\Xây-dựng-phần-mềm-quản-lý-bộ-học-liệu-môn-học.docx', 'C:\\Users\\hailo\\Downloads\\Documents\\Bai 02 Hiem hoa  ATTT.pdf', 'C:\\Users\\hailo\\Downloads\\Documents\\Ảnh hưởng của chính sách an toàn thông tin đến văn hóa an toàn_Bài tập lớn.docx', '2021-12-30', '2022-01-02', 'Bài 1', 29, 'C:\\Users\\hailo\\Downloads\\Documents\\tiny love.mp4'),
	(36, NULL, NULL, NULL, '2021-12-31', NULL, 'Bài 1', 30, NULL),
	(37, NULL, NULL, NULL, '2021-12-31', NULL, 'Bài 2', 30, NULL),
	(38, NULL, NULL, NULL, '2021-12-31', NULL, 'Bài 3', 30, NULL),
	(39, NULL, NULL, NULL, '2021-12-31', NULL, 'Bài 1', 31, NULL),
	(42, NULL, NULL, NULL, '2021-12-31', NULL, 'Bài 1', 33, NULL),
	(43, NULL, NULL, NULL, '2021-12-31', NULL, 'Bài 2', 33, NULL);
/*!40000 ALTER TABLE `bai_hoc` ENABLE KEYS */;

-- Dumping structure for table quanlyhoclieu.hoc_lieu
CREATE TABLE IF NOT EXISTS `hoc_lieu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ten_hoc_lieu` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  `create_at` date NOT NULL,
  `update_at` date DEFAULT NULL,
  `create_by` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ten_hoc_lieu` (`ten_hoc_lieu`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- Dumping data for table quanlyhoclieu.hoc_lieu: ~5 rows (approximately)
/*!40000 ALTER TABLE `hoc_lieu` DISABLE KEYS */;
INSERT INTO `hoc_lieu` (`id`, `ten_hoc_lieu`, `create_at`, `update_at`, `create_by`) VALUES
	(28, 'PHP', '2021-12-30', NULL, 'admin@gmail.com'),
	(29, 'Java', '2021-12-30', NULL, 'nguyenhau@gmail.com'),
	(30, 'Lập Trình Căn Bản', '2021-12-30', '2021-12-30', 'nguyenhau@gmail.com'),
	(31, 'C', '2021-12-31', '2022-01-02', 'anhtuan@gmail.com'),
	(33, 'Triết', '2021-12-31', NULL, 'anhtuan@gmail.com');
/*!40000 ALTER TABLE `hoc_lieu` ENABLE KEYS */;

-- Dumping structure for table quanlyhoclieu.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  `role` varchar(50) COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- Dumping data for table quanlyhoclieu.user: ~4 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `role`, `email`) VALUES
	(11, 'Admin', '$2a$10$tQwm0/xJTzWP7SyLlNOMKOyY.pAJUnmbadbyXD5xQ5iZBMPM9Annu', 'Admin', 'admin@gmail.com'),
	(12, 'Hậu Nguyễn', '$2a$10$pVrmX8XgZBW5KIkPJQwKBuw3lamGHp3M29YGTbGJRwjIPKVJDNBc.', 'Giảng viên', 'nguyenhau@gmail.com'),
	(13, 'Anh Tuấn', '$2a$10$Hjh1KOXOWrr9i65jDOStNOn/3n6CsJ6OYX2T9WD57xADjMyEnx/dG', 'Giảng viên', 'anhtuan@gmail.com'),
	(17, 'Huy', '$2a$10$saB7BZtIvDp2yihGZ4//NOzjqZyCMDxseOxDkkal6uodRKYa3q/.a', 'Người dùng', 'phamhuy@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
