DROP DATABASE IF EXISTS extra6;
CREATE DATABASE extra6;

USE extra6;


DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
	employee_id	TINYINT	UNSIGNED	PRIMARY KEY	AUTO_INCREMENT,
	employee_last_name	VARCHAR(50)		NOT NULL,
    employee_first_name	VARCHAR(50)		NOT NULL,
    employee_hire_date	DATE,
    employee_status		VARCHAR(100),
    supervisor_id		TINYINT	UNSIGNED,
    social_security_number	INT,
    FOREIGN KEY (supervisor_id) REFERENCES employee(employee_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS projects;
CREATE TABLE projects (
	project_id	TINYINT	UNSIGNED	PRIMARY KEY	AUTO_INCREMENT,
	manager_id	TINYINT	UNSIGNED,
	project_name	VARCHAR(50)		NOT NULL,
    project_start_date	DATE,
    project_description	VARCHAR(100),
    project_detail		VARCHAR(100),
    project_complete_on	DATE,
    FOREIGN KEY (manager_id) REFERENCES employee(employee_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS project_modules;
CREATE TABLE project_modules (
	module_id	TINYINT	UNSIGNED	PRIMARY KEY	AUTO_INCREMENT,
    project_id	TINYINT UNSIGNED,
    employee_id	TINYINT	UNSIGNED,
    project_module_date	DATE,
    project_module_complete_on	DATE,	
    project_module_description	VARCHAR(100),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (project_id) REFERENCES projects(project_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS work_done;
CREATE TABLE work_done (
	work_done_id	TINYINT	UNSIGNED	PRIMARY KEY	AUTO_INCREMENT,
	employee_id		TINYINT	UNSIGNED,
    module_id		TINYINT	UNSIGNED,
    work_done_date	DATE,
    work_done_description	VARCHAR(100),
	work_done_status		VARCHAR(100),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (module_id) REFERENCES project_modules(module_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO employee (employee_last_name, employee_first_name, employee_hire_date, employee_status, supervisor_id, social_security_number)
VALUES
	('Nguyễn', 'Anh Thư', '2018-01-01', 1, null,123),
	('Nguyễn', 'Anh Dương', '2017-01-01', 1, null,123),
	('Phạm', 'Văn Hoàng', '2016-01-01', 1, 1,123),
	('Nguyễn', 'Chí hiếu', '2019-01-01', 1, 2,123),
	('Nguyễn', 'Quang Anh', '2019-01-01', 1, 1,123);
    
    
INSERT INTO projects (manager_id, project_name, project_start_date, project_description, project_detail, project_complete_on)
VALUES
	(1, 'dự án A', '2019-01-01', 'description dự án A', 'detailt dự án A', '2019-02-01'),
	(2, 'dự án B', '2021-09-05', 'description dự án B', 'detailt dự án B', '2021-10-01'),
	(2, 'dự án C', '2020-04-01', 'description dự án C', 'detailt dự án C', '2021-02-01'),
	(1, 'dự án D', '2021-10-01', 'description dự án D', 'detailt dự án D', '2022-03-01'),
	(3, 'dự án E', '2021-11-01', 'description dự án D', 'detailt dự án E', '2022-02-01');
    
INSERT INTO project_modules (project_id, employee_id, project_module_date, project_module_complete_on, project_module_description)
VALUES
	(1, 2, '2019-01-05', '2019-01-06', 'project modules description 1'),
	(1, 1, '2019-01-10', '2019-01-09', 'project modules description 2'),
	(2, 3, '2021-09-09', '2021-09-10', 'project modules description 3'),
	(2, 2, '2021-09-15', '2021-09-17', 'project modules description 4'),
	(3, 1, '2021-09-15', '2021-09-17', 'project modules description 5'),
	(4, 4, '2021-09-15', null, 'project modules description 6'),
	(4, 3, '2021-09-15', null, 'project modules description 7'),
	(4, 4, '2021-09-15', '2021-11-15', 'project modules description 7');
    
INSERT INTO work_done (employee_id, module_id, work_done_date, work_done_description, work_done_status)
VALUES
	(1, 1, '2019-01-06', 'work done description 1', 1),
	(1, 2, '2019-01-09', 'work done description 2', 1),
	(2, 3, '2021-09-10', 'work done description 3', 1),
	(2, 5, '2021-09-17', 'work done description 4', 1),
	(3, 5, '2021-09-17', 'work done description 5', 1),
	(2, 5, '2021-09-17', 'work done description 6', 1);
    
    
-- b) Viết stored procedure (không có parameter) để Remove tất cả thông tin
-- project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã
-- remove từ các table liên quan trong khi removing (dùng lệnh print)

DROP PROCEDURE IF EXISTS sp_etrab;
DELIMITER $$
CREATE PROCEDURE sp_etrab()
	BEGIN
		DECLARE delRowCntProject TINYINT;
        DECLARE delRowCntPM TINYINT;
        
        SELECT COUNT(project_id) INTO delRowCntProject FROM projects WHERE project_complete_on <= DATE_SUB(NOW(), INTERVAL 3 MONTH);
	
        
        SELECT SUM(cnt) INTO delRowCntPM
        FROM 
			(SELECT count(pm.module_id) cnt
			FROM projects p
			JOIN project_modules pm ON p.project_id = pm.project_id
			WHERE project_complete_on <= DATE_SUB(NOW(), INTERVAL 3 MONTH)
			GROUP BY p.project_id) tmp;
        
        DELETE FROM Projects
        WHERE project_complete_on <= DATE_SUB(NOW(), INTERVAL 3 MONTH);
        
        SELECT CONCAT('project table ', delRowCntProject, ' record', ', project_modules table ', delRowCntPM, ' record') as 'số lượng record đã remove';
	END$$
DELIMITER ;

CALL sp_etrab();
        
-- c) Viết stored procedure (có parameter) để in ra các module đang được thực
-- hiện)
DROP PROCEDURE IF EXISTS sp_etrac;
DELIMITER $$
CREATE PROCEDURE sp_etrac()
	BEGIN
		SELECT *
        FROM project_modules
        WHERE project_module_complete_on > NOW() OR project_module_complete_on IS NULL;
	END$$
DELIMITER ;

CALL sp_etrac();

-- d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc
-- dù không ai giao việc cho nhân viên đó (trong bảng Works)
-- DROP FUNCTION IF EXISTS f_etrad;
-- DELIMITER $$
-- CREATE FUNCTION f_etrad (