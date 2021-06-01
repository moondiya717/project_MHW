/* 
프로시저 
drop procedure if exists 프로시저명;
delimiter 기호
create procedure 프로시저명(
	{in | out} 변수명1, -- 타입이 in 일때 매개변수, 타입이 out이면 리턴값
    {in | out} 변수명2,
    ...
)
begin
	구현;
end 기호
delimiter ;
*/

drop procedure if exists addOrder; 
delimiter //
create procedure addOrder(
	in _id varchar(20),
    in _product char(3),
    in _amount int,
    in _address varchar(30),
    in _date varchar(20)
)
begin
	declare _count int default 0;
    declare _order_num char(3);
    set _count = (select count(*) from 주문) +1;
    set _order_num = concat('o',_count); -- concat은 여러 문자열을 하나로 합쳐 하나의 문자열로 만드는 것
    insert into `주문` values(_order_num, _id, _product, _amount, _address, _date);
	select * from `주문`;
end //
delimiter ;

-- 프로시저 호출하기(트리거랑 다르게 자동으로 실행되는게 아니라, 자바 메소드처럼 호출해줘야 함)
-- call 프로시저명(변수들);
call addOrder('apple', 'p01', 15, '충북 청주시', '2021-06-01'); 