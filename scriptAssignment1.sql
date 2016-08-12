/* Selecting the Database */
USE LIS;

/* To display all columns of member table */
SHOW COLUMNS FROM members;

/* To display member name, member id and category of member table */
SELECT member_name, member_id, category FROM members;

/* To display member name, member id and category of member table 
 * where the category of member is Faculty i.e. F */
SELECT member_name, member_id, category FROM members WHERE category='F';

/* To display various categories of member */
SELECT DISTINCT category FROM members;

/* To display member name and category in descending order of member name */
SELECT member_name, category FROM members ORDER BY member_name DESC;

/* To display all titles, their subjects and their publishers */
SELECT t.title_name, s.subject_name, p.publisher_name FROM titles t
	INNER JOIN subjects s ON s.subject_id=t.subject_id
    INNER JOIN publishers p ON p.publisher_id=t.publisher_id;

/* To display number of members present in each category */
SELECT category, COUNT(member_id) AS Total FROM members GROUP BY category;

/* To display name of those members who belongs to the same category
 * as to which 'Keshav Sharma' belongs */    
SELECT a.member_name FROM members a 
	INNER JOIN members b ON a.category=b.category WHERE b.member_name='Keshav Sharma';

/* To display information on all the books issued. The result should have issue date, 
 * accessin number, member id, member name and return date. If book is not returned,
 * keep the return date column blank. */    
SELECT a.issue_date AS Issued_On, a.accession_no AS Accession_No, a.member_id AS Member_Id, IFNULL(b.return_date, ' ') AS Returned_On FROM book_issue a
	INNER JOIN book_return b ON a.accession_no=b.accession_no;