-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: airportmgtdb
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `allot`
--

DROP TABLE IF EXISTS `allot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allot` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `hanger_id` bigint NOT NULL,
  `manager_id` bigint NOT NULL,
  `plane_id` bigint NOT NULL,
  `hanger` bigint NOT NULL,
  `manager` bigint NOT NULL,
  `plane` bigint NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsvn2xqbilj43gm3b1pcwh7p75` (`hanger`),
  KEY `FKn0aiik2uylhvup8bo7fvm6dj7` (`manager`),
  KEY `FKna8n7ktssq2aa1f7tcleg5965` (`plane`),
  CONSTRAINT `FKn0aiik2uylhvup8bo7fvm6dj7` FOREIGN KEY (`manager`) REFERENCES `user` (`id`),
  CONSTRAINT `FKna8n7ktssq2aa1f7tcleg5965` FOREIGN KEY (`plane`) REFERENCES `plane` (`id`),
  CONSTRAINT `FKsvn2xqbilj43gm3b1pcwh7p75` FOREIGN KEY (`hanger`) REFERENCES `hanger` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allot`
--

LOCK TABLES `allot` WRITE;
/*!40000 ALTER TABLE `allot` DISABLE KEYS */;
INSERT INTO `allot` VALUES (4,'nic@gmail.com','2021-07-22 22:22:05.064000','nic@gmail.com','2021-07-22 22:22:05.064000',1,11,1,1,11,1,'Alloted');
/*!40000 ALTER TABLE `allot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deploc`
--

DROP TABLE IF EXISTS `deploc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deploc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `dep_loc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deploc`
--

LOCK TABLES `deploc` WRITE;
/*!40000 ALTER TABLE `deploc` DISABLE KEYS */;
INSERT INTO `deploc` VALUES (1,'Admin@123.com','2021-07-24 14:04:17.809000','Admin@123.com','2021-07-24 14:04:17.809000','Delhi'),(2,'Admin@123.com','2021-07-24 14:05:11.084000','Admin@123.com','2021-07-24 14:05:11.084000','Mumbai');
/*!40000 ALTER TABLE `deploc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination_loc`
--

DROP TABLE IF EXISTS `destination_loc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destination_loc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `destination_loc` varchar(255) DEFAULT NULL,
  `des_loc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination_loc`
--

LOCK TABLES `destination_loc` WRITE;
/*!40000 ALTER TABLE `destination_loc` DISABLE KEYS */;
INSERT INTO `destination_loc` VALUES (1,'Admin@123.com','2021-07-24 14:56:05.270000','Admin@123.com','2021-07-24 14:56:05.270000',NULL,'Delhi'),(2,'Admin@123.com','2021-07-24 15:08:05.853000','Admin@123.com','2021-07-24 15:08:05.853000',NULL,'Indore'),(3,'Admin@123.com','2021-07-26 01:00:40.812000','Admin@123.com','2021-07-26 01:00:40.812000',NULL,'Mumbai');
/*!40000 ALTER TABLE `destination_loc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flightplanupdate`
--

DROP TABLE IF EXISTS `flightplanupdate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flightplanupdate` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `alt_air` varchar(255) DEFAULT NULL,
  `arr_time` datetime(6) DEFAULT NULL,
  `departure_loc_id` bigint NOT NULL,
  `destination_loc_id` bigint NOT NULL,
  `plane_id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `waypoints_id` bigint NOT NULL,
  `departure_location` bigint NOT NULL,
  `des_loc` bigint NOT NULL,
  `plane` bigint NOT NULL,
  `waypoints` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhvn2lci2px07rig17ca6a2iv0` (`departure_location`),
  KEY `FKc9x0wnvxh3k4oahtfbd2qybk` (`des_loc`),
  KEY `FKrbki6ehy7v121sxl9t3udppos` (`waypoints`),
  KEY `FK4gvq3sl08n2fh958fmiv8ay0a` (`plane`),
  CONSTRAINT `FK4gvq3sl08n2fh958fmiv8ay0a` FOREIGN KEY (`plane`) REFERENCES `plane` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKc9x0wnvxh3k4oahtfbd2qybk` FOREIGN KEY (`des_loc`) REFERENCES `destination_loc` (`id`),
  CONSTRAINT `FKhvn2lci2px07rig17ca6a2iv0` FOREIGN KEY (`departure_location`) REFERENCES `deploc` (`id`),
  CONSTRAINT `FKrbki6ehy7v121sxl9t3udppos` FOREIGN KEY (`waypoints`) REFERENCES `waypoints` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flightplanupdate`
--

LOCK TABLES `flightplanupdate` WRITE;
/*!40000 ALTER TABLE `flightplanupdate` DISABLE KEYS */;
INSERT INTO `flightplanupdate` VALUES (2,'khanhuma1021994@gmail.com','2021-07-24 22:01:49.381000','khanhuma1021994@gmail.com','2021-07-24 22:01:49.381000','Jaipur','1970-01-01 23:01:00.000000',1,2,1,10,1,1,2,1,1);
/*!40000 ALTER TABLE `flightplanupdate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hanger`
--

DROP TABLE IF EXISTS `hanger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hanger` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `hanger_address` varchar(455) DEFAULT NULL,
  `hanger_model` varchar(255) DEFAULT NULL,
  `hanger_name` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hanger`
--

LOCK TABLES `hanger` WRITE;
/*!40000 ALTER TABLE `hanger` DISABLE KEYS */;
INSERT INTO `hanger` VALUES (1,'Admin@123.com','2021-07-22 14:01:32.459000','Admin@123.com','2021-07-22 14:01:32.459000','A B Street','Model1','Hanger1'),(2,'Admin@123.com','2021-07-22 14:04:21.404000','Admin@123.com','2021-07-22 14:04:21.404000','S L Street','Model2','Hanger2');
/*!40000 ALTER TABLE `hanger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `help`
--

DROP TABLE IF EXISTS `help`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `help` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `issue` varchar(255) DEFAULT NULL,
  `request_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `description` varchar(455) DEFAULT NULL,
  `answer` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `help`
--

LOCK TABLES `help` WRITE;
/*!40000 ALTER TABLE `help` DISABLE KEYS */;
INSERT INTO `help` VALUES (2,'nic@gmail.com','2021-10-10 14:32:16.787000','nic@gmail.com','2021-10-10 14:32:16.787000','connection',NULL,'1012','Facing connection issue','Yes, we are resolving');
/*!40000 ALTER TABLE `help` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plane`
--

DROP TABLE IF EXISTS `plane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plane` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `last_service_date` varchar(255) DEFAULT NULL,
  `model_number` varchar(255) DEFAULT NULL,
  `purchase_date` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plane`
--

LOCK TABLES `plane` WRITE;
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
INSERT INTO `plane` VALUES (1,'Admin@123.com','2021-07-21 23:43:50.703000','Admin@123.com','2021-07-21 23:43:50.703000','01/19/2021','12345','01/03/1990',78560),(2,'Admin@123.com','2021-07-26 12:51:18.668000','Admin@123.com','2021-07-26 12:51:18.668000','07/09/2021','7899','01/04/1990',78525);
/*!40000 ALTER TABLE `plane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_flight`
--

DROP TABLE IF EXISTS `post_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_flight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `hanger_id` bigint NOT NULL,
  `master_switch` varchar(255) DEFAULT NULL,
  `plane_id` bigint NOT NULL,
  `hanger` bigint NOT NULL,
  `plane` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKau84tqxkyxpf0ilieooqn8h06` (`hanger`),
  KEY `FKi6algwl04geudnb14cot2fw7t` (`plane`),
  CONSTRAINT `FKau84tqxkyxpf0ilieooqn8h06` FOREIGN KEY (`hanger`) REFERENCES `hanger` (`id`),
  CONSTRAINT `FKi6algwl04geudnb14cot2fw7t` FOREIGN KEY (`plane`) REFERENCES `plane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_flight`
--

LOCK TABLES `post_flight` WRITE;
/*!40000 ALTER TABLE `post_flight` DISABLE KEYS */;
INSERT INTO `post_flight` VALUES (1,'root','2021-07-25 23:27:06.751000','root','2021-07-25 23:27:06.751000',1,'OFF',1,1,1);
/*!40000 ALTER TABLE `post_flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_flight`
--

DROP TABLE IF EXISTS `pre_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pre_flight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `motor` varchar(255) DEFAULT NULL,
  `laptop_battery` varchar(255) DEFAULT NULL,
  `laptop_power` varchar(255) DEFAULT NULL,
  `mission_planner` varchar(255) DEFAULT NULL,
  `plane_id` bigint NOT NULL,
  `plane` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKktf0c8pifj20l2t5xf2yb5l9d` (`plane`),
  CONSTRAINT `FKktf0c8pifj20l2t5xf2yb5l9d` FOREIGN KEY (`plane`) REFERENCES `plane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_flight`
--

LOCK TABLES `pre_flight` WRITE;
/*!40000 ALTER TABLE `pre_flight` DISABLE KEYS */;
INSERT INTO `pre_flight` VALUES (1,'khanhuma1021994@gmail.com','2021-07-25 11:04:16.534000','khanhuma1021994@gmail.com','2021-07-25 11:04:16.534000','Secured','Full Charged','ON','Start',1,1);
/*!40000 ALTER TABLE `pre_flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `employee_id` bigint DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `secret_ans1` varchar(455) DEFAULT NULL,
  `secret_ans2` varchar(455) DEFAULT NULL,
  `secret_ans3` varchar(455) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `role_name` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1010,'Admin','Admin','Admin','Admin@123.com','Admin@123',1,NULL,NULL,NULL,'1','ADMIN'),(10,'Admin@123.com','2021-07-23 11:15:46.172000','Admin@123.com','2021-07-23 11:15:46.172000','8806793322','Pilot','1994-10-02 00:00:00.000000',1011,'Huma','Female','Khan','khanhuma1021994@gmail.com','password#123',3,'huma','minu','880','1','PILOT'),(11,'Admin@123.com','2021-07-22 23:34:58.042000','Admin@123.com','2021-07-22 23:34:58.042000','9999999999','Manager','1990-01-10 00:00:00.000000',1012,'Nicolas','Male','Dsouza','nic@gmail.com','password@123',2,'nic','nic','999','1','MANAGER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waypoints`
--

DROP TABLE IF EXISTS `waypoints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waypoints` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `wapoints_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waypoints`
--

LOCK TABLES `waypoints` WRITE;
/*!40000 ALTER TABLE `waypoints` DISABLE KEYS */;
INSERT INTO `waypoints` VALUES (1,'Admin@123.com','2021-07-24 12:29:07.030000','Admin@123.com','2021-07-24 12:29:07.030000','SABER',NULL),(2,'Admin@123.com','2021-07-26 00:11:36.550000','Admin@123.com','2021-07-26 00:11:36.550000','EIXB',NULL),(3,'Admin@123.com','2021-07-26 00:44:12.285000','Admin@123.com','2021-07-26 00:44:12.285000','ECUBV',NULL);
/*!40000 ALTER TABLE `waypoints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_schedule`
--

DROP TABLE IF EXISTS `work_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_schedule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `workdate` datetime(6) DEFAULT NULL,
  `description` varchar(555) DEFAULT NULL,
  `destination_location_id` bigint NOT NULL,
  `pilot_id` bigint NOT NULL,
  `timeslot` varchar(255) DEFAULT NULL,
  `des_loc` bigint NOT NULL,
  `pilot` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKftwww7u2qtpqyhn7bpxpfouj5` (`des_loc`),
  KEY `FKbio5hrn9sepnv2odcqw8gxf5` (`pilot`),
  CONSTRAINT `FKbio5hrn9sepnv2odcqw8gxf5` FOREIGN KEY (`pilot`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKftwww7u2qtpqyhn7bpxpfouj5` FOREIGN KEY (`des_loc`) REFERENCES `destination_loc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_schedule`
--

LOCK TABLES `work_schedule` WRITE;
/*!40000 ALTER TABLE `work_schedule` DISABLE KEYS */;
INSERT INTO `work_schedule` VALUES (8,'Admin@123.com','2021-07-26 11:35:46.631000','Admin@123.com','2021-07-26 11:35:46.631000','2021-01-02 00:07:00.000000','fly with safety',1,10,'11:00-12:00',1,10);
/*!40000 ALTER TABLE `work_schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-11 15:10:46
