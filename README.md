# get2016

Note :

Q1: WAP to implement a Stack using a linked list that will contain push and pop operations.
Write a function to convert Infix notation to Postfix using the above implemented stack.

Q2. WAP to implement the Queue in Java using Array.
The program should implement the following responsibility:
	a)void enqueue( item )  - Adding an Object item
	b)Object dequeue( ) -  Remove and return the least recent item inserted
	c)void makeEmpty( ) -  Remove all items of queue and make queue empty
	d)Object getFront( ) - Return least recently inserted item

Using the above Queue structure implement College counseling process. 
Create queue of all the candidates based on their respective ranks. Higher rank will be at the starting. 
Creating List of Colleges that will be available for admission. Take minimum 5 colleges as available, So each candidate will have option to select from 1 to 5 ranked colleges.  
Candidates will be called for counselling in the order based on created queue and the candidate can only opt for the seats available in the college at that time. Un Assigned will be processed in the later round. 

1. Question first is done in file MyStack.java.
2. My customised queue is file MyQueue.java
3. For question second, list of all the candidates are fetched from file CandidatesList.txt and list of all the college list is fetched from CollegeList.txt.
4. Main function of question second is starting in CollegeCounselingProcess.java.
