CREATE DATABASE  IF NOT EXISTS `stock_management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `stock_management`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: stock_management
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNaccountIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
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
  PRIMARY KEY (`CATEGORY_ID`),
  UNIQUE KEY `CATEGORY_CODE_UNIQUE` (`CATEGORY_CODE`),
  UNIQUE KEY `CATEGORY_NAME_UNIQUE` (`CATEGORY_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
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
  PRIMARY KEY (`GOODS_ID`),
  UNIQUE KEY `GOODS_CODE_UNIQUE` (`GOODS_CODE`),
  KEY `fk_goods_supplier1_idx` (`SUPPLIER_ID`),
  KEY `fk_goods_category1_idx` (`CATEGORY_ID`),
  KEY `fk_goods_producer1_idx` (`PRODUCER_ID`),
  CONSTRAINT `fk_goods_category1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`category_id`),
  CONSTRAINT `fk_goods_producer1` FOREIGN KEY (`PRODUCER_ID`) REFERENCES `producer` (`producer_id`),
  CONSTRAINT `fk_goods_supplier1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
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
  PRIMARY KEY (`PRODUCER_ID`),
  UNIQUE KEY `PRODUCER_CODE_UNIQUE` (`PRODUCER_CODE`),
  UNIQUE KEY `PRODUCER_NAME_UNIQUE` (`PRODUCER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producer`
--

LOCK TABLES `producer` WRITE;
/*!40000 ALTER TABLE `producer` DISABLE KEYS */;
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
  PRIMARY KEY (`STOCK_ID`),
  UNIQUE KEY `STOCK_CODE_UNIQUE` (`STOCK_CODE`),
  UNIQUE KEY `STOCK_NAME_UNIQUE` (`STOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
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
  PRIMARY KEY (`SUPPLIER_ID`),
  UNIQUE KEY `SUPPLIER_CODE_UNIQUE` (`SUPPLIER_CODE`),
  UNIQUE KEY `SUPPLIER_NAME_UNIQUE` (`SUPPLIER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
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



-- Dump completed on 2018-11-20 20:52:10
-- them du lieu vao bang account
insert into account 
(account_fullname,account_username,account_password,account_active)
values('Dinh Khanh Duong','duongdk','123','1');
insert into account 
(account_fullname,account_username,account_password,account_active)
values('Do Duy Mau','maudd','123','1');
insert into account 
(account_fullname,account_username,account_password,account_active)
values('Nguyen Duc Manh','manhnd','123','1');
insert into account 
(account_fullname,account_username,account_password,account_active)
values('Vu Van','Vanv','123','1');

-- them du lieu bang category
insert into category
(category_code,category_name)
values('CL01','Dien thoai');
insert into category
(category_code,category_name)
values('CL02','Thuc pham');
insert into category
(category_code,category_name)
values('CL03','Dien may');
insert into category
(category_code,category_name)
values('CL04','Do gia dung');
insert into category
(category_code,category_name)
values('CL05','May tinh');
-- thm du lieu bang producer
insert into producer
(producer_code,producer_name)
values('SX01','VinGroup');
insert into producer
(producer_code,producer_name)
values('SX02','Apple');
insert into producer
(producer_code,producer_name)
values('SX03','SamSung');
insert into producer
(producer_code,producer_name)
values('SX04','Lock&Lock');
insert into producer
(producer_code,producer_name)
values('SX05','Sony');

-- thm du lieu bang supplier
insert into supplier
(supplier_code,supplier_name)
values('CC01','Dien may xanh');
insert into supplier
(supplier_code,supplier_name)
values('CC02','The gioi di dong');
insert into supplier
(supplier_code,supplier_name)
values('CC03','Dien may Tran Anh');
insert into supplier
(supplier_code,supplier_name)
values('CC04','Eco mart');
insert into supplier
(supplier_code,supplier_name)
values('CC05','Vin mart');
-- them du lieu bang stock
insert into stock
(stock_code,stock_name)
values('K01','Kho Dien thoai');
insert into stock
(stock_code,stock_name)
values('K02','Kho Dien may');
insert into stock
(stock_code,stock_name)
values('K03','Kho Thuc pham');
insert into stock
(stock_code,stock_name)
values('K04','Kho Gia dung');
insert into stock
(stock_code,stock_name)
values('K05','Kho May tinh');
-- them du lieu bang goods
insert into goods
(supplier_id,category_id,producer_id,goods_code,goods_name,goods_new_brand,goods_lotnumber,goods_unit,goods_feature,goods_expiration,goods_import_price,goods_export_price)
values(1,1,2,'HH01','Iphone X',null,'L01','chiec','4inch',null,20000000,22000000);
insert into goods
(supplier_id,category_id,producer_id,goods_code,goods_name,goods_new_brand,goods_lotnumber,goods_unit,goods_feature,goods_expiration,goods_import_price,goods_export_price)
values(1,1,2,'HH02','Iphone 6',null,'L01','chiec','4inch',null,15000000,18000000);
insert into goods
(supplier_id,category_id,producer_id,goods_code,goods_name,goods_new_brand,goods_lotnumber,goods_unit,goods_feature,goods_expiration,goods_import_price,goods_export_price)
values(1,1,3,'HH03','Galaxy Note 9',null,'L02','chiec','9inch',null,20000000,22000000);
insert into goods
(supplier_id,category_id,producer_id,goods_code,goods_name,goods_new_brand,goods_lotnumber,goods_unit,goods_feature,goods_expiration,goods_import_price,goods_export_price)
values(1,1,4,'HH04','Am sieu toc',null,'L02','chiec',null,null,2000000,2200000);
insert into goods
(supplier_id,category_id,producer_id,goods_code,goods_name,goods_new_brand,goods_lotnumber,goods_unit,goods_feature,goods_expiration,goods_import_price,goods_export_price)
values(1,1,5,'HH05','TV LED',null,'L01','chiec','65inch',null,40000000,45000000);