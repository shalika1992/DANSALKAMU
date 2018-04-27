CREATE DATABASE  IF NOT EXISTS `dansala` ;
USE `dansala`;
DROP TABLE IF EXISTS `dansal`;

CREATE TABLE `dansal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

LOCK TABLES `dansal` WRITE;
INSERT INTO `dansal` VALUES (1,'Cool Drinks',79.9981,6.93582),(2,'Tea',80.4917,7.48322),(3,'Bima',79.8849,7.8945),(4,'Bima',78.9489,7.8393),(5,'kama',80.5917,7.47322),(6,'coffee',80.4785,7.8945);

<!-- STATUSCATEGORY TABLE -->
CREATE TABLE STATUSCATEGORY (
    CODE VARCHAR(16) NOT NULL,
    DESCRIPTION VARCHAR(64) NOT NULL,
	PRIMARY KEY (CODE)
)ENGINE=InnoDB;

<!-- STATUS TABLE -->
CREATE TABLE STATUS (
    CODE VARCHAR(16) NOT NULL,
    DESCRIPTION VARCHAR(64) NOT NULL,
	CATEGORY VARCHAR(16) NOT NULL,
	PRIMARY KEY (CODE),
	FOREIGN KEY (CATEGORY) REFERENCES STATUSCATEGORY(CODE)
)ENGINE=InnoDB;


<!-- USERROLETYPE TABLE -->
CREATE TABLE USERROLETYPE (
    USERROLETYPECODE VARCHAR(16) NOT NULL,
    DESCRIPTION VARCHAR(64) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (USERROLETYPECODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE)
)ENGINE=InnoDB;

<!-- USERROLE TABLE -->
CREATE TABLE USERROLE (
    USERROLECODE VARCHAR(16) NOT NULL,
    DESCRIPTION VARCHAR(64) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	USERROLETYPECODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (USERROLECODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE),
	FOREIGN KEY (USERROLETYPECODE) REFERENCES USERROLETYPE(USERROLETYPECODE)
)ENGINE=InnoDB;

<!-- SECTION TABLE -->
CREATE TABLE SECTION (
    SECTIONCODE VARCHAR(16) NOT NULL,
    DESCRIPTION VARCHAR(64) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (SECTIONCODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE)
)ENGINE=InnoDB;

<!-- PAGE TABLE -->
CREATE TABLE PAGE(
    PAGECODE VARCHAR(16) NOT NULL,
    DESCRIPTION VARCHAR(64) NOT NULL,
	URL VARCHAR(256) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (PAGECODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE)
)ENGINE=InnoDB;

<!-- TASK TABLE -->
CREATE TABLE TASK(
    TASKCODE VARCHAR(16) NOT NULL,
    DESCRIPTION VARCHAR(64) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (TASKCODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE)
)ENGINE=InnoDB;

<!-- USER TABLE -->
CREATE TABLE USER(
    USERID BIGINT NOT NULL AUTO_INCREMENT,
	USERNAME VARCHAR(32) NOT NULL,
	PASSWORD VARCHAR(512) NOT NULL,
	FIRSTNAME VARCHAR(256) NOT NULL,
	LASTNAME VARCHAR(256) NOT NULL,
	EMAIL VARCHAR(256) NOT NULL,
	PHONENUMBER VARCHAR(16) NOT NULL,
	RESETLOGIN SMALLINT(1) DEFAULT 0,
	FIRSTLOGIN SMALLINT(1) DEFAULT 0,
	CHANNEL VARCHAR(8) NOT NULL,
	VERIFYCODE VARCHAR(16),
	STATUSCODE VARCHAR(16) NOT NULL,
	USERROLECODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTLOGGEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (USERID),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE),
	FOREIGN KEY (USERROLECODE) REFERENCES USERROLE(USERROLECODE)
)ENGINE=InnoDB;

ALTER TABLE USER AUTO_INCREMENT=5001;

<!-- AUDITTRACE TABLE -->
CREATE TABLE AUDITTRACE(
    AUDITTRACEID BIGINT NOT NULL AUTO_INCREMENT,
	USERROLECODE VARCHAR(16),
	DESCRIPTION VARCHAR(512),
	PAGECODE VARCHAR(16),
	TASKCODE VARCHAR(16),
	REMARKS VARCHAR(256),
	IP VARCHAR(16),
	OLDVALUE VARCHAR(512),
	NEWVALUE VARCHAR(512),
	AFFECTEDKEY VARCHAR(256),
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (AUDITTRACEID)
)ENGINE=InnoDB;

ALTER TABLE AUDITTRACE AUTO_INCREMENT=1001;

<!--ICON TABLE-->
CREATE TABLE `dansala`.`icon` (
  `iconId` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(100) NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`iconId`)
);

<!--dansalcategory TABLE-->
CREATE TABLE `dansala`.`dansalcategory` (
  `categoryId` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `iconId` INT NOT NULL,
  PRIMARY KEY (`categoryId`),
  INDEX `icon_idx` (`iconId` ASC),
  CONSTRAINT `icon` FOREIGN KEY (`iconId`) REFERENCES `dansala`.`icon` (`iconId`) ON DELETE NO ACTION ON UPDATE NO ACTION
 );
    
ALTER TABLE `dansala`.`dansalcategory` CHANGE COLUMN `categoryId` `categoryId` INT(11) NOT NULL AUTO_INCREMENT ;

!--PWDPARM TABLE-->
CREATE TABLE PWDPARM (
	PARAMCODE VARCHAR(16) NOT NULL,
	DESCRIPTION VARCHAR(64),
	VALUE VARCHAR(100),
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	PRIMARY KEY (PARAMCODE)
);

<!--TOBE EXECUTED-->
<!--PAGETASK TABLE-->
CREATE TABLE PAGETASK(
    PAGE VARCHAR(16) NOT NULL,
    TASK VARCHAR(16) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (PAGE,TASK),
	FOREIGN KEY (PAGE) REFERENCES PAGE(PAGECODE),
	FOREIGN KEY (TASK) REFERENCES TASK(TASKCODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE)
)ENGINE=InnoDB;

<!--PAGESECTIONUSERROLE TABLE-->
CREATE TABLE PAGESECTIONUSERROLE(
    PAGE VARCHAR(16) NOT NULL,
    SECTION VARCHAR(16) NOT NULL,
	USERROLE VARCHAR(16) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (PAGE,SECTION,USERROLE),
	FOREIGN KEY (PAGE) REFERENCES PAGE(PAGECODE),
	FOREIGN KEY (SECTION) REFERENCES SECTION(SECTIONCODE),
	FOREIGN KEY (USERROLE) REFERENCES USERROLE(USERROLECODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE)
)ENGINE=InnoDB;

<!-- TASK PAGETASKUSERROLE -->
CREATE TABLE PAGETASKUSERROLE(
    PAGE VARCHAR(16) NOT NULL,
	TASK VARCHAR(16) NOT NULL,
	USERROLE VARCHAR(16) NOT NULL,
	STATUSCODE VARCHAR(16) NOT NULL,
	LASTUPDATEDUSER VARCHAR(64) NOT NULL,
	LASTUPDATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CREATEDTIME DATETIME  DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (PAGE,TASK,USERROLE),
	FOREIGN KEY (PAGE) REFERENCES PAGE(PAGECODE),
	FOREIGN KEY (TASK) REFERENCES TASK(TASKCODE),
	FOREIGN KEY (USERROLE) REFERENCES USERROLE(USERROLECODE),
	FOREIGN KEY (STATUSCODE) REFERENCES STATUS(CODE)
)ENGINE=InnoDB;

<!-- statuscategory table -->
INSERT INTO statuscategory(code,description) values('USER','User Status Category');

<!-- status table -->
INSERT INTO status(code,description,category) values('ACT','Active','USER');
INSERT INTO status(code,description,category) values('DCT','De-Active','USER');
INSERT INTO status(code,description,category) values('BLK','Block','USER');

<!-- userroletype table -->
insert into userroletype(userroletypecode,description,statuscode,lastupdateduser) values
('WEB','Web User','ACT','admin');

<!-- userrole table -->
insert into userrole(userrolecode,description,statuscode,userroletypecode,lastupdateduser) values
('WEBUSER','Web User','ACT','WEB','admin')

insert into userrole(userrolecode,description,statuscode,userroletypecode,lastupdateduser) values
('WEBADMIN','Web User','ACT','WEB','admin')

<!-- user table -->
INSERT INTO user(username,password,firstname,lastname,email,phonenumber,resetlogin,firstlogin,channel,verifycode,statuscode,userrolecode,lastupdateduser) values 
('supul','c3VwdWxAMTIz','Supul','Gintota','supul@gmail.com','0712456789','0','0','WEB','1111','ACT','WEBUSER','admin');

INSERT INTO user(username,password,firstname,lastname,email,phonenumber,resetlogin,firstlogin,channel,verifycode,statuscode,userrolecode,lastupdateduser) values 
('shalika','shalika@123','Shalika','Weerasinghe','shalika@gmail.com','0712456789','0','0','WEB','1111','ACT','WEBUSER','admin');

<!-- pwdparam table -->
insert into pwdparam(PARAMCODE,DESCRIPTION,VALUE,LASTUPDATEDUSER) values('ITM','Inactive Time Period','60','admin');

commit;