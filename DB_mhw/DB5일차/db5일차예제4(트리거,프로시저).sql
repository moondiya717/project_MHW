/*트리거와 프로시저 : 사용을 안하는 것이 좋다고 함
프로시저: 사용자가 만든 함수로 호출하여 사용 
트리거: 데이터가 추가, 수정, 삭제가 일어나는 경우 미리 지정된 작업이 자동으로 실행
트리거
delimiter 기호  --임시로 문장의 끝을 ;가 아니라 기호로 바꿨다가 
create trigger 트리거명
{before|after} {insert|update|delete} on 테이블명  -- 트리거 발생시점을 지정
for each row
begin
	코드작성;
end 기호
delimiter;  -- 다시 문장의 끝을 ; 로 돌려놓기

*delimiter 기호? 
- 문장의 마지막을 알려주는 기호 ; 대신에 지정한 기호로 대체
- 코드작성부분에 ;이 나왔을 때 실행되지 않도록 ;을 무시하게 하기위해서 사용
*/

/* 과일상점(fruit shop) 데이터베이스 생성*/
create database fruitshop;