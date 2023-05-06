DROP DATABASE IF EXISTS assignment_01;

CREATE DATABASE IF NOT EXISTS assignment_01;

USE assignment_01;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	department_id 	TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    department_name	VARCHAR(50)	NOT NULL		UNIQUE
);

DROP TABLE IF EXISTS Positionn;
CREATE TABLE Positionn (
	positionn_id 	TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    positionn_name	ENUM('Dev', 'Test', 'Scum Master', 'PM')	UNIQUE	NOT NULL
);

DROP TABLE IF EXISTS Accountt;
CREATE TABLE Accountt (
	account_id 		TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    email			VARCHAR(50)	NOT NULL		UNIQUE,
    user_name		VARCHAR(50)	NOT NULL		UNIQUE,
    full_name		VARCHAR(50) NOT NULL,
    department_id 	TINYINT 	UNSIGNED		NOT NULL,
    positionn_id 	TINYINT 	UNSIGNED		NOT NULL,
    create_date		DATETIME	NOT NULL		DEFAULT NOW(),
    FOREIGN KEY (department_id) REFERENCES Department(department_id),
    FOREIGN KEY (positionn_id) 	REFERENCES Positionn(positionn_id)
);

DROP TABLE IF EXISTS Groupp;
CREATE TABLE Groupp (
	group_id 		TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    group_name		VARCHAR(50)	NOT NULL		UNIQUE,
    creator_id		TINYINT		UNSIGNED		NOT NULL,
    create_date		DATE,
    FOREIGN KEY (creator_id) REFERENCES Accountt(account_id)
);

DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account (
	group_id 		TINYINT		UNSIGNED		NOT NULL,
    account_id 		TINYINT		UNSIGNED		NOT NULL,
    join_date		DATE,
	PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id) 		REFERENCES Groupp(group_id),
    FOREIGN KEY (account_id) 	REFERENCES Accountt(account_id)
);

DROP TABLE IF EXISTS Type_Question;
CREATE TABLE Type_Question (
	type_id			TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    type_name		ENUM('Essay', 'Multiple-Choice')
);

DROP TABLE IF EXISTS Category_Question;
CREATE TABLE Category_Question (
	category_id		TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    category_name	VARCHAR(30)	NOT NULL
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
	question_id		TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    content			VARCHAR(80)	NOT NULL,
    category_id		TINYINT		UNSIGNED		NOT NULL,
    type_id			TINYINT		UNSIGNED		NOT NULL,
    creator_id		TINYINT		UNSIGNED		NOT NULL,	
    create_date		DATE,
    FOREIGN KEY	(category_id)	REFERENCES	Category_Question(category_id),
    FOREIGN KEY	(type_id)		REFERENCES	Type_Question(type_id),
    FOREIGN KEY (creator_id) REFERENCES Accountt(account_id)
);

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
	answer_id		TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    content			VARCHAR(80)	NOT NULL,
    question_id		TINYINT		UNSIGNED		NOT NULL,
	isCorrect		BOOLEAN,
    FOREIGN KEY	(question_id)	REFERENCES	Question(question_id)
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	exam_id			TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    codee			char(10)	NOT NULL,
    title			VARCHAR(50)	NOT NULL,
    category_id 	TINYINT		UNSIGNED		NOT NULL,
    duration		TINYINT		UNSIGNED		NOT NULL,
    creator_id		TINYINT		UNSIGNED		NOT NULL,
    create_date		DATETIME 	DEFAULT NOW(),
    FOREIGN KEY (creator_id) REFERENCES Accountt(account_id),
    FOREIGN KEY (category_id) REFERENCES Category_Question(category_id)
);

DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question (
	exam_id			TINYINT		UNSIGNED,
    question_id		TINYINT		UNSIGNED,
    PRIMARY KEY(exam_id, question_id),
    FOREIGN KEY	(exam_id)		REFERENCES	Exam(exam_id),
    FOREIGN KEY	(question_id)	REFERENCES	Question(question_id)
);