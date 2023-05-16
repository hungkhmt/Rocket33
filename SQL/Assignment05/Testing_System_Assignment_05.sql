USE assignment_01;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
-- VIEW
DROP VIEW IF EXISTS v_nhanvien;
CREATE VIEW v_nhanvien AS
	SELECT a.*, d.department_name
	FROM accountt a INNER JOIN Department d
	ON a.department_id = d.department_id
	WHERE d.department_name = 'Sales';
    
SELECT * FROM v_nhanvien;

-- CTE
WITH nhanvien_sales AS (
	SELECT a.*, d.department_name
    FROM accountt a INNER JOIN department d
    ON a.department_id = d.department_id
    WHERE d.department_name = 'Sales'
)
SELECT * FROM nhanvien_sales;
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
DROP VIEW IF EXISTS v_max_accout_group;
CREATE VIEW v_max_accout_group AS
	SELECT a.*, COUNT(g.group_id) AS 'Số lượng group'
	FROM accountt a LEFT JOIN Group_Account g
	ON a.account_id = g.account_id
	GROUP BY a.account_id
	HAVING COUNT(g.group_id) = (
								SELECT MAX(count_group)
								FROM (
										SELECT COUNT(g.group_id) AS count_group
										FROM accountt a LEFT JOIN Group_Account g
										ON a.account_id = g.account_id
										GROUP BY a.account_id
										) AS bangtam );

SELECT * FROM v_max_accout_group;

-- CTE
WITH so_group_theo_account AS (
	SELECT a.*, COUNT(g.group_id) AS group_counts
    FROM accountt a LEFT JOIN Group_Account g
    ON a.account_id = g.account_id
    GROUP BY a.account_id
)
SELECT * FROM so_group_theo_account
WHERE group_counts = ( SELECT MAX(group_counts) FROM so_group_theo_account);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
DROP VIEW IF EXISTS v_content_tren300;
CREATE VIEW v_content_tren300 AS
	SELECT * FROM Question
	WHERE LENGTH(content) > 300;

SELECT * FROM v_content_tren300;
DELETE FROM Question
WHERE question_id IN (SELECT question_id FROM v_content_tren300);
-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS v_dept_nhanvien;
CREATE VIEW v_dept_nhanvien AS
	SELECT d.*, COUNT(a.account_id)
	FROM department d LEFT JOIN accountt a
	ON d.department_id = a.department_id
	GROUP BY d.department_id
	HAVING COUNT(a.account_id) = ( SELECT MAX(acc_counts)
									FROM (
											SELECT COUNT(a.account_id) AS acc_counts
											FROM department d LEFT JOIN accountt a
											ON d.department_id = a.department_id
											GROUP BY d.department_id ) bangtam );
                                            
SELECT * FROM v_dept_nhanvien;
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS v_question_create_by_Nguyen;
CREATE VIEW v_question_create_by_Nguyen AS
	SELECT q.*, a.full_name
	FROM Question q INNER JOIN Accountt a
	ON q.creator_id = a.account_id
	WHERE a.full_name LIKE ('Nguyễn%');
    
SELECT * FROM v_question_create_by_Nguyen;

-- CTE
WITH question_by_Nguyen AS (
	SELECT q.*, a.full_name
    FROM Question q INNER JOIN Accountt a
    ON q.creator_id = a.account_id
    WHERE a.full_name LIKE ('Nguyễn%')
)
SELECT * FROM question_by_Nguyen;