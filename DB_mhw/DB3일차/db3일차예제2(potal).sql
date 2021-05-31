select * from potal.professor;
select * from potal.class;
select * from potal.student;

-- 컴퓨터 학과의 교수님 수를 확인
select count(*) from professor where pr_dep="컴퓨터";
select count(*) from professor where pr_dep = "컴퓨터" group by pr_dep;

-- 교수번호가 P2002140001인 교수님의 강의리스트를 확인
select * from class;
select * from class where cl_pr_num="P2002140001";

-- 학점이 2학점이상인 강의리스트 확인
select * from class where cl_point >= 2;

-- 월요일에 수업하는 강의 리스트 확인
select * from class where cl_schedule like "%월%";

-- 2020학번 학생들을 확인하는 
select * from student where st_num like "2020%";

-- 2020135001 학생이 2021MSC004 강의를 수강했을 때, 사용해야하는 쿼리문
desc course;
insert into course (co_st_num, co_cl_code) -- co_num은 AI체크되어있어서 자동으로 값들어감
values("2020135001", "2021MSC004");
select * from course;

-- 2020135001 학번 학생이 수강한 강의 수 확인
select count(*) as "수강한 강의 수" from course where co_st_num = "2020135001"; 
select count(co_st_num = "2020135001") as "수강 갯수" from course; 

-- 2020135001 학번 학생이 2021년도에 수강한 강의 수 확인
select count(*) as "2021년도 수강한 강의 수" from course where co_st_num="2020135001" and co_cl_code like "2021%";
select count(co_st_num = "2020135001") as "2021년 수강 갯수" from course where co_cl_code like "2021%";

-- 2020135001 학생의 수강한 강의 제목을 하나의 테이블로 확인할 수 있다 (X) 
-- => 2020135001 학생이 수강한 강의코드는 확인할 수 있지만 제목은 확인 불가 
-- 2020135001 학생의 수강한 강의 코드를 하나의 테이블로 확인할 수 있다 (O) => course 확인가능

-- join은 한 테이블로 원하는 모든 정보를 가져올 수 없을 때, 여러 테이블을 하나로 만들어서 가져와야하는 경우에 사용
-- select 테이블.속성1, 테이블1.속성2, .. , 테이블2.속성1 from 테이블1, 테이블2 where 조건
-- 2020135001 학생의 수강한 강의 제목 => course(수강정보), class(강의제목) 테이블이 필요
-- 구ver.
select co_st_num as "학번", cl_title as "강의명" from course, class where co_cl_code = cl_code and co_st_num = 2020135001;
 
  -- 신 ver.
 -- select 속성1, 속성2,.. from 테이블1 join 테이블2 on 테이블1.외래키 = 테이블2.기본키;  (테이블 순서가 바뀌어도 상관없음)
 -- 위에 한 2020135001 학번 학생이 수강한 강의명을 확인하는 코드를 join을 이용하여 확인
 select course.co_st_num as "학번", class.cl_title as "강의명" from course 
	join class 
		on course.co_cl_code = class.cl_code 
			where course.co_st_num="2020135001";
            -- join할 때 두 테이블의 속성명이 겹치지 않는 경우, 속성 이름 앞에 테이블명을 생략해도 된다
            
 
 -- P2000135001 교수님의 강의를 들은 학생명단 =>
 -- old ver.
 select st_name from course, class, student where co_cl_code = cl_code and co_st_num = st_num and cl_pr_num ="P2000135001";
 
 
 -- 네트워크를 강의하는 교수님 이름을 확인
 select pr_name as "교수 이름" from class, professor where cl_pr_num=pr_num and cl_title="네트워크";
 
 select pr_name as "교수 이름" from class
	join professor
		on cl_pr_num=pr_num 
			where cl_title="네트워크";