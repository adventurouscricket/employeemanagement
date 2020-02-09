create schema employeemanagement;

use employeemanagement;

create table employee (
	id bigint primary key auto_increment,
    name nvarchar(255),
    grid nvarchar(255)
);
INSERT INTO `employeemanagement`.`employee` (`name`,`grid`) VALUES ('Sato', 'A');
INSERT INTO `employeemanagement`.`employee` (`name`,`grid`) VALUES ('Suzuki', 'B');
INSERT INTO `employeemanagement`.`employee` (`name`,`grid`) VALUES ('Takahashi', 'B');
INSERT INTO `employeemanagement`.`employee` (`name`,`grid`) VALUES ('Tanaka', 'A');
INSERT INTO `employeemanagement`.`employee` (`name`,`grid`) VALUES ('Watanabe', 'C');
