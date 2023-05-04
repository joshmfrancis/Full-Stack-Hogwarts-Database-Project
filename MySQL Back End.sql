CREATE DATABASE  IF NOT EXISTS `csc315finalproject` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `csc315finalproject`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: csc315finalproject
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `CourseID` int NOT NULL,
  `CourseName` varchar(45) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `RoomNumber` varchar(45) DEFAULT NULL,
  `Professor_ProfessorID` int NOT NULL,
  `Subject_SubjectID` int NOT NULL,
  PRIMARY KEY (`CourseID`),
  KEY `fk_Course_Professor1_idx` (`Professor_ProfessorID`),
  KEY `fk_Course_Subject1_idx` (`Subject_SubjectID`),
  CONSTRAINT `fk_Course_Professor1` FOREIGN KEY (`Professor_ProfessorID`) REFERENCES `professor` (`ProfessorID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Course_Subject1` FOREIGN KEY (`Subject_SubjectID`) REFERENCES `subject` (`SubjectID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Potions 123','2023-09-01','2024-06-30','Hogwarts Castle Room 5',2598,600),(2,'Charms 312','2023-09-01','2024-06-30','Hogwarts Castle Room 15',6397,246),(3,'Transfiguration 345','2023-09-01','2024-06-30','Hogwarts Castle Room 4532',1243,600),(4,'History of Magic 201','2023-09-01','2024-06-30','Hogwarts Castle Room 234',8236,823),(5,'Defense Against the Dark Arts 403','2023-09-01','2024-06-30','Hogwarts Castle Room 56',4759,600),(6,'Divination 432','2023-09-01','2024-06-30','Hogwarts Castle Room 87',3621,713),(7,'Herbology 134','2023-09-01','2024-06-30','Greenhouse 3',9887,405),(8,'Care of Magical Creatures 123','2023-09-01','2024-06-30','Forbidden Forest Clearing',5643,509),(9,'Ancient Runes 234','2023-09-01','2024-06-30','Hogwarts Castle Room 11',3087,823),(10,'Astronomy 101','2023-09-01','2024-06-30','Observatorium',7209,128);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrolls`
--

DROP TABLE IF EXISTS `enrolls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrolls` (
  `Student_StudentID` int NOT NULL,
  `Course_CourseID` int NOT NULL,
  `DateOfEnrollment` date DEFAULT NULL,
  `EnrollmentStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Student_StudentID`,`Course_CourseID`),
  KEY `fk_Student_has_Course_Course1_idx` (`Course_CourseID`),
  KEY `fk_Student_has_Course_Student_idx` (`Student_StudentID`),
  CONSTRAINT `fk_Student_has_Course_Course1` FOREIGN KEY (`Course_CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Student_has_Course_Student` FOREIGN KEY (`Student_StudentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrolls`
--

LOCK TABLES `enrolls` WRITE;
/*!40000 ALTER TABLE `enrolls` DISABLE KEYS */;
INSERT INTO `enrolls` VALUES (1354,2,'2022-04-21','Enrolled'),(2940,4,'2022-01-01','Enrolled'),(4094,8,'2022-02-10','Enrolled'),(6307,6,'2022-03-15','Enrolled'),(6500,3,'2022-09-19','Enrolled'),(7968,5,'2022-06-02','Enrolled'),(8066,5,'2022-07-08','Enrolled'),(8629,9,'2022-08-11','Enrolled'),(8903,5,'2022-05-09','Enrolled'),(9348,7,'2022-01-03','Enrolled');
/*!40000 ALTER TABLE `enrolls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `house` (
  `HouseID` int NOT NULL,
  `HouseName` varchar(45) DEFAULT NULL,
  `HousePoints` int DEFAULT NULL,
  PRIMARY KEY (`HouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES (1,'Gryffindor',93),(2,'Hufflepuff',84),(3,'Slytherin',57),(4,'Ravenclaw',63);
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `MaterialID` int NOT NULL,
  `MaterialType` varchar(45) DEFAULT NULL,
  `MaterialName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaterialID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (101,'Animal','Owl'),(102,'Animal','Cat'),(103,'Animal','Rat'),(104,'Animal','Toad'),(201,'Broom','Comet 260'),(202,'Broom','Cleansweep 11'),(203,'Broom','Nimbus 3000'),(204,'Broom','Nimbus 2000'),(301,'Cauldron Volume','5 Liters'),(302,'Cauldron Volume','10 Liters'),(303,'Cauldron Volume','15 Liters'),(304,'Cauldron Volume','20 Liters'),(401,'BookISBN','6.55512E+12'),(402,'BookISBN','4.65567E+12'),(403,'BookISBN','8.93695E+12'),(404,'BookISBN','5.33131E+12');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `ProfessorID` int NOT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `MiddleName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `BloodType` varchar(45) DEFAULT NULL,
  `House_HouseID` int NOT NULL,
  PRIMARY KEY (`ProfessorID`),
  KEY `fk_Professor_House1_idx` (`House_HouseID`),
  CONSTRAINT `fk_Professor_House1` FOREIGN KEY (`House_HouseID`) REFERENCES `house` (`HouseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1243,'Severus','Tobias','Snape','half-blood',3),(2598,'Minerva','Elyse','McGonagall','half-blood',1),(3087,'Dolores','Miriam','Umbridge','pure-blood',1),(3621,'Gilderoy','Lysander','Lockhart','pure-blood',2),(4759,'Rubeus','Maximus','Hagrid','half-blood',1),(5643,'Alastor','Moody','Jones','pure-blood',4),(6397,'Filius','Phineas','Flitwick','pure-blood',2),(7209,'Horace','Edgar','Slughorn','pure-blood',2),(8236,'Pomona','Amanda','Sprout','muggle-born',4),(9887,'Sybill','Aurora','Trelawney','half-blood',3);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requires`
--

DROP TABLE IF EXISTS `requires`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requires` (
  `Course_CourseID` int NOT NULL,
  `Material_MaterialID` int NOT NULL,
  PRIMARY KEY (`Course_CourseID`,`Material_MaterialID`),
  KEY `fk_Course_has_Material_Material1_idx` (`Material_MaterialID`),
  KEY `fk_Course_has_Material_Course1_idx` (`Course_CourseID`),
  CONSTRAINT `fk_Course_has_Material_Course1` FOREIGN KEY (`Course_CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Course_has_Material_Material1` FOREIGN KEY (`Material_MaterialID`) REFERENCES `material` (`MaterialID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requires`
--

LOCK TABLES `requires` WRITE;
/*!40000 ALTER TABLE `requires` DISABLE KEYS */;
INSERT INTO `requires` VALUES (3,101),(5,101),(8,101),(2,102),(3,102),(8,102),(7,104),(1,202),(6,202),(5,203),(10,203),(1,302),(6,302),(9,302),(2,303),(5,304),(3,401),(4,402),(9,402),(10,402),(4,403),(7,404);
/*!40000 ALTER TABLE `requires` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `StudentID` int NOT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `MiddleName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `BloodType` varchar(45) DEFAULT NULL,
  `House_HouseID` int NOT NULL,
  PRIMARY KEY (`StudentID`),
  KEY `fk_Student_House1_idx` (`House_HouseID`),
  CONSTRAINT `fk_Student_House1` FOREIGN KEY (`House_HouseID`) REFERENCES `house` (`HouseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1354,'Hermione','Jean','Granger','1996-09-19','pure-blood',1),(1403,'Madison','Rae','Adams','1997-03-15','muggle-born',1),(1829,'Sophia','Elizabeth','Baker','1998-03-29','half-blood',3),(1955,'Isabella','Rose','Lopez','1997-11-20','pure-blood',3),(1978,'Kirke','Digory','Andrew','1996-04-09','half-blood',3),(2271,'Lucas','David','Garcia','1997-05-12','muggle-born',4),(2940,'Dudley','Ver','Dursley','1996-07-22','pure-blood',1),(2988,'Robins','Peakes','Demelza','1995-10-31','muggle-born',4),(3086,'Evelyn','Faith','Turner','1999-05-02','muggle-born',1),(3111,'Charlotte','Marie','Anderson','1995-07-01','half-blood',1),(4094,'Harry','James','Potter','1998-06-04','pure-blood',3),(4713,'Aiden','Christopher','Stewart','1996-10-26','half-blood',2),(4914,'Harper','Rose','Johnson','1995-10-16','half-blood',1),(5166,'Victoria','Lola','Frobisher','1997-02-22','muggle-born',2),(5460,'Luna','Marina','Martin','1997-06-06','muggle-born',3),(5576,'Avery','Lee','Wilson','1999-04-08','half-blood',1),(5683,'Roger','James','Davies','1997-12-27','half-blood',2),(6307,'Ron','Bilius','Weasley','1999-02-01','pure-blood',4),(6500,'Amelia','Louise','Miller','1996-01-30','half-blood',1),(6628,'Viktor','Grace','Krum','1995-12-18','muggle-born',3),(6636,'Hazel','Mae','Hall','1996-05-27','half-blood',3),(6825,'Emma','Kate','Robinson','1999-11-03','pure-blood',3),(7021,'Liam','Michael','Davis','1996-08-11','half-blood',4),(7130,'Aria','Nicole','Campbell','1995-08-06','pure-blood',3),(7765,'Noah','William','Harris','1999-12-15','muggle-born',2),(7958,'Levi','Andrew','Nelson','1996-02-24','half-blood',4),(7968,'Austin','Lee','Spoor','1998-11-27','pure-blood',3),(8066,'Josh','ThatGuy','Robertson','1997-04-20','pure-blood',4),(8092,'Cameron','Joseph','Wright','1997-01-05','half-blood',2),(8629,'Tom','Marvolo','Riddle','1999-09-06','pure-blood',1),(8761,'Oliver','George','Clark','1998-08-27','muggle-born',2),(8876,'Jackson','Taylor','Hughes','1998-04-13','pure-blood',2),(8903,'Joshua','Middleton','Francis','1999-08-04','pure-blood',2),(9186,'Mason','Robert','Cooper','1999-06-17','muggle-born',4),(9348,'Draco','Lucius','Malfoy','1995-11-13','pure-blood',2),(9397,'Gabriel','Thomas','Morris','1995-12-08','muggle-born',4),(9556,'Logan','Scott','Thompson','1995-09-23','half-blood',2),(9622,'Caleb','Anthony','Green','1998-01-18','muggle-born',4),(9712,'Edward','Remus','Lupin','1998-05-09','pure-blood',4),(9961,'Aurora','Grace','Rossi','1998-09-11','muggle-born',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `SubjectID` int NOT NULL,
  `SubjectName` varchar(45) DEFAULT NULL,
  `LastDateOffered` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SubjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (123,'Wizarding Music Theory and Performance','5/22/2022'),(128,'Wizarding Astronomy and Astrology','4/17/2022'),(246,'Wizarding Linguistics and Etymology','7/31/2022'),(405,'Magical Botany and Herbology','3/18/2022'),(509,'Wizarding Beasts','8/20/2022'),(600,'Wizarding Defense Tactics','6/29/2022'),(713,'Wizarding Politics and Diplomacy','2/25/2022'),(737,'Wizarding Law and Ethics','6/15/2022'),(823,'Wizarding Archeology and History','5/7/2022'),(958,'Wizarding Art and Literature','4/10/2022');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `TaskName` varchar(45) NOT NULL,
  `LastDateCompleted` varchar(45) DEFAULT NULL,
  `House_HouseID` int NOT NULL,
  PRIMARY KEY (`TaskName`),
  KEY `fk_Tasks_House1_idx` (`House_HouseID`),
  CONSTRAINT `fk_Tasks_House1` FOREIGN KEY (`House_HouseID`) REFERENCES `house` (`HouseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES ('Basement Sweep','2023-04-09',2),('Chamber Polishing','2023-04-03',3),('Classroom Organization','2023-04-04',2),('Common Room Cleaning','2023-04-10',1),('Dungeons Tidying','2023-04-07',4),('Kitchen Cleaning','2023-04-05',1),('Library Sorting','2023-03-31',1),('Office Rearrangement','2023-04-02',4),('Tower Dusting','2023-04-08',3),('Trophy Room Dusting','2023-03-30',2);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-20  1:24:55
