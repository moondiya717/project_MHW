create database if not exists fruit_shop2;
use fruit_shop2;

CREATE TABLE if not exists `fruit` (
	`fr_name`	varchar(20)	NOT NULL,
	`fr_price`	int	not NULL default 0,
	`fr_unit`	varchar(10)	not NULL default 'box',
	`fr_amount`	int	not NULL default 0,
    primary key (fr_name)
);

CREATE TABLE if not exists `trade` (
	`tr_num`	int	NOT NULL,
	`tr_amount`	int	not NULL default 0,
	`tr_type`	varchar(4)	not NULL default 'sell',
	`tr_price`	int	not NULL default 0,
	`tr_date`	datetime not NULL default current_timestamp,
	`tr_fr_name`	varchar(20)	NOT NULL,
    primary key(tr_num),
    foreign key(tr_fr_name) references fruit(fr_name) -- 이거안먹은거같은데
);

-- 사과가 입고되기 위해서 fruit테이블에 사과정보가 등록되어있어야 한다
insert into fruit values ('사과', 10000, 'box', 0);
select * from fruit;

-- (A과수원에서) 사과 100상자가 입고되었다. 상자당 가격은 10000원
-- trade 테이블 insert 후, fruit 테이블에 재고량을 update
insert into trade(tr_num, tr_amount, tr_type, tr_price, tr_fr_name)
	values(1,100,'buy',1000000,'사과');
select*from trade;
update fruit set fr_amount=fr_amount+100 where fr_name = '사과';
select*from fruit;

-- 손님이 사과 1상자를 상자 당 20000원에 구매를 했다
-- trade 테이블에 insert, fruit테이블에 update
insert into trade(tr_num, tr_amount, tr_type, tr_price, tr_fr_name)
	values(2,1,'sell',20000,'사과');
select*from trade;
update fruit set fr_amount=fr_amount-1 where fr_name = '사과'; 
select*from fruit;

-- 오늘 과일 판매액을 확인
select sum(tr_price) as '판매액' from trade where tr_type ='sell';  -- 전체판매액
select sum(tr_price) as '판매액' from trade where tr_type ='sell' and tr_date like '2021-06-02%'; 
-- 날짜는 문자열처럼 비교 가능 

-- 총 매출액
/* case when 사용법 
(case when 조건1 then 반환값
when 조건2 then 반환값
else 반환값 end) as 속성명
*/ -- as 속성명 안쓰면 수식이 다나와서 속성명이 넘 길게나오니까 as로 바꿔주면 좋음
select 
	sum(case when tr_type = 'buy' then -tr_price
	else tr_price end) as '총매출액'
    from trade;
    -- 값을저장할때 +,-를 구분하지 않으면 이렇게 쿼리를 실행해줘야 함.

-- 트리거 생성
drop trigger if exists insert_trade; -- insert_trade라는 트리거가있으면 해당 트리거를 삭제하고 아래 트리거 생성할거다
/* delimiter //
create trigger 트리거명 전/후 이벤트 on 테이블명 for each row
begin
실행;
end //
delimiter ; */
delimiter //
create trigger insert_trade after insert on trade for each row
begin
	if new.tr_type = 'buy' then    
		update fruit set fr_amount=fr_amount + new.tr_amount 
		where fr_name = new.tr_fr_name;  -- new 새롭게 추가된 튜플
    else
    update fruit set fr_amount=fr_amount - new.tr_amount 
		where fr_name = new.tr_fr_name;  -- new 새롭게 추가된 튜플
    end if;
end //
delimiter ;

insert into trade(tr_num, tr_amount, tr_type, tr_price, tr_fr_name)
	values(3,10,'sell',200000,'사과');

select*from fruit;

-- 프로시저: 입고될 때 없는 과일이 입고되는 경우 fruit 테이블에 새로운 과일을 추가하는 프로시저
drop procedure if exists insert_buy;
/* delimiter 기호
create procedure 프로시저명(
	{in | out} 변수명1, -- 타입이 in 일때 매개변수, 타입이 out이면 리턴값
    {in | out} 변수명2,
    ...
)
begin
	구현;
end 기호
delimiter ; */
delimiter //
create procedure insert_buy(
	in _name varchar(15),
    in _amount int,
    in _price int,
    in _sell_price int
    -- 이 프로시저는 buy일때만, 시간은 자동, 거래번호는 거래 입력할때 입력해야 함
)
begin
	declare _count int default 0; -- 구매하려는 과일이 있는지 없는지 확인
    declare _num int;
    set _count= (select count(*) from fruit where fr_name = _name); -- count(*)는 amount가 아니라 튜블 행이 몇 라인인지, 0라인이면 아예 과일 튜플이 없음을 의미
	-- 해당 과일이 없으면 
	if _count = 0 then
		-- fruit 테이블에 포도를 추가(이때, 판매가격 설정)
        insert into fruit(fr_name, fr_price)
        values(_name, _sell_price);
	end if;
    -- 해당 과일이 있으면, 추가작업이 필요없음
		-- trade 테이블에 구매 내역 추가
	set _num = (select max(tr_num) from trade) +1;
    insert into trade(tr_num, tr_amount, tr_type, tr_price, tr_fr_name)
    values(_num, _amount, 'buy', _price, _name);
end //
delimiter ; 

call insert_buy('포도', 100, 500000, 10000);
select*from fruit;

