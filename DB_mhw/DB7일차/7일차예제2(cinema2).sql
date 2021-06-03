/*영화 정보 확인하는 쿼리문 - 컨저링3*/
select * from movie where mo_title like '%컨저링3%';
select * from movie where mo_title like concat('%','컨저링3','%');
-- concat은 문자열들을 이어주는 기능을 함

/*컨저링3의 오늘(2021-06-03) 상영시간을 확인하는 쿼리문*/
select sc_start_time from screen 
	join movie on mo_num = sc_mo_num
    where mo_title like concat('%','컨저링3','%') and sc_date = '2021-06-03';
    
 /* 컨저링3의 CGV청주성안길 지점의 상영 정보를 확인하는 쿼리문*/
/*방법1*/
select screen.* from screen -- screen.* 하면 screen에 대한 정보만 나옴
	join screen_room on sr_num=sc_sr_num
    join movie on mo_num=sc_mo_num
    where mo_title like '%컨저링%' and sr_th_branch like 'CGV청주성안길';

/*방법2*/
select screen.* from screen
	where sc_mo_num = (select mo_num from movie where mo_title like '%컨저링%')
    and sc_sr_num = (select sr_num from screen_room where sr_th_branch like 'CGV청주성안길');


/* 청주 성안길 지점의 1관의 예매 가능한 좌석 정보를 확인하는 쿼리문*/
select se_name from seat 
	join screen_room on sr_num=se_sr_num
    where sr_name like '1관' and sr_th_branch like 'CGV청주성안길';
    
select se_name from seat
	where se_sr_num = (select sr_num from screen_room 
    where sr_name like '1관' and sr_th_branch like 'CGV청주성안길');
    -- 데이터가 많은 경우, join보다는 서브쿼리를 이용하는게 더 빠를 수 있음
    
/* CGV청주성안길 컨저링3가 9:00에 있을 때, 해당 영화의 선택 가능한 좌석을 확인
-- 해당 영화의 상영시간 번호와 상영관 번호를 확인
-- 해당 영화 예매 내역 중 예약된 좌석 현황
-- 해당 영노하의 예매 가능한 좌석 정보를 확인*/


-- 해당 영화의 상영시간 번호와 상영관 번호를 확인
-- CGV청주성안길 지점에서 오늘 9:00에 시작하는 컨저링3 영화의 상영관번호
select sc_num, sc_sr_num from screen_room join screen on sc_sr_num =sr_num
    where sr_th_branch like 'CGV 청주성안길' and sc_start_time like '9:00' and sc_date like '2021-06-03%'
    and sc_mo_num=(select mo_num from movie where mo_title like '컨저링3%');
-- 위에껄 서브쿼리로 만들기=('상영시간번호')
select sc_num, sc_sr_num  from screen
    where sc_sr_num = (select sr_num from screen_room where sr_th_branch like 'CGV청주성안길')
    and sc_start_time like '9:00'
    and sc_date like '2021-06-03%'
    and sc_mo_num = (select mo_num from movie where mo_title like'컨저링3%');


-- 해당 영화 예매 내역 중 예약된 좌석 현황 =('예약된 좌석명')
select se_name from seat where se_num in 
	(select re_se_num from reservation where re_sc_num = ('상영시간번호'));


-- 해당 영화에서(오늘 9:00 컨저링3) 예약 가능한 좌석
select se_name from seat where se_sr_num= ('상영관번호') 
	and se_name not in ('예약된 좌석명');
-- 예약 가능한 좌석은 전체 좌석에서 예약된 좌석을 제외한(포함하지 않은) 좌석들

--  CGV청주성안길 지점에서 오늘 9:00에 시작하는 컨저링3 영화 상영관의 전체 좌석
select se_name from seat
	where se_sr_num =
    (select sr_num from screen_room join screen on sc_sr_num=sr_num
    where sr_th_branch like 'CGV청주성안길' and sc_start_time like '9:00' and sc_date like '2021-06-03%'
    and sc_mo_num=(select mo_num from movie where mo_title like '컨저링3%'));
    
/* abc123 회원이 관람했던 영화 리스트를 확인*/
select mo_title from movie
	join screen on mo_num =sc_mo_num
    join reservation on sc_num=re_se_num
    where re_me_id like 'abc123';
    
-- 위에껄 서브쿼리로
select mo_title from movie where mo_num in 
(select sc_mo_num from screen
join reservation on sc_num = re_sc_num where re_me_id='acd123');

    
