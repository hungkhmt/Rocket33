USE assignment_01;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS sp_account_thuoc_dept;
DELIMITER $$
CREATE PROCEDURE sp_account_thuoc_dept (IN p_in_dept_name VARCHAR(50))
	BEGIN
		SELECT a.*, d.department_name
        FROM department d INNER JOIN accountt a
        ON d.department_id = a.department_id
        WHERE d.department_name = p_in_dept_name;
	END$$
DELIMITER ;

CALL sp_account_thuoc_dept('Marketing');
-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_account_in_group;
DELIMITER $$
CREATE PROCEDURE sp_account_in_group ()
	BEGIN
		SELECT g.group_id, COUNT(ga.account_id) AS 'Số lượng Account'
        FROM groupp g INNER JOIN group_account ga
        ON g.group_id = ga.group_id
        GROUP BY g.group_id;
	END$$
DELIMITER ;

CALL sp_account_in_group();
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
DROP PROCEDURE IF EXISTS sp_typequestion_question;
DELIMITER $$
CREATE PROCEDURE sp_typequestion_question (IN p_in_month TINYINT)
	BEGIN
		SELECT t.*, COUNT(q.question_id) AS 'Số lượng question'
        FROM Type_Question t LEFT JOIN Question q
        ON t.type_id = q.type_id
        WHERE MONTH(create_date) = p_in_month
        GROUP BY t.type_id;
	END$$
DELIMITER ;

CALL sp_typequestion_question(4);
-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_max_typequestion;
DELIMITER $$
CREATE PROCEDURE sp_max_typequestion (OUT p_out_typeid TINYINT)
	BEGIN
		SELECT t.type_id INTO p_out_typeid
		FROM question q INNER JOIN type_question t 
        ON q.type_id = t.type_id
		GROUP BY q.type_id
		ORDER BY COUNT(q.question_id) DESC
		LIMIT 1;
	END$$
DELIMITER ;

SET @type_id = '';
CALL sp_max_typequestion(@type_id);
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT type_name FROM type_question
WHERE type_id = @type_id;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS sp_chuoi_in_group;
DELIMITER $$
CREATE PROCEDURE sp_chuoi_in_group(IN p_in_chuoi VARCHAR(30))
	BEGIN
		SELECT a.user_name AS 'User name or group name'
        FROM accountt a
        WHERE a.user_name LIKE CONCAT('%', p_in_chuoi, '%')
        UNION
        SELECT group_name AS 'User name or group name'
        FROM groupp 
        WHERE group_name LIKE CONCAT('%', p_in_chuoi, '%');
	END$$
DELIMITER ;

CALL sp_chuoi_in_group('u');
-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer (tìm trog bảng dept phòng ban có id là developer rồi gán cho pos)
-- departmentID: sẽ được cho vào 1 phòng chờ (tạo mới 1 bản ghi trong pos có tên phòng chờ)
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_nhap_thong_tin_va_gan;
DELIMITER $$
CREATE PROCEDURE sp_nhap_thong_tin_va_gan(IN p_in_fullname VARCHAR(50), IN p_in_email VARCHAR(50))
	BEGIN
		DECLARE dept_id TINYINT;
        DECLARE post_id TINYINT;
		SELECT positionn_id INTO post_id FROM positionn WHERE positionn_name = 'Dev';
        SELECT department_id INTO dept_id FROM department WHERE department_name = 'Phòng chờ';
        
        INSERT INTO accountt(email, user_name, full_name, department_id, positionn_id)
        VALUE (p_in_email, SUBSTRING_INDEX(p_in_email, '@', 1), p_in_fullname, dept_id, post_id);
	END$$
DELIMITER ;

CALL sp_nhap_thong_tin_va_gan('Nguyễn Văn A', 'nguyenvana@gmail.com');
SELECT * FROM Accountt;

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS sp_question8;
DELIMITER $$
CREATE PROCEDURE sp_question8(IN p_in_typename ENUM('Essay', 'Multiple-Choice'))
	BEGIN
		WITH cte_typename AS (
			SELECT q.*
            FROM Question q INNER JOIN Type_Question t
            ON q.type_id = t.type_id
            WHERE t.type_name = p_in_typename
		)
        SELECT * FROM cte_typename
        WHERE LENGTH(content) = (SELECT MAX(LENGTH(content)) FROM cte_typename);
	END$$
DELIMITER ;

CALL sp_question8('Essay');
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_question9;
DELIMITER $$
CREATE PROCEDURE sp_question9 (IN p_in_exam_id TINYINT)
	BEGIN
		DELETE FROM Exam
        WHERE exam_id = p_in_exam_id;
	END$$
DELIMITER ;

CALL sp_question9(2);
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
DROP PROCEDURE IF EXISTS sp_question10;
DELIMITER $$
CREATE PROCEDURE sp_question10()
	BEGIN
		DECLARE examID TINYINT;
        DECLARE delCountExam TINYINT;
        DECLARE delCountExamQuestion TINYINT;
        
        DECLARE isFull BOOLEAN DEFAULT FALSE;
        
        DECLARE cur CURSOR FOR
        SELECT exam_id FROM Exam WHERE YEAR(create_date) <= YEAR(NOW()) - 3;
        
        SELECT COUNT(exam_id) INTO delCountExam
        FROM Exam 
        WHERE YEAR(create_date) <= YEAR(NOW()) - 3;
        
        SELECT COUNT(eq.exam_id) INTO delCountExamQuestion
        FROM Exam e LEFT JOIN Exam_Question eq
        ON e.exam_id = eq.exam_id
        WHERE YEAR(e.create_date) <= YEAR(NOW()) - 3;
        
        OPEN cur;
			read_loop: LOOP
				FETCH cur INTO examID;
                
                CALL sp_question9(examID);
                
                IF isFull THEN
					LEAVE read_loop;
				END IF;
			END LOOP;
		CLOSE cur;
        
		SELECT concat('exam table ', delRowCntExam, ' record', ', exam_question table ', delRowCntExam, ' record') AS 'số lượng record đã remove';
	END$$
DELIMITER ;
-- gọi thủ tục
CALL sp_delete_exam_and_select_count_record();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS sp_question11;
DELIMITER $$
CREATE PROCEDURE sp_question11(IN p_in_department_name VARCHAR(50))
	BEGIN
		UPDATE Accountt
        SET department_id = (SELECT department_id FROM Department WHERE department_name = 'Phòng ban chờ việc')
        WHERE department_id = (SELECT department_id FROM Department WHERE department_name = p_in_department_name);
        
        DELETE FROM Acountt
        WHERE department_id = (SELECT department_id FROM Department WHERE department_name = p_in_department_name);
	END$$
DELIMITER ;
CALL sp_question11('Sales');
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS sp_question12;
DELIMITER $$
CREATE PROCEDURE sp_question12()
	BEGIN
		SELECT 
		CONCAT(SUM(IF(thang = '01', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 1',
		CONCAT(SUM(IF(thang = '02', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 2',
		CONCAT(SUM(IF(thang = '03', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 3',
		CONCAT(SUM(IF(thang = '04', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 4',
		CONCAT(SUM(IF(thang = '05', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 5',
		CONCAT(SUM(IF(thang = '06', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 6',
		CONCAT(SUM(IF(thang = '07', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 7',
		CONCAT(SUM(IF(thang = '08', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 8',
		CONCAT(SUM(IF(thang = '09', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 9',
		CONCAT(SUM(IF(thang = '10', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 10',
		CONCAT(SUM(IF(thang = '11', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 11',
		CONCAT(SUM(IF(thang = '12', so_cau_hoi, 0)), ' câu hỏi') AS 'Tháng 12'
	FROM
		(
			SELECT MONTH(create_date) AS thang, COUNT(question_id) AS so_cau_hoi
			FROM question 
			WHERE YEAR(create_date) = YEAR(NOW())
			GROUP BY MONTH(create_date)
		) bang_tam;
	END$$
DELIMITER ;

CALL sp_question12();
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất 
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS sp_question13;
DELIMITER $$
CREATE PROCEDURE sp_question13()
	BEGIN
		WITH cte_t AS (
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS YEAR
            UNION
            SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS YEAR
            UNION
            SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS YEAR
            UNION
            SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS YEAR
            UNION
            SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS YEAR
            UNION
            SELECT MONTH(NOW()) AS MONTH, YEAR(NOW()) AS YEAR
		)
        SELECT MONTH, YEAR,
			CASE
				WHEN COUNT(question_id) = 0 THEN 'Không có câu hỏi nào'
                ELSE COUNT(question_id)
                END AS 'Số lượng question'
		FROM cte_t t LEFT JOIN question q
        ON t.MONTH = MONTH(q.create_date)
        GROUP BY t.MONTH, t.YEAR;
	END$$
DELIMITER ;
            
CALL sp_question13();