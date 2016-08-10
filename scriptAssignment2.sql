/* Creating a new Database for LibraryInformationSystem */
CREATE DATABASE LIS;

USE LIS;

/* Creating all tables for LibraryInformationSystem */
CREATE TABLE members (
	member_id VARCHAR(10) PRIMARY KEY,
    member_name VARCHAR(50) NOT NULL,
    address_line1 VARCHAR(100) NOT NULL,
    address_line2 VARCHAR(100),
    category VARCHAR(10) NOT NULL
);

CREATE TABLE subjects (
	subject_id VARCHAR(10) PRIMARY KEY,
    subject_name VARCHAR(50) NOT NULL
);

CREATE TABLE publishers (
	publisher_id VARCHAR(10) PRIMARY KEY,
    publisher_name VARCHAR(50) NOT NULL
);

CREATE TABLE authors (
	author_id VARCHAR(10) PRIMARY KEY,
    author_name VARCHAR(50) NOT NULL
);

CREATE TABLE titles (
	title_id VARCHAR(10) PRIMARY KEY,
    title_name VARCHAR(50) NOT NULL,
    subject_id VARCHAR(10),
    publisher_id VARCHAR(10),
    CONSTRAINT fk_subject_id_titles 
		FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
	CONSTRAINT fk_publisher_id_titles
		FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id)
);

CREATE TABLE title_author (
		title_id VARCHAR(10),
        author_id VARCHAR(10),
        CONSTRAINT fk_title_id_title_author
			FOREIGN KEY(title_id) REFERENCES titles(title_id),
		CONSTRAINT fk_author_id_title_author
			FOREIGN KEY(author_id) REFERENCES authors(author_id),
		PRIMARY KEY(title_id, author_id)
);

CREATE TABLE books (
	accession_no INT PRIMARY KEY,
    title_id VARCHAR(10),
    purchase_date DATE NOT NULL,
    price DECIMAL(8,2) NOT NULL,
    status VARCHAR(10) NOT NULL,
    CONSTRAINT fk_title_id_books
		FOREIGN KEY(title_id) REFERENCES titles(title_id)
);

CREATE TABLE book_issue (
	issue_date DATE,
    accession_no INT,
    member_id VARCHAR(10),
    due_date DATE,
    CONSTRAINT fk_accession_no_book_issue
		FOREIGN KEY(accession_no) REFERENCES books(accession_no),
	 CONSTRAINT fk_member_id_book_issue
		FOREIGN KEY(member_id) REFERENCES members(member_id),
	PRIMARY KEY(issue_date, accession_no, member_id)
);

CREATE TABLE book_return (
	return_date DATE,
    accession_no INT,
    member_id VARCHAR(10),
    issue_date DATE,
    CONSTRAINT fk_accession_no_book_return
		FOREIGN KEY(accession_no) REFERENCES books(accession_no),
	CONSTRAINT fk_member_id_book_return
		FOREIGN KEY(member_id) REFERENCES members(member_id),
	PRIMARY KEY(return_date, accession_no, member_id)
);

/* Display all table names of LibraryInformationSystem */
SHOW TABLES;

/* Alter definitions book_issue to provide the default constraints */
ALTER TABLE book_issue
MODIFY COLUMN issue_date DATE DEFAULT CURDATE();

ALTER TABLE book_issue
MODIFY COLUMN due_date DATE DEFAULT DATE_ADD(CURDATE() + INTERVAL 15DAY);

/* Removing the members table from the database */
ALTER TABLE book_issue
	DROP FOREIGN KEY fk_member_id_book_issue;
ALTER TABLE book_return DROP 
    FOREIGN KEY fk_member_id_book_return;
DROP TABLE members;

/* Recreating the members table */
CREATE TABLE members (
	member_id VARCHAR(10) PRIMARY KEY,
    member_name VARCHAR(50) NOT NULL,
    address_line1 VARCHAR(100) NOT NULL,
    address_line2 VARCHAR(100),
    category VARCHAR(10) NOT NULL
);

/* Restting the Foreign Key Constraints */
ALTER TABLE book_issue
	ADD CONSTRAINT fk_member_id_book_issue
		FOREIGN KEY (member_id) REFERENCES members (member_id);
        
ALTER TABLE book_return
	ADD CONSTRAINT fk_member_id_book_return
		FOREIGN KEY (member_id) REFERENCES members (member_id);
