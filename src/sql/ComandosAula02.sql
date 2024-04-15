CREATE SCHEMA `customerdb` ;

CREATE TABLE `customerdb`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`));

SELECT * FROM customerdb.customer;