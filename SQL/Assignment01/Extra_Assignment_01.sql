DROP DATABASE IF EXISTS fresher_management;
CREATE DATABASE fresher_management;

USE fresher_management;

-- Exercise 1
CREATE TABLE Trainee (
	trainee_id	TINYINT		UNSIGNED	PRIMARY KEY	AUTO_INCREMENT,
    full_name	VARCHAR(50)	NOT NULL,
    birth_date	DATE		NOT NULL,
    gender		ENUM('Male', 'Female', 'unknown'),
    et_iq		TINYINT		NOT NULL	CHECK(et_iq >=0 and et_iq<=20),
    et_gmath	TINYINT		NOT NULL	CHECK(et_gmath >=0 and et_gmath<=20),
    et_english	TINYINT		NOT NULL	CHECK(et_english >=0 and et_english<=50),
    training_class	CHAR(6)	NOT NULL,
    evaluation_notes		VARCHAR(100)
);
ALTER TABLE Trainee
ADD COLUMN VTI_Account VARCHAR(30)	NOT NULL	UNIQUE;

-- Exercise 2
CREATE TABLE datatypes (
	data_id		MEDIUMINT	UNSIGNED	PRIMARY KEY	AUTO_INCREMENT,
    data_name	VARCHAR(50)	NOT NULL,
    data_code	CHAR(5)		NOT NULL,
    modified_date	DATETIME	DEFAULT NOW()
);

-- Exercise 3
CREATE TABLE datatypes2 (
	data_id2	MEDIUMINT	UNSIGNED	PRIMARY KEY	AUTO_INCREMENT,
    data_name2	VARCHAR(50)	NOT NULL,
    birth_date	DATE		NOT NULL,
    
    -- 0: Male, 1: Female, NULL: Unknown
    gender		TINYINT		CHECK (gender IN (0, 1, NULL)),
    
    -- 0: Đang hoạt động, 1: Đã xoá
    is_delete_flag			BOOL
);