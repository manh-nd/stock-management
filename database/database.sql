CREATE DATABASE  IF NOT EXISTS `stock_management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `stock_management`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stock_management
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `ACCOUNT_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ACCOUNT_FULLNAME` varchar(40) NOT NULL,
  `ACCOUNT_USERNAME` varchar(16) NOT NULL,
  `ACCOUNT_PASSWORD` varchar(16) NOT NULL,
  `ACCOUNT_ACTIVE` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ACCOUNT_ID`),
  UNIQUE KEY `ACCOUNT_USERNAME_UNIQUE` (`ACCOUNT_USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Dinh Khanh Duong','duongdk','123',1),(2,'Do Duy Mau','maudd','123',1),(3,'Nguyen Duc Manh','manhnd','123',1),(4,'Vu Van','Vanv','123',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `CATEGORY_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `CATEGORY_CODE` varchar(6) NOT NULL,
  `CATEGORY_NAME` varchar(45) NOT NULL,
  `CATEGORY_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`CATEGORY_ID`),
  UNIQUE KEY `CATEGORY_CODE_UNIQUE` (`CATEGORY_CODE`),
  UNIQUE KEY `CATEGORY_NAME_UNIQUE` (`CATEGORY_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'CL01','Điện thoại',1),(2,'CL02','Thực phẩm',1),(3,'CL03','Điện máy',1),(4,'CL04','Gia dụng',1),(5,'CL05','Nội thất',1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `goods` (
  `GOODS_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `SUPPLIER_ID` int(11) unsigned NOT NULL,
  `CATEGORY_ID` int(11) unsigned NOT NULL,
  `PRODUCER_ID` int(11) unsigned NOT NULL,
  `GOODS_CODE` varchar(8) NOT NULL,
  `GOODS_NAME` varchar(64) NOT NULL,
  `GOODS_NEW_BRAND` tinyint(1) DEFAULT '0',
  `GOODS_LOTNUMBER` varchar(16) DEFAULT NULL,
  `GOODS_UNIT` varchar(16) NOT NULL,
  `GOODS_FEATURE` varchar(45) DEFAULT NULL,
  `GOODS_EXPIRATION` date DEFAULT NULL,
  `GOODS_IMPORT_PRICE` int(11) unsigned NOT NULL DEFAULT '0',
  `GOODS_EXPORT_PRICE` int(11) unsigned NOT NULL DEFAULT '0',
  `GOODS_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`GOODS_ID`),
  UNIQUE KEY `GOODS_CODE_UNIQUE` (`GOODS_CODE`),
  KEY `fk_goods_supplier1_idx` (`SUPPLIER_ID`),
  KEY `fk_goods_category1_idx` (`CATEGORY_ID`),
  KEY `fk_goods_producer1_idx` (`PRODUCER_ID`),
  CONSTRAINT `fk_goods_category1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`category_id`),
  CONSTRAINT `fk_goods_producer1` FOREIGN KEY (`PRODUCER_ID`) REFERENCES `producer` (`producer_id`),
  CONSTRAINT `fk_goods_supplier1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,1,1,2,'HH01','iPhone X',0,'L01','Chiếc','5.7 Inch','2018-12-12',20000000,22000000,NULL),(2,1,1,2,'HH02','Iphone 6',0,'L01','chiec','4inch','2018-12-22',15000000,18000000,NULL),(3,1,1,3,'HH03','Galaxy Note 9',0,'L02','chiec','9inch','2019-12-01',20000000,22000000,NULL),(4,1,4,4,'HH04','Ấm siêu tốc Lock v2.1',0,'L02','Chiếc','','2019-12-30',2000000,2200000,NULL),(5,1,1,5,'HH05','TV Sony  OLED 65 Inch 2018',1,'L01','Chiếc','65 Inch','2018-01-12',40000000,45000000,NULL);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inventory` (
  `INVENTORY_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `GOODS_ID` int(11) unsigned NOT NULL,
  `STOCK_ID` int(11) unsigned NOT NULL,
  `INVENTORY_QUANTITY` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`INVENTORY_ID`),
  UNIQUE KEY `GOODS_ID_UNIQUE` (`GOODS_ID`,`STOCK_ID`),
  KEY `fk_inventory_goods_idx` (`GOODS_ID`),
  KEY `fk_inventory_stock1_idx` (`STOCK_ID`),
  CONSTRAINT `fk_inventory_goods` FOREIGN KEY (`GOODS_ID`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_inventory_stock1` FOREIGN KEY (`STOCK_ID`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,1,1,96),(2,2,1,100),(3,3,1,69),(4,4,4,43),(5,5,2,12);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producer`
--

DROP TABLE IF EXISTS `producer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producer` (
  `PRODUCER_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PRODUCER_CODE` varchar(6) NOT NULL,
  `PRODUCER_NAME` varchar(45) NOT NULL,
  `PRODUCER_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`PRODUCER_ID`),
  UNIQUE KEY `PRODUCER_CODE_UNIQUE` (`PRODUCER_CODE`),
  UNIQUE KEY `PRODUCER_NAME_UNIQUE` (`PRODUCER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producer`
--

LOCK TABLES `producer` WRITE;
/*!40000 ALTER TABLE `producer` DISABLE KEYS */;
INSERT INTO `producer` VALUES (1,'SX01','VinGroup',1),(2,'SX02','Apple',1),(3,'SX03','SamSung',1),(4,'SX04','Lock&Lock',1),(5,'SX05','Sony',1);
/*!40000 ALTER TABLE `producer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stock` (
  `STOCK_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(6) NOT NULL,
  `STOCK_NAME` varchar(45) NOT NULL,
  `STOCK_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`STOCK_ID`),
  UNIQUE KEY `STOCK_CODE_UNIQUE` (`STOCK_CODE`),
  UNIQUE KEY `STOCK_NAME_UNIQUE` (`STOCK_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,'K01','Kho điện thoại',1),(2,'K02','Kho điện máy',1),(3,'K03','Kho thực phẩm',1),(4,'K04','Kho gia dụng',1),(5,'K05','Kho nội thất',1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier` (
  `SUPPLIER_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `SUPPLIER_CODE` varchar(6) NOT NULL,
  `SUPPLIER_NAME` varchar(45) NOT NULL,
  `SUPPLIER_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`SUPPLIER_ID`),
  UNIQUE KEY `SUPPLIER_CODE_UNIQUE` (`SUPPLIER_CODE`),
  UNIQUE KEY `SUPPLIER_NAME_UNIQUE` (`SUPPLIER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'CC01','Điện máy xanh',1),(2,'CC02','Thế giới di động',1),(3,'CC03','Điện máy Trần Anh',1),(4,'CC04','Eco mart',1),(5,'CC05','Vin mart',1);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-26 17:48:18
