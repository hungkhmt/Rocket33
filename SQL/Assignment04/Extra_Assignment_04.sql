DROP DATABASE IF EXISTS extra_04;

CREATE DATABASE IF NOT EXISTS extra_04;

USE extra_04;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	department_number 	TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    department_name		VARCHAR(50)	NOT NULL		UNIQUE
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
	employee_number 	TINYINT 	UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    employee_name		VARCHAR(50)	NOT NULL		UNIQUE,
    department_number	TINYINT		UNSIGNED		NOT NULL,
    FOREIGN KEY (department_number) REFERENCES Department(department_number)
);

DROP TABLE IF EXISTS Employee_Skill;
CREATE TABLE Employee_Skill (
	employee_number 	TINYINT 	UNSIGNED,
    skill_code			VARCHAR(50)	NOT NULL,
    date_registered		DATE		NOT NULL,
    FOREIGN KEY (employee_number) REFERENCES Employee(employee_number)
);

-- Question 2
INSERT INTO Department(department_name)
VALUES	('Giám đốc'),
		('Thư ký'),
        ('Kỹ thuật'),
        ('Marketing'),
        ('Tài chính'),
        ('Kế toán'),
        ('Nhân sự'),
        ('Kỹ thuật 02'),
        ('Sales'),
        ('Bảo vệ');
        
INSERT INTO Employee(employee_name, department_number)
VALUES	('Nguyễn Thế Hưng', 3),
		('Nguyễn Trọng Hoàng', 4),
        ('Bùi Huy Đông', 2),
        ('Lê Hà Thu', 9),
        ('Nguyễn Thị Hải Yến', 3),
        ('Lưu Thuỳ Dung', 4),
        ('Nguyễn Quang Huy', 5),
        ('Phạm Thanh Sơn', 7),
        ('Nguyễn Văn Việt', 3),
        ('Lê Bảo Ngọc', 6);
        
INSERT INTO Employee_Skill(employee_number, skill_code, date_registered)
VALUES	(1, 'Java', '2023-03-18'),
		(3, 'C++', '2023-03-12'),
        (6, 'JavaScript', '2023-03-15'),
        (1, 'JavaScript', '2023-03-15'),
        (2, 'PHP', '2023-03-22'),
        (7, 'Python', '2023-03-21'),
        (9, 'Java', '2023-03-18'),
        (6, 'Ruby', '2023-03-17'),
        (1, 'Python', '2023-03-18'),
        (8, 'C++', '2023-03-20');
        
        
-- Question 3
SELECT n.employee_number, n.employee_name, k.skill_code
FROM Employee n INNER JOIN Employee_Skill k
ON n.employee_number = k.employee_number
WHERE k.skill_code = 'Java'
GROUP BY n.employee_number;

-- Question 4
SELECT d.department_number, d.department_name, COUNT(1) AS 'Số lượng nhân viên'
FROM Department d INNER JOIN Employee e
ON d.department_number = e.department_number
GROUP BY d.department_number
HAVING COUNT(d.department_number) > 3;

-- Question 5
SELECT d.*, e.employee_name
FROM Department d INNER JOIN Employee e
ON d.department_number = e.department_number
ORDER BY d.department_number;

-- Question 6
SELECT n.employee_number, n.employee_name, COUNT(1) AS 'Số lượng skill'
FROM Employee n INNER JOIN Employee_Skill k
ON n.employee_number = k.employee_number
GROUP BY n.employee_number
HAVING COUNT(n.employee_number) > 1;