DROP DATABASE draylson;
CREATE DATABASE draylson;
USE draylson;

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

CREATE TABLE Enrollment (
	student INT NOT NULL,
	course INT NOT NULL,
	CONSTRAINT PK_enrollment PRIMARY KEY (student, course),
	CONSTRAINT FK_enrollment_student FOREIGN KEY (student) REFERENCES User (idCode) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_enrollment_course FOREIGN KEY (course) REFERENCES Course (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Assignment (
	idCode INT NOT NULL,
	course INT,
	title VARCHAR(50),
	description VARCHAR(500),
	startDate DATETIME,
	endDate DATETIME,
	timeout INT,
	minimumCoverage INT,
	pstsVisible BOOLEAN,
	pitsVisible BOOLEAN,
	pstiVisible BOOLEAN,
	pstsWeight DOUBLE,
	pitsWeight DOUBLE,
	pstiWeight DOUBLE,
	pitiCoverage DOUBLE,
	CONSTRAINT PK_assignment PRIMARY KEY (idCode),
	CONSTRAINT FK_assignment_course FOREIGN KEY (course) REFERENCES Course (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Oracle (
	idCode INT NOT NULL,
	title VARCHAR(50),
	description VARCHAR(500),
	language VARCHAR(50),
	CONSTRAINT PK_oracle PRIMARY KEY (idCode)
);

CREATE TABLE Tool (
	idCode INT NOT NULL,
	name VARCHAR(50),
	language VARCHAR(50),
	compiler VARCHAR(50),
	testFormat VARCHAR(50),
	commandFile VARCHAR(50),
	outputFile VARCHAR(50),
	CONSTRAINT PK_tool PRIMARY KEY (idCode)
);

CREATE TABLE Criterion (
	tool INT NOT NULL,
	idCode INT NOT NULL,
	name VARCHAR(50),
	propertyKey VARCHAR(50),
	CONSTRAINT PK_criterion PRIMARY KEY (tool, idCode),
	CONSTRAINT FK_criterion_tool FOREIGN KEY (tool) REFERENCES Tool (idCode)
);

CREATE TABLE Operator (
	tool INT NOT NULL,
	criterion INT NOT NULL,
	idCode INT NOT NULL,
	name VARCHAR(50),
	parameter VARCHAR(50),
	required BOOLEAN,
	CONSTRAINT PK_operator PRIMARY KEY (tool, criterion, idCode),
	CONSTRAINT FK_operator_criterion FOREIGN KEY (tool, criterion) REFERENCES Criterion (tool, idCode)
);

CREATE TABLE Requisite (
	assignment INT NOT NULL,
	tool INT NOT NULL,
	criterion INT NOT NULL,
	weight DOUBLE,
	pstsRequired BOOLEAN,
	pitsRequired BOOLEAN,
	pstiRequired BOOLEAN,
	executionParameters VARCHAR(5000),
	CONSTRAINT PK_requisite PRIMARY KEY (assignment, tool, criterion),
	CONSTRAINT FK_requisite_assignment FOREIGN KEY (assignment) REFERENCES Assignment (idCode),
	CONSTRAINT FK_requisite_criterion FOREIGN KEY (tool, criterion) REFERENCES Criterion (tool, idCode)
);

CREATE TABLE Submission (
	student INT NOT NULL,
	assignment INT NOT NULL,
	submissionDate DATETIME,
	pstsCoverage DOUBLE,
	pitsCoverage DOUBLE,
	pstiCoverage DOUBLE,
	grade DOUBLE,
	CONSTRAINT PK_evaluation PRIMARY KEY (student, assignment),
	CONSTRAINT FK_evaluation_student FOREIGN KEY (student) REFERENCES User (idCode) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_evaluation_assignment FOREIGN KEY (assignment) REFERENCES Assignment (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Sequence (
	entity VARCHAR(50),
	id INT,
	CONSTRAINT PK_Sequence PRIMARY KEY (entity)
);

DELIMITER $$

CREATE TRIGGER `insert_student_evaluations` AFTER INSERT ON `Enrollment` 
    FOR EACH ROW BEGIN
	DECLARE i INT DEFAULT 0;
	SELECT MAX(Assignment.idCode) INTO i FROM Assignment WHERE Assignment.course = NEW.course;
	WHILE i > 0 DO
		IF (SELECT COUNT(*) FROM Assignment WHERE Assignment.course = NEW.course AND Assignment.idCode = i) > 0 THEN
			INSERT INTO Submission(student, assignment, pstTst, pinstTst, pstTinst, score) VALUES(NEW.student, i, 0, 0, 0, 0);
		END IF;
		SET i = i - 1;
	END WHILE;
END;$$

CREATE TRIGGER `delete_student_evaluations` BEFORE DELETE ON `Enrollment` 
    FOR EACH ROW BEGIN
	DECLARE i INT DEFAULT 0;
	SELECT MAX(Assignment.idCode) INTO i FROM Assignment WHERE Assignment.course = OLD.course;
	WHILE i > 0 DO
		IF (SELECT COUNT(*) FROM Assignment WHERE Assignment.course = OLD.course AND Assignment.idCode = i) > 0 THEN
			DELETE FROM Submission WHERE Submission.student = OLD.student AND Assignment = i;
		END IF;
		SET i = i - 1;
	END WHILE;
END;$$

CREATE TRIGGER `insert_students_evaluations` AFTER INSERT ON `Assignment` 
    FOR EACH ROW BEGIN
	DECLARE i INT DEFAULT 0;
	SELECT MAX(Enrollment.student) INTO i FROM Enrollment WHERE Enrollment.course = NEW.course;
	WHILE i > 0 DO
		IF (SELECT COUNT(*) FROM Enrollment WHERE Enrollment.course = NEW.course AND Enrollment.student = i) > 0 THEN
			INSERT INTO Submission(student, assignment, pstTst, pinstTst, pstTinst, score) VALUES(i, NEW.idCode, 0, 0, 0, 0);
		END IF;
		SET i = i - 1;
	END WHILE;
END;$$

DELIMITER ;

INSERT INTO Sequence VALUES('User', 100);

INSERT INTO Sequence VALUES('Course', 100);

INSERT INTO Sequence VALUES('Assignment', 100);

INSERT INTO Sequence VALUES('Oracle', 100);

INSERT INTO Sequence VALUES('Tool', 100);

INSERT INTO User VALUES(1, 'progtest', 'ProgTest', 'progtest@gmail.com', 'progtest', 'instructor');

INSERT INTO Tool VALUES(1, 'JUnit', 'Java', 'Javac', 'JUnit', 'cmdlines.txt', 'output.properties');

INSERT INTO Criterion VALUES(1, 1, 'Pass Rate', 'passrate');

INSERT INTO Tool VALUES(2, 'JaBUTiService', 'Java', 'Javac', 'JUnit', 'cmdlines.txt', 'output.properties');

INSERT INTO Criterion VALUES(2, 1, 'All-Nodes-ei', 'all.nodes.ei');

INSERT INTO Criterion VALUES(2, 2, 'All-Nodes-ed', 'all.nodes.ed');

INSERT INTO Criterion VALUES(2, 3, 'All-Edges-ei', 'all.edges.ei');

INSERT INTO Criterion VALUES(2, 4, 'All-Edges-ed', 'all.edges.ed');

INSERT INTO Criterion VALUES(2, 5, 'All-Uses-ei', 'all.uses.ei');

INSERT INTO Criterion VALUES(2, 6, 'All-Uses-ed', 'all.uses.ed');

INSERT INTO Criterion VALUES(2, 7, 'All-Potencial-Uses-ei', 'all.potencial.uses.ei');

INSERT INTO Criterion VALUES(2, 8, 'All-Potencial-Uses-ed', 'all.potencial.uses.ed');

INSERT INTO Tool VALUES(3, 'Jumble', 'Java', 'Javac', 'JUnit', 'cmdlines.txt', 'output.properties');

INSERT INTO Criterion VALUES(3, 1, 'Mutants Analysis', 'score');

INSERT INTO Operator VALUES(3, 1, 1, 'Conditionals', NULL, TRUE);

INSERT INTO Operator VALUES(3, 1, 2, 'Binary Arithmetic Operations', NULL, TRUE);

INSERT INTO Operator VALUES(3, 1, 3, 'Increments', '-i', FALSE);

INSERT INTO Operator VALUES(3, 1, 4, 'Inline Constants', '-k', FALSE);

INSERT INTO Operator VALUES(3, 1, 5, 'Class Pool Constants', '-w', FALSE);

INSERT INTO Operator VALUES(3, 1, 6, 'Return Values', '-r', FALSE);

INSERT INTO Operator VALUES(3, 1, 7, 'Switch Statements', '-j', FALSE);

INSERT INTO Tool VALUES(4, 'CUnit', 'C', 'GCC', 'CUnit', 'cmdlines.txt', 'output.properties');

INSERT INTO Criterion VALUES(4, 1, 'Pass Rate', 'passrate');

INSERT INTO Tool VALUES(5, 'GCov', 'C', 'GCC', 'CUnit', 'cmdlines.txt', 'output.properties');

INSERT INTO Criterion VALUES(5, 1, 'All-Nodes', 'allnodes');

INSERT INTO Criterion VALUES(5, 2, 'All-Edges', 'alledges');

INSERT INTO Tool VALUES(6, 'Proteum', 'C', 'GCC', 'CUnit', 'cmdlines.txt', 'output.properties');

INSERT INTO Criterion VALUES(6, 1, 'Mutants Analysis', 'score');

INSERT INTO Operator VALUES(6, 1, 1, 'OAAA - Arithmetic Assignment Mutation', '-u-OAAA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 2, 'OAAN - Arithmetic Operator Mutation', '-u-OAAN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 3, 'OABA - Arithmetic Assignment by Bitwise Assignment', '-u-OABA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 4, 'OABN - Arithmetic by Bitwise Operator', '-u-OABN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 5, 'OAEA - Arithmetic Assignment by Plain Assignment', '-u-OAEA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 6, 'OALN - Arithmetic Operator by Logical Operator', '-u-OALN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 7, 'OARN - Arithmetic Operator by Relacional Operator', '-u-OARN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 8, 'OASA - Arithmetic Assignment by Shift Assignment', '-u-OASA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 9, 'OASN - Arithmetic Operator by Shift Operator', '-u-OASN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 10, 'OBAA - Bitwise Assignment by Arithmetic Assignment', '-u-OBAA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 11, 'OBAN - Bitwise Operator by Arithmetic Assignment', '-u-OBAN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 12, 'OBBA - Bitwise Assignment Mutation', '-u-OBBA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 13, 'OBBN - Bitwise Operator Mutation', '-u-OBBN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 14, 'OBEA - Bitwise Assignment by Plain Assignment', '-u-OBEA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 15, 'OBLN - Bitwise Operator by Logical Operator', '-u-OBLN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 16, 'OBNG - Bitwise Negation', '-u-OBNG 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 17, 'OBRN - Bitwise Operator by Relational Operator', '-u-OBRN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 18, 'OBSA - Bitwise Assignment by Shift Assignment', '-u-OBSA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 19, 'OBSN - Bitwise Operator by Shift Operator', '-u-OBSN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 20, 'OCNG - Logical Context Negation', '-u-OCNG 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 21, 'OCOR - Cast Operator by Cast Operator', '-u-OCOR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 22, 'OEAA - Plain Assignment by Arithmetic Assignment', '-u-OEAA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 23, 'OEBA - Plain Assignment by Bitwise Assignment', '-u-OEBA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 24, 'OESA - Plain Assignment by Shift Assignment', '-u-OESA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 25, 'Oido - Increment/Decrement Mutation', '-u-Oido 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 26, 'OIPM - Indirection Operator Precedence Mutation', '-u-OIPM 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 27, 'OLAN - Logical Operator by Arithmentic Operator', '-u-OLAN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 28, 'OLBN - Logical Operator by Bitwise Operator', '-u-OLBN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 29, 'OLLN - Logical Operator Mutation', '-u-OLLN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 30, 'OLNG - Logical Negation', '-u-OLNG 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 31, 'OLRN - Logical Operator by Relational Operator', '-u-OLRN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 32, 'OLSN - Logial Operator by Shift Operator', '-u-OLSN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 33, 'ORAN - Relational Operator by Arithmentic Operator', '-u-ORAN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 34, 'ORBN - Relational Operator by Bitwise Operator', '-u-ORBN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 35, 'ORLN - Relational Operator by Logical Operator', '-u-ORLN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 36, 'ORRN - Relational Operator Mutation', '-u-ORRN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 37, 'ORSN - Relational Operator by Shift Operator', '-u-ORSN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 38, 'OSAA - Shift Assignment by Arithmetic Assignment', '-u-OSAA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 39, 'OSAN - Shift Operator by Arithmetic Operator', '-u-OSAN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 40, 'OSBA - Shift Assignment by Bitwise Assignment', '-u-OSBA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 41, 'OSBN - Shift Operator by Bitwise Operator', '-u-OSBN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 42, 'OSEA - Shift Assignment by Plain Assignment', '-u-OSEA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 43, 'OSLN - Shift Operator by Logical Operator', '-u-OSLN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 44, 'OSRN - Shift Operator by Relational Operator', '-u-OSRN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 45, 'OSSA - Shift Assignment Mutation', '-u-OSSA 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 46, 'OSSN - Shift Operator Mutation', '-u-OSSN 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 47, 'SBRC - break Replacement by continue', '-u-SBRC 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 48, 'SBRn - break Out to Nth Level', '-u-SBRn 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 49, 'SCRB - continue Replacement by break', '-u-SCRB 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 50, 'SCRn - continue Out to Nth Level', '-u-SCRn 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 51, 'SDWD - do-while Replacement by while', '-u-SDWD 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 52, 'SGLR - goto Label Replacement', '-u-SGLR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 53, 'SMTC - n-trip continue', '-u-SMTC 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 54, 'SMTT - n-trip trap', '-u-SMTT 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 55, 'SMVB - Move Brace Up and Down', '-u-SMVB 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 56, 'SRSR - return Replacement', '-u-SRSR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 57, 'SSDL - Statement Deletion', '-u-SSDL 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 58, 'SSWM - switch Statement Mutation', '-u-SSWM 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 59, 'STRI - Trap on if Condition', '-u-STRI 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 60, 'STRP - Trap on Statement Execution', '-u-STRP 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 61, 'SWDD - while Replacement by do-while', '-u-SWDD 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 62, 'VDTR - Domain Traps', '-u-VDTR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 63, 'VGAR - Mutate Global Array References', '-u-VGAR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 64, 'VGPR - Mutate Global Pointer references', '-u-VGPR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 65, 'VGSR - Mutate Global Scalar References', '-u-VGSR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 66, 'VGTR - Mutate Global Structure References', '-u-VGTR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 67, 'VLAR - Mutate Local Array References', '-u-VLAR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 68, 'VLPR - Mutate Local Pointer References', '-u-VLPR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 69, 'VLSR - Mutate Local Scalar References', '-u-VLSR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 70, 'VLTR - Mutate Local Structure References', '-u-VLTR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 71, 'VSCR - Structure Component Replacement', '-u-VSCR 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 72, 'VTWD - Twiddle Mutations', '-u-VTWD 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 73, 'Cccr - Constant for Constant Replacement', '-u-Cccr 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 74, 'Ccsr - Constant for Scalar Replacement', '-u-Ccsr 100 0', FALSE);

INSERT INTO Operator VALUES(6, 1, 75, 'CRCR - Required Constant Replacement', '-u-CRCR 100 0', FALSE);

INSERT INTO Oracle VALUES(1, 'Maximum Value', 'Obtains the highest value of a sequence of integers.', 'Java');

INSERT INTO Oracle VALUES(2, 'Maximum and Minimum Value', 'Obtains the highest and lowest values of a sequence of integers.', 'Java');

INSERT INTO Oracle VALUES(3, 'Fibonacci', 'Computes the Fibonacci sequence.', 'Java');

INSERT INTO Oracle VALUES(4, 'String Marriage', 'Searches the occurrence of one string in another string.', 'Java');

INSERT INTO Oracle VALUES(5, 'Sort', 'Sorts a sequence of numbers.', 'Java');

INSERT INTO Oracle VALUES(6, 'Bubble Sort', 'Implementation of the bubble sort algorithm.', 'Java');

INSERT INTO Oracle VALUES(7, 'Heapsort', 'Implementation of the heapsort algorithm.', 'Java');

INSERT INTO Oracle VALUES(8, 'Insertion Sort', 'Implementation of the insertion sort algorithm.', 'Java');

INSERT INTO Oracle VALUES(9, 'Selection Sort', 'Implementation of the selection sort algorithm.', 'Java');

INSERT INTO Oracle VALUES(10, 'List', 'Implementation of a list.', 'Java');

INSERT INTO Oracle VALUES(11, 'Stack', 'Implementation of a stack.', 'Java');

INSERT INTO Oracle VALUES(12, 'Queue', 'Implementation of a queue.', 'Java');

INSERT INTO Oracle VALUES(13, 'Binary Tree', 'Implementation of a binary tree.', 'Java');

INSERT INTO Oracle VALUES(14, 'Graph', 'Implementation of a graph.', 'Java');

INSERT INTO Oracle VALUES(15, 'Depth-first Search', 'Implementation of the depth-first search in a graph.', 'Java');

INSERT INTO Oracle VALUES(16, 'Breadth-first Search', 'Implementation of the breadth-first search in a graph.', 'Java');

INSERT INTO Oracle VALUES(17, 'Strongly Connected Components', 'Gets the number of strongly connected components of a graph.', 'Java');

INSERT INTO Oracle VALUES(18, 'Prim Algorithm', 'Implementation of the Prim algorithm.', 'Java');

INSERT INTO Oracle VALUES(19, 'Hash Table', 'Implementation of a hash table.', 'Java');

INSERT INTO Oracle VALUES(20, 'Matrix Multiplication', 'Gets the result of multiplying two matrices.', 'Java');
