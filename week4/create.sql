create database shop;
use shop

create table car(car_id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30) NOT NULL,price int, year date);

insert into car(name, price, year) values('Mercedes', 93000, '2012-06-01');
insert into car(name, price, year) values('Toyota', 10000, '2017-06-01');
insert into car(name, price, year) values('Lexus', 32000, '2010-06-01');
insert into car(name, price, year) values('BMW', 32000, '2015-06-01');
--------------------------------------------------------------------------------


create table Userr(user_id int AUTO_INCREMENT PRIMARY KEY, user_name varchar(30), password varchar(30) NOT NULL, active boolean);
insert into users (user_name, password, active) values('Gaara', 'crow65', true);
insert into Userr (user_name, password, active) values('Sakura', 'mima2', true);
insert into Userr (user_name, password, active) values('Itachi', 'groww', true);
insert into Userr (user_name, password, active) values('Temari', 'qweee', true);

create table role(role_id int AUTO_INCREMENT PRIMARY KEY, rol enum('ADMIN', 'STAFF', 'CUSTOMER') NOT NULL);
insert into role(rol) values('CUSTOMER');



--============================================================================
create table user_role(user_id int, role_id int, 
primary key (user_id, role_id),

foreign key (user_id) references Userr(user_id),
foreign key (role_id) references role(role_id));

insert into user_role values(1,1);
--============================================================================


create table basket(user_id int not null, car_id int,
 primary key (car_id),
 foreign key (user_id) references Userr(user_id),
 foreign key (car_id) references car(car_id));


insert into basket values(1, 1);
insert into basket values(1, 2);
insert into basket values(1, 3);
insert into basket values(2, 4);
insert into basket values(1, 2);


----------------------------- for Test

select * from car c join basket b on b.car_id=c.car_id
where b.user_id=1;



select * from car;


select * from basket;


