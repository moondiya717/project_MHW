
-- test라는 테이블을 생성
create database if not exists test;
use test;

-- table t1,t2는 num이라는 AI, PK 와 contents가 똑같이 속성으로 들어가있음
create table if not exists t1;
create table if not exists t2;

-- 값을 t1과 t2에 똑같이 1~10까지를 넣었음 (생략 걍 수동으로 빠르게 넣으셈)

-- t1은 delete 로 지우고
delete from t1 where num;
select * from t1; -- 값이 전부 지워진 걸 확인 

-- t2는 truncate 로 지우고
truncate t2; 
select * from t2; -- 값이 전부 지워진 걸 확인 함 

-- 다시 값을 1-14까지 t1과 t2에 넣겠음 
select * from t1; -- num가 AI가 걸려있는데 11부터 시작함 (최초 1-10 입력한 숫자를 지운 이후와 이어지는 11부터 시작)
select * from t2; -- num가 AI가 걸려있고 1부터 시작함(완전 초기화처럼, 앞에 얼마나 데이터가 있었는지 모름)


