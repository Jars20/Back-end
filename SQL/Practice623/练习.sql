
drop table if exists workers;
drop table  if exists worker2;

create table workers(
	id int not null,
    name varchar(20),
    leaderid int,
    sex char(1),
    age int,
    birth int
);


create table worker2 like workers;

insert into workers values(1,'阿飞',0,'男',20,623);
insert into workers values(2,'阿杜',1,'男',24,622);
insert into workers values(3,'小刚',2,'女',24,621);
insert into workers values(4,'小霞',2,'女',18,511);
insert into workers values(5,'蘑菇',1,'男',66,921);
insert into workers values(6,'起飞',4,'男',11,901);
insert into workers values(7,'飞机',4,'男',22,902);
insert into workers values(8,null,null,'男',22,null);






insert into worker2 select * from workers;
-- (uodate)
-- SET SQL_SAFE_UPDATES = 0;
-- update worker2 set sex='男' where sex='女';

-- (distinct)
-- select distinct age as '年龄' from worker2 order by age;

-- (列名+固定值)/(列名+列名2)
-- 条件查询
-- select (id+5),name,age as 新工号 from worker2 where age>18;

-- like + 通配符字符串
-- select * from worker2 where name like '阿%' order by birth [asc|desc];

-- 聚合函数
-- 之前都是横向查询，根据条件一行一行的查询。聚合函数查询是纵向的查询，对一列的值进行计算
-- 语法：select 聚合函数（列名）from 表名
 select ifnull(name,'无名'),id from worker2 where age>24;



-- select * from worker2;


