/* Selecting the database */
USE LIS;

/* To display subjectwise information on number of books purchased.
 * It should include subject name, subject id and number of books purchased */
SELECT s.subject_id AS 'Subject Id', s.subject_name AS 'Subject Name',COUNT(b.accession_number) AS 'Number of books' FROM subjects s
    INNER JOIN titles t ON s.subject_id = t.subject_id
    INNER JOIN books b ON t.title_id = b.title_id
    GROUP BY s.subject_id;
    
/* To display those rows from book_issue table where a book can be returned 
 * after 2 months i.e. difference between issue and due date is greater than 2 months*/
SELECT issue_dt AS 'Issue Date', due_dt AS 'Due Date',
    accession_number AS 'Book ID', member_id AS 'Member ID'
    FROM book_issue WHERE DATEDIFF(issue_date,due_date) > 60;

/* To display the list of books having price greater than the 
 * minimum price of books purchased so far */
SELECT accession_no AS 'Book Id', title_id AS 'Title Id', purchase_date AS 'Purchase Date', price AS 'Price',status AS 'Status'
    FROM books WHERE price > (SELECT MIN(price) FROM books);