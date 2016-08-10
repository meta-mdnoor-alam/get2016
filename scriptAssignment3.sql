/* Selecting database */
USE LIS;

/* Inserting values to the table */
INSERT INTO members VALUES('M2016/700', 'Noor', '84/51', 'Vaishali Nagar', 'M');
INSERT INTO members VALUES('M2016/701', 'Adam', 'A/52', 'Jodhpur', 'F');
INSERT INTO members VALUES('M2016/702', 'Amit', 'Flat F-2', 'Nirman Naga', 'M');
INSERT INTO members VALUES('M2016/703', 'Pulkit', 'B-A/65','Tonk Road', 'M');
INSERT INTO members VALUES('M2016/704', 'Arpit', 'H/12-52', 'Sitapura', 'M');

INSERT INTO subjects VALUES('S/001', 'Program Fundamentals');
INSERT INTO subjects VALUES('S/002', 'Intro to Networking');
INSERT INTO subjects VALUES('S/003', 'Intro to C');
INSERT INTO subjects VALUES('S/004', 'Database Management Systems');
INSERT INTO subjects VALUES('S/005', 'Computer Networks');

INSERT INTO publishers VALUES('P/101', 'Tata McGraw Hill');
INSERT INTO publishers VALUES('P/102', 'Oracle Publications');
INSERT INTO publishers VALUES('P/103', 'Dhanpat Publications');
INSERT INTO publishers VALUES('P/104', 'Pearson');
INSERT INTO publishers VALUES('P/105', 'Genius Publications');

INSERT INTO authors VALUES('A53/01', 'R.K.Sharma');
INSERT INTO authors VALUES('A53/02', 'Bipul Jain');
INSERT INTO authors VALUES('A53/03', 'Martin Luthor');
INSERT INTO authors VALUES('A53/04', 'Adam');
INSERT INTO authors VALUES('A53/05', 'Adil Mohammad');

INSERT INTO titles VALUES('T02/163', 'The book of Life', 'S/001', 'P/104' );
INSERT INTO titles VALUES('T03/164', 'Make It Happen', 'S/003', 'P/104' );
INSERT INTO titles VALUES('T04/165', 'The Case of Missing City', 'S/002', 'P/101' );
INSERT INTO titles VALUES('T05/166', 'All About Cloud', 'S/005', 'P/103' );

INSERT INTO title_author VALUES('T02/163', 'A53/02');
INSERT INTO title_author VALUES('T03/164', 'A53/03');
INSERT INTO title_author VALUES('T05/166', 'A53/04');
INSERT INTO title_author VALUES('T05/166', 'A53/05');

INSERT INTO books VALUES(30521, 'T02/163', '2015/01/01', 230.15, 'Rented' );
INSERT INTO books VALUES(30523, 'T03/164', '2015/03/22', 1230.15, 'Purchased' );
INSERT INTO books VALUES(30525, 'T04/165', '2016/04/15', 49.89, 'Purchased' );
INSERT INTO books VALUES(30527, 'T05/166', '2016/08/01', 5001.01, 'Rented' );

INSERT INTO book_issue VALUES('2016/08/13', 30523, 'M2016/700', '2016/08/25' );
INSERT INTO book_issue VALUES('2016/08/15', 30525, 'M2016/702', '2016/08/28' );
INSERT INTO book_issue VALUES('2016/08/17', 30527, 'M2016/704', '2016/08/30' );

INSERT INTO book_return VALUES('2016/08/25', 30523, 'M2016/702', '2016/08/10' );
INSERT INTO book_return VALUES('2016/08/30', 30527, 'M2016/704', '2016/08/17' );

/* Change values of address_line2 in members table to 'Jaipur' */
UPDATE members SET address_line2 = 'Jaipur';

/* Change values of address_line1 in members table to 'EPIP, Sitapura' */
UPDATE members SET address_line1 = 'EPIP, Sitapura' WHERE category = 'F';

/* Deleting all rows from publisher table */
ALTER TABLE titles DROP 
    FOREIGN KEY fk_publisher_id;
DELETE FROM publishers;

/* Inserting the data back to the publisher table using substitution variables */
SET @id = 'P/101';
SET @name = 'Tata McGraw Hill';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'P/102';
SET @name = 'Oracle Publications';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'P/103';
SET @name = 'Dhanpat Publications';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'P/104';
SET @name = 'Pearson';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'P/105';
SET @name = 'Genius Publications';
INSERT INTO publishers VALUES ( @id, @name );

ALTER TABLE titles
	ADD CONSTRAINT fk_publisher_id_titles
		FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id);

/* Deleting rows of title table with publisher id = 1 */
DELETE FROM titles WHERE publisher_id = '1';
