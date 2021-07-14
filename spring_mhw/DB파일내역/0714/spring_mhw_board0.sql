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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `num` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `contents` longtext NOT NULL,
  `writer` varchar(15) NOT NULL,
  `registered` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int NOT NULL DEFAULT '0',
  `valid` varchar(1) NOT NULL DEFAULT 'I',
  PRIMARY KEY (`num`),
  KEY `writer_idx` (`writer`),
  CONSTRAINT `writer` FOREIGN KEY (`writer`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'게시글 수정되는지 볼게요!','게시글내용임둥 둥두루두두둥둥(수정된 내용입니다)','alpha','2021-07-06 16:26:28',14,'D'),(2,'나얼마나신나게~','호롤룰루루','alpha','2021-07-06 16:26:56',10,'I'),(3,'애플펜슬','내일온대','alpha','2021-07-06 16:27:31',15,'D'),(4,'Happy Meal','Lunch Box!','alpha','2021-07-07 12:45:51',26,'D'),(5,'t수정됐나요???????~네네네네네4차 ㄱㄷ','UPDATED?!ㄱㄷ','alpha','2021-07-08 16:34:50',57,'I'),(6,'DELETE','dfafehrere','alpha','2021-07-08 17:33:00',38,'I'),(7,'test','아트박스','morning','2021-07-12 16:30:44',0,'I'),(8,'글쓰기했을떼 페이지네이션 늘어나요?','늘어나는지 확인하려고요! TotalCount','alpha','2021-07-09 14:21:34',4,'I'),(9,'\"와\"','test','alpha','2021-07-09 15:23:54',13,'I'),(10,'\"\"','test','alpha','2021-07-09 15:24:55',4,'I'),(11,'가능함?','test','morning','2021-07-12 16:00:01',0,'I'),(12,'시간을 속일수없어','호호호','morning','2021-07-12 16:00:02',0,'I'),(13,'글껴넣기중입니다','중간에삭제했거등여','morning','2021-07-12 16:00:03',0,'I'),(14,'등록일자가 다를거임','글을 중간에 껴넣었기때문에 강제로~','morning','2021-07-12 16:00:04',0,'I'),(15,'세션이','내 지금 글 올릴 수 있도록 해주신옮ㄴㅇㄴ','alpha','2021-07-12 16:19:01',2,'I'),(16,'시험삼아글써봐요','아트박스보다 모닝글로리','morning','2021-07-12 16:30:44',9,'I'),(17,'아니 내가쓴글이 아닌데 막 삭제가 된다','으뜨카면죠하','morning','2021-07-12 16:43:04',8,'D'),(18,'아니 alpha는 안되는데여?','재시작안되서그런ㄱ라','alpha','2021-07-12 16:43:45',32,'I'),(19,'등록번호가 몇번일지 확인하기위해서','test','alpha','2021-07-12 17:20:30',1,'D'),(23,'neq','fdsf','art','2021-07-13 16:24:46',3,'D'),(24,'어디갔나','20번부터는','art','2021-07-13 16:25:16',2,'D'),(25,'Come on!!!!!!','ㄹㅇ','art','2021-07-13 16:52:06',5,'D'),(26,'gg','ㅌ','art','2021-07-13 17:02:25',1,'D'),(27,'djfskl','fkjdslf','mini','2021-07-13 17:17:11',10,'D'),(28,'test','test','mini','2021-07-14 09:53:26',0,'D'),(29,'test','test','mini','2021-07-14 09:58:56',5,'I'),(30,'시험삼아글써봐요','test','art','2021-07-14 16:34:59',0,'I'),(31,'ㅎㅎ오류날꺼같앙','ㅎㄶㄴ','art','2021-07-14 16:35:24',1,'I'),(32,'내용이없는데','들억졌어','art','2021-07-14 16:39:10',0,'I'),(33,'빈','ㅅㄷㄴㅅ','art','2021-07-14 16:53:45',0,'I'),(34,'글','ㅅㄷ','art','2021-07-14 16:54:23',0,'I'),(35,'을','1','art','2021-07-14 16:54:25',0,'I'),(36,'막','4','alpha','2021-07-14 16:56:01',0,'I'),(37,'아','ㄱ','alpha','2021-07-14 16:56:04',1,'I'),(38,'야','ㄷㅇㄴ','mini','2021-07-14 16:57:22',0,'I'),(39,'한','ㄹ','mini','2021-07-14 16:57:24',0,'I'),(40,'다','ㅎ','mini','2021-07-14 16:57:35',0,'I'),(41,'호','ㅌㅇㄹ','mini','2021-07-14 16:57:38',0,'I'),(42,'호','ㄹ','morning','2021-07-14 16:59:37',0,'I'),(43,'첨부파일올려욤','예[이잉','art','2021-07-14 17:08:52',12,'I'),(44,'afdsa','dasf','art','2021-07-14 17:11:44',5,'I'),(45,'test','ydyafyyboo','mini','2021-07-14 17:15:40',2,'I'),(46,'..','..','art','2021-07-14 17:24:41',1,'I'),(47,'수정으로 글을 올릴 순 없나바 ㅇ흐으흐그흐극','두번쨰설리\r\n','art','2021-07-14 17:26:50',1,'I'),(48,'test먗ㅁ개야','ㅅㄷㄴㅅ','art','2021-07-14 17:27:35',2,'I');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-14 17:35:53
