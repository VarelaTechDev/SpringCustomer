DROP DATABASE IF EXISTS `customerdb`;
CREATE DATABASE `customerdb`;

USE customerDb;

DROP TABLE IF EXISTS `customer`;

# Create the customer table
CREATE TABLE `customer`(
                           customerId INT,
                           FirstName VARCHAR(255),
                           LastName VARCHAR(255),
                           CardNumber VARCHAR(255),
                           CardLimit INT,
                           CardBalance INT,
                           PRIMARY KEY(customerId)
);

ALTER TABLE customer
    ADD COLUMN isDeleted BOOLEAN DEFAULT FALSE;
