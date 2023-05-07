USE assignment_01;

-- Question 1
INSERT INTO Department(department_name) VALUES ('Phó giám đốc'),
												('Thư ký'),
												('Sales'),
												('Bảo vệ'),
												('Marketing 02'),
												('Tài chính 02'),
                                                ('Kế toán 02'),
                                                ('Kỹ thuật 02'),
                                                ('Nhân sự 02'),
                                                ('Kỹ thuật 03');
                                                
SELECT * FROM Department;

INSERT INTO Accountt(email, user_name, full_name, department_id, positionn_id)
VALUES	('vinhda@gmail.com','vinhdonganh', 'Đỗ Khánh Vinh', 10, 1),
		('huongnguyen@gmail.com', 'huongnguyen', 'Nguyễn Thị Hương', 11, 4),
		('habui@gmail.com', 'habui', 'Bùi Thị Hà', 12, 3),
        ('nguyenngu@gmail.com', 'nguyenngu', 'Phạm Thảo Nguyên', 9, 4),
        ('trunganh11@gmail.com', 'trunganh', 'Nguyễn Trung Anh', 7, 2),
        ('tuantuat@gmail.com', 'tuantuat', 'Nguyễn Văn Tuấn', 8, 1),
        ('truongki33@gmail.com', 'truongki', 'Nguyễn Hữu Trường', 16, 1),
        ('tranghoang@gmail.com', 'tranghoang', 'Hoàng Thu Trang', 15, 1),
        ('lanvan104@gmail.com', 'lanvan', 'Nguyễn Thị Lan', 14, 1),
        ('haudoo@gmail.com', 'haudoo', 'Đỗ Thị Hậu', 16, 3);
        
SELECT * FROM Accountt;

INSERT INTO Groupp(group_name, creator_id, create_date)
VALUES	('Development 02', 1, '2023-03-28'),
		('Marketing 02', 4, '2023-03-28'),
        ('Testing System 02', 2, '2023-03-28'),
        ('Secretary', 13, '2023-03-28'),
        ('Finance', 6, '2023-03-28'),
        ('Finance 02', 10, '2023-03-28'),
        ('Sales', 11, '2023-03-28'),
        ('Development 03', 17, '2023-03-28'),
        ('Human Resources Department 02', 15, '2023-03-28'),
        ('Management 02', 12, '2023-03-28');
        
SELECT * FROM Groupp;

INSERT INTO Group_Account(group_id, account_id, join_date)
VALUES	(6, 11, '2023-04-01'),
		(7, 6, '2023-04-02'),
        (8, 9, '2023-03-29'),
        (9, 13, '2023-04-01'),
        (10, 12, '2023-04-01'),
        (11, 8, '2023-03-29'),
        (12, 16, '2023-04-01'),
        (13, 15, '2023-04-02'),
        (14, 7, '2023-04-02'),
        (15, 5, '2023-04-01');
        
SELECT * FROM Group_Account;

INSERT INTO Category_Question(category_name)
VALUES	('C/C++'),
		('C#'),
        ('SQL'),
        ('Swift');
        
SELECT * FROM Category_Question;

INSERT INTO Question(content, category_id, type_id, creator_id, create_date)
VALUES	('Các câu hỏi liên quan đến C/C++', 7, 1, 11, '2023-04-15'),
		('Các câu hỏi liên quan đến C#', 8, 1, 13, '2023-04-15'),
        ('Các câu hỏi liên quan đến SQL', 9, 2, 12, '2023-04-15'),
        ('Các câu hỏi liên quan đến Swift', 10, 2, 8, '2023-04-15'),
        ('Các câu hỏi liên quan đến PHP', 3, 2, 9, '2023-04-15'),
        ('Các câu hỏi liên quan đến Python', 2, 2, 1, '2023-04-15'),
        ('Các câu hỏi liên quan đến .NET', 6, 1, 15, '2023-04-15'),
        ('Các câu hỏi liên quan đến SQL', 9, 1, 16, '2023-04-15'),
        ('Các câu hỏi liên quan đến C/C++', 7, 1, 13, '2023-04-15'),
        ('Các câu hỏi liên quan đến JavaScript', 4, 2, 15, '2023-04-15');
        
SELECT * FROM Question;

INSERT INTO Answer(content, question_id, isCorrect)
VALUES	('Câu trả lời 08', 12, true),
		('Câu trả lời 08', 11, false),
        ('Câu trả lời 10', 9, false),
        ('Câu trả lời 11', 8, true),
        ('Câu trả lời 12', 8, true),
        ('Câu trả lời 13', 10, false),
        ('Câu trả lời 14', 15, true),
        ('Câu trả lời 15', 13, false),
        ('Câu trả lời 16', 7, true),
        ('Câu trả lời 17', 14, true);
        
SELECT * FROM Answer;

INSERT INTO Exam(codee, title, category_id, duration, creator_id)
VALUES	('DT08', 'Bài test C/C++', 7, 50, 11),
		('DT09', 'Bài test Swift', 10, 50, 12),
        ('DT10', 'Bài test SQL', 9, 50, 10),
        ('DT11', 'Bài test SQL', 9, 50, 4),
        ('DT12', 'Bài test C#', 8, 50, 6),
        ('DT13', 'Bài test C/C++', 7, 50, 9),
        ('DT14', 'Bài test Ruby', 5, 50, 15),
        ('DT15', 'Bài test JavaScript', 4, 50, 16),
        ('DT16', 'Bài test PHP', 3, 50, 8),
        ('DT17', 'Bài test .NET', 6, 50, 11);
        
SELECT * FROM Exam;

INSERT INTO Exam_Question(exam_id, question_id)
VALUES	(8, 8),
		(9, 11),
        (10, 10),
        (11, 10),
        (12, 9),
        (13, 8),
        (14, 6),
		(15, 17),
        (16, 12),
        (17, 14);
        
SELECT * FROM Exam_Question;


-- Question 2
SELECT * FROM Department;

-- Question 3
SELECT department_id FROM Department
WHERE department_name = 'Sales';

-- Question 4
SELECT * FROM Accountt
ORDER BY CHAR_LENGTH(full_name) DESC LIMIT 1;

-- Question 5
SELECT * FROM Accountt
WHERE department_id = 3
ORDER BY CHAR_LENGTH(full_name) DESC LIMIT 1;

-- Question 6
SELECT * FROM Groupp
WHERE create_date > '2019-12-20';

-- Question 7
SELECT question_id FROM Answer
GROUP BY question_id
HAVING count(question_id) >= 4;

-- Question 8
SELECT exam_id FROM Exam
WHERE duration >= 60 and create_date < '2019-12-20';

-- Question 9
SELECT * FROM Groupp
ORDER BY create_date DESC LIMIT 5;

-- Question 10
SELECT COUNT(department_id) FROM Accountt
WHERE department_id = 2
GROUP BY department_id;

-- Question 11
SELECT * FROM Accountt
WHERE full_name LIKE 'D%' AND '%o';

-- Question 12
DELETE
FROM Exam
WHERE create_date < '2019-12-20';

-- Question 13
DELETE
FROM Question
WHERE content LIKE ('Câu hỏi %');

-- Question 14
UPDATE Accountt
SET full_name = 'Nguyễn Bá Lộc', email = 'loc.nguyenba@vti.com.vn'
WHERE account_id = 5;

-- Question 15
UPDATE Group_Account
SET group_id = 4
WHERE account_id = 5;

