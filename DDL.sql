CREATE TABLE `test`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `first_name` VARCHAR(50) NULL COMMENT '',
  `last_name` VARCHAR(50) NULL COMMENT '',
  `email_addr` VARCHAR(50) NULL COMMENT '',
  `age` INT NULL COMMENT '',
  PRIMARY KEY (`user_id`)  COMMENT '');
  
ALTER TABLE `test`.`user` ADD UNIQUE INDEX `emailUniqueIndex` (`email_addr` ASC)  COMMENT '';
  
INSERT INTO `test`.`user` (`user_id`, `first_name`, `last_name`, `email_addr`, `age`) VALUES ('1', 'Rana', 'Nalla', 'rana.roche.com', '30');
INSERT INTO `test`.`user` (`user_id`, `first_name`, `last_name`, `email_addr`, `age`) VALUES ('2', 'Loi', 'Thai', 'loi.roche.com', '40');
