/*update문을 이용해서 교수의 비밀번호를 모두 abc123으로 변경하기 */
use potal;
update professor set pr_pw="abc123";
select * from professor;


/* P2000135001 교수님의 이름을 고길동으로 수정*/
update professor set pr_name="고길동" where pr_num="P2000135001";
select * from professor;

/* delete from 테이블명 where 조건
- 해당 조건을 만족하는 튜플을 삭제
- 조건이 생략되면 전체 튜플을 삭제*/

-- board라는 테이블 생성
create table if not exists board(
bd_num int auto_increment,
bd_title varchar(50) not null,
bd_is_del char(1) not null default "N",
primary key(bd_num)
);

-- 게시글 5개 등록
insert into board(bd_title) values("제목1"), ("제목2"),("제목3"), ("제목4"), ("제목5");
select * from board;
-- 1번 게시글 삭제
update board set bd_is_del="Y" where bd_num=1;
-- 삭제되지 않은 게시글 검색 (실제로 지운건 아님)
select * from board where bd_is_del = "N";

/* 기존 테이블을 기반으로 만들어진 가상의 테이블 => View뷰*/
select * from board where bd_is_del = "N"; -- 이것도 view의 일종






