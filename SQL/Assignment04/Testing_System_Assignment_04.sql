USE assignment_01;

-- Question 1
SELECT a.*, d.department_name FROM Accountt a INNER JOIN Department d
ON a.department_id = d.department_id;

-- Question 2
SELECT * FROM Accountt
WHERE create_date > '2010-12-20';

-- Question 3
SELECT a.*, positionn_name FROM Accountt a INNER JOIN Positionn p
ON a.positionn_id = p.positionn_id
WHERE positionn_name = 'Dev';

-- Question 4
SELECT d.department_id, COUNT(d.department_id) AS 'Số lượng nhân viên' FROM Accountt a INNER JOIN Department d
ON a.department_id = d.department_id
GROUP BY d.department_id
HAVING COUNT(d.department_id) > 3;

-- Question 5
SELECT q.question_id, q.content, COUNT(1) AS 'Số lượng câu hỏi' FROM Question q INNER JOIN Exam_Question e
ON q.question_id = e.question_id
GROUP BY q.question_id
HAVING COUNT(q.question_id) = (SELECT MAX(question_count) 
								FROM (
									SELECT COUNT(q2.question_id) AS question_count FROM Question q2 INNER JOIN Exam_Question e2
									ON q2.question_id = e2.question_id
									GROUP BY q2.question_id
                                    ) AS counts);

-- Question 6
SELECT q.category_id, c.category_name, COUNT(q.category_id) AS 'Số lượng category dùng trong question' FROM Question q INNER JOIN Category_Question c
ON q.category_id = c.category_id
GROUP BY q.category_id;

-- Question 7
SELECT q.question_id, q.content, COUNT(q.question_id) AS 'Số question được dùng'
FROM Question q LEFT JOIN Exam_Question e
ON q.question_id = e.question_id
GROUP BY q.question_id;

-- Question 8
SELECT q.question_id, q.content, COUNT(1) AS 'Số lượng Question'
FROM Question q INNER JOIN Answer a
ON q.question_id = a.question_id
GROUP BY q.question_id
HAVING COUNT(q.question_id) = (SELECT MAX(question_count) 
								FROM (
									SELECT COUNT(q2.question_id) AS question_count FROM Question q2 INNER JOIN Answer a2
									ON q2.question_id = a2.question_id
									GROUP BY q2.question_id
                                    ) AS counts);
                                    
-- Question 9
SELECT g.group_id, COUNT(ga.account_id) AS 'Số lượng account'
FROM Group_Account ga INNER JOIN Groupp g 
ON ga.group_id = g.group_id
GROUP BY g.group_id;

-- Question 10
SELECT p.positionn_id, p.positionn_name, COUNT(a.positionn_id) AS 'Số lượng chức vụ'
FROM Accountt a INNER JOIN Positionn p
ON a.positionn_id = p.positionn_id
GROUP BY a.positionn_id
HAVING COUNT(a.positionn_id) = (SELECT MIN(position_count) 
								FROM (
									SELECT COUNT(a2.positionn_id) AS position_count FROM Accountt a2 INNER JOIN Positionn p2
									ON a2.positionn_id = p2.positionn_id
									GROUP BY a2.positionn_id
                                    ) AS counts);
                                    
-- Question 11
SELECT d.department_id, d.department_name, p.positionn_id, p.positionn_name, COUNT(1) AS 'Số lượng nhân viên'
FROM Department d INNER JOIN Accountt a
ON d.department_id = a.department_id
INNER JOIN Positionn p
ON a.positionn_id = p.positionn_id
GROUP BY d.department_id, p.positionn_id
ORDER BY d.department_id;

-- Question 12
SELECT q.question_id, q.content, t.type_name, a.full_name, an.content
FROM Question q INNER JOIN Accountt a
ON q.creator_id = a.account_id
INNER JOIN type_question t
ON q.type_id = t.type_id
INNER JOIN Answer an
ON q.question_id = an.question_id
GROUP BY q.question_id, t.type_id, a.account_id, an.answer_id
ORDER BY q.question_id;

-- Question 13
SELECT t.type_id, t.type_name, COUNT(1) AS 'Số lượng câu hỏi'
FROM Question q INNER JOIN Type_Question t
ON q.type_id = t.type_id
GROUP BY q.type_id;

-- Question 14
SELECT *
FROM groupp g LEFT JOIN group_account ga
ON g.group_id = ga.group_id
WHERE ga.account_id IS NULL;

-- Question 15
SELECT *
FROM group_account ga RIGHT JOIN groupp g
ON g.group_id = ga.group_id
WHERE ga.account_id IS NULL;

-- Question 16
SELECT * FROM Question
WHERE question_id NOT IN (SELECT question_id FROM Exam_Question);

-- Question 17
-- a
SELECT *
FROM Accountt a INNER JOIN groupp g
ON a.account_id = g.creator_id
WHERE g.group_id = 1;

-- b
SELECT *
FROM Accountt a INNER JOIN groupp g
ON a.account_id = g.creator_id
WHERE g.group_id = 2;

-- c
SELECT *
FROM Accountt a INNER JOIN groupp g
ON a.account_id = g.creator_id
WHERE g.group_id = 1
UNION
SELECT *
FROM Accountt a INNER JOIN groupp g
ON a.account_id = g.creator_id
WHERE g.group_id = 2;

-- Question 18
-- a
SELECT g.group_id, g.group_name
FROM group_account ga INNER JOIN groupp g
ON ga.group_id = g.group_id
GROUP BY g.group_id
HAVING COUNT(g.group_id) > 5;

-- b
SELECT g.group_id, g.group_name
FROM group_account ga INNER JOIN groupp g
ON ga.group_id = g.group_id
GROUP BY g.group_id
HAVING COUNT(g.group_id) < 7;

-- c
SELECT g.group_id, g.group_name
FROM group_account ga INNER JOIN groupp g
ON ga.group_id = g.group_id
GROUP BY g.group_id
HAVING COUNT(g.group_id) > 5
UNION
SELECT g.group_id, g.group_name
FROM group_account ga INNER JOIN groupp g
ON ga.group_id = g.group_id
GROUP BY g.group_id
HAVING COUNT(g.group_id) < 7;