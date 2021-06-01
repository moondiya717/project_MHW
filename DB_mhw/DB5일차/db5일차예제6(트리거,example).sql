use example;
/*delimiter 기호  --임시로 문장의 끝을 ;가 아니라 기호로 바꿨다가 
create trigger 트리거명
{before|after} {insert|update|delete} on 테이블명  -- 트리거 발생시점을 지정
for each row
begin
	코드작성;
end 기호
delimiter;  -- 다시 문장의 끝을 ; 로 돌려놓기*/

/*주문 테이블에 주문내역이 추가되면 제품 테이블의 재고량이 변하는 트리거를 작성하세요.*/
select*from 주문;

drop trigger if exists insert_order;
delimiter //
create trigger insert_order after insert on `주문` for each row
begin 
	update `제품` 
		set  재고량= 재고량-new.수량
			where 제품번호 = new.주문제품;
end //
delimiter ;

show triggers;

INSERT INTO `example`.`주문` (`주문번호`, `주문고객`, `주문제품`, `수량`, `배송지`, `주문일자`) VALUES ('o11', 'carrot', 'p01', '50', '충북 청주시', '2021-06-01');
INSERT INTO `example`.`주문` (`주문번호`, `주문고객`, `주문제품`, `수량`, `배송지`, `주문일자`) VALUES ('o12', 'carrot', 'p01', '50', '충북 청주시', '2021-06-01 00:00:00');


