DROP DATABASE IF EXISTS `customerdb`;
CREATE DATABASE `customerdb`;

USE customerDb;

DROP TABLE IF EXISTS `customer`;

-- # Create the customer table
-- CREATE TABLE `customer`(
--     customerId INT,
--     firstName VARCHAR(255),
--     lastName VARCHAR(255),
--     cardNumber VARCHAR(255),
--     cardLimit INT,
--     cardBalance INT,
--     isDeleted BOOLEAN DEFAULT FALSE,
--     PRIMARY KEY(customerId)
-- );

--  Create the customer table
CREATE TABLE `customer`(
    customerId INT AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    cardNumber VARCHAR(255),
    cardLimit INT,
    cardBalance INT,
    isDeleted BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(customerId)
);

--  ALTER TABLE customer
--    ADD COLUMN isDeleted BOOLEAN DEFAULT FALSE;
