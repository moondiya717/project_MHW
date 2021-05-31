-- music 데이터베이스 생성
create database if not exists music;

-- music 테이블 선택
use music;

/*가수 테이블(그룹가수) = signer
- 가수번호(기본키), 가수명, 데뷔년도, 소속사, ...
가수번호: si_num, si_num,, auto_increment, 기본키
가수명:  si_name, varchar(50) 
데뷔년도:  si_start_year, int
소속사: si_agency, varchar(30)
*/
create table if not exists singer(
	si_num int auto_increment , -- AI는 기본키만 가능함. 여러 속성중 하나만 가능
	si_name varchar(50),
	si_start_year int,
	si_agency varchar(30),
	primary key(si_num),
	check(si_start_year >=0 and si_start_year <=9999) -- 이게 좀 중요해보이넹ㅎ
);

/*아티스트 테이블(그룹일때 각 멤버 정보) = artist 
- 번호(기본키), 아티스트명, 생일, 현재 소속사, 본명, ... 

아티스트번호: ar_num, int, auto_increment, primary key
아티스트 생일: ar_birth, datetime, not null
소속사: ar_agency, varchar(30)
아티스트 명: ar_name, varchar(50), not null
본명 : ar_rname, varchar(50), not null
*/
create table if not exists artist(
	ar_num int auto_increment,
	ar_birth datetime not null,
	ar_agency varchar(30),
	ar_name varchar(50) not null,
	ar_rname varchar(50) not null,
	primary key(ar_num)
);

/*멤버테이블(어떤 그룹에 어떤 아티스트가 있는지 연결하기 위함) = member
- 번호(기본키), 가수번호, 아티스트번호, 포지션, ...

번호: me_num, int ,auto_increment ,기본키 
(*기본키는 null이 올 수 없음, not null 체크안해도 null값이 들어갈 수 없음)
가수번호: me_si_num ,int,외래키, not null
아티스트번호: me_ar_num, int, 외래키, not null
포지션: me_prosition, varchar(20)
(*외래키에서 null이 아닌 경우, not null적어줘야 함. 외래키는 null을 허용하기때문에)
*/
create table if not exists member(
	me_num int auto_increment,
	me_si_num int not null, 
	me_ar_num int not null,
	me_position varchar(20),
	primary key(me_num),
	foreign key (me_si_num) references singer(si_num), -- foreign key뒤에 꼭()있어야함
	foreign key (me_ar_num) references artist(ar_num)
);

/*음원 테이블 = source
- 음원번호, 제목, 가사, 발매일, 작곡가, 작사가 ,..
( 작곡가, 작사가 - 여러명일수있어서원래 테이블인데, 여기서는 다루지 않겠음)

음원번호: so_num, int, auto_increment
제목:so_title, varchar(50), not null
가사:so_lyric, longtext, not null
발매(공개)일: so_public_day, datetime, not null
작곡가: so_songwriter, varchar(50), not null
작사가: so_lyricist, varchar(50), not null
*/
create table if not exists source(
	so_num int auto_increment,
	so_title varchar(50) not null,
	so_lyric longtext not null,
	so_public_day datetime not null,
	so_songwriter varchar(50) not null,
	so_lyricist varchar(50) not null,
	primary key(so_num)
);

/*음원에포함된 가수 테이블=sing
-음원에포함된가수번호, 음원번호, 가수번호, 피처링여부 

번호: sn_num int auto_increment 기본키
음원번호: sn_so_num int not null 외래키
가수번호: sn_si_num int not null 외래키
피처링여부: sn_featuring char(1) not null
(*Y = 피처링O, N=피처링X)
*/
create table if not exists sing(
	sn_num int auto_increment,
	sn_so_num int not null,
	sn_si_num int not null,
	sn_featuring char(1) not null,
	primary Key(sn_num),
	foreign key(sn_so_num) references `source`(so_num), -- 키워드로 기능이 있을 수 있음 `로 다름표시
	foreign key(sn_si_num) references singer(si_num)
);

/*앨범 테이블(앨범의 기본 정보를 위한) = album
- 앨범번호, 앨범 타이틀명, 발매일, ...,

앨범번호: al_num int auto_increment 기본키
타이틀명: al_title varchar(50) not null
발매일: al_issue_date date
*/
create table if not exists album(
	al_num int auto_increment,
	al_title varchar(50) not null,
	al_issue_date date,
	primary Key(al_num)
);

/*앨범포함된가수테이블(앨범에 포함된 가수목록테이블) =issue
- 앨범에포함된가수번호, 앨범번호, 가수번호, ..

앨범에포함된가수번호:is_num int auto_increment 기본키
앨범번호: is_al_num int 외래키
가수번호: is_si_num int 외래키
*/
create table if not exists issue(
	is_num int auto_increment,
	is_al_num int,
	is_si_num int,
	primary Key(is_num),
	foreign key (is_al_num) references album(al_num),
	foreign key(is_si_num) references singer(si_num)
);

/*앨범에포함된 음원 테이블 = list
 -앨범에포함된음원번호, 앨범번호, 음원번호, 대표곡여부

앨범에포함된음원번호:li_num int auto_increment
앨범번호: li_al_num int 외래키 not null
음원번호:li_so_num int 외래키 not null
대표곡 여부: li_main char(1) not null
*/
create table if not exists list(
	li_num int auto_increment,
	li_al_num int not null,
	li_so_num int not null,
	li_main char(1) not null,
    primary key(li_num),
	foreign key (li_al_num) references album(al_num),
	foreign key (li_so_num) references `source`(so_num)
);

