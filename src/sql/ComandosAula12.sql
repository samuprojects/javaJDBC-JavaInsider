SELECT * FROM customer;

UPDATE `customerdb`.`customer` SET `name` = 'Pedro' WHERE (`id` = '1');

ALTER TABLE `customerdb`.`customer` 
ADD COLUMN `city` VARCHAR(45) NULL AFTER `age`;

SELECT * FROM customer;

UPDATE `customerdb`.`customer` SET `city` = 'Rio de Janeiro' WHERE (`id` = '1');
UPDATE `customerdb`.`customer` SET `city` = 'Fortaleza' WHERE (`id` = '3');


