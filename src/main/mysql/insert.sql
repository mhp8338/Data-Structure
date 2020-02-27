use question50;
insert into student(student_id,student_name,birthday,sex)
values('0001' , '猴子' , '1989-01-01' , '男');

insert into student(student_id,student_name,birthday,sex)
values('0002' , '猴子' , '1990-12-21' , '女');

insert into student(student_id,student_name,birthday,sex)
values('0003' , '马云' , '1991-12-21' , '男');

insert into student(student_id,student_name,birthday,sex)
values('0004' , '王思聪' , '1990-05-20' , '男');

insert into score(student_id,lession_id,score)
values('0001' , '0001' , 80);

insert into score(student_id,lession_id,score)
values('0001' , '0002' , 90);

insert into score(student_id,lession_id,score)
values('0001' , '0003' , 99);

insert into score(student_id,lession_id,score)
values('0002' , '0002' , 60);

insert into score(student_id,lession_id,score)
values('0002' , '0003' , 80);

insert into score(student_id,lession_id,score)
values('0003' , '0001' , 80);

insert into score(student_id,lession_id,score)
values('0003' , '0002' , 80);

insert into score(student_id,lession_id,score)
values('0003' , '0003' , 80);

insert into course(lession_id,lession_name,teacher_id)
values('0001' , '语文' , '0002');

insert into course(lession_id,lession_name,teacher_id)
values('0002' , '数学' , '0001');

insert into course(lession_id,lession_name,teacher_id)
values('0003' , '英语' , '0003');

-- 教师表：添加数据
insert into teacher(teacher_id,teacher_name)
values('0001' , '孟扎扎');

insert into teacher(teacher_id,teacher_name)
values('0002' , '马化腾');

-- 这里的teacher_name是空值（null）
insert into teacher(teacher_id,teacher_name)
values('0003' , null);

-- 这里的teacher_name是空字符串（''）
insert into teacher(teacher_id,teacher_name)
values('0004' , '');