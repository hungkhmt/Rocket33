USE Assignment_01;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước
DROP TRIGGER IF EXISTS t_check_group_insert;
DELIMITER $$
CREATE TRIGGER t_check_group_insert
	BEFORE INSERT ON Groupp
    FOR EACH ROW
    BEGIN
		DECLARE tmp_date DATE;
        SELECT DATE_SUB(CURDATE(), INTERVAL 1 YEAR) INTO tmp_date;
        IF NEW.create_date < tmp THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Ngày tạo không hợp lệ';
		END IF;
	END$$
DELIMITER ;

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"
DROP TRIGGER IF EXISTS t_not_insert_to_department_sale;
DELIMITER $$
CREATE TRIGGER t_not_insert_to_department_sale
	BEFORE INSERT ON Accountt
    FOR EACH ROW
    BEGIN
		DECLARE sale_id TINYINT;
        SELECT department_id INTO sale_id
        FROM Department
        WHERE department_name = 'Sale';
        
        IF NEW.department_id < sale_id THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Department Sale cannot add more user';
		END IF;
	END$$
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS t_group_max_user;
DELIMITER $$
CREATE TRIGGER t_group_max_user
	BEFORE INSERT ON Group_Account
    FOR EACH ROW
    BEGIN
		DECLARE user_count TINYINT;
        SELECT COUNT(account_id) INTO user_count
        FROM Group_Account
        WHERE group_id = NEW.group_id
        GROUP BY group_id;
        
        IF user_count > 5 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Group không quá 5 user';
		END IF;
	END$$
DELIMITER ;

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS t_exam_max_question;
DELIMITER $$
CREATE TRIGGER t_exam_max_question
	BEFORE INSERT ON Exam_Question
    FOR EACH ROW
    BEGIN
		DECLARE question_count TINYINT;
        SELECT COUNT(question_id) INTO question_count
        FROM Exam_Question
        WHERE exam_id = NEW.exam_id
        GROUP BY exam_id;
        
        IF question_count > 10 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Group không quá 5 user';
		END IF;
	END$$
DELIMITER ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
DROP TRIGGER IF EXISTS t_check_del_admin;
DELIMITER $$
CREATE TRIGGER t_check_del_admin
	BEFORE DELETE ON Accountt
    FOR EACH ROW
    BEGIN
        IF OLD.email = 'admin@gmail.com' THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Đây là tài khoản Admin, không cho phép user xoá';
		END IF;
	END$$
DELIMITER ;

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS t_check_insert_dept;
DELIMITER $$
CREATE TRIGGER t_check_insert_dept
	BEFORE INSERT ON Accountt
    FOR EACH ROW
    BEGIN
		DECLARE deptID TINYINT;
        SELECT department_id INTO deptID
        FROM Department
        WHERE department_name = 'waiting Department';
        
        IF NEW.department_id IS NULL THEN
			SET NEW.department_id = deptID;
		END IF;
	END$$
DELIMITER ;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
-- đáp án đúng: 1
-- đáp án sai: 0
DROP TRIGGER IF EXISTS t_check_answer;
DELIMITER $$
CREATE TRIGGER t_check_answer
	BEFORE INSERT ON answer
	FOR EACH ROW
	BEGIN
		DECLARE countAnswer TINYINT;
        DECLARE countTrue TINYINT;

		SELECT COUNT(answer_id) INTO countAnswer
		FROM Answer
		WHERE question_id = NEW.question_id;
        
		SELECT count(isCorrect) INTO countTrue
		FROM Answer
		WHERE question_id = NEW.question_id AND isCorrect = 1;
        
        IF countAnswer >= 4 OR (countTrue >= 2 AND NEW.isCorrect = 1) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'câu hỏi không được quá 4 answers và 2 đáp án đúng';
        END IF;       
	END $$
DELIMITER ;

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS t_fix_gender;
DELIMITER $$
CREATE TRIGGER t_fix_gender
	BEFORE INSERT ON Accountt
	FOR EACH ROW
	BEGIN
		-- Không có thuộc tính gender trong Testing_system_assignment
		IF NEW.gender = 'nam' THEN
			SET NEW.gender = 'M';
		END IF;
        IF NEW.gender = 'nữ' THEN
			SET NEW.gender = 'F';
		END IF;
        IF NEW.gender = 'chưa xác định' THEN
			SET NEW.gender = 'U';
		END IF;
	END $$
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
-- Nghĩa là ngày 1 ngày 2 không xóa được
DROP TRIGGER IF EXISTS t_check_del_block;
DELIMITER $$
CREATE TRIGGER t_check_del_block
	BEFORE DELETE ON Exam
    FOR EACH ROW
    BEGIN
        IF OLD.create_date > NOW() - 2 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Không được phép xoá bài thi mới tạo 2 ngày';
		END IF;
	END$$
DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
-- check update
DROP TRIGGER IF EXISTS t_update_question;
DELIMITER $$
CREATE TRIGGER t_update_question
	BEFORE UPDATE ON question
    FOR EACH ROW
	BEGIN
		IF OLD.question_id NOT IN (
			SELECT q.question_id
			FROM question q LEFT JOIN exam_question e 
            ON q.question_id = e.question_id
			WHERE e.exam_id IS NULL) THEN
				SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT = 'không được phép sửa câu hỏi đã được sử dụng trong bài thi';
		END IF;
	END $$
DELIMITER ;

-- Question 12: Lấy ra thông tin exam trong đó:

-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT exam_id, codee, title, category_id
        , CASE WHEN duration <= 30 THEN 'Short time' 
			WHEN 30 < duration AND duration <= 60 THEN 'Medium time'
			WHEN duration > 60 THEN 'Long time'
		END duration, creator_id, create_date
FROM exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
		-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
		-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
		-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT g.group_id, COUNT(ga.account_id) cnt_acc, 
	CASE WHEN COUNT(ga.account_id) <= 5 THEN 'few' 
		WHEN 5 < COUNT(ga.account_id) AND COUNT(ga.account_id) <= 20 THEN 'normal' 
        WHEN COUNT(ga.account_id) > 20 THEN 'higher' 
	END the_number_user_amount
FROM Groupp g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT d.department_name, 
	CASE WHEN COUNT(a.account_id) = 0 THEN 'Không có User' 
		ELSE  COUNT(a.account_id)
	END 'số user của phòng ban'
FROM department d
LEFT JOIN Accountt a ON d.department_id = a.department_id
GROUP BY d.department_id;