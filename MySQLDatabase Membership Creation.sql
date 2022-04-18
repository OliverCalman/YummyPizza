drop table `membershipdb`.`customer`;
drop table `membershipdb`.`address`;

CREATE TABLE `membershipdb`.`customer`(
	`memberNumber` int NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `dateCreated` VARCHAR(50),
	`dateOfBirth`  VARCHAR(50),
	`gender` VARCHAR(7),
	`phoneNumber` VARCHAR(20),
	`emailAddress` VARCHAR(64),
	`numberOfOrders` INTEGER,
    PRIMARY KEY (`memberNumber`)
);

CREATE TABLE `membershipdb`.`address`(
	`memberNumber` int NOT NULL,
    `addressLine1` VARCHAR(50),
	`addressLine2` VARCHAR(50),
	`suburb` VARCHAR(50),
	`state` VARCHAR(50),
	`postCode` varchar(4),
    `inDeliveryRange` varchar(5),
    PRIMARY KEY (`memberNumber`)
);

select * from `membershipdb`.`customer`;
select * from `membershipdb`.`address`;
