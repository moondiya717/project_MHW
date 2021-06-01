/* 오프라인 과일가게에서 과일판매를 관리하려고 한다 이를 ERD로 작성한 후 DB와 테이블을 생성하세요
DB명: fruit_shop
기능 -> 과일 입고, 출고, 판매, 판매 내역, 구매 내역 관리해야 함 
*누구한테 얼마나 팔았는지가 아니라, 몇개나 팔았는지가 중요
*(조건) 해당 가게에서 판매될 모든 과일은 미리 등록되어있다.
*서비스X
*/

/*트리거 
과일을 입고하거나 판매하면 재고량이 입고/판매량에 맞춰 변하는 트리거를 생성*/

create database if not exists fruit_shop;
use fruit_shop;
create table if not exists buy(
	b_num int auto_increment primary key,
    b_name varchar(30) not null,
    b_count int not null,
    b_price int not null,
    b_date date not null,
    check (b_price>=0) 
);

ALTER TABLE buy ADD b_seller varchar(30) not null;

create table if not exists sell(
	s_num int auto_increment primary key,
	s_b_name varchar(30) not null,
    s_count int not null default 0,
    s_price int not null,
    s_date date not null,
    foreign key (s_b_name) references buy(b_name),
    check (s_price>=0) 
);

create table if not exists product(
	p_num int auto_increment primary key,
	p_s_b_name varchar(30) not null,
    p_count int not null default 0,
    p_price int not null,
    p_date date not null
    check (p_price>=0) 
);



drop trigger if exists adjust_count;
delimiter //
create trigger adjust_count after insert on `sell` for each row
begin 
	update `product` 
		set  p_count= p_count-new.s_count
			where p_s_b_name = new.s_b_name;
end //
delimiter ;

drop trigger if exists adjust_count2;
delimiter //
create trigger adjust_count2 after insert on `buy` for each row
begin 
	update `product` 
		set  p_count= p_count+new.b_count
			where p_s_b_name = new.b_name;
end //
delimiter ;

show triggers;


select*from product;
select*from sell;
select*from buy;


/* [A과수원에서] 사과 100상자 입고되었다. 상자당 가격은 10000원 
과수원이름은 생략가능/ 사과, 100상자, 가격은 필수 입력*/
select * from buy;


/* 손님이 사과 1상자를 개당 20000원에 구매를 했다.*/
select * from sell;
UPDATE `fruit_shop`.`sell` SET `s_b_name` = 'apple', `s_count` = '1', `s_price` = '20000' WHERE (`s_num` = '1');


/* 오늘 과일 판매액을 확인하는 쿼리문*/
select * from sell;
select s_b_name, s_price from sell where s_date="2021-06-01"; 