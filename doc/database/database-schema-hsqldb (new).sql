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

CREATE TABLE Assignment (
	course INT NOT NULL,
	idCode INT NOT NULL,
	title VARCHAR(50),
	description VARCHAR(500),
	startDate DATETIME,
	endDate DATETIME,
	CONSTRAINT PK_assignment PRIMARY KEY (course, idCode),
	CONSTRAINT FK_assignment_course FOREIGN KEY (course) REFERENCES Course (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Language (
	idCode INT NOT NULL,
	name VARCHAR(50),
	CONSTRAINT PK_language PRIMARY KEY (idCode)
);

CREATE TABLE Oracle (
	idCode INT NOT NULL,
	title VARCHAR(50),
	description VARCHAR(500),
	language INT,
	CONSTRAINT PK_oracle PRIMARY KEY (idCode),
	CONSTRAINT FK_oracle_language FOREIGN KEY (language) REFERENCES Language (idCode)
);

CREATE TABLE Compiler (
	idCode INT NOT NULL,
	name VARCHAR(50),
	language INT,
	CONSTRAINT PK_compiler PRIMARY KEY (idCode),
	CONSTRAINT FK_compiler_language FOREIGN KEY (language) REFERENCES Language (idCode)
);

CREATE TABLE Tool (
	idCode INT NOT NULL,
	name VARCHAR(50),
	type VARCHAR(50),
	language INT,
	CONSTRAINT PK_tool PRIMARY KEY (idCode),
	CONSTRAINT FK_tool_language FOREIGN KEY (language) REFERENCES Language (idCode)
);

CREATE TABLE Criterion (
	tool INT NOT NULL,
	idCode INT NOT NULL,
	name VARCHAR(50),
	CONSTRAINT PK_criterion PRIMARY KEY (tool, idCode),
	CONSTRAINT FK_criterion_tool FOREIGN KEY (tool) REFERENCES Tool (idCode)
);

CREATE TABLE assignment_criterion (
	course INT NOT NULL,
	assignment INT NOT NULL,
	tool INT NOT NULL,
	criterion INT NOT NULL,
	weight INT,
	CONSTRAINT PK_assignment_criterion PRIMARY KEY (course, assignment, tool, criterion),
	CONSTRAINT FK_assignment_criterion_assignment FOREIGN KEY (course, assignment) REFERENCES Assignment (course, idCode),
	CONSTRAINT FK_assignment_criterion_criterion FOREIGN KEY (tool, criterion) REFERENCES Criterion (tool, idCode)
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

CREATE SEQUENCE SEQ_LANGUAGE START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_COMPILER START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_TOOL START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_CRITERION START WITH 1 INCREMENT BY 1;

INSERT INTO User VALUES(1, 'progtest', 'ProgTest', 'progtest@gmail.com', 'progtest', 'instructor');

INSERT INTO Language VALUES(1, 'Java');

INSERT INTO Compiler VALUES(1, 'Javac', 1);

INSERT INTO Tool VALUES(1, 'JaBUTiService', 'Structural', 1);

INSERT INTO Criterion VALUES(1, 1, 'All-Nodes-ei');

INSERT INTO Criterion VALUES(1, 2, 'All-Nodes-ed');

INSERT INTO Criterion VALUES(1, 3, 'All-Edges-ei');

INSERT INTO Criterion VALUES(1, 4, 'All-Edges-ed');

INSERT INTO Criterion VALUES(1, 5, 'All-Uses-ei');

INSERT INTO Criterion VALUES(1, 6, 'All-Uses-ed');

INSERT INTO Criterion VALUES(1, 7, 'All-Pot-Uses-ei');

INSERT INTO Criterion VALUES(1, 8, 'All-Pot-Uses-ed');

INSERT INTO Oracle VALUES(1, 'Maximum Value', 'Obtains the highest value of a sequence of integers.', 1);

INSERT INTO Oracle VALUES(2, 'Maximum and Minimum Value', 'Obtains the highest and lowest values of a sequence of integers.', 1);

INSERT INTO Oracle VALUES(3, 'Fibonacci', 'Computes the Fibonacci sequence.', 1);

INSERT INTO Oracle VALUES(4, 'String Marriage', 'Searches the occurrence of one string in another string.', 1);

INSERT INTO Oracle VALUES(5, 'Sort', 'Sorts a sequence of numbers.', 1);

INSERT INTO Oracle VALUES(6, 'Bubble Sort', 'Implementation of the bubble sort algorithm.', 1);

INSERT INTO Oracle VALUES(7, 'Heapsort', 'Implementation of the heapsort algorithm.', 1);

INSERT INTO Oracle VALUES(8, 'Insertion Sort', 'Implementation of the insertion sort algorithm.', 1);

INSERT INTO Oracle VALUES(9, 'Selection Sort', 'Implementation of the selection sort algorithm.', 1);

INSERT INTO Oracle VALUES(10, 'List', 'Implementation of a list.', 1);

INSERT INTO Oracle VALUES(11, 'Stack', 'Implementation of a stack.', 1);

INSERT INTO Oracle VALUES(12, 'Queue', 'Implementation of a queue.', 1);

INSERT INTO Oracle VALUES(13, 'Binary Tree', 'Implementation of a binary tree.', 1);

INSERT INTO Oracle VALUES(14, 'Graph', 'Implementation of a graph.', 1);

INSERT INTO Oracle VALUES(15, 'Depth-first Search', 'Implementation of the depth-first search in a graph.', 1);

INSERT INTO Oracle VALUES(16, 'Breadth-first Search', 'Implementation of the breadth-first search in a graph.', 1);

INSERT INTO Oracle VALUES(17, 'Strongly Connected Components', 'Gets the number of strongly connected components of a graph.', 1);

INSERT INTO Oracle VALUES(18, 'Prim Algorithm', 'Implementation of the Prim algorithm.', 1);

INSERT INTO Oracle VALUES(19, 'Hash Table', 'Implementation of a hash table.', 1);

INSERT INTO Oracle VALUES(20, 'Matrix Multiplication', 'Gets the result of multiplying two matrices.', 1);
