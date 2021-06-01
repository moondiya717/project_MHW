SELECT * FROM potal.class;


ALTER TABLE `potal`.`class` 
ADD COLUMN `cl_now_count` INT NOT NULL DEFAULT 0 AFTER `cl_pr_num`;


UPDATE `potal`.`class` SET `cl_now_count` = '1' WHERE (`cl_code` = '2021MSC004');

