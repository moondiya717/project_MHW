
/* 주문vs제품 => 
 right join : 오른쪽인 제품을 기준으로 join을 하는데 
			  제품과 연결된 주문내역이 없으면 주문에 해당하는 속성들의 값이 null로 채워서 보여줌*/
SELECT * FROM example.주문 right join 제품 on 주문제품 = 제품번호;
    
-- 주문과 제품 테이블에서 그냥 join은 inner join이면서, 
-- 그러나 이 문제에서는 left join에도 해당
SELECT * FROM example.주문 left join 제품 on 주문제품 = 제품번호;
    
/*
 select * from A left join B on A.속성 = B.속성; -- 어느걸 외래키로 할지 공식에선 모르니깐 걍 속성으로 썻다함
 select * from A right join A on A.속성 = B.속성; 과 같다
 */
 SELECT * FROM example.주문 right outer join 제품 on 주문제품 = 제품번호; -- 이 경우, 주문제품이 제품에 다 들어가있어서 outer사용안됨 right만해도 outer효과남
 
 -- inner 교집합만, right 오른쪽은 전부 + 교집합, left 왼쪽 전부+교집합 , outer 두 집합의 모든 요소