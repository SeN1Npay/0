/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.11.13-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 1208-1    Database: Bikshanov
-- ------------------------------------------------------
-- Server version	10.11.13-MariaDB-0+deb12u1.astra3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `automobiles`
--

DROP TABLE IF EXISTS `automobiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `automobiles` (
  `idautomobile` int(11) NOT NULL AUTO_INCREMENT,
  `idcustomer` int(11) NOT NULL,
  `idmodel` int(11) NOT NULL,
  `vin` varchar(17) NOT NULL,
  `registrationnumber` varchar(20) NOT NULL,
  `productionyear` int(11) NOT NULL,
  `photolink` varchar(200) NOT NULL,
  PRIMARY KEY (`idautomobile`),
  KEY `idcustomer` (`idcustomer`),
  KEY `idmodel` (`idmodel`),
  CONSTRAINT `automobiles_customers_FK` FOREIGN KEY (`idcustomer`) REFERENCES `customers` (`idcustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `automobiles_models_FK` FOREIGN KEY (`idmodel`) REFERENCES `models` (`idmodel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobiles`
--

LOCK TABLES `automobiles` WRITE;
/*!40000 ALTER TABLE `automobiles` DISABLE KEYS */;
INSERT INTO `automobiles` VALUES
(3,3,3,'TEST0000000000003','А103АА24',2020,'photos/car3.jpg'),
(4,4,4,'TEST0000000000004','А104АА24',2017,'photos/car4.jpg'),
(5,5,5,'TEST0000000000005','А105АА24',2021,'photos/car5.jpg'),
(6,6,6,'TEST0000000000006','А106АА24',2020,'photos/car6.jpg'),
(7,7,7,'TEST0000000000007','А107АА24',2016,'photos/car7.jpg'),
(8,8,8,'TEST0000000000008','А108АА24',2018,'photos/car8.jpg'),
(9,9,9,'TEST0000000000009','А109АА24',2015,'photos/car9.jpg'),
(10,10,10,'TEST0000000000010','А110АА24',2022,'photos/car10.jpg'),
(11,10,10,'JTDKB20U793012345','A123BC154',2018,'/photos/car1.jpg'),
(12,10,10,'JTDKB20U793012345','A123BC154',2018,'/photos/car1.jpg');
/*!40000 ALTER TABLE `automobiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `brands` (
  `idbrand` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`idbrand`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES
(2,'Kia'),
(3,'Hyundai'),
(4,'Renault'),
(5,'Volkswagen'),
(6,'Skoda'),
(7,'Nissan'),
(8,'Ford'),
(9,'Chevrolet'),
(10,'Lada'),
(11,'Toyota'),
(12,'Toyota'),
(13,'SRT');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`idcustomer`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `customers_users_FK` FOREIGN KEY (`iduser`) REFERENCES `users` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES
(2,2,'79040000002'),
(3,3,'79040000003'),
(4,4,'79040000004'),
(5,5,'79040000005'),
(6,6,'79040000006'),
(7,7,'79040000007'),
(8,8,'79040000008'),
(9,9,'79040000009'),
(10,10,'79040000010');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `idlog` int(11) NOT NULL AUTO_INCREMENT,
  `method` varchar(30) NOT NULL,
  `recordtype` varchar(50) NOT NULL,
  `recordtext` varchar(200) NOT NULL,
  `actiondate` date NOT NULL,
  `actiontime` varchar(8) NOT NULL,
  PRIMARY KEY (`idlog`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES
(1,'INSERT','Ремонт','Добавлен ремонт 1','2026-09-01','09:00:00'),
(2,'INSERT','Ремонт','Добавлен ремонт 2','2026-09-02','09:30:00'),
(3,'INSERT','Ремонт','Добавлен ремонт 3','2026-09-03','10:00:00'),
(4,'INSERT','Ремонт','Добавлен ремонт 4','2026-09-04','10:30:00'),
(5,'INSERT','Ремонт','Добавлен ремонт 5','2026-09-05','11:00:00'),
(6,'INSERT','Ремонт','Добавлен ремонт 6','2026-09-06','11:30:00'),
(7,'INSERT','Ремонт','Добавлен ремонт 7','2026-09-07','12:00:00'),
(8,'INSERT','Ремонт','Добавлен ремонт 8','2026-09-08','12:30:00'),
(9,'INSERT','Ремонт','Добавлен ремонт 9','2026-09-09','13:00:00'),
(10,'INSERT','Ремонт','Добавлен ремонт 10','2026-09-10','13:30:00'),
(11,'SELECT','Пользователи','Просмотр данных таблицы','2026-11-12','08:53:02'),
(12,'SELECT','Приемщики','Просмотр данных таблицы','2026-11-12','08:53:27'),
(13,'SELECT','Приемщики','Просмотр данных таблицы','2026-11-12','09:06:22'),
(14,'SELECT','Зарплаты','Просмотр данных таблицы','2026-11-12','09:06:33'),
(15,'SELECT','Клиенты','Просмотр данных таблицы','2026-11-12','09:06:41'),
(16,'SELECT','Менеджеры','Просмотр данных таблицы','2026-11-12','09:06:46'),
(17,'SELECT','Механики','Просмотр данных таблицы','2026-11-12','09:06:53'),
(18,'SELECT','Зарплаты','Просмотр данных таблицы','2026-11-12','09:10:15'),
(19,'SELECT','Приемщики','Просмотр данных таблицы','2026-11-12','09:10:36'),
(20,'SELECT','Механики','Просмотр данных таблицы','2026-11-12','09:11:01'),
(21,'SELECT','Приемщики','Просмотр данных таблицы','2026-11-12','09:11:56'),
(22,'SELECT','Марки','Просмотр данных таблицы','2026-11-12','09:12:04'),
(23,'SELECT','Модели','Просмотр данных таблицы','2026-11-12','09:12:10'),
(24,'SELECT','Автомобили','Просмотр данных таблицы','2026-11-12','09:12:17'),
(25,'SELECT','Посты ремонта','Просмотр данных таблицы','2026-11-12','09:12:22'),
(26,'SELECT','Ремонты','Просмотр данных таблицы','2026-11-12','09:12:30'),
(27,'SELECT','Услуги','Просмотр данных таблицы','2026-11-12','09:12:38'),
(28,'SELECT','Услуги ремонта','Просмотр данных таблицы','2026-11-12','09:12:44'),
(29,'SELECT','Услуги ремонта','Просмотр данных таблицы','2026-11-12','09:12:44'),
(30,'SELECT','Запчасти','Просмотр данных таблицы','2026-11-12','09:12:47'),
(31,'SELECT','Запчасти ремонта','Просмотр данных таблицы','2026-11-12','09:12:53'),
(32,'MAIL','Письма','Рассылка всем пользователям, отправлено писем: 9','2026-11-12','09:25:26'),
(33,'MAIL','Письма','Рассылка с файлом всем пользователям, отправлено писем: 0','2026-11-12','09:30:39'),
(34,'MAIL','Письма','Рассылка с файлом всем пользователям, отправлено писем: 0','2026-11-12','09:32:38'),
(35,'MAIL','Письма','Письмо пользователю id=8','2026-11-12','09:33:01'),
(36,'MAIL','Письма','Письмо пользователю id=8','2026-11-12','09:33:15'),
(37,'MAIL','Письма','Рассылка с файлом всем пользователям, отправлено писем: 0','2026-11-12','09:34:18'),
(38,'MAIL','Письма','Письмо пользователю id=8','2026-11-12','09:34:27'),
(39,'MAIL','Письма','Письмо пользователю id=8','2026-11-18','08:05:33'),
(40,'MAIL','Письма','Рассылка всем пользователям, отправлено писем: 9','2026-11-18','08:05:56'),
(41,'MAIL','Письма','Рассылка всем пользователям, отправлено писем: 9','2026-11-18','08:07:29');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `idmanager` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idmanager`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `managers_users_FK` FOREIGN KEY (`iduser`) REFERENCES `users` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mechanics`
--

DROP TABLE IF EXISTS `mechanics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `mechanics` (
  `idmechanic` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idmechanic`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `mechanics_users_FK` FOREIGN KEY (`iduser`) REFERENCES `users` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanics`
--

LOCK TABLES `mechanics` WRITE;
/*!40000 ALTER TABLE `mechanics` DISABLE KEYS */;
INSERT INTO `mechanics` VALUES
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);
/*!40000 ALTER TABLE `mechanics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `models` (
  `idmodel` int(11) NOT NULL AUTO_INCREMENT,
  `idbrand` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`idmodel`),
  KEY `idbrand` (`idbrand`),
  CONSTRAINT `models_brands_FK` FOREIGN KEY (`idbrand`) REFERENCES `brands` (`idbrand`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` VALUES
(2,2,'Rio'),
(3,3,'Solaris'),
(4,4,'Logan'),
(5,5,'Polo'),
(6,6,'Octavia'),
(7,7,'Almera'),
(8,8,'Focus'),
(9,9,'Aveo'),
(10,10,'Vesta');
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairbays`
--

DROP TABLE IF EXISTS `repairbays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `repairbays` (
  `idbay` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `purpose` varchar(100) NOT NULL,
  PRIMARY KEY (`idbay`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairbays`
--

LOCK TABLES `repairbays` WRITE;
/*!40000 ALTER TABLE `repairbays` DISABLE KEYS */;
INSERT INTO `repairbays` VALUES
(2,2,'Обслуживание системы впуска'),
(3,3,'Обслуживание системы зажигания'),
(4,4,'Замена тормозных колодок'),
(5,5,'Замена тормозных дисков'),
(6,6,'Обслуживание аккумуляторов'),
(7,7,'Обслуживание системы охлаждения'),
(8,8,'Ремонт подвески'),
(9,9,'Обслуживание ременного привода'),
(10,10,'Обслуживание стеклоочистителей'),
(11,1,'Диагностика');
/*!40000 ALTER TABLE `repairbays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairparts`
--

DROP TABLE IF EXISTS `repairparts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `repairparts` (
  `idrepairpart` int(11) NOT NULL AUTO_INCREMENT,
  `idrepair` int(11) NOT NULL,
  `idsparepart` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`idrepairpart`),
  KEY `idrepair` (`idrepair`),
  KEY `idsparepart` (`idsparepart`),
  CONSTRAINT `repairparts_repairs_FK` FOREIGN KEY (`idrepair`) REFERENCES `repairs` (`idrepair`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `repairparts_spareparts_FK` FOREIGN KEY (`idsparepart`) REFERENCES `spareparts` (`idsparepart`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairparts`
--

LOCK TABLES `repairparts` WRITE;
/*!40000 ALTER TABLE `repairparts` DISABLE KEYS */;
INSERT INTO `repairparts` VALUES
(3,3,3,4),
(4,4,4,1),
(5,5,5,2),
(6,6,6,1),
(7,7,7,1),
(8,8,8,2),
(11,9,9,1);
/*!40000 ALTER TABLE `repairparts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairs`
--

DROP TABLE IF EXISTS `repairs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `repairs` (
  `idrepair` int(11) NOT NULL AUTO_INCREMENT,
  `idautomobile` int(11) NOT NULL,
  `idmechanic` int(11) NOT NULL,
  `idadvisor` int(11) NOT NULL,
  `idbay` int(11) NOT NULL,
  `acceptancedate` date NOT NULL,
  `completiondate` date NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`idrepair`),
  KEY `idautomobile` (`idautomobile`),
  KEY `idmechanic` (`idmechanic`),
  KEY `idadvisor` (`idadvisor`),
  KEY `idbay` (`idbay`),
  CONSTRAINT `repairs_automobiles_FK` FOREIGN KEY (`idautomobile`) REFERENCES `automobiles` (`idautomobile`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `repairs_mechanics_FK` FOREIGN KEY (`idmechanic`) REFERENCES `mechanics` (`idmechanic`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `repairs_repairbays_FK` FOREIGN KEY (`idbay`) REFERENCES `repairbays` (`idbay`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `repairs_serviceadvisors_FK` FOREIGN KEY (`idadvisor`) REFERENCES `serviceadvisors` (`idadvisor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairs`
--

LOCK TABLES `repairs` WRITE;
/*!40000 ALTER TABLE `repairs` DISABLE KEYS */;
INSERT INTO `repairs` VALUES
(3,3,3,4,3,'2026-09-03','2026-09-04','Завершен'),
(4,4,4,5,4,'2026-09-04','2026-09-05','Завершен'),
(5,5,5,6,5,'2026-09-05','2026-09-06','Завершен'),
(6,6,6,7,6,'2026-09-06','2026-09-07','Завершен'),
(7,7,7,8,7,'2026-09-07','2026-09-08','Завершен'),
(8,8,8,9,8,'2026-09-08','2026-09-09','Завершен'),
(9,9,9,10,9,'2026-09-09','2026-09-10','Завершен');
/*!40000 ALTER TABLE `repairs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairservices`
--

DROP TABLE IF EXISTS `repairservices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `repairservices` (
  `idrepairservice` int(11) NOT NULL AUTO_INCREMENT,
  `idrepair` int(11) NOT NULL,
  `idservice` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`idrepairservice`),
  KEY `idrepair` (`idrepair`),
  KEY `idservice` (`idservice`),
  CONSTRAINT `repairservices_repairs_FK` FOREIGN KEY (`idrepair`) REFERENCES `repairs` (`idrepair`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `repairservices_services_FK` FOREIGN KEY (`idservice`) REFERENCES `services` (`idservice`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairservices`
--

LOCK TABLES `repairservices` WRITE;
/*!40000 ALTER TABLE `repairservices` DISABLE KEYS */;
INSERT INTO `repairservices` VALUES
(3,3,3,1),
(4,4,4,1),
(5,5,5,1),
(6,6,6,1),
(7,7,7,1),
(8,8,8,1),
(11,9,9,9);
/*!40000 ALTER TABLE `repairservices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaries`
--

DROP TABLE IF EXISTS `salaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `salaries` (
  `idsalary` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `periodstart` date NOT NULL,
  `periodend` date NOT NULL,
  `amount` int(11) NOT NULL,
  `paymentdate` date NOT NULL,
  PRIMARY KEY (`idsalary`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `salaries_users_FK` FOREIGN KEY (`iduser`) REFERENCES `users` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaries`
--

LOCK TABLES `salaries` WRITE;
/*!40000 ALTER TABLE `salaries` DISABLE KEYS */;
INSERT INTO `salaries` VALUES
(2,2,'2026-08-01','2026-08-31',78000,'2026-09-05'),
(3,3,'2026-08-01','2026-08-31',82000,'2026-09-05'),
(4,4,'2026-08-01','2026-08-31',70000,'2026-09-05'),
(5,5,'2026-08-01','2026-08-31',76000,'2026-09-05'),
(6,6,'2026-08-01','2026-08-31',72000,'2026-09-05'),
(7,7,'2026-08-01','2026-08-31',80000,'2026-09-05'),
(8,8,'2026-08-01','2026-08-31',74000,'2026-09-05'),
(9,9,'2026-08-01','2026-08-31',79000,'2026-09-05'),
(10,10,'2026-08-01','2026-08-31',73000,'2026-09-05');
/*!40000 ALTER TABLE `salaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceadvisors`
--

DROP TABLE IF EXISTS `serviceadvisors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `serviceadvisors` (
  `idadvisor` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idadvisor`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `serviceadvisors_users_FK` FOREIGN KEY (`iduser`) REFERENCES `users` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceadvisors`
--

LOCK TABLES `serviceadvisors` WRITE;
/*!40000 ALTER TABLE `serviceadvisors` DISABLE KEYS */;
INSERT INTO `serviceadvisors` VALUES
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);
/*!40000 ALTER TABLE `serviceadvisors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `idservice` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`idservice`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES
(2,'Замена воздушного фильтра',500),
(3,'Замена комплекта свечей зажигания',1200),
(4,'Замена передних тормозных колодок',1800),
(5,'Замена двух передних тормозных дисков',2500),
(6,'Замена аккумулятора',700),
(7,'Замена охлаждающей жидкости',1500),
(8,'Замена двух передних амортизаторов',4000),
(9,'Замена приводного ремня',1300),
(10,'Замена комплекта щеток стеклоочистителя',300),
(11,'Замена масла',1500);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spareparts`
--

DROP TABLE IF EXISTS `spareparts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `spareparts` (
  `idsparepart` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `article` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`idsparepart`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spareparts`
--

LOCK TABLES `spareparts` WRITE;
/*!40000 ALTER TABLE `spareparts` DISABLE KEYS */;
INSERT INTO `spareparts` VALUES
(2,'Воздушный фильтр для Rio','PART002',900,18),
(3,'Свеча зажигания для Solaris','PART003',500,40),
(4,'Комплект передних колодок для Logan','PART004',2800,12),
(5,'Передний тормозной диск для Polo','PART005',3500,16),
(6,'Аккумулятор для Octavia','PART006',8000,10),
(7,'Охлаждающая жидкость 10 л','PART007',2400,15),
(8,'Передний амортизатор для Focus','PART008',4500,14),
(9,'Приводной ремень для Aveo','PART009',1200,20),
(10,'Комплект щеток для Vesta','PART010',1500,25),
(11,'Масляный фильтр','OF-1234',500,20);
/*!40000 ALTER TABLE `spareparts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(30) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `middlename` varchar(30) NOT NULL,
  `birthdate` date NOT NULL,
  `employmentdate` date NOT NULL,
  `passport` varchar(20) NOT NULL,
  `snils` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `photolink` varchar(200) NOT NULL,
  `login` varchar(30) NOT NULL,
  `passwordhash` varchar(64) NOT NULL,
  `status` varchar(30) NOT NULL,
  `registrationcode` varchar(30) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES
(2,'Борисов','Сергей','Петрович','1987-03-20','2016-03-01','0000 000002','000-000-002 00','user2@example.com','photos/user2.jpg','user2','4fabd41a170ff3b93f2da8f37698a0ee55e9793c284e37e66b040503064e2489','Активен','REG002'),
(3,'Власов','Михаил','Андреевич','1989-05-10','2017-04-03','0000 000003','000-000-003 00','user3@example.com','photos/user3.jpg','user3','0e7ead277db4eea03dfd600d7f4caa2c7fd834e65331a7c5eca9304cb3118d49','Активен','REG003'),
(4,'Гусева','Елена','Олеговна','1990-07-18','2018-05-07','0000 000004','000-000-004 00','user4@example.com','photos/user4.jpg','user4','9e1b0fb48d797760d1fd4ad250833595c892ac7f6536a92100c29f723a220a6f','Активен','REG004'),
(5,'Демин','Дмитрий','Сергеевич','1991-09-12','2019-06-03','0000 000005','000-000-005 00','user5@example.com','photos/user5.jpg','user5','a805bc7e21abfefd0cb2f841bc7a2582cb92514bc55d66a5902104263cc44830','Активен','REG005'),
(6,'Егорова','Марина','Викторовна','1992-11-25','2020-07-01','0000 000006','000-000-006 00','user6@example.com','photos/user6.jpg','user6','20b236416e77f7c228c34357a7af8d58b0574f32d34ad384e7f27a15d7a1c159','Активен','REG006'),
(7,'Жуков','Алексей','Алексеевич','1993-02-14','2021-08-02','0000 000007','000-000-007 00','user7@example.com','photos/user7.jpg','user7','cd9c46741c2ed19f9aecd8d044b4c21999f67439d35981ad963752256f5820d1','Активен','REG007'),
(8,'Зорина','Ольга','Игоревна','1994-04-22','2022-09-01','0000 000008','000-000-008 00','dimabikshanov@yandex.ru','photos/user8.jpg','user8','173eff6f5595eddf25b9417ef1b4c7e2f457aa75a382eada2567014aa6b43c85','Активен','REG008'),
(9,'Исаев','Павел','Николаевич','1995-06-08','2023-10-02','0000 000009','000-000-009 00','user9@example.com','photos/user9.jpg','user9','14ab9a652ac8f20ee6704ccaeba26d6d0752748e0b6fa5860eae85cf263bbde9','Активен','REG009'),
(10,'Крылова','Ирина','Петровна','1996-08-30','2024-11-01','0000 000010','000-000-010 00','user10@example.com','photos/user10.jpg','user10','68c2ccb3141e6acefa61746283a26e344dde828d0a8cbb3fbee62874b91f5728','Активен','REG010'),
(11,'Петров','Петр','Петрович','2000-10-10','2020-01-01','3123','123213','213213','231233','213213','21321','123123','3213'),
(12,'Петров','Петр','Петрович','2000-10-10','2020-01-01','3123','123213','213213','231233','213213','21321','123123','3213'),
(13,'Иванов','Петр','Петрович','2000-10-10','2020-01-01','3123','123213','213213','231233','213213','21321','123123','3213'),
(14,'Иванов','Петр','Петрович','2000-10-10','2020-01-01','3123','123213','213213','231233','213213','21321','123123','3213'),
(18,'Иванов','Кирилл','Петрович','2000-10-10','2020-01-01','3123','123213','213213','231233','213213','21321','123123','3213'),
(19,'Иванов','Кирилл','Олегович','2000-10-10','2020-01-01','3123','123213','213213','231233','213213','21321','123123','3213'),
(20,'Иванов','Кирилл','Олегович','2000-10-10','2020-01-01','3123','123213','213213','231233','213213','21321','123123','3213');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'Bikshanov'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-18  8:55:19
