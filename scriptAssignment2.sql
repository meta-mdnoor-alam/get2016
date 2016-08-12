/* Selecting the database */
USE LIS;

/* To display information on all the books issued. The result should have issue date, 
   accessin number, member id, member name and return date. If book is not returned,
   keep the return date column blank. Sort the result in ascending order of issue date
   and then ascending ordeer of member name*/
SELECT a.issue_date AS Issue_Date, a.accession_no AS Accession_Number, a.member_id AS Member_Id, c.member_name AS Member_Name, b.return_date FROM book_issue a
	INNER JOIN book_return b ON a.accession_no=b.accession_no
    INNER JOIN members c ON a.member_id = c.member_id
    ORDER BY a.issue_date, c.member_name;