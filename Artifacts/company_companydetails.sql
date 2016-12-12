CREATE DATABASE  IF NOT EXISTS `Company` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `company`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `companydetails`
--

DROP TABLE IF EXISTS `companydetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companydetails` (
  `companyID` varchar(20) DEFAULT NULL,
  `companysite` varchar(50) DEFAULT NULL,
  `companydesc` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companydetails`
--

LOCK TABLES `companydetails` WRITE;
/*!40000 ALTER TABLE `companydetails` DISABLE KEYS */;
INSERT INTO `companydetails` VALUES ('100','www.Airbnb.com','Airbnb is a peer-to-peer online marketplace and homestay network enabling people to list or rent short-term lodging in residential properties, with the cost of such accommodation set by the property owner.'),('101','www.alexa.com','Alexa Internet, Inc. is a California-based company that provides commercial web traffic data and analytics. It is a wholly owned subsidiary of Amazon.com. Founded as an independent company in 1996, Alexa was acquired by Amazon in 1999.'),('103','www.bqool.com','Best Amazon Seller Software- Get fast repricing and win buy box, increase positive feedback and manage product reviews easily.'),('104','https://canary.is','Canary is a complete security system in a single device. Includes a 1080p HD camera, night vision, motion-activated recording, air quality sensors, and more.'),('105','www.channel4.com','Channel 4 is a British public-service television broadcaster that began transmission on 2 November 1982. Although largely commercially self-funded, it is ultimately publicly owned; originally a subsidiary of the Independent Broadcasting Authority.'),('106','unknown','Dato is a startup focused on creating a platform for people to build intelligent applications that use machine learning as their core technology.'),('107','www.decisyon.com','Decisyon develops a wide array of platforms that help customers unify business and operational applications for better decision making.'),('108','www.elizacorporation.com','Eliza is one of the leaders and pioneers in health engagement management solutions.'),('109','https://www.essent.eu','Essent NV, based in s-Hertogenbosch, the Netherlands, is an energy company. It is a public limited liability corporation. Essent is the largest energy company in the Netherlands.'),('110','www.flypay.co.uk','Flypay is a mobile application and payment technology company based in London.'),('111','kaplan.com','Kaplan is a global provider of educational services for individuals, schools, and businesses.');
/*!40000 ALTER TABLE `companydetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-12 12:58:16
