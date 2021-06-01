-- 정규화를 위한 예제
use music;
/* 소녀시대가 부른 노래를 검색 */
select so_title from signer
join sing on si_num = sn_si_num
join `source` on so_num = sn_so_num
where si_name = "소녀시대";

-- sing이라는 테이블에 가수이름이있었으면 join을 안해도 됨=> 반정규화
-- sing 테이블 2번째 info에서 마지막줄에 sn_si_name추가함
ALTER TABLE `music`.`sing` 
CHANGE COLUMN `sn_si_name` `sn_si_name` VARCHAR(50) NOT NULL ;
-- 반정규화를진행하니 join테이블이 줄어든다
select so_title from sing 
join `source` on so_num = sn_so_num
where sn_si_name = "소녀시대";

/* 소녀시대의 3집 앨범의 수록곡을 확인하기 위한 쿼리문*/
select so_title from singer
	join sing on si_num = sn_si_num
	join `source` on  so_num = sn_so_num
	join `list` on so_num = li_so_num
	join album on al_num = li_al_num
	where si_name = "소녀시대" and al_title like "%3집%";

-- 위에서 sing에  sn_si_name추가한것때매 singer없애고,    
-- list에 li_si_name 추가해서 song도 없앰.    
ALTER TABLE `music`.`list` 
ADD COLUMN `li_si_name` VARCHAR(50) NOT NULL AFTER `li_main`;
-- 소녀시대의 3집 앨범의 수록곡을 확인 쿼리
select so_title from `source` 
	join `list` on so_num = li_so_num
	join album on al_num = li_al_num
	where li_si_name = "소녀시대" and al_title like "%3집%";