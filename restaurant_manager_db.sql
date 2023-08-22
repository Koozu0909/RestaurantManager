-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurant_manager_db
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `UserId` int DEFAULT NULL,
  `FoodItemId` int DEFAULT NULL,
  `FoodName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `ImageURL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FoodItemId` (`FoodItemId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`FoodItemId`) REFERENCES `fooditem` (`Id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (2,'New Category 2'),(3,'Category 3'),(4,'New Category'),(5,'New Category 2');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fooditem`
--

DROP TABLE IF EXISTS `fooditem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fooditem` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Description` text COLLATE utf8mb4_unicode_ci,
  `Ingredients` text COLLATE utf8mb4_unicode_ci,
  `ImageURL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PreparationTime` int DEFAULT NULL,
  `Calories` int DEFAULT NULL,
  `Protein` double DEFAULT NULL,
  `Carbohydrates` double DEFAULT NULL,
  `Fat` double DEFAULT NULL,
  `CategoryId` int DEFAULT NULL,
  `RestaurantId` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `CategoryId` (`CategoryId`),
  KEY `RestaurantId` (`RestaurantId`),
  CONSTRAINT `fooditem_ibfk_1` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`Id`),
  CONSTRAINT `fooditem_ibfk_2` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fooditem`
--

LOCK TABLES `fooditem` WRITE;
/*!40000 ALTER TABLE `fooditem` DISABLE KEYS */;
INSERT INTO `fooditem` VALUES (34,'Bún Thái Cay',14.5,'Delicious cheeseburger with juicy beef patty','Beef patty, cheese, lettuce, tomato, onion','http://localhost:8080/RestaurantManager/api/fooditems/image/056b3b35-8035-40e1-8180-8f18ea4614fb_bunthai.jpeg',10,50,25,40,20,3,1),(35,'Bánh Tráng',16,'Delicious cheeseburger with juicy beef patty','Beef patty, cheese, lettuce, tomato, onion','http://localhost:8080/RestaurantManager/api/fooditems/image/b4bb273c-606b-4e27-a564-7ba2afc06b22_banhtrang.jpg',10,50,25,40,20,3,1),(36,'Cơm Gà',19,'Delicious cheeseburger with juicy beef patty','Beef patty, cheese, lettuce, tomato, onion','http://localhost:8080/RestaurantManager/api/fooditems/image/6a615883-25a0-4e58-b938-85251336d149_comga.jpeg',10,50,25,40,20,3,1),(37,'Pizza',12.3,'Delicious cheeseburger with juicy beef patty','Beef patty, cheese, lettuce, tomato, onion','http://localhost:8080/RestaurantManager/api/fooditems/image/c5e23c85-9455-4250-a4d4-21eed36dfe21_piza.jpeg',10,50,25,40,20,2,1),(38,'Cơm Chiên & Nui Xào',17.3,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','http://localhost:8080/RestaurantManager/api/fooditems/image/d1d32ba2-f938-453f-9c2b-597ac0cc42ea_conchien.jpeg',10,50,25,40,20,2,1),(39,'Cơm Tấm',12,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultricies integer quis auctor elit sed vulputate mi.','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lectus quam id leo in vitae.','http://localhost:8080/RestaurantManager/api/fooditems/image/c9c05228-be9c-46d0-b631-d714fe8934b3_comtam.jpg',10,50,25,40,20,2,1),(40,'Bánh Mì Thịt Bò Nướng',12,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pharetra sit amet aliquam id diam maecenas.','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Etiam dignissim diam quis enim lobortis scelerisque fermentum.','http://localhost:8080/RestaurantManager/api/fooditems/image/2f505def-f1e9-41b0-9db3-22d6d5c2d7ac.jpg',10,50,25,40,20,2,1),(41,'Cơm Gà Xối Mỡ',12,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pharetra sit amet aliquam id diam maecenas.','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Etiam dignissim diam quis enim lobortis scelerisque fermentum.','http://localhost:8080/RestaurantManager/api/fooditems/image/2e0105f6-a81b-4e5f-ad6c-5081e1141381.jpeg',10,50,25,40,20,4,1),(42,'Tré Trộn Cóc ',10,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pharetra sit amet aliquam id diam maecenas.','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Etiam dignissim diam quis enim lobortis scelerisque fermentum.','http://localhost:8080/RestaurantManager/api/fooditems/image/2a61c43c-f13f-4bc6-94e8-10ae0b181c00.jpg',10,50,25,40,20,4,1);
/*!40000 ALTER TABLE `fooditem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `RestaurantId` int DEFAULT NULL,
  `FoodItemId` int DEFAULT NULL,
  `FoodName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `ImageURL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `RestaurantId` (`RestaurantId`),
  KEY `FoodItemId` (`FoodItemId`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`Id`),
  CONSTRAINT `menu_ibfk_2` FOREIGN KEY (`FoodItemId`) REFERENCES `fooditem` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `UserId` int DEFAULT NULL,
  `FoodItemId` int DEFAULT NULL,
  `FoodName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `ImageURL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PaymentId` int DEFAULT NULL,
  `DeliveryAddress` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `OrderTime` datetime DEFAULT NULL,
  `TotalAmount` decimal(20,5) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FoodItemId` (`FoodItemId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`FoodItemId`) REFERENCES `fooditem` (`Id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `OpeningHours` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CuisineType` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ImageURL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MapLocation` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'Test Restaurant 2','123 Test Street 2','123-456-7890','test@example.com','9:00 AM - 10:00 PM',NULL,NULL,'http://localhost:8080/RestaurantManager/api/restaurant/image/ab87e42e-06f6-416b-9c87-b495badbedfe_images-restaurant.jpeg',NULL),(3,'Test Restaurant 2','123 Test Street 2','123-456-7890','test@example.com','9:00 AM - 10:00 PM',NULL,NULL,'http://localhost:8080/RestaurantManager/api/restaurant/image/4909141c-80e4-4acc-b3e1-6e5ad24ad263_le-cafe-restaurant-2-10-orig_wide.jpg',NULL),(4,'Test Restaurant 2','123 Test Street 2','123-456-7890','test@example.com','9:00 AM - 10:00 PM',NULL,NULL,'http://localhost:8080/RestaurantManager/api/restaurant/image/a646289a-589a-4cad-9b30-70410d7c0bba_images-restaurant.jpeg',NULL);
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `UserId` int DEFAULT NULL,
  `FoodItemId` int DEFAULT NULL,
  `RestaurantId` int DEFAULT NULL,
  `Rate` int DEFAULT NULL,
  `Comment` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `RestaurantId` (`RestaurantId`),
  KEY `FoodItemId` (`FoodItemId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`Id`),
  CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`FoodItemId`) REFERENCES `fooditem` (`Id`),
  CONSTRAINT `reviews_ibfk_3` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Lastname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Phone` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Username` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Active` tinyint(1) NOT NULL,
  `Userrole` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ImageURL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Jane','Smith','jane.smith@example.com','9876543210','janesmith','pass456',1,'ROLE_USER',NULL),(3,'Admin','Adminson','admin@example.com','5555555555','admin','adminpass',1,'ROLE_ADMIN',NULL),(5,'John!!','Doe','john.doe@example.com','1234567890','johndoe','$2a$10$f/qIlGrkp8muTSVAsU0AkOAEgCRpBNralrdBgf8t6i5ZjQpXvkgHW',1,'ROLE_USER','http://localhost:8080/RestaurantManager/api/user/image/71dd10fe-ec0a-4b43-bbc8-a68fb0f8e1ff_user white.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-22 18:24:25
