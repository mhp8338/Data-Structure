USE question50;
CREATE TABLE student(
    student_id VARCHAR(255) NOT NULL,
    student_name VARCHAR(255) NOT NULL,
    birthday VARCHAR(255) NOT NULL,
    sex VARCHAR(255) NOT NULL,
    PRIMARY KEY (student_id)
);

CREATE TABLE score(
    student_id VARCHAR(255) NOT NULL,
    lession_id VARCHAR(255) NOT NULL,
    score FLOAT(3) NOT NULL,
    PRIMARY KEY (student_id,lession_id)
);

CREATE TABLE course(
    lession_id VARCHAR(255) NOT NULL,
    lession_name VARCHAR(255) NOT NULL,
    teacher_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (lession_id)
);

CREATE TABLE teacher(
    teacher_id VARCHAR(20) NOT NULL,
    teacher_name VARCHAR(20) ,
    PRIMARY KEY (teacher_id)
);