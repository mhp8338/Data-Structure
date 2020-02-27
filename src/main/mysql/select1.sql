-- 查询性猴的名单
SELECT *
FROM student
WHERE student_name LIKE '猴%';

-- 查询最后一个字是猴的名单
SELECT *
FROM student
WHERE student_name LIKE '%猴';

-- 查询带猴字的名单
SELECT *
FROM student
WHERE student_name LIKE '%猴%';

# 查询课程编号为0002的总成绩
SELECT SUM(score)
FROM score
WHERE lession_id = '0002';

# 查询选了课程的学生人数
SELECT COUNT(DISTINCT student_id) AS total_num
FROM score;

# 分组练习
# 查询各科成绩最高和最低的分， 以如下的形式显示：课程号，最高分，最低分
SELECT lession_id, MAX(score) AS max_score, MIN(score) AS min_score
FROM score
GROUP BY lession_id;
# 查询每门课程被选修的学生数
SELECT COUNT(student_id) as stu_num
FROM score
GROUP BY lession_id;
# 查询男生、女生人数
SELECT COUNT(student_id)
FROM student
GROUP BY sex;

# 分组结果的条件
# 查询平均成绩大于60分学生的学号和平均成绩
SELECT student_id, AVG(score) AS avg_score
FROM score
GROUP BY student_id
HAVING avg_score > 60
ORDER BY avg_score DESC;
# 查询至少选修两门课程的学生学号
SELECT student_id, COUNT(lession_id) AS lesson_count
FROM score
GROUP BY student_id
HAVING lesson_count > 2;
# 查询同名同性学生名单并统计同名人数
SELECT student_name, COUNT(*) AS num
FROM student
GROUP BY student_name
HAVING num >= 2;
# 查询不及格的课程并按课程号从大到小排列
SELECT lession_id
FROM score
WHERE score < 60
ORDER BY lession_id DESC;
# 查询每门课程的平均成绩，结果按平均成绩升序排序，平均成绩相同时，按课程号降序排列
SELECT lession_id, AVG(score) AS avg
FROM score
GROUP BY lession_id
ORDER BY avg ASC, lession_id DESC;
# 检索课程编号为“0004”且分数小于60的学生学号，结果按按分数降序排列
SELECT student_id, score
FROM score
WHERE lession_id = '0003'
  AND score < 90
ORDER BY score DESC;
# 统计每门课程的学生选修人数(超过2人的课程才统计)
# 要求输出课程号和选修人数，查询结果按人数降序排序，若人数相同，按课程号升序排序
SELECT lession_id, COUNT(student_id) AS cut
FROM score
GROUP BY lession_id
HAVING cut > 2
ORDER BY cut DESC, lession_id ASC;
# 查询两门以上不及格课程的同学的学号及其平均成绩
SELECT student_id, AVG(score) AS avg
FROM score
WHERE score < 90
GROUP BY student_id
HAVING COUNT(lession_id) > 2;

# 复杂查询
# 查询所有课程成绩小于60分学生的学号、姓名
SELECT student_id, student_name
FROM student
WHERE student_id IN (
    SELECT student_id
    FROM score
    WHERE score < 90
);
# 查询没有学全所有课的学生的学号、姓名|
SELECT student_id, student_name
FROM student
WHERE student_id IN (
    SELECT student_id
    FROM score
    GROUP BY student_id
    HAVING COUNT(lession_id) < (SELECT COUNT(lession_id) FROM course)
);
# 查询出只选修了两门课程的全部学生的学号和姓名|
SELECT student_id, student_name
FROM student
WHERE student_id IN (
    SELECT student_id
    FROM score
    GROUP BY student_id
    HAVING COUNT(lession_id) = 2
);
# 1990年出生的学生名单
SELECT student_name
FROM student
WHERE birthday = 1990;
# 查询各科成绩前两名的记录
SELECT *
FROM score
WHERE lession_id = '0001'
ORDER BY score DESC
LIMIT 1;

# 多表查询
# 查询所有学生的学号、姓名、选课数、总成绩
SELECT a.student_name, a.student_id, COUNT(b.lession_id) AS lesson_num, SUM(b.score) AS sum
FROM student AS a
         LEFT JOIN score AS b
                   ON a.student_id = b.student_id
GROUP BY a.student_id;
# 查询平均成绩大于85的所有学生的学号、姓名和平均成绩
SELECT a.student_id, a.student_name, AVG(b.score) AS avg
FROM student AS a
         LEFT JOIN score AS b
                   ON a.student_id = b.student_id
GROUP BY a.student_id
HAVING avg > 85;
# 查询学生的选课情况：学号，姓名，课程号，课程名称
SELECT a.student_id, a.student_name, c.lession_id, c.lession_name
FROM student AS a
         INNER JOIN score AS b
                    ON a.student_id = b.student_id
         INNER JOIN course AS c
                    ON b.lession_id = c.lession_id;
# 查询出每门课程的及格人数和不及格人数
SELECT lession_id,
       SUM(IF(score >= 80, 1, 0)) AS pass_num,
       sum(IF(score < 80, 1, 0))  AS not_pass_num
FROM score
GROUP BY lession_id;

# 使用分段[100-85],[85-70],[70-60],[<60]来统计各科成绩，
# 分别统计：各分数段人数，课程号和课程名称
SELECT c.lession_id,
       c.lession_name,
       SUM(IF(score BETWEEN 85 AND 100, 1, 0)) AS '[100-85]',
       SUM(IF(score BETWEEN 70 AND 85, 1, 0))  AS '[85-70]',
       SUM(IF(score BETWEEN 60 AND 70, 1, 0))  AS '[70-60]',
       SUM(IF(score < 60, 1, 0))               AS '[<60]'
FROM course c
         RIGHT JOIN score s
                    ON c.lession_id = s.lession_id
GROUP BY c.lession_id, c.lession_name;

# 查询课程编号为0003且课程成绩在80分以上的学生的学号和姓名|
SELECT stu.student_id, stu.student_name
FROM student AS stu
         INNER JOIN score AS sco
                    ON stu.student_id = sco.student_id
WHERE lession_id = '0003'
  AND sco.score > 90;

# 行列转换
SELECT student_id,
       IF(lession_id = '0001', score, 0) AS 'lesson_0001',
       IF(lession_id = '0002', score, 0) AS 'lesson_0002',
       IF(lession_id = '0003', score, 0) AS 'lesson_0003'
FROM score;

SELECT student_id,
       MAX(IF(lession_id = '0001', score, 0)) AS '0001',
       MAX(IF(lession_id = '0002', score, 0)) AS '0002',
       MAX(IF(lession_id = '0003', score, 0)) AS '0003'
FROM score
GROUP BY student_id;

SELECT lession_id,
       MAX(IF(student_id='0001',score,0)) AS 'student_0001',
       MAX(IF(student_id='0002',score,0)) AS 'student_0002',
       MAX(IF(student_id='0003',score,0)) AS 'student_0003'
FROM score
GROUP BY lession_id;
