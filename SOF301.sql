Create database AssignmentSOF301

use AssignmentSOF301
create table Customers(
Username varchar(50) NOT NULL PRIMARY KEY,
Password varchar (30) NOT NULL,
Name varchar (50) NOT NULL,
Gender varchar NULL,
Email varchar (30) NOT NULL,
Role varchar (20) NOT NULL
)

INSERT INTO Customers ( Username, Password , Name, Gender, Email, Role ) VALUES('chenjai', '123', 'Chen Jai', 'F' , 'chenjai1984@gmail.com', 'user')
INSERT INTO Customers ( Username, Password , Name, Gender, Email, Role ) VALUES('admin', 'admin', 'Admin', 'M' , 'chenjai1984@gmail.com', 'admin')

create table Products(
Code varchar(30) NOT NULL PRIMARY KEY,
Name varchar (50) NOT NULL,
Price float NULL
)

INSERT INTO Products ( Code, Name, Price) VALUES('PS001', 'iPhone 7 Plus', 1000)
INSERT INTO Products ( Code, Name, Price) VALUES('PS002', 'iPhone 7 ', 899)
INSERT INTO Products ( Code, Name, Price) VALUES('PS003', 'iPhone 6s Plus', 899)
INSERT INTO Products ( Code, Name, Price) VALUES('PS004', 'iPhone 6s ', 799)
INSERT INTO Products ( Code, Name, Price) VALUES('PS005', 'iPhone 6 Plus', 799)
INSERT INTO Products ( Code, Name, Price) VALUES('PS006', 'iPhone 6', 699)
INSERT INTO Products ( Code, Name, Price) VALUES('PS007', 'iPhone 5s', 499)
INSERT INTO Products ( Code, Name, Price) VALUES('PS008', 'iPhone 5', 399)
INSERT INTO Products ( Code, Name, Price) VALUES('PS009', 'iPhone 5SE', 599)


create table History(
ID int IDENTITY(1,1) PRIMARY KEY NOT NULL ,
DateX varchar(20) NOT NULL,
Quantity int  NOT NULL,
Total float NULL,
Code varchar(30) NOT NULL references Products(Code),
Username varchar(50) NOT NULL references Customers(Username)
)

drop table History;

INSERT INTO History ( DateX, Quantity, Total, Code, Username) VALUES('18-10-2016', 1, 599, 'PS002', 'admin')
