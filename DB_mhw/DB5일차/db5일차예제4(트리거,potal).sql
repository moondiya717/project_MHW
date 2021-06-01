SELECT * FROM potal.class;


ALTER TABLE `potal`.`class` 
ADD COLUMN `cl_now_count` INT NOT NULL DEFAULT 0 AFTER `cl_pr_num`;


UPDATE `potal`.`class` SET `cl_now_count` = '1' WHERE (`cl_code` = '2021MSC004');

-- 학생이 강의를 수강신청하면 해당 강의의 현재 정원이 1증가하는 트리거
use potal;
drop trigger if exists insert_class;
delimiter //
create trigger insert_course after insert on course for each row
begin 
update class 
set cl_now_count = cl_now_count+1
where cl_code = new.co_cl_code;
end //
delimiter ;

INSERT INTO `potal`.`course` (`co_st_num`, `co_cl_code`) VALUES ('2020160001', '2021MSC004');

-- 해당 데이터베이스의 트리거 확인
show triggers;