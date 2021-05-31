/* 소녀시대가 부른 노래를 검색할 때 필요한 쿼리문
singer테이블(가수이름), source테이블(노래명)
sing테이블(가수번호, 음원번호)
[문법]
select 속성 * from 테이블;
select 속성들 from 테이블 1 join 테이블 2
	on 테이블1.외래키 = 테이블2.기본키
    where 조건;
*/
select so_title from singer
	join sing
		on si_num = sn_si_num
	join `source`
		on so_num = sn_so_num
	where si_name= "소녀시대";
    
/* 소녀시대의 멤버들을 검색하기 위한 쿼리문*/
select ar_name from `member`
	join singer
		on si_num = me_si_num
	join artist
		on ar_num = me_ar_num
	where si_name = "소녀시대";
    
/* 소녀시대의 3집 앨범의 수록곡들을 확인하기 위한 쿼리문*/
select so_title from singer
	join sing
		on si_num = sn_si_num
	join `source`
		on  so_num = sn_so_num
	join `list`
		on so_num = li_so_num
	join album
		on al_num = li_al_num
	where si_name = "소녀시대" and al_title like "%3집%";

/*소녀시대의 3집 앨범의 수록곡들을 확인하기 위한 쿼리문 수정 ver. 
join을 하는 경우 순서에 따라 검색 시간이 달라짐*/
select so_title from (select*from singer where si_name = "소녀시대") as singer_search
	join sing
		on si_num = sn_si_num
	join `source`
		on  so_num = sn_so_num
	join `list`
		on so_num = li_so_num
	join album
		on al_num = li_al_num
	where al_title like "%3집%";

/* 노래 제목이 거짓말이 들어간 노래를 확인하는 쿼리문*/
select so_title from `source` where so_title like "%거짓말%"; -- like대신 = 는 안돼(똑같아야되서)
	
/* 노래 제목 또는 가사에 거짓말이 포함된 노래를 확인하는 쿼리문*/
select so_title, so_lyric from `source` where so_title and so_lyric like "%거짓말%";  

/* SM 소속 아티스트들의 목록을 확인하는 쿼리문*/
select ar_name from artist where ar_agency = "SM"; -- 정확하게 일치하는 경우에는 = 가능 like 가능

/* 태연이 활동한 그룹들을 확인하는 쿼리문
artist 테이블(태연), member(속한 그룹), singer 테이블(그룹명)*/
select si_name from `member`
	join artist
		on ar_num = me_ar_num
	join singer
		on si_num = me_si_num
	where ar_name like "%태연%";
   
/* 태연(가수)이 피처링한 노래들을 확인하는 쿼리문
singer테이블 : 태연, sing 테이블 : 피처링 여부, source테이블 :노래 */
select so_title from sing 
	join `source` on so_num = sn_so_num
	join singer   on si_num = sn_si_num
	where si_name like "%태연%" and sn_featuring like "Y";

/* 소녀시대의 메인 타이틀곡들을 확인하는 쿼리문*/
-- 방법1
select al_title as "타이틀곡" from issue
	join album on al_num=is_al_num
    join singer on si_num=is_si_num
    where si_name like "%소녀시대%";
-- 방법2
select so_title from singer
	join sing
		on si_num = sn_si_num
	join `source`
		on  so_num = sn_so_num
	join `list`
		on so_num = li_so_num
	join album
		on al_num = li_al_num
	where si_name = "소녀시대" and li_main="Y";