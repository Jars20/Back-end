CREATE TABLE company(
    company_ID VARCHAR(32) NOT NULL   COMMENT '公司ID' ,
    PRIMARY KEY (company_ID)
) COMMENT = '公司 ';

CREATE TABLE project(
    company_ID VARCHAR(32)    COMMENT '公司ID' ,
    project_ID VARCHAR(32) NOT NULL   COMMENT '工程号' ,
    projectName VARCHAR(32)    COMMENT '工程名称' ,
    PRIMARY KEY (project_ID)
) COMMENT = '工程 ';

CREATE TABLE stuff(
    company_ID VARCHAR(32)    COMMENT '公司ID' ,
    project_ID VARCHAR(32)    COMMENT '工程ID' ,
    Stuff_ID VARCHAR(32) NOT NULL   COMMENT '职工号' ,
    name VARCHAR(128)    COMMENT '姓名' ,
    sex VARCHAR(32)    COMMENT '性别' ,
    position1_ID VARCHAR(32)    COMMENT '职位编号' ,
    PRIMARY KEY (Stuff_ID)
) COMMENT = '职工 ';

CREATE TABLE position1(
    position1_ID VARCHAR(32) NOT NULL   COMMENT '职位编号' ,
    position1 VARCHAR(32)    COMMENT '职务' ,
    RateOfPay DECIMAL(32,10)    COMMENT '小时工资率' ,
    PRIMARY KEY (position1_ID)
) COMMENT = '职位 ';

CREATE TABLE WorkingTime(
    Stuff_ID VARCHAR(32)    COMMENT '职工ID' ,
    WorkingTime DECIMAL(32,10)    COMMENT '工作时长' 
) COMMENT = '工作时长 ';