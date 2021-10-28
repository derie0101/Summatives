 drop database if exists SuperHeroApp;

create database SuperHeroApp;

use SuperHeroApp;

create table hero (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
heroName VARCHAR(45),
heroDescription VARCHAR(500),
heroSuperPower VARCHAR(100) );

create table location (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
locationName VARCHAR(100),
locationDescription VARCHAR(500),
locationAddress VARCHAR(100),
locationLatitude DECIMAL(6,4),
locationLongitude  DECIMAL(6,4) );

create table `organization` (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
organizationName VARCHAR(45),
organizationDescription VARCHAR(500),
organizationAddress VARCHAR(45),
organizationContactInfo VARCHAR(100) 
);

create table sighting (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
locationId INT,
timeOfSighting DATETIME,
FOREIGN KEY (LocationID) REFERENCES location(id)
 );
 
 create table heroSighting (
HeroID INT,
SightingID INT,
PRIMARY KEY (HeroID , SightingID) ,
FOREIGN KEY (HeroID) REFERENCES hero(id),
FOREIGN KEY (SightingID) REFERENCES sighting(id)

);

create table heroOrganization (
HeroID INT,
OrganizationID INT,
PRIMARY KEY (HeroID , OrganizationID),
FOREIGN KEY (HeroID) REFERENCES hero(id),
FOREIGN KEY (OrganizationID) REFERENCES `organization`(id)
);


