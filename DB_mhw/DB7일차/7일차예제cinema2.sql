create database if not exists cinema2;
use cinema2;

CREATE TABLE if not exists `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(50) not	NULL,
	`mo_contents`	longtext not NULL,
	`mo_director`	varchar(100) not NULL,
	`mo_main_actor`	longtext not NULL,
	`mo_sub_actor`	longtext	NULL,
	`mo_opening_date`	date	NULL,
	`mo_genre`	varchar(100) not NULL,
	`mo_runtime`	int	not NULL,
	`mo_rating`	int	not NULL,
    primary key (mo_num)
);
CREATE TABLE if not exists `theater` (
	`th_branch`	varchar(50)	NOT NULL,
	`th_address`	varchar(50)	NULL,
	`th_transport`	longtext	NULL,
    primary key(th_branch)
);

CREATE TABLE if not exists `screen_room` (
	`sr_num`	int	NOT NULL,
	`sr_th_branch`	varchar(50)	NOT NULL,
	`sr_name`	varchar(10)	not NULL,
	`sr_personnel`	int	not null default 0,
	`sr_location`	varchar(50)	not NULL,
    primary key (sr_num)
);
-- 위 테이블에 외래키를 추가해야하는데 빼먹어서 아래 코드를 이용하여 외래키 추가
ALTER TABLE `screen_room` ADD CONSTRAINT foreign key(sr_th_branch) references theater(th_branch); 

CREATE TABLE `screen` ( 
	`sc_num`	int	NOT NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_start_time`	char(5) not	NULL,
	`sc_end_time`	char(5)	not NULL,
	`sc_date`	date	not NULL,
	`sc_sr_num`	int	NOT NULL,
	`sc_type`	varchar(10)	not NULL default '2D',
    primary key(sc_num),
    foreign key(sc_mo_num) references movie (mo_num),
    foreign key(sc_sr_num) references screen_room(sr_num)
);

CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_name`	varchar(50)	not NULL,
	`me_level`	varchar(10)	not NULL default 'bronze',
	`me_point`	int	not null default 0,
    primary key (me_id)
);

CREATE TABLE if not exists `ticket` (
	`ti_num`	int	NOT NULL,
	`ti_personel`	int	not NULL default 1,
    primary key(ti_num)
);
CREATE TABLE `seat` (
	`se_num`	int	NOT NULL,
	`se_sr_num`	int	NOT NULL,
	`se_name`	char(3)	NULL,
    primary key(se_num),
    foreign key(se_sr_num) references screen_room(sr_num)
);

CREATE TABLE `reservation` ( 
	`re_num`	int	NOT NULL,
	`re_me_id`	varchar(20)	NOT NULL,
	`re_sc_num`	int	NOT NULL,
	`re_se_num`	int	NOT NULL,
	`re_price`	int	not NULL default 0,
	`re_ti_num`	int	NOT NULL,
    primary key(re_num),
    foreign key(re_me_id) references `member`(me_id),
	foreign key(re_sc_num) references screen(sc_num),
	foreign key(re_se_num) references seat(se_num),
	foreign key(re_ti_num) references ticket(ti_num)
);

insert into movie (mo_num, mo_title, mo_contents, mo_director, mo_main_actor, mo_sub_actor, mo_opening_date, mo_genre, mo_runtime, mo_rating) 
values (1, '컨저링3-악마가시켰다', '모든 것은 악마가 시켰다!', '마이클 차베즈', '베라파미가, 패트릭윌슨, 줄리안 힐리아드','' ,'2021.06.03','호러,미스테리,스릴러','112','15' 
);
select * from movie;

insert into theater(th_branch, th_address, th_transport) 
values('CGV청주성안길', '충청북도 청주시 상당구 북문로 1가 170-1', 
'※ 버스 이용 시 (지하상가 정류장) 하차\n
- 사직사거리 방향\n
:30-2, 40-1, 50-2, 105, 105-1, 311,313-1,419, 712, 712-1, 715-1, 715,\n
716, 718, 719, 920, 720-1, 721, 722, 811-2, 831, 842-2, 843, 862-1, 863-2, 864\n
872-1, 872-2, 911, 911-1, 912, 913, 913-1, 916-1, 917, 918, 918-1, 919\n
-도청 방향\n
:11-1, 30-1, 50-1, 311, 311-1, 313-1, 500, 502, 513, 513-1, 513-2, 515\n
611, 612, 613, 615, 616, 617, 717, 811, 811-1, 832, 842-1, 862-2, 863-1, 864\n
872-1, 872-2, 911, 911-1, 912, 916-2, 917, 918, 919');
select * from theater;


