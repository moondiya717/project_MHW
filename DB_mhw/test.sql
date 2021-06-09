create database if not exists fruit_shop_exam;
use fruit_shop_exam;
create table if not exists fruit(
	fr_name varchar(15) not null,
    fr_prive int not null,
    fr_amount int not null,
    primary key (fr_name)
);
create table if not exists trade(
	tr_num int auto_increment not null,
    tr_amount int not null,
    tr_type varchar(4) default 'sell' not null,
    tr_date date default current_timestamp not null,
    tr_price int not null,
    tr_fr_name varchar(15) not null,
    primary key(tr_num),
    foreign key (tr_fr_name) references fruit(fr_name)
);