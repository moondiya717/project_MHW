CREATE DATABASE  IF NOT EXISTS `spring_mhw` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spring_mhw`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_mhw
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `rp_num` int NOT NULL AUTO_INCREMENT,
  `rp_bd_num` int NOT NULL,
  `rp_me_id` varchar(15) NOT NULL,
  `rp_content` longtext NOT NULL,
  `rp_valid` varchar(1) NOT NULL DEFAULT 'I',
  `rp_regDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rp_upDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rp_num`),
  KEY `rp_bd_num_idx` (`rp_bd_num`),
  KEY `rp_me_id_idx` (`rp_me_id`),
  CONSTRAINT `rp_bd_num` FOREIGN KEY (`rp_bd_num`) REFERENCES `board` (`num`),
  CONSTRAINT `rp_me_id` FOREIGN KEY (`rp_me_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,74,'art','sf','I','2021-07-21 10:45:48','2021-07-21 10:45:48'),(2,74,'art','sf','I','2021-07-21 10:45:49','2021-07-21 10:45:49'),(3,74,'art','sf','I','2021-07-21 10:45:51','2021-07-21 10:45:51'),(4,74,'art','sf','I','2021-07-21 10:45:51','2021-07-21 10:45:51'),(5,74,'art','sf','I','2021-07-21 10:45:51','2021-07-21 10:45:51'),(6,74,'art','sf','I','2021-07-21 10:45:51','2021-07-21 10:45:51'),(7,74,'art','sf','I','2021-07-21 10:45:52','2021-07-21 10:45:52'),(8,80,'art','a.a','I','2021-07-21 10:47:00','2021-07-21 10:47:00'),(9,80,'art','sdfs','I','2021-07-21 11:25:46','2021-07-21 11:25:46'),(10,80,'art','dfafs','I','2021-07-21 11:26:48','2021-07-21 11:26:48'),(11,80,'art',' 왘!','I','2021-07-21 11:34:43','2021-07-21 11:34:43'),(12,80,'art','아!','I','2021-07-21 11:35:04','2021-07-21 11:35:04'),(13,80,'art','앜!!!!!!!!!!!!!','I','2021-07-21 11:35:25','2021-07-21 11:35:25'),(14,80,'art','??????????','I','2021-07-21 11:35:44','2021-07-21 11:35:44'),(15,80,'art','??????????ㅇㄴㄹㄹ','I','2021-07-21 11:36:08','2021-07-21 11:36:08'),(16,80,'art','ㄴㄹㅇ','I','2021-07-21 11:36:20','2021-07-21 11:36:20'),(17,80,'art','6ㅅㄳ','I','2021-07-21 11:36:33','2021-07-21 11:36:33'),(18,80,'art','굑','D','2021-07-21 11:36:38','2021-07-21 16:54:22'),(19,80,'art','ㅇㄴㄹㅇㄴㄹ','D','2021-07-21 11:38:52','2021-07-21 16:54:21'),(20,80,'art','우왘!!!!!!!!!!!!!!!!앜!!!!!!!!!!!','I','2021-07-21 11:43:11','2021-07-21 11:43:11'),(21,80,'art','쾅코아쾅!!!!!!!!!!!쾅쾅쾅!!!!!!!!!!!!!!!!!','I','2021-07-21 11:44:05','2021-07-21 11:44:05'),(22,80,'art','ㅋ','I','2021-07-21 11:45:09','2021-07-21 11:45:09'),(23,80,'art','sdf','D','2021-07-21 13:00:38','2021-07-21 16:51:47'),(24,80,'art','test','D','2021-07-21 13:00:41','2021-07-21 16:52:01'),(25,80,'art','test','D','2021-07-21 13:00:43','2021-07-21 16:51:25'),(26,80,'art','testasdfafds','D','2021-07-21 13:00:46','2021-07-21 16:51:35'),(27,80,'art','testasdfafds','D','2021-07-21 13:00:49','2021-07-21 16:51:37'),(28,80,'morning','내가 썼어ㅏ!!!!!!!!','I','2021-07-21 16:24:20','2021-07-21 16:24:20'),(29,66,'art','무댓글','I','2021-07-21 17:31:04','2021-07-21 17:31:04'),(30,66,'art','ㅋㅋㅋ','I','2021-07-21 17:31:50','2021-07-21 17:31:50');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-01 22:28:19
