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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,45,'/2021/07/14/d792f1e5-71ab-4286-8a09-129eab1c7284_boo.png','I','boo.png'),(2,47,'/2021/07/14/bdee36e2-7809-4cb9-81db-0d0756e779a3_sully.png','D','sully.png'),(3,48,'/2021/07/14/dba88e6a-7069-477f-849f-47acc7b2a9d0_greenshoes.jpg','D','greenshoes.jpg'),(4,48,'/2021/07/15/6ca1b524-1330-460f-905d-3ff9b9b7a229_sully.png','D','sully.png'),(5,48,'/2021/07/15/90b06458-1e27-4718-a3cc-fd804715ac4b_sully.png','D','sully.png'),(6,48,'/2021/07/15/8eb02549-c9b0-46c0-8eac-c02a4dd7f1de_boo.png','D','boo.png'),(7,48,'/2021/07/15/32f0b777-d1c5-4667-87d5-9ed4f5f9ff4e_sully.png','D','sully.png'),(8,49,'/2021/07/15/cc8b430e-2852-4204-ad3b-db7cb5171ba8_sully.png','D','sully.png'),(9,49,'/2021/07/15/b4578455-727e-4fb9-ba88-f988efa8ea0d_sully.png','I','sully.png'),(10,49,'/2021/07/15/5556fa02-4f61-400c-91e7-0a4bfc609e96_sully.png','I','sully.png'),(11,49,'/2021/07/15/2b1c1bef-4e26-4ed5-8005-c04fa274d8f3_greenshoes.jpg','I','greenshoes.jpg'),(12,50,'/2021/07/15/64fe2c4d-67a8-449e-bc4d-6f2c1e67d2cf_sully.png','I','sully.png'),(13,50,'/2021/07/15/b96fb3d5-e371-4c32-bb38-63188a49db07_spring day3.txt','I','spring day3.txt'),(14,50,'/2021/07/15/c98137b0-4d91-4cd4-b25e-a08d9fd5e81b_spring day8.txt','I','spring day8.txt'),(15,51,'/2021/07/16/7ccd3aec-9c23-4c97-9375-bd56a2aaadd5_LICENSE.electron.txt','I','LICENSE.electron.txt'),(16,52,'/2021/07/16/45b7cb5e-bc8e-42a2-88a6-36a74f4745be_libGLESv2.dll','I','libGLESv2.dll'),(17,52,'/2021/07/16/cdad7395-9cb1-4051-a69e-85e3d96c3855_ffmpeg.dll','I','ffmpeg.dll'),(18,53,'/2021/07/16/aa0a0be8-1d82-46bb-a979-6625d65b0183_Update.exe','D','Update.exe'),(19,53,'/2021/07/16/5d1092f4-748a-4526-8906-74a0bf961b48_GitHubDesktop.exe','I','GitHubDesktop.exe'),(20,53,'/2021/07/16/4beed9f4-79fb-4c5c-829a-196abac5baf7_Squirrel-CheckForUpdate.log','D','Squirrel-CheckForUpdate.log'),(21,53,'/2021/07/16/7f6dd13f-86e1-4ce9-a2c2-87c029a4345f_Squirrel-CheckForUpdate.log','I','Squirrel-CheckForUpdate.log'),(22,53,'/2021/07/16/4097fd90-cc60-43fa-9b6e-871ec6bc9ad7_Squirrel-Update.log','I','Squirrel-Update.log'),(23,67,'/2021/07/16/5c552ad6-b60c-4f83-92e5-1908f62daad4_spring day2.txt','D','spring day2.txt'),(24,68,'/2021/07/16/76fb01af-269a-4d06-9421-bbcf69a34bf2_spring day2.txt','D','spring day2.txt'),(25,69,'/2021/07/16/065c09c4-1fa6-462b-b905-8c4ad07811a7_spring day3.txt','D','spring day3.txt'),(26,69,'/2021/07/16/1cbbb9e0-81c1-4436-86b9-ffb37f0cd080_spring day10.txt','D','spring day10.txt'),(27,69,'/2021/07/16/0eab43ff-aa70-4a1d-92d8-97176e215c2d_spring day8.txt','D','spring day8.txt'),(28,70,'/2021/07/19/ca25716c-710f-4cf4-bbb0-80560e9982c0_Aishiteru Lover.ttf','D','Aishiteru Lover.ttf'),(29,71,'/2021/07/19/a2a51ea1-6d9a-40fa-be2c-ee1b49a62dc3_Aishiteru Lover.ttf','D','Aishiteru Lover.ttf'),(30,72,'/2021/07/19/2f27eeee-e530-4fe9-b09a-5c66a172598c_GitHubDesktop.exe','I','GitHubDesktop.exe'),(31,73,'/2021/07/19/dacd09b6-70cc-49f9-858d-f63a005d1f04_Squirrel-CheckForUpdate.log','I','Squirrel-CheckForUpdate.log'),(32,74,'/2021/07/19/8d103a8b-ceb9-4471-9eef-b7c650abfc9b_Squirrel-Shortcut.log','I','Squirrel-Shortcut.log'),(33,75,'/2021/07/19/396c68dd-de22-4632-a1a1-d11a862f4089_Squirrel-Update.log','D','Squirrel-Update.log'),(34,76,'/2021/07/19/eba288f9-e1d8-4b40-923d-44ec486cfa3e_squirrel.exe','I','squirrel.exe'),(35,77,'/2021/07/19/ef97720c-7dda-4f86-89d0-9b13d6459e13_LICENSE','D','LICENSE'),(36,77,'/2021/07/19/ad4b3f22-31c5-45a9-9647-8eeec0c70f63_libGLESv2.dll','D','libGLESv2.dll'),(37,78,'/2021/07/19/653f255d-f6db-4de1-8f29-12353a30a127_vk_swiftshader_icd.json','D','vk_swiftshader_icd.json'),(38,78,'/2021/07/19/cf3938a3-ddd7-4598-9a75-f5150f886948_v8_context_snapshot.bin','D','v8_context_snapshot.bin'),(39,78,'/2021/07/19/59b12b2c-adcf-4f0d-a878-78ac2f76c4e4_vk_swiftshader.dll','D','vk_swiftshader.dll'),(40,78,'/2021/07/19/c5e177a3-1b61-4345-a466-f56c0303a87c_libEGL.dll','I','libEGL.dll');
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

-- Dump completed on 2021-07-20 17:28:32
