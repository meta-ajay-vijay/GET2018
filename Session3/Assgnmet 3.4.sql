USE Storefront;
SHOW Tables;

# SQL Query to consider a form where providing a Zip Code populates associated City and State. 
CREATE TABLE States (
    StateID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    State varchar(55) 
);

CREATE TABLE Cities (
   ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   City varchar(55),
   StateID INT(55),
   FOREIGN KEY (StateID) REFERENCES States(StateID)
);

CREATE TABLE ZipCodes (
   ZipCode int NOT NULL PRIMARY KEY,
   Area varchar(100),
   City_Code int,
   FOREIGN KEY (City_Code) REFERENCES Cities(ID)
);

INSERT INTO States (State) VALUES
    ('Rajasthan'),
    ('Madhya Pradesh'),
    ('Uttar Pradesh'),
    ('Maharashtra');

INSERT INTO Cities (City,StateId) VALUES
   ('Ajmer','1'),
   ('Bhilwara','1'),
   ('jaipur','1'),
   ('Kota','1'),
   ('Udaipur','1'),
   ('Bhopal','2'),
   ('Indore','2'),
   ('Varanasi','3'),
   ('Mumbai','4');

INSERT INTO ZipCodes values
   ('324001','Mahaveer Nagar','4'),
   ('324002','DADABARI','4'),
   ('311001','R.K. Colony','2'),
   ('311002','Sindhu Nagar','2'),
   ('302011','Pratap Nagar','3'),
   ('302022','Sitapura','3'),
   ('324009','Mahaveer Nagar','4'),
   ('394004','Thane','9'),
   ('324008','Teachers colony','7');
   
SELECT z.ZipCode,z.Area,c.City,s.State
FROM ZipCodes z
LEFT JOIN
Cities c
ON z.City_Code = c.Id
LEFT JOIN
States s
ON c.stateId = s.stateId
ORDER BY s.State, c.City;

