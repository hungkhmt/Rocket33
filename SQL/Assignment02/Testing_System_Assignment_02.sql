USE assignment_01;

INSERT INTO Department(department_name) VALUES ('Giám đốc'),
												('Marketing'),
												('Tài chính'),
												('Kế toán'),
												('Kỹ thuật'),
												('Nhân sự');
                   
SELECT * FROM Department;

INSERT INTO Positionn(positionn_name) VALUES ('Dev'),
											('Test'), 
											('Scum Master'), 
                                            ('PM');

SELECT * FROM Positionn;

INSERT INTO Accountt(email, user_name, full_name, department_id, positionn_id)
VALUES	('hung11812@gmail.com','hungkhmt', 'Nguyễn Thế Hưng', 5, 1),
		('hoangnguyen@gmail.com', 'hoangnguyen', 'Nguyễn Trọng Hoàng', 6, 4),
		('luudung@gmail.com', 'dungdl', 'Lưu Thùy Dung', 4, 3),
        ('lehathu@gmail.com', 'thukngu', 'Lê Hà Thu', 2, 4),
        ('dongkisot@gmail.com', 'dongkave', 'Bùi Huy Đông', 5, 2),
        ('dungmo188@gmail.com', 'dungmo', 'Nguyễn Trung Dũng', 3, 1),
        ('haiyen06@gmail.com', 'yenidl', 'Nguyễn Hải Yến', 1, 3);
        
SELECT * FROM Accountt;

INSERT INTO Groupp(group_name, creator_id, create_date)
VALUES	('Development', 1, '2023-03-28'),
		('Marketing', 4, '2023-03-28'),
        ('Testing System', 2, '2023-03-28'),
        ('Human Resources Department', 3, '2023-03-28'),
        ('Management', 1, '2023-03-28');
        
SELECT * FROM Groupp;

INSERT INTO Group_Account(group_id, account_id, join_date)
VALUES	(1, 1, '2023-04-01'),
		(2, 4, '2023-04-02'),
        (3, 2, '2023-03-29'),
        (4, 3, '2023-04-01'),
        (5, 1, '2023-04-01');
        
SELECT * FROM Group_Account;

INSERT INTO Type_Question(type_name)
VALUES	('Essay'),
		('Multiple-Choice');
        
SELECT * FROM Type_Question;

INSERT INTO Category_Question(category_name)
VALUES	('Java'),
		('Python'),
        ('PHP'),
        ('JavaScript'),
        ('Ruby'),
        ('.NET');
        
SELECT * FROM Category_Question;

INSERT INTO Question(content, category_id, type_id, creator_id, create_date)
VALUES	('Các câu hỏi liên quan đến Java', 1, 1, 1, '2023-04-15'),
		('Các câu hỏi liên quan đến Python', 2, 1, 3, '2023-04-15'),
        ('Các câu hỏi liên quan đến PHP', 3, 2, 2, '2023-04-15'),
        ('Các câu hỏi liên quan đến JavaScript', 4, 2, 2, '2023-04-15'),
        ('Các câu hỏi liên quan đến Java', 1, 2, 4, '2023-04-15'),
        ('Các câu hỏi liên quan đến Ruby', 5, 1, 4, '2023-04-15'),
        ('Các câu hỏi liên quan đến .NET', 6, 1, 5, '2023-04-15');
        
SELECT * FROM Question;

INSERT INTO Answer(content, question_id, isCorrect)
VALUES	('Câu trả lời 01', 1, true),
		('Câu trả lời 02', 1, false),
        ('Câu trả lời 03', 3, false),
        ('Câu trả lời 04', 5, true),
        ('Câu trả lời 05', 6, true),
        ('Câu trả lời 06', 2, true),
        ('Câu trả lời 07', 4, true);
        
SELECT * FROM Answer;

INSERT INTO Exam(codee, title, category_id, duration, creator_id)
VALUES	('DT01', 'Bài test Java', 1, 50, 1),
		('DT02', 'Bài test Python', 2, 50, 2),
        ('DT03', 'Bài test .NET', 6, 50, 1),
        ('DT04', 'Bài test Ruby', 5, 50, 4),
        ('DT05', 'Bài test JavaScript', 4, 50, 3),
        ('DT06', 'Bài test PHP', 3, 50, 5),
        ('DT07', 'Bài test .NET', 6, 50, 6);
        
SELECT * FROM Exam;

INSERT INTO Exam_Question(exam_id, question_id)
VALUES	(1, 1),
		(2, 2),
        (3, 7),
        (4, 6),
        (5, 4),
        (6, 3),
        (7, 7),
        (1, 5);
        
SELECT * FROM Exam_Question;
        