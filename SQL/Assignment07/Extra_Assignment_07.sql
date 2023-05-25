USE extra6;

-- Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ
-- (Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
-- Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn)
DROP TRIGGER IF EXISTS t_check_moduleP;
DELIMITER $$
CREATE TRIGGER t_check_moduleP
	BEFORE INSERT ON project_modules
    FOR EACH ROW
    BEGIN
		DECLARE projectStartDate DATE;
		DECLARE projectCompletedOn DATE;
		SELECT p.project_start_date, p.project_module_complete_on INTO projectStartDate, projectCompletedOn
        FROM project p
        WHERE p.project_id = NEW.project_id;
        IF NEW.project_module_date < projectStartDate OR NEW.project_module_complete_on > projectCompletedOn THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'thông tin không hợp lệ';
        END IF;
    END $$
DELIMITER ;

-- Exercise 2: View
-- Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là
-- ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số
-- điểm như sau:
--  ET_IQ + ET_Gmath>=20
--  ET_IQ>=8
--  ET_Gmath>=8
--  ET_English>=18
USE fresher_management;
DROP VIEW IF EXISTS v_TTS_thoa_man;
CREATE VIEW v_TTS_thoa_man AS 
	SELECT * 
	FROM trainee 
	WHERE (et_iq + et_gmath) >= 20
	  AND et_iq >= 8
	  AND et_gmath >= 8
	  AND et_english >= 18;