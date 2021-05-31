-- example 데이터베이스 생성
create database example;

-- example 데이터베이스 선택
use example;

-- 고객 테이블을 생성
create table 고객(
고객아이디 varchar(20) not null,
고객이름 varchar (10) not null,
나이 int,
등급 varchar(10) not null,
직업 varchar(20),
적립금 int default 0,
primary key (고객아이디)
);

create table 제품(
제품번호 char(3) not null,
제품명 varchar(20),
재고량 int,
단가 int,
제조업체 varchar(20),
primary key(제품번호),
check (재고량>= 0 and 재고량 <=10000)
);

create table 주문(
주문번호 char(3) not null,
주문고객 varchar(20),
주문제품 char(3),
수량 int,
배송지 varchar(30),
주문일자 datetime,
primary key (주문번호),
foreign key(주문고객) references 고객(고객아이디),
foreign key(주문제품) references 제품(제품번호)
);


select *from 고객; -- 릴레이션(릴레이션스키마, 릴레이션 인스턴스가 한번에 나오는 구조)
desc 고객;  -- 릴레이션스키마의 리스트와 특성자세히보기
select *from 제품;
select *from 주문;


insert into 고객(고객아이디, 고객이름, 나이, 등급, 직업, 적립금)
values("apple", "정소화", "20", "gold", "학생", "1000"),
("banana", "김선우", "25", "vip", "간호사", "2500"),
("carrot", "고명석", "28", "gold", "교사", "4500"),
("orange", "김용욱", "22", "silver", "학생", "0"),
("melon", "성원용", "35", "gold", "회사원", "5000"),
("peach", "오형준", null, "silver", "의사", "300"),
("pear", "채광주", "31", "silver", "회사원","500");

insert into  제품(제품번호, 제품명, 재고량, 단가, 제조업체)
values("p01", "그냥만두", "5000", "4500", "대한식품"),
("p02", "매운쫄면", "2500", "5500", "민국푸드"),
("p03", "쿵떡파이", "3600", "2600", "한빛제과"),
("p04", "맛난초콜렛", "1250", "2500", "한빛제과"),
("p05", "얼큰라면", "2200", "1200", "대한식품"),
("p06", "통통우동", "1000", "1550", "민국푸드"),
("p07", "달콤비스켓", "1650", "1500", "한빛제과");

insert into 주문(주문번호, 주문고객, 주문제품, 수량, 배송지, 주문일자)
values ("o01", "apple", "p03", "10", "서울시 마포구", "2013-01-01"),
("o02", "melon", "p01", "5", "인천시 계양구", "2013-01-10"),
("o03", "banana", "p06", "45", "경기도 부천시", "2013-01-11"),
("o04", "carrot", "p02", "8", "부산시 금정구", "2013-02-01"),
("o05", "melon", "p06", "36", "경기도 용인시", "2013-02-20"),
("o06", "banana", "p01", "19", "충청북도 보은군", "2013-03-02"),
("o07", "apple", "p03", "22", "서울시 영등포구", "2013-03-15"),
("o08", "pear", "p02", "50", "강원도 춘천시", "2013-04-10"),
("o09", "banana", "p04", "15", "전라남도 목포시", "2013-04-11"),
("o10", "carrot", "p03", "20", "경기도 안양시", "2013-05-22");

-- 고객 명단 확인 (고객의 전체 정보를 확인)
select * from 고객;

-- 고객명단에서 고객들의 등급을 확인
-- [all | distinct]를 생략하면 all이 기본값으로 적용
select 등급 from 고객; -- 값이 중복되서 나옴
select distinct 등급 from 고객; -- 중복값을 제거하고 나옴 

-- 현재 선택된 데이터베이스에 따라 쿼리문이 실행되지 않을 수도 있다
-- 다른 데이터베이스에서 실행을 해야 한다면 데이터베이스 이름을 써줘야돼. select 등급 from example.고객 이렇게alter

-- 고객의 등급을 확인(고객아이디과 등급을 확인)
select 고객아이디, 등급 from 고객;

-- 검색 결과의 속성 이름을 변경하는 키워드 as (해당 검색 결과에서만 바뀜, 실제 속성이름이 영구적으로 바뀌는게 아님)
select 고객아이디 as '아이디', 등급 from 고객;

-- 고객아이디가 apple인 고객의 주문 내역 확인
-- 검색할 때 where(조건문)
select * from 주문 where (주문고객 = "apple");

-- 제품명이 p01인 제품이 주문된 내역을 확인하기
-- 속성이름은 ""를 붙이지 않고 값은 "" 붙여주기
select * from 주문 where (주문제품 = "p01");

-- 제조업체가 한빛제과인 제품의 목록을 확인
select 제품명 from 제품 where ( 제조업체 = "한빛제과") ;

-- 5개이상 주문한 고객의 아이디를 확인
select distinct 주문고객 as 아이디 from 주문 where (수량 > "5");
-- distinct 중복값 제거, as주문고객을 아이디라고 칭해서 노출, where (조건 수량>"5")

-- 단가가 2000원 이상 3000원 이하인 제품명을 확인
select 제품명, 단가 from 제품 where (단가 >="2000" and 단가<="3000");

-- 조건에서 속성 = "문자열"로 확인하면 해당 문자열과 완전히 일치하는 것들을 확인

-- 고객 이름이 "오" 인 고객리스트를 확인( %나 _가 안쓰이면 like도 = 와 같은 역할을 함.)
select * from 고객 where 고객이름 like "오";

-- 고객 이름이 3글자인 고객의 리스트를 확인
select * from 고객 where 고객이름 like "___";

-- 고객의 성이 김씨인 고객의 리스트를 확인
select 고객이름 from 고객 where 고객이름 like "김%";

-- 속성의 값이 null인지 아닌지를 확인할 때 is null 또는 is not null을 이용
-- 나이가 null로 저장된 고객의 이름을 확인
select 고객이름 from 고객 where 나이 is null;

-- 나이가 null이 아닌 고객의 이름을 확인
select 고객이름 from 고객 where 나이 is not null;

-- 정렬은 order by 속성명 [asc | desc]로 정렬할 수 있다
-- 정렬하고싶은 값이 여러개라면(값이 중복일 경우): order by 속성명1[asc|desc], 속성명2[asc|desc], ... 로 정렬 가능
-- order by와 where는 별개이고 항상 쿼리에 필요한건 아님. 필요할 때만 쓰면 돼 
-- asc: 오름차순, 기본값(생략했을 때) , desc: 내림차순
-- 고객을 고객 이름순으로 정렬 
select * from 고객 order by 고객이름 asc;

-- 고객의 등급을 기준으로 정렬
select * from 고객 order by 등급 desc;

-- 고객의 등급을 기준으로 정렬 한 후, 이름순으로 정렬
select * from 고객 order by 등급 asc, 고객이름 asc; 
-- gold 등급에서 ㄱㄴㄷ 순으로, silver 등급에서 ㄱㄴㄷ 순으로 정렬이 됨
 
 -- [집계함수] count: 속성값의 개수, max/min : 속성값 중 최대/최소, sum:속성값들의 합계, avg : 속성값들의 평균
 -- 집계함수는 null인 속성 값은 제외하고 개수 계산
 -- 가입된 고객의 수
 select count(고객아이디) from 고객;
 select count(*) from 고객;

 -- 가입된 고객 중 최고령자의 나이
 select max(나이) from 고객;

-- 가입된 고객 중 최연소자의 나이
select min(나이) from 고객;

-- 판매된 제품 수 (총 판매 수량)
select sum(수량) as "판매량" from 주문;

-- 제품의 평균 가격
select avg(단가) from 제품;

-- 아이디가 apple인 회원의 평균 주문량을 확인
select avg(수량) from 주문 where (주문고객 = "apple");

-- group by는 where절 다음에 order by 앞에 있어야 한다
-- 주문 제품별 총 판매 수량
select 주문제품, sum(수량) as "판매수량" from 주문 group by 주문제품;

-- 고객 별 총 주문 수량
select 주문고객, sum(수량) as "주문수량(누적)" from 주문 group by 주문고객;

-- 제조업체별 제품 수와 제품들의 최고가와 최저가를 확인
select 제조업체, count(제품명) as "제품 수" , max(단가) as "최고가", min(단가) as"최저가" from 제품 group by 제조업체; 
select 제조업체, count(*) as 제품수, max(단가) as최고가, min(단가) as최저가 from 제품 group by 제조업체;
-- 속성이름에는 ""안해도 되는데 했음, 습관마냥..주륵, (제품명)대신 (*) 로 대신할 수 있음

-- having : 그룹에서 조건을 걸 고 싶을 때, 사용하는 절로 집계함수를 이용할 수 있다.
-- where절에서는 집계함수(min, max, ..) 이용이 안됨 따라서 group by 뒤로가서 having 을 사용해서 조건을 달면됨(집계함수 사용가능).
-- 제조업체의 제품수가 3개 이상인 제조업체
select 제조업체 from 제품 group by 제조업체 having count(*)>=3;




 
 
