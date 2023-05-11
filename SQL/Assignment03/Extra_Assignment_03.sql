USE fresher_management;

INSERT INTO Trainee (full_name, birth_date, gender, et_iq, et_gmath, et_english, training_class, evaluation_notes, VTI_Account)
VALUES	('Nguyễn Thế Hưng', '2002-12-18', 'Male', 16, 15, 44, 'VTI001', 'Good', 'hungkhmt'),
		('Nguyễn Trọng Hoàng', '2001-12-15', 'Male', 14, 15, 40, 'VTI001', 'Good', 'hoangngu'),
        ('Nguyễn Hải Yến', '2002-05-06', 'Female', 12, 11, 38, 'VTI002', 'Good', 'yennt'),
        ('Lê Bảo Ngọc', '2002-09-05', 'Female', 05, 06, 14, 'VTI003', 'Bad', 'ngocle'),
        ('Bùi Huy Đông', '2000-10-02', 'Male', 17, 15, 44, 'VTI003', 'Good', 'dongkisot'),
        ('Lưu Thuỳ Dung', '2002-12-16', 'Female', 15, 18, 42, 'VTI001', 'Good', 'dungg'),
        ('Nguyễn Quang Huy', '2001-04-18', 'Male', 11, 10, 28, 'VTI002', 'Normal', 'huynguyen'),
        ('Lê Hà Thu', '2002-08-11', 'Female', 12, 16, 47, 'VTI001', 'Good', 'thule'),
        ('Nguyễn Văn Việt', '2002-10-12', 'Male', 11, 09, 28, 'VTI002', 'Normarl', 'vietvuong'),
        ('Nguyễn Thị Hảo', '2001-08-12', 'Female', 06, 09, 19, 'VTI001', 'Bad', 'haohao');
        
SELECT * FROM Trainee;

INSERT INTO datatypes (data_name, data_code)
VALUES	('Apple', 'DT001'),
		('Banana', 'DT002'),
        ('Orange', 'DT003'),
        ('Plums', 'DT004'),
        ('Peach', 'DT005'),
        ('Guava', 'DT006'),
        ('Jackfruit', 'DT007'),
        ('Carrot', 'DT008'),
        ('Cabbage', 'DT009'),
        ('Mango', 'DT010');
        
SELECT * FROM datatypes;

INSERT INTO datatypes2 (data_name2, birth_date, gender, is_delete_flag)
VALUES	('Nguyễn Thế Hưng', '2002-12-18', 0, 0),
		('Nguyễn Trọng Hoàng', '2001-12-15', 0, 0),
        ('Nguyễn Hải Yến', '2002-05-06', 1, 0),
        ('Lê Bảo Ngọc', '2002-09-05', 1, 1),
        ('Bùi Huy Đông', '2000-10-02', 0, 0),
        ('Lưu Thuỳ Dung', '2002-12-16', 1, 0),
        ('Nguyễn Quang Huy', '2001-04-18', 0, 1),
        ('Lê Hà Thu', '2002-08-11', 1, 0),
        ('Nguyễn Văn Việt', '2002-10-12', 0, 1),
        ('Nguyễn Thị Hảo', '2001-08-12', 1, 1);
        
SELECT * FROM datatypes2;

-- Question 2
SELECT MONTH(birth_date) AS 'tháng sinh', GROUP_CONCAT(full_name) AS 'các thực tập sinh đã vượt qua bài test đầu vào' FROM trainee 
WHERE evaluation_notes != 'bad'
GROUP BY MONTH(birth_date);

-- Question 3
SELECT full_name, birth_date, gender, training_class, vti_account 
FROM trainee
WHERE LENGTH(full_name) = 
	(SELECT MAX(LENGTH(full_name))
     FROM trainee);


-- Question 4
SELECT * FROM trainee
WHERE (et_iq + et_gmath) >= 20 AND et_iq >= 8 AND et_gmath >= 8 AND et_english >= 18;

-- Question 5
DELETE 
FROM trainee
WHERE trainee_id = 3;

-- Question 6
UPDATE trainee
SET training_class = 'VTI002'
WHERE trainee_id = 5;