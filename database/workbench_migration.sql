-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema `shearup_db`
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `shearup_db` ;

-- -----------------------------------------------------
-- Schema `shearup_db`
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shearup_db` DEFAULT CHARACTER SET utf8mb4 ;
USE `shearup_db` ;

-- -----------------------------------------------------
-- Table `shearup_db`.`locations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shearup_db`.`locations` ;

CREATE TABLE IF NOT EXISTS `shearup_db`.`locations` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `address_one` VARCHAR(50) NOT NULL,
  `address_two` VARCHAR(50) NULL,
  `city` VARCHAR(50) NOT NULL,
  `state` VARCHAR(2) NOT NULL,
  `zip_code` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `shearup_db`.`services`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shearup_db`.`services` ;

CREATE TABLE IF NOT EXISTS `shearup_db`.`services` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` LONGTEXT NOT NULL,
  `price` DECIMAL(4,2) UNSIGNED NOT NULL,
  `duration` INT UNSIGNED NULL DEFAULT 'depends on client',
  `barber_details_id_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `shearup_db`.`images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shearup_db`.`images` ;

CREATE TABLE IF NOT EXISTS `shearup_db`.`images` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `filestack_url` VARCHAR(255) NOT NULL,
  `service_id_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `shearup_db`.`barber_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shearup_db`.`barber_details` ;

CREATE TABLE IF NOT EXISTS `shearup_db`.`barber_details` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `bio` LONGTEXT NOT NULL,
  `location_id_fk` INT UNSIGNED NOT NULL,
  `image_id_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shearup_db`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shearup_db`.`users` ;

CREATE TABLE IF NOT EXISTS `shearup_db`.`users` (
  `id` INT UNSIGNED NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `is_barber` TINYINT NOT NULL,
  `barber_details_id_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `shearup_db`.`appointments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shearup_db`.`appointments` ;

CREATE TABLE IF NOT EXISTS `shearup_db`.`appointments` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id_fk` INT NULL,
  `service_id_fk` INT UNSIGNED NULL,
  `appointment_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shearup_db`.`reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shearup_db`.`reviews` ;

CREATE TABLE IF NOT EXISTS `shearup_db`.`reviews` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `rating` DECIMAL(1,1) UNSIGNED NOT NULL,
  `image_id_fk` INT UNSIGNED NOT NULL,
  `appointment_id_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
