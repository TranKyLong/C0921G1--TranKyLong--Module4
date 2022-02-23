-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: case_study_furama
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `attach_id` int NOT NULL AUTO_INCREMENT,
  `attach_cost` double DEFAULT NULL,
  `attach_name` varchar(255) DEFAULT NULL,
  `attach_status` varchar(255) DEFAULT NULL,
  `attach_unit` int DEFAULT NULL,
  PRIMARY KEY (`attach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (1,100,'massage',NULL,50),(2,50,'karaoke',NULL,50),(3,40,'thức ăn',NULL,50),(4,40,'Thức uống',NULL,50),(5,30,'thuê xe',NULL,50);
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `deposit` double DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `total_money` double DEFAULT NULL,
  `customer_id_customer_id` int DEFAULT NULL,
  `employee_id_employee_id` int DEFAULT NULL,
  `service_id_service_id` int DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `FKkt679lnubw8dm7jha6gq74x4v` (`customer_id_customer_id`),
  KEY `FKk7hpqmb818wpacrh8b4r5b19m` (`employee_id_employee_id`),
  KEY `FK6ostyr3qyterf97qu6hjwyd91` (`service_id_service_id`),
  CONSTRAINT `FK6ostyr3qyterf97qu6hjwyd91` FOREIGN KEY (`service_id_service_id`) REFERENCES `furama_service` (`service_id`),
  CONSTRAINT `FKk7hpqmb818wpacrh8b4r5b19m` FOREIGN KEY (`employee_id_employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKkt679lnubw8dm7jha6gq74x4v` FOREIGN KEY (`customer_id_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,5,'2022-03-02 00:00:00.000000','2022-02-28 00:00:00.000000',NULL,1,1,2);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `attach_service_id_attach_id` int DEFAULT NULL,
  `contract_id_contract_id` int DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `FKhkx04r5fqrjwn1mlcc802c1vo` (`attach_service_id_attach_id`),
  KEY `FKe1lo7juco7f3ufr751enhlwbx` (`contract_id_contract_id`),
  CONSTRAINT `FKe1lo7juco7f3ufr751enhlwbx` FOREIGN KEY (`contract_id_contract_id`) REFERENCES `contract` (`contract_id`),
  CONSTRAINT `FKhkx04r5fqrjwn1mlcc802c1vo` FOREIGN KEY (`attach_service_id_attach_id`) REFERENCES `attach_service` (`attach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
INSERT INTO `contract_detail` VALUES (1,0,NULL,1);
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_adress` varchar(255) DEFAULT NULL,
  `customer_birthday` date DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_gender` int DEFAULT NULL,
  `customer_id_card` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `customer_type_customer_type_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FKltng8d0uct0oe9wfq2tby2ee` (`customer_type_customer_type_id`),
  CONSTRAINT `FKltng8d0uct0oe9wfq2tby2ee` FOREIGN KEY (`customer_type_customer_type_id`) REFERENCES `customer_type` (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Đà Nẵng',NULL,'KH-8985','khanhvan@gmail.com',0,'0985855555','Khánh Vân','0906567895',1),(3,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',2),(4,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Hải Yến','0985652345',3),(5,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','delete this','0985652345',4),(6,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Lạnh Hoài','0985652345',5),(7,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Mưa Hoài','0985652345',1),(8,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Dịch Hoài','0985652345',2),(9,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bug Hoài Ngàn Năm','0985652345',3),(10,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Lag Hoài','0985652345',4),(11,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Thua Hoài','0985652345',5),(12,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Minh Tuyết','0985652345',1),(13,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Lưu Hương Hồn','0985652345',2),(14,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Lê Hữu Đa','0985652345',3),(15,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Võ Sĩ Quyền Năng','0985652345',4),(16,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',5),(17,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',1),(18,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',2),(19,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',3),(20,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',4),(21,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',5),(22,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',1),(23,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',2),(24,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',3),(25,'Hà Nội',NULL,'KH-8985','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0985652345',4),(26,'Hà Nội',NULL,'KH-8989','oldsnow@gmail.com',0,'0568798654','Bão Hoài','0905652345',5),(27,'Hội An',NULL,'KH-5687','mail@gmail.kom',1,'234568976','new name','0912356875',2),(28,'Hội An',NULL,'KH-5687','8qqq88@mail.com',1,'0123456789','nameq','0912356875',4);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `customer_type_id` int NOT NULL AUTO_INCREMENT,
  `customer_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `division` (
  `division_id` int NOT NULL AUTO_INCREMENT,
  `division_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`division_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'Sale – Marketing'),(2,'Hành Chính'),(3,'Phục vụ'),(4,'Quản lý');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_degree`
--

DROP TABLE IF EXISTS `education_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education_degree` (
  `edu_id` int NOT NULL AUTO_INCREMENT,
  `edu_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`edu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_degree`
--

LOCK TABLES `education_degree` WRITE;
/*!40000 ALTER TABLE `education_degree` DISABLE KEYS */;
INSERT INTO `education_degree` VALUES (1,'Trung cấp'),(2,'Cao đẳng'),(3,'Đại học '),(4,'sau đại học');
/*!40000 ALTER TABLE `education_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_adress` varchar(255) DEFAULT NULL,
  `employee_birthday` date DEFAULT NULL,
  `employee_id_card` varchar(255) DEFAULT NULL,
  `employee_mail` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_phone` varchar(255) DEFAULT NULL,
  `employee_salary` double DEFAULT NULL,
  `division_id_division_id` int DEFAULT NULL,
  `education_degree_id_edu_id` int DEFAULT NULL,
  `pos_id_postd` int DEFAULT NULL,
  `username_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKem36i0swys3as7xtd9fwk3rfs` (`division_id_division_id`),
  KEY `FKqvmkryiyoo8pwxvhaf8purh1i` (`education_degree_id_edu_id`),
  KEY `FK77dq0s9wre0h6w2gnjnbe6up4` (`pos_id_postd`),
  KEY `FKluylajrsh8oxlf0keudgcqmrv` (`username_username`),
  CONSTRAINT `FK77dq0s9wre0h6w2gnjnbe6up4` FOREIGN KEY (`pos_id_postd`) REFERENCES `position` (`postd`),
  CONSTRAINT `FKem36i0swys3as7xtd9fwk3rfs` FOREIGN KEY (`division_id_division_id`) REFERENCES `division` (`division_id`),
  CONSTRAINT `FKluylajrsh8oxlf0keudgcqmrv` FOREIGN KEY (`username_username`) REFERENCES `user` (`username`),
  CONSTRAINT `FKqvmkryiyoo8pwxvhaf8purh1i` FOREIGN KEY (`education_degree_id_edu_id`) REFERENCES `education_degree` (`edu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'sdf','2021-02-08','1234567899','sdfsnkjn@gmail.com','Hú','0917598765',150,1,4,4,'employee'),(2,'adress','2021-02-08','1234567890','tklong0sa42000@gmail.com','naming new','0918956423',56,3,1,5,'employee2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `furama_service`
--

DROP TABLE IF EXISTS `furama_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `furama_service` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `floors_number` int NOT NULL,
  `free_service` varchar(255) DEFAULT NULL,
  `is_rent` bit(1) NOT NULL,
  `max_people` int DEFAULT NULL,
  `pool_area` double DEFAULT NULL,
  `service_area` int DEFAULT NULL,
  `service_code` varchar(255) DEFAULT NULL,
  `service_cost` double DEFAULT NULL,
  `service_name` varchar(255) DEFAULT NULL,
  `standar_room` varchar(255) DEFAULT NULL,
  `rent_type_id_rent_id` int DEFAULT NULL,
  `service_type_id_service_type_id` int DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `FKs6omuvi2sr9p7upqd409frdrm` (`rent_type_id_rent_id`),
  KEY `FKfx3ngpvuolv3mu1406nac7vi1` (`service_type_id_service_type_id`),
  CONSTRAINT `FKfx3ngpvuolv3mu1406nac7vi1` FOREIGN KEY (`service_type_id_service_type_id`) REFERENCES `service_type` (`service_type_id`),
  CONSTRAINT `FKs6omuvi2sr9p7upqd409frdrm` FOREIGN KEY (`rent_type_id_rent_id`) REFERENCES `rent_type` (`rent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `furama_service`
--

LOCK TABLES `furama_service` WRITE;
/*!40000 ALTER TABLE `furama_service` DISABLE KEYS */;
INSERT INTO `furama_service` VALUES (1,'view dep',1,'Du hành vũ trụ',_binary '\0',4,4,4,'DV-0123',566,'VILLA VILLA ','VIP',1,1),(2,'tuyet voi',4,'kéo rank',_binary '',4,NULL,45,'DV-0120',543,'house','sfvdvbgfb',2,2);
/*!40000 ALTER TABLE `furama_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `postd` int NOT NULL AUTO_INCREMENT,
  `pos_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`postd`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Lễ tân'),(2,'phục vụ'),(3,'chuyên viên'),(4,'giám sát'),(5,'quản lý'),(6,'giám đốc');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `rent_id` int NOT NULL AUTO_INCREMENT,
  `rent_cost` double DEFAULT NULL,
  `rent_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,NULL,'Năm'),(2,NULL,'Tháng'),(3,NULL,'Ngày'),(4,NULL,'Giờ');
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_CUSTOMER'),(4,'ROLE_EMPLOYEE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `service_type_id` int NOT NULL AUTO_INCREMENT,
  `service_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`service_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'Villa'),(2,'House'),(3,'Room');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `is_disable` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `employee_id_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FKq7r0kvr94ld253doarsfsfab4` (`employee_id_employee_id`),
  CONSTRAINT `FKq7r0kvr94ld253doarsfsfab4` FOREIGN KEY (`employee_id_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin',_binary '\0','$2a$10$brkT5SBptgIxhLjc0fupxOekVPLN4LMaENE2VIOj6Quu4lrBgA54a',NULL),('employee',_binary '\0','$2a$10$brkT5SBptgIxhLjc0fupxOekVPLN4LMaENE2VIOj6Quu4lrBgA54a',NULL),('employee2',_binary '\0','$2a$10$brkT5SBptgIxhLjc0fupxOekVPLN4LMaENE2VIOj6Quu4lrBgA54a',NULL),('user',_binary '\0','$2a$10$brkT5SBptgIxhLjc0fupxOekVPLN4LMaENE2VIOj6Quu4lrBgA54a',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `role_id` int NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`,`user_name`),
  KEY `FKlo35m1ajgm8bq9tkce6dcpvec` (`user_name`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKlo35m1ajgm8bq9tkce6dcpvec` FOREIGN KEY (`user_name`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'admin'),(4,'admin'),(4,'employee'),(2,'user');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-23 11:25:23
