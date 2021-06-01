-- 트리거 실행문에서 조건문 사용해보기
/*
drop trigger if exists test_order;
delimiter //
create trigger test_order after insert on `주문` for each row
begin 
	/* if문 문법
    if 조건 then
		쿼리문;
	elseif 조건 then
		쿼리문;
	else
		쿼리문
	end if;
    */
-- end //
-- delimiter ;


drop trigger if exists test_order;
delimiter //
create trigger test_order after insert on `주문` for each row
begin 
	/* if문 문법
    /* 변수 선언 (begin 바로 밑에 변수들을 모아서 선언해야 함)
    declare 변수명 타입 default 초기값;
    - 변수 선언 시 변수명 앞에 _를 붙이면 좋다. 속성이름과 구분하기 위해
    /* 변수 저장
    set 변수명 = 값;
    */
    declare _amount int default 0;
    declare _state varchar(10) default '';
    set _amount = 10;
    set _amount = (select count(*) from 주문);
    if _amount >10 then
		set _state = "많다";
	elseif _amount > 5 then
		set _state = "적절";
	else
		set _state = "적응";
	end if;
end //
delimiter ;

show triggers;