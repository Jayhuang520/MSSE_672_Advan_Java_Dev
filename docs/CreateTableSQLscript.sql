/**
 * Author:  Zhijie Huang
 * Created: Apr 1, 2018
 */

REM ********************************************************************
PROMPT Removing 'rooms' database object
REM ********************************************************************


DROP TABLE IF EXISTS `regis`.`rooms`;

REM ********************************************************************
PROMPT Creating relational table 'ROOMS' that will hold the rooms in the 
PROMPT Huangs inventory
REM ********************************************************************


CREATE TABLE `regis`.`rooms` (
  `idrooms` INT NOT NULL AUTO_INCREMENT,
  `LOCATION_FK` INT NOT NULL,
  `bed_type` VARCHAR(20) NOT NULL,
  `rate` FLOAT NULL,
  `rented` CHAR NULL,
  PRIMARY KEY (`idrooms`)
  );
  
REM ********************************************************************
PROMPT Inserting sample data into relational table 'ROOM' ...
REM ********************************************************************

 INSERT INTO `regis`.`rooms` (idrooms, LOCATION_FK,bed_type, rate,rented) VALUES(
1, 1, 'DOUBLE', 500, "N"); 
 INSERT INTO `regis`.`rooms` (idrooms, LOCATION_FK,bed_type, rate,rented) VALUES(
2, 1, 'QUEEN', 1000, "N"); 
 INSERT INTO `regis`.`rooms` (idrooms, LOCATION_FK,bed_type, rate,rented) VALUES(
3, 1, 'KING', 1500, "N"); 


REM ********************************************************************
PROMPT Removing 'location' database object
REM ********************************************************************

  DROP TABLE IF EXISTS `regis`.`location`;
  

REM ********************************************************************
PROMPT Creating relational table 'LOCATION ' that will hold the locations where the 
PROMPT rooms are located in Fleet inventory
REM ********************************************************************


  CREATE TABLE `regis`.`location` (
  `idlocation` INT NOT NULL,
  `CITY` VARCHAR(20) NULL,
  PRIMARY KEY (`idlocation`));
  
REM ********************************************************************
PROMPT Inserting sample data into relational table 'LOCATION' ...
REM ********************************************************************

  INSERT INTO regis.LOCATION (idLocation, city) VALUES(
1, "DENVER"); 
  
  ALTER TABLE `regis`.`rooms` 
DROP FOREIGN KEY `idlocation`;
ALTER TABLE `regis`.`rooms` 
ADD CONSTRAINT `LOCATION_FK`
  FOREIGN KEY (`LOCATION_FK`)
  REFERENCES `regis`.`location` (`idlocation`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  