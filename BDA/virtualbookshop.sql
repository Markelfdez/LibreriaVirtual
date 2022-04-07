-- MySQL dump 10.13  Distrib 5.7.29, for Win64 (x86_64)
--
-- Host: localhost    Database: virtualbookshop
-- ------------------------------------------------------
-- Server version	5.7.29-log

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `username` varchar(20) NOT NULL,
  `yearsWorked` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('Alexito',45),('Frankcisko',4),('hhellyeahh',12),('MarKKus',37);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `codAu` varchar(20) NOT NULL,
  `nameA` varchar(20) NOT NULL,
  `surname` varchar(15) NOT NULL,
  `birthDate` date NOT NULL,
  `deathDate` date DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`codAu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES ('a01','Eiichiro','Oda','1975-01-01',NULL,1),('a02','William','Shakespeare','1564-04-23','1616-05-03',1),('a03','Jules','Verne','1828-02-08','1905-03-24',1),('a04','Stephen','King','1947-09-21',NULL,1),('a05','Joanne','Rowling','1965-07-31',NULL,1);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `isbn` varchar(20) NOT NULL DEFAULT '',
  `title` varchar(50) NOT NULL DEFAULT '',
  `descrip` varchar(500) DEFAULT NULL,
  `editorial` varchar(20) NOT NULL,
  `publiDate` date NOT NULL,
  `price` float NOT NULL DEFAULT '0',
  `offer` tinyint(1) DEFAULT NULL,
  `discountRate` int(11) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `codG` int(11) NOT NULL,
  `codAu` varchar(20) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`isbn`),
  KEY `codG` (`codG`),
  KEY `codAu` (`codAu`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`codG`) REFERENCES `genre` (`codG`) ON DELETE CASCADE,
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`codAu`) REFERENCES `author` (`codAu`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('978-00-03252-45-3','Romeo y Julieta','Romeo y Julieta trata de la historia de amor imposible entre dos jóvenes pertenecientes a dos familias de Verona enfrentadas desde tiempos inmemoriales: los Montesco y los Capuleto. Romeo Montesco conoce a la bella dama Julieta Capuleto en una fiesta y ambos se enamoran perdidamente el uno del otro.','Anaya','1595-01-29',11.5,0,NULL,10,10,'a02',1),('978-88-69183-15-7','Harry Potter y la Piedra Filosofal','Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y el insoportable primo Dudley. Harry se siente muy triste y solo, hasta que un buen día recibe una carta que cambiará su vida para siempre. En ella le comunican que ha sido aceptado como alumno en el Colegio Hogwarts de Magia.','Salamandra','1997-06-26',14.25,1,10,50,3,'a05',1),('978-89-25285-64-1','ROMANCE DAWN-El amanecer de una aventura','Primer tomo del manga One Piece.','Shueisha','1999-10-20',6.6,0,NULL,67,9,'a01',1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `codG` int(11) NOT NULL,
  `nameG` varchar(40) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`codG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Action and Adventure',1),(2,'Detective and Mystery',1),(3,'Fantasy',1),(4,'Historical Fiction',1),(5,'Horror',1),(6,'Literary Fiction',1),(7,'Romance',1),(8,'Science Fiction',1),(9,'Manga',1),(10,'Tragedia',1);
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `username` varchar(20) NOT NULL,
  `name` varchar(15) NOT NULL,
  `surname` varchar(15) NOT NULL,
  `address` varchar(20) NOT NULL,
  `phone` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `accountNumber` varchar(30) NOT NULL,
  `preferencesAuthor` varchar(20) DEFAULT NULL,
  `preferencesGenre` varchar(20) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('Carmensita','Carmen','Pascual','C. San Ignacio',620825173,'pascucarmen@gmail.com','ES02 7604 4532 87 1234567856',NULL,NULL,1),('OmenGatito','Unai','Zuluaga','C. San Juan',689854406,'omengatito@gmail.com','ES77 7674 4532 45 1234567856',NULL,NULL,1),('OTPBreach','Unai','Bonilla','C. Santutxu',634431891,'unaibonilla@gmail.com','ES79 7674 4532 45 1234556344',NULL,NULL,1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `isbn` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `datePurchase` date NOT NULL,
  `cant` int(11) NOT NULL,
  PRIMARY KEY (`isbn`,`username`),
  KEY `username` (`username`),
  CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`) ON DELETE CASCADE,
  CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES ('978-00-03252-45-3','OmenGatito','2022-02-14',1),('978-89-25285-64-1','Carmensita','2022-04-05',5),('978-89-25285-64-1','OTPBreach','2022-06-06',2);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `passwd` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Alexito','AlexAdmin'),('Carmensita','CarmenMember'),('Frankcisko','FranAdmin'),('hhellyeahh','LeireAdmin'),('MarKKus','MarkelAdmin'),('OmenGatito','ZuluMember'),('OTPBreach','BonillaMember');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07  8:36:30
