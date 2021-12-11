CREATE DATABASE  IF NOT EXISTS `blueBank6` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blueBank6`;
-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: blueBank6
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `cliente_id` bigint NOT NULL AUTO_INCREMENT,
  `apelido` varchar(20) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `escolaridade` varchar(50) NOT NULL,
  `estado_civil` varchar(10) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `nome_completo` varchar(50) NOT NULL,
  `nome_mae` varchar(50) NOT NULL,
  `renda` decimal(12,2) DEFAULT '0.00',
  `telefone` varchar(20) NOT NULL,
  `conta_id` bigint NOT NULL,
  `endereco_id` bigint NOT NULL,
  `rg_id` bigint NOT NULL,
  PRIMARY KEY (`cliente_id`),
  UNIQUE KEY `UK_7wflw78ibh162cmq12ii6ffly` (`cpf`),
  KEY `FK2opmsix3motgkkis4w0n77cya` (`conta_id`),
  KEY `FK6insj35866kfg0wdbvp9ogti4` (`endereco_id`),
  KEY `FKr8lhemv3u34fqfmxpa7irf8oo` (`rg_id`),
  CONSTRAINT `FK2opmsix3motgkkis4w0n77cya` FOREIGN KEY (`conta_id`) REFERENCES `contas` (`conta_id`),
  CONSTRAINT `FK6insj35866kfg0wdbvp9ogti4` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`endereco_id`),
  CONSTRAINT `FKr8lhemv3u34fqfmxpa7irf8oo` FOREIGN KEY (`rg_id`) REFERENCES `rgs` (`rg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contas`
--

DROP TABLE IF EXISTS `contas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contas` (
  `conta_id` bigint NOT NULL AUTO_INCREMENT,
  `agencia` varchar(5) NOT NULL,
  `numero_conta` int DEFAULT NULL,
  `saldo` decimal(19,2) DEFAULT NULL,
  `senha` int NOT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`conta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contas`
--

LOCK TABLES `contas` WRITE;
/*!40000 ALTER TABLE `contas` DISABLE KEYS */;
/*!40000 ALTER TABLE `contas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecos`
--

DROP TABLE IF EXISTS `enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enderecos` (
  `endereco_id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(20) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `complemento` varchar(50) NOT NULL,
  `logradouro` varchar(30) NOT NULL,
  `numero` int NOT NULL,
  `pais` varchar(10) NOT NULL,
  `ponto_referencia` varchar(50) NOT NULL,
  `uf` varchar(2) NOT NULL,
  PRIMARY KEY (`endereco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

LOCK TABLES `enderecos` WRITE;
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rgs`
--

DROP TABLE IF EXISTS `rgs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rgs` (
  `rg_id` bigint NOT NULL AUTO_INCREMENT,
  `data_emissao` date NOT NULL,
  `numero_rg` varchar(30) NOT NULL,
  `orgao_emissor` varchar(10) NOT NULL,
  PRIMARY KEY (`rg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rgs`
--

LOCK TABLES `rgs` WRITE;
/*!40000 ALTER TABLE `rgs` DISABLE KEYS */;
/*!40000 ALTER TABLE `rgs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacoes`
--

DROP TABLE IF EXISTS `transacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacoes` (
  `transacao_id` bigint NOT NULL AUTO_INCREMENT,
  `data_emissao` datetime NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `valor` decimal(12,2) DEFAULT '0.00',
  `id_conta_origem` bigint DEFAULT NULL,
  `id_conta_destino` bigint DEFAULT NULL,
  PRIMARY KEY (`transacao_id`),
  KEY `FKe475y73113l2cyxbh837ivec7` (`id_conta_origem`),
  KEY `FK92wpy85lne4yqu8xcmtro6yc7` (`id_conta_destino`),
  CONSTRAINT `FK92wpy85lne4yqu8xcmtro6yc7` FOREIGN KEY (`id_conta_destino`) REFERENCES `contas` (`conta_id`),
  CONSTRAINT `FKe475y73113l2cyxbh837ivec7` FOREIGN KEY (`id_conta_origem`) REFERENCES `contas` (`conta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacoes`
--

LOCK TABLES `transacoes` WRITE;
/*!40000 ALTER TABLE `transacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacoes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-11 15:06:19
