DROP DATABASE progtest;
CREATE DATABASE progtest;
USE progtest;

CREATE TABLE User (
	idCode INT NOT NULL,
	userName VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(100),
	email VARCHAR(100) UNIQUE,
	password VARCHAR(80),
	role VARCHAR(10) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (idCode)
);

CREATE TABLE Course (
	idCode INT NOT NULL,
	name VARCHAR(50),
	startDate DATE,
	endDate DATE,
	instructor INT NOT NULL,
	CONSTRAINT PK_course PRIMARY KEY (idCode),
	CONSTRAINT FK_course_instructor FOREIGN KEY (instructor) REFERENCES User (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE student_course (
	student INT NOT NULL,
	course INT NOT NULL,
	CONSTRAINT PK_student_course PRIMARY KEY (student, course),
	CONSTRAINT FK_student_course_student FOREIGN KEY (student) REFERENCES User (idCode) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_student_course_course FOREIGN KEY (course) REFERENCES Course (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Oracle (
	idCode INT NOT NULL,
	title VARCHAR(50),
	description VARCHAR(500),
	CONSTRAINT PK_oracle PRIMARY KEY (idCode)
);

CREATE TABLE Assignment (
	course INT NOT NULL,
	idCode INT NOT NULL,
	title VARCHAR(50),
	description VARCHAR(500),
	startDate DATETIME,
	endDate DATETIME,
	weightPinstTinst INT,
	weightPalTal INT,
	weightPinstTal INT,
	weightPalTinst INT,
	weightFunctional INT,
	weightAllNodes INT,
	weightAllEdges INT,
	weightAllUses INT,
	weightAllPotUses INT,
	CONSTRAINT PK_assignment PRIMARY KEY (course, idCode),
	CONSTRAINT FK_assignment_course FOREIGN KEY (course) REFERENCES Course (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Evaluation (
	student INT NOT NULL,
	course INT NOT NULL,
	assignment INT NOT NULL,
	submissionDate DATETIME,
	score DOUBLE,
	CONSTRAINT PK_evaluation PRIMARY KEY (student, course, assignment),
	CONSTRAINT FK_evaluation_student FOREIGN KEY (student) REFERENCES User (idCode) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_evaluation_assignment FOREIGN KEY (course, assignment) REFERENCES Assignment (course, idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE SEQUENCE SEQ_USER START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_COURSE START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_ORACLE START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_ASSIGNMENT START WITH 1 INCREMENT BY 1;

INSERT INTO User VALUES(1, 'progtest', 'ProgTest', 'progtest@gmail.com', 'progtest', 'instructor');

INSERT INTO Oracle VALUES(1, 'Maximum Value', 'Obtains the highest value of a sequence of integers.');

INSERT INTO Oracle VALUES(2, 'Maximum and Minimum Value', 'Obtains the highest and lowest values of a sequence of integers.');

INSERT INTO Oracle VALUES(3, 'Fibonacci', 'Computes the Fibonacci sequence.');

INSERT INTO Oracle VALUES(4, 'String Marriage', 'Searches the occurrence of one string in another string.');

INSERT INTO Oracle VALUES(5, 'Sort', 'Sorts a sequence of numbers.');

INSERT INTO Oracle VALUES(6, 'Bubble Sort', 'Implementation of the bubble sort algorithm.');

INSERT INTO Oracle VALUES(7, 'Heapsort', 'Implementation of the heapsort algorithm.');

INSERT INTO Oracle VALUES(8, 'Insertion Sort', 'Implementation of the insertion sort algorithm.');

INSERT INTO Oracle VALUES(9, 'Selection Sort', 'Implementation of the selection sort algorithm.');

INSERT INTO Oracle VALUES(10, 'List', 'Implementation of a list.');

INSERT INTO Oracle VALUES(11, 'Stack', 'Implementation of a stack.');

INSERT INTO Oracle VALUES(12, 'Queue', 'Implementation of a queue.');

INSERT INTO Oracle VALUES(13, 'Binary Tree', 'Implementation of a binary tree.');

INSERT INTO Oracle VALUES(14, 'Graph', 'Implementation of a graph.');

INSERT INTO Oracle VALUES(15, 'Depth-first Search', 'Implementation of the depth-first search in a graph.');

INSERT INTO Oracle VALUES(16, 'Breadth-first Search', 'Implementation of the breadth-first search in a graph.');

INSERT INTO Oracle VALUES(17, 'Strongly Connected Components', 'Gets the number of strongly connected components of a graph.');

INSERT INTO Oracle VALUES(18, 'Prim Algorithm', 'Implementation of the Prim algorithm.');

INSERT INTO Oracle VALUES(19, 'Hash Table', 'Implementation of a hash table.');

INSERT INTO Oracle VALUES(20, 'Matrix Multiplication', 'Gets the result of multiplying two matrices.');