DROP DATABASE progtest;
CREATE DATABASE progtest;
USE progtest;

CREATE TABLE user (
	idCode INT NOT NULL AUTO_INCREMENT,
	userName VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(100),
	email VARCHAR(100) UNIQUE,
	password VARCHAR(80),
	role VARCHAR(10) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (idCode)
);

CREATE TABLE course (
	idCode INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	startDate DATE,
	endDate DATE,
	instructor INT NOT NULL,
	CONSTRAINT PK_course PRIMARY KEY (idCode),
	CONSTRAINT FK_course_instructor FOREIGN KEY (instructor) REFERENCES user (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE student_course (
	student INT NOT NULL,
	course INT NOT NULL,
	CONSTRAINT PK_student_course PRIMARY KEY (student, course),
	CONSTRAINT FK_student_course_student FOREIGN KEY (student) REFERENCES user (idCode) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_student_course_course FOREIGN KEY (course) REFERENCES course (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE oracle (
	idCode INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(50),
	description VARCHAR(500),
	CONSTRAINT PK_oracle PRIMARY KEY (idCode)
);

CREATE TABLE assignment (
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
	CONSTRAINT FK_assignment_course FOREIGN KEY (course) REFERENCES course (idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE evaluation (
	student INT NOT NULL,
	course INT NOT NULL,
	assignment INT NOT NULL,
	submissionDate DATETIME,
	score DOUBLE,
	CONSTRAINT PK_evaluation PRIMARY KEY (student, course, assignment),
	CONSTRAINT FK_evaluation_student FOREIGN KEY (student) REFERENCES user (idCode) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_evaluation_assignment FOREIGN KEY (course, assignment) REFERENCES assignment (course, idCode) ON UPDATE CASCADE ON DELETE CASCADE
);

DELIMITER $$

CREATE TRIGGER `insert_student_course` AFTER INSERT ON `student_course` 
    FOR EACH ROW BEGIN
	DECLARE i INT DEFAULT 0;
	SELECT MAX(assignment.idCode) INTO i FROM assignment WHERE assignment.course = NEW.course;
	WHILE i > 0 DO
		IF (SELECT COUNT(*) FROM assignment WHERE assignment.course = NEW.course AND assignment.idCode = i) > 0 THEN
			INSERT INTO evaluation(student, course, assignment, score) VALUES(NEW.student, NEW.course, i, 0);
		END IF;
		SET i = i - 1;
	END WHILE;
END;$$

CREATE TRIGGER `remove_student_course` BEFORE DELETE ON `student_course` 
    FOR EACH ROW BEGIN
	DECLARE i INT DEFAULT 0;
	SELECT MAX(assignment.idCode) INTO i FROM assignment WHERE assignment.course = OLD.course;
	WHILE i > 0 DO
		IF (SELECT COUNT(*) FROM assignment WHERE assignment.course = OLD.course AND assignment.idCode = i) > 0 THEN
			DELETE FROM evaluation WHERE evaluation.student = OLD.student AND evaluation.course = OLD.course AND assignment = i;
		END IF;
		SET i = i - 1;
	END WHILE;
END;$$

CREATE TRIGGER `insert_assignment` AFTER INSERT ON `assignment` 
    FOR EACH ROW BEGIN
	DECLARE i INT DEFAULT 0;
	SELECT MAX(student_course.student) INTO i FROM student_course WHERE student_course.course = NEW.course;
	WHILE i > 0 DO
		IF (SELECT COUNT(*) FROM student_course WHERE student_course.course = NEW.course AND student_course.student = i) > 0 THEN
			INSERT INTO evaluation(student, course, assignment, score) VALUES(i, NEW.course, NEW.idCode, 0);
		END IF;
		SET i = i - 1;
	END WHILE;
END;$$

DELIMITER ;

INSERT INTO user VALUES(1, 'progtest', 'ProgTest', 'progtest@gmail.com', 'progtest', 'instructor');

INSERT INTO oracle VALUES(1, 'Valor Máximo', 'Implementar um programa que obtem o maior valor de uma sequência de números. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando uma sequência de números separados por vírgula e retorne uma String representando o maior número da sequência de entrada.');

INSERT INTO oracle VALUES(2, 'Valores Máximo e Mínimo', 'Implementar um programa que obtem o maior e o menor valor de uma sequência de números. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando uma sequência de números separados por vírgula e retorne uma String representando o maior e menor número da sequência de entrada separados por vírgula.');

INSERT INTO oracle VALUES(3, 'Fibonacci', 'Implementar um programa que calcula a equação de Fibonacci para um determinado número. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando o número a ser calculado e retorna uma String representando o número resultante do cálculo.');

INSERT INTO oracle VALUES(4, 'Casamento de Cadeias de Caracteres', 'Implementar um programa que realiza busca em cadeias de caracteres. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro duas Strings e retorna uma String representando o posição em que o valor das Strings de entrada casam.');

INSERT INTO oracle VALUES(5, 'Ordenação', 'Implementar um programa que ordena uma sequência de números. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando uma sequência de números separados por vírgula e retorne uma String representando a sequência de números ordenada.');

INSERT INTO oracle VALUES(6, 'BubbleSort', 'Implementar o BubbleSrot. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando uma sequência de números separados por vírgula e uma String representando o número de iterações do algorítmo deverá ser executada. O método deverá retornar uma String com a sequência de número obtida após realizar as iterações.');

INSERT INTO oracle VALUES(7, 'HeapSort', 'Implementar o HeapSrot. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando uma sequência de números separados por vírgula e uma String representando o número de iterações do algorítmo deverá ser executada. O método deverá retornar uma String com a sequência de número obtida após realizar as iterações.');

INSERT INTO oracle VALUES(8, 'Inserção Simples', 'Implementar o algorítmo de ordenação Inserção Simples. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando uma sequência de números separados por vírgula e uma String representando o número de iterações do algorítmo deverá ser executada. O método deverá retornar uma String com a sequência de número obtida após realizar as iterações.');

INSERT INTO oracle VALUES(9, 'Seleção Simples', 'Implementar o algorítmo de ordenação Seleção Simples. O programa deverá ter uma classe Main com um metodo main que recebe como parâmetro uma String representando uma sequência de números separados por vírgula e uma String representando o número de iterações do algorítmo deverá ser executada. O método deverá retornar uma String com a sequência de número obtida após realizar as iterações.');

INSERT INTO oracle VALUES(10, 'Lista', 'Implementar uma lista. O programa deverá ter uma classe Lista com os métodos add, remove, print. O último deve retornar uma String com os valores presentes na lista separados por vírgula.');

INSERT INTO oracle VALUES(11, 'Pilha', 'Implementar uma pilha. O programa deverá ter uma classe Pilha com os métodos push, pop, print. O último deve retornar uma String com os valores presentes na pilha separados por vírgula.');

INSERT INTO oracle VALUES(12, 'Fila', 'Implementar uma fila. O programa deverá ter uma classe Fila com os métodos add, remove, print. O último deve retornar uma String com os valores presentes na fila separados por vírgula.');

INSERT INTO oracle VALUES(13, 'Árvore Binária', 'Implementar uma árvore binária. O programa deverá ter uma classe BTree com os métodos add, remove, print. O último deve retornar uma String com os valores presentes na árvore separados por vírgula.');

INSERT INTO oracle VALUES(14, 'Grafo', 'Implementar um grafo. O programa deverá ter uma classe Grafo com os métodos addEdge, removeEdge, print. O último deve retornar uma String com as arestas do Grafo.');

INSERT INTO oracle VALUES(15, 'Busca em Profundidade', 'Implementar a busca em profundidade em um grafo. O programa deverá ter uma classe Grafo com os métodos add, remove, search. O último deve retornar uma String com os valores dos vertices na ordem que foram visitados.');

INSERT INTO oracle VALUES(16, 'Busca em Largura', 'Implementar a busca em largura em um grafo. O programa deverá ter uma classe Grafo com os métodos add, remove, search. O último deve retornar uma String com os valores dos vertices na ordem que foram visitados.');

INSERT INTO oracle VALUES(17, 'Componentes Fortemente Conectadas', 'Implementar um algorítimo para identificar as componentes fortemente conectadas de um Grafo. O programa deverá ter uma classe Grafo com os métodos add, remove e cfc. O último deve retornar uma String com o número de componentes fortemente conectadas.');

INSERT INTO oracle VALUES(18, 'Algorítmo de Prim', 'Implementar o algorítmo de Prim. O programa deverá ter uma classe Grafo com os métodos add, remove e prim. O último deve retornar um Grafo correspondente a árvore geradora mínima');

INSERT INTO oracle VALUES(19, 'Tabela Hash', 'Implementar uma tabela hash. O programa deverá ter uma classe Hash com os métodos add, remove, print. O último deve retornar uma String com os valores presentes na tabela hash separados por vírgula.');

INSERT INTO oracle VALUES(20, 'Avaliação de Multiplicação de Matrizes', 'Avaliação de Multiplicação de Matrizes');