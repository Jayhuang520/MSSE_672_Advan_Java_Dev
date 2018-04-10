use regis;

REM ********************************************************************
PROMPT Removing 'location' database object
REM ********************************************************************

drop table location;

REM ********************************************************************
PROMPT Creating relational table 'location' that will hold the city in the 
PROMPT Huangs inventory
REM ********************************************************************

CREATE TABLE location (
  idLOCATION INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  CITY VARCHAR(20) NULL,
  PRIMARY KEY(idLOCATION)  
);

REM ********************************************************************
PROMPT Inserting sample data into relational table 'locaiton' ...
REM ********************************************************************

INSERT INTO regis.location (idLocation, city) VALUES(
1, "DENVER"); 


REM ********************************************************************
PROMPT Removing 'rooms' database object
REM ********************************************************************

#drop table rooms;


REM ********************************************************************
PROMPT Creating relational table 'ROOMS' that will hold the rooms in the 
PROMPT Huangs inventory
REM ********************************************************************

CREATE TABLE rooms(
	idROOM INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    LOCATION_FK INTEGER UNSIGNED NOT NULL,
    BED_type VARCHAR(20) NULL,
    rate FLOAT NULL,
    rented CHAR NULL,
	discriminator VARCHAR(20) NOT NULL,
	PRIMARY KEY(idROOM),
	INDEX CARS_FKIndex1(LOCATION_FK),
	FOREIGN KEY(LOCATION_FK)
    REFERENCES LOCATION(idLOCATION)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

REM ********************************************************************
PROMPT Inserting sample data into relational table 'ROOM' ...
REM ********************************************************************

INSERT INTO regis.ROOMS (LOCATION_FK, bed_type, rate, rented, discriminator) VALUES(
1, "DOUBLE", 500, "N", "R");

INSERT INTO regis.ROOMS (LOCATION_FK, bed_type, rate, rented, discriminator) VALUES(
1, "QUEEN", 1000, "N", "R");

