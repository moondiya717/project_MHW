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
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `num` int NOT NULL AUTO_INCREMENT,
  `board` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` varchar(1) NOT NULL DEFAULT 'I',
  `ori_name` varchar(255) NOT NULL,
  PRIMARY KEY (`num`),
  KEY `board_idx` (`board`),
  CONSTRAINT `board` FOREIGN KEY (`board`) REFERENCES `board` (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,45,'/2021/07/14/d792f1e5-71ab-4286-8a09-129eab1c7284_boo.png','I','boo.png'),(2,47,'/2021/07/14/bdee36e2-7809-4cb9-81db-0d0756e779a3_sully.png','D','sully.png'),(3,48,'/2021/07/14/dba88e6a-7069-477f-849f-47acc7b2a9d0_greenshoes.jpg','D','greenshoes.jpg'),(4,48,'/2021/07/15/6ca1b524-1330-460f-905d-3ff9b9b7a229_sully.png','D','sully.png'),(5,48,'/2021/07/15/90b06458-1e27-4718-a3cc-fd804715ac4b_sully.png','D','sully.png'),(6,48,'/2021/07/15/8eb02549-c9b0-46c0-8eac-c02a4dd7f1de_boo.png','D','boo.png'),(7,48,'/2021/07/15/32f0b777-d1c5-4667-87d5-9ed4f5f9ff4e_sully.png','I','sully.png'),(8,49,'/2021/07/15/cc8b430e-2852-4204-ad3b-db7cb5171ba8_sully.png','D','sully.png'),(9,49,'/2021/07/15/b4578455-727e-4fb9-ba88-f988efa8ea0d_sully.png','D','sully.png'),(10,49,'/2021/07/15/5556fa02-4f61-400c-91e7-0a4bfc609e96_sully.png','D','sully.png'),(11,49,'/2021/07/15/2b1c1bef-4e26-4ed5-8005-c04fa274d8f3_greenshoes.jpg','I','greenshoes.jpg'),(12,50,'/2021/07/15/64fe2c4d-67a8-449e-bc4d-6f2c1e67d2cf_sully.png','I','sully.png'),(13,50,'/2021/07/15/b96fb3d5-e371-4c32-bb38-63188a49db07_spring day3.txt','I','spring day3.txt'),(14,50,'/2021/07/15/c98137b0-4d91-4cd4-b25e-a08d9fd5e81b_spring day8.txt','I','spring day8.txt');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-15 17:16:19
