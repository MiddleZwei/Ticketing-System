DROP TABLE IF EXISTS `Address`;
DROP TABLE IF EXISTS `Person`;
DROP TABLE IF EXISTS `Seat`;
DROP TABLE IF EXISTS `Concert`;
DROP TABLE IF EXISTS `Ticket`;
DROP TABLE IF EXISTS `Purchase`;
DROP TABLE IF EXISTS `Cashier`;
DROP TABLE IF EXISTS `Musician`;
DROP TABLE IF EXISTS `Manager`;
DROP TABLE IF EXISTS `EmploymentType`;
DROP TABLE IF EXISTS `CheckIn`;

create table Address(
	address_id INT NOT NULL auto_increment PRIMARY KEY,
    address_line_1 VARCHAR(200) default 'Not provided',
    address_line_2 VARCHAR(200) default 'Not provided',
    district VARCHAR(30) default 'Not provided',
    city VARCHAR(30) default 'Not provided',
    postal_code VARCHAR(30) default 'Not provided',
    phone VARCHAR(30) default 'Not provided'
    
)ENGINE=InnoDB;

create table Person (
   person_id INT NOT NULL auto_increment PRIMARY KEY,
   first_name VARCHAR(30) default 'Not provided',
   last_name  VARCHAR(30) default 'Not provided',
   email  VARCHAR(30) default 'Not provided',
   mobile  VARCHAR(30) default 'Not provided',
   
   whitelisted boolean default 1,
   active boolean default 1,
   username varchar(30) default '',
   password varchar(30) default '',
   
   address_id INT,
   
   UNIQUE unique_identity(first_name, last_name, email, mobile),
   
   FOREIGN KEY fk_address(address_id)
   REFERENCES Address(address_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;


create table Cashier (
   cashier_id INT NOT NULL auto_increment PRIMARY KEY,
   
   FOREIGN KEY fk_person(cashier_id)
   REFERENCES Person(person_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;

create table Manager (
   manager_id INT NOT NULL auto_increment PRIMARY KEY,
   education varchar(300) default 'Not provided',
   years_of_experience double default 0.0,
   
   FOREIGN KEY fk_person(manager_id)
   REFERENCES Person(person_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;

create table Musician (
   musician_id INT NOT NULL auto_increment PRIMARY KEY,
   songs varchar(300) default 'Not provided',
   
   FOREIGN KEY fk_person(musician_id)
   REFERENCES Person(person_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE,
   
   concert_id INT,
   FOREIGN KEY fk_concert(concert_id)
   REFERENCES Concert(concert_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;





create table Concert (
   concert_id INT NOT NULL auto_increment PRIMARY KEY,
   `from` DATE,
   `to` DATE,
   amount double,
   title VARCHAR(30)
   
)ENGINE=InnoDB;

create table Seat (
   seat_id INT NOT NULL auto_increment PRIMARY KEY,
   `row` int,
   `number` int,
   
   ticket_id int,
      FOREIGN KEY fk_ticket(ticket_id)
   REFERENCES Ticket(ticket_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
   
)ENGINE=InnoDB;


create table Ticket (
   ticket_id INT NOT NULL auto_increment PRIMARY KEY,
   validFrom DATE,
   validTo DATE,
   amount double,
   title VARCHAR(30),
   
   concert_id INT,
   FOREIGN KEY fk_concert(concert_id)
   REFERENCES Concert(concert_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;

create table EmploymentType (
   employment_type_id int primary key not null default 0,
   `title` varchar(30) not null default '0'
   
)ENGINE=InnoDB;

create table Purchase (
   purchase_id INT NOT NULL auto_increment PRIMARY KEY,
   `date` DATE NOT NULL,
   payment_method  VARCHAR(30),
   card_number  VARCHAR(16),
   emailed_receipt  boolean NOT NULL default 0,
   amount_paid double, 
   refunded boolean NOT NULL default 0, 
   
   cashier_id INT, 
   FOREIGN KEY fk_cashier(cashier_id)
   REFERENCES Cashier(cashier_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT,
   
   ticket_id INT,
   FOREIGN KEY fk_ticket(ticket_id)
   REFERENCES Ticket(ticket_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT,
   
   person_id int,
   FOREIGN KEY fk_person(person_id)
   REFERENCES Person(person_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;


create table Employment (
   employment_id INT NOT NULL auto_increment PRIMARY KEY,
   `hire_date` DATE,
   `fire_date` DATE,
   title  VARCHAR(30),
   wage double, 
   total double, 
   refunded boolean NOT NULL default 0, 
   
   employment_type_id INT, 
   FOREIGN KEY fk_employment_type(employment_type_id)
   REFERENCES EmploymentType(employment_type_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE,
   
   person_id int,
   FOREIGN KEY fk_person(person_id)
   REFERENCES Person(person_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;


create table CheckIn (
   check_in_id INT NOT NULL auto_increment PRIMARY KEY,
   `hire_date` DATE,
   `fire_date` DATE,
   
   employment_id INT, 
   FOREIGN KEY fk_employment_type(employment_id)
   REFERENCES Employment(employment_id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
   
)ENGINE=InnoDB;