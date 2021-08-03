-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_mhw
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(15) NOT NULL,
  `pw` varchar(255) NOT NULL,
  `gender` varchar(1) NOT NULL DEFAULT 'M',
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL DEFAULT ' ',
  `authority` varchar(45) NOT NULL DEFAULT 'USER',
  `session_id` varchar(255) DEFAULT NULL,
  `session_limit` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('abc','$2a$10$bujpVWIyxswE7DA..305w.SV4Mdasp37oygz4yd8poul5jPoIVwX6','M','dafd@naver.com','123','USER','',NULL),('alpha','$2a$10$LZGYXnb.VJH88yAZiV9bNOMo6e/lnYyTacnLtDOWRzsIgw0UZKVPm','M','staionery@daum.net','plus','USER','',NULL),('art','$2a$10$mU8ddJRoCJXU5HrjladzsuZin.MXru59xQm0sGOMSwsW/8ns2JS/G','F','dongsuk@artbox.com','box','SUPER ADMIN','970CAB9135F67137B06B9A6E2A741142','2021-08-10 16:21:07'),('mini','$2a$10$7Gx4gMg3yPk6HUbs4trJ.uQFdYma5MipL5ZhivP/Y289PNng6rL2e','M','minimini@yaya.com','soo','ADMIN','',NULL),('moondi','$2a$10$DAqSp5v/g5oPAKhjOA9pcubp6XhC7NE/VOAhS7vh2fhvMzehVCMlu','F','hi@gmail.com','월요일','USER','',NULL),('morning','$2a$10$JVfRoT1/RsVmVsvG9mXin.iVrUzIfaIXOHSIIv3J0mgSBkF6IMLui','F','river@gmail.com','glory','USER','',NULL),('star','$2a$10$l3YI2nGkd3X9qBiFUYNXCesYnmUozKmGtVNCMVkE2smMPNL80Awna','F','American@coffee.stars','bucks','USER','',NULL),('starbucks','$2a$10$NaaB5/A8fH1u7rO6aEcDK.NqOdRwYxePoYTzah6tf/l5ltVpQT4hu','F','american@coffee.com','1이여덟개','USER','',NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-03 17:52:05
