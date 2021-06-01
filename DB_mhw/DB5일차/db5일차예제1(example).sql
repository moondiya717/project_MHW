/*문제1.
 달콤 비스켓과 같은 제조업체에서 제조한 제품의 제품명과 단가를 검색*/
-- 방법1 (달콤비스켓의 제조업체를 확인하고 그 다음에에 한빛제과로 내역찾기) => 굉장히비효율적X
select 제조업체 from 제품 where 제품명 = "달콤비스켓";
select 제품명, 단가 from 제품 where 제조업체 = "한빛제과";

-- 방법2 서브쿼리(=부속 질의문)
select 제품명, 단가 from 제품 where 제조업체 = (select 제조업체 from 제품 where 제품명 = "달콤비스켓");
-- where 제조업체 = 뒤에 () 괄호를 필수로 쳐줘야 함. 안하면 에러발생

/*문제2.
banana 고객이 주문한 제품의 제품명과 제조업체를 검색
*/
-- 방법1 join을 이용
select 제품명, 제조업체 from 주문
	join 제품 on 제품번호=주문제품 where 주문고객 = "banana";
-- 방법2    
select 제품명, 제조업체 from 제품 
	where 제품번호 in (select 주문제품 from 주문 where 주문고객="banana"); 
    -- 0개 또는 한개는 = 나타내고, 여러개일수있을땐 in
    
/*문제3.
banana 고객이 주문하지 않은 제품의 제품명과 제조업체를 검색*/
-- 방법1을 이용하면 => 바나나고객이 아닌 다른고객들이 주문한 제품들 => 문제의 잘못된 쿼리
select distinct 제품명, 제조업체 from 주문
	join 제품 on 제품번호=주문제품 where 주문고객 <> "banana"; 
    -- !=랑 <> 는 is not이라는 뜻
-- 방법2
select 제품명, 제조업체 from 제품 
	where 제품번호 not in (select 주문제품 from 주문 where 주문고객="banana"); 
    -- in의 반대는 not in
    
/* 문제4.
대한식품이 제조한 모든 제품의 단가보다 비싼 제품의 제품명, 단가, 제조업체 검색*/
select 제품명, 단가, 제조업체 from 제품 
where 단가 > all (select 단가 from 제품 where 제조업체 ="대한식품");
-- where절에는 함수못씀(예:max) having에만 쓸 수 있음
-- all -> 해당하는 정보를 모두 만족하는 제품들

/*문제5.
2013년 3월 15일에 제품을 주문한 고객의 고객이름을 검색*/
-- 방법1. join이용
select 고객이름 from 고객 
	join 주문 on 주문고객 = 고객아이디
    where 주문일자 like "2013-03-15%";
	-- 문자열로도 날짜 검색 가능 where주문일자 = "2013-03-15";
-- 방법2. exists와 서브쿼리 이용
select 고객이름 from 고객 
	where exists (select *from 주문 where 주문일자="2013-03-15" and 주문고객=고객아이디);
	-- exists (연산자) 서브쿼리조건에 존재하는 정보들

