/* 사원들의 월급을 관리하는 시스템을 위한 DB를 설계하세요.
직급 : 사원, 대리, 과장, 부장, 전무, 이사
월급 : 월급은 직급 별 기본급에 직급 별 호봉에 따른 추가금
예시) 사원 기본급 200만, 호봉 별 추가금 10만원  => 2년차 사원 홍길동의 월급: 220만원 */

create database if not exists  salary;
use salary;

CREATE TABLE if not exists `WorkerInfo` (
	`w_num`	int	NOT NULL primary key auto_increment,
	`w_name`	varchar(20) not	NULL,
	`w_position`	varchar(20)	not NULL,
	`w_start`	date	not NULL,
	`w_birth`	date	NULL
);

CREATE TABLE if not exists `SalaryInfo` (
	`s_num`	int	NOT NULL primary key auto_increment,
	`s_tax`	int not	NULL,
	`s_total`	int	not NULL,
	`s_w_num`	int	NOT NULL,
	`ps_num`	int	NOT NULL
);

CREATE TABLE if not exists `PaymentSystem` (
	`ps_num`	int	NOT NULL primary key auto_increment,
	`w_ps_position`	varchar(20)	not NULL,
	`ps_pay`	int	not NULL,
	`ps_grade`	int	not NULL
);

ALTER TABLE `salary`.`paymentsystem` 
ADD COLUMN `ps_gr_pay` VARCHAR(45) NOT NULL AFTER `ps_grade`;

-- 직급별 호봉 금액
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('1', 'staff', '2000000', '1', '100000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('2', 'staff', '2000000', '2', '200000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('3', 'staff', '2000000', '3', '300000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('4', 'staff', '2000000', '4', '400000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('5', 'staff', '2000000', '5', '500000');

INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('10', 'AS', '2500000', '1', '100000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('11', 'AS', '2500000', '2', '200000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('12', 'AS', '2500000', '3', '300000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('13', 'AS', '2500000', '4', '400000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('14', 'AS', '2500000', '5', '500000');

INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('15', 'Manager', '3000000', '1', '100000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('16', 'Manager', '3000000', '2', '200000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('17', 'Manager', '3000000', '3', '300000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('18', 'Manager', '3000000', '4', '400000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('19', 'Manager', '3000000', '5', '500000');

INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('20', 'GM', '3500000', '1', '100000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('21', 'GM', '3500000', '2', '200000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('22', 'GM', '3500000', '3', '300000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('23', 'GM', '3500000', '4', '400000');
INSERT INTO `salary`.`paymentsystem` (`ps_num`, `w_ps_position`, `ps_pay`, `ps_grade`, `ps_gr_pay`) VALUES ('24', 'GM', '3500000', '5', '500000');



/* 호봉이나 직급이 변경되면 월급이 변경되는 트리거 또는 프로시저를 만드세요*/


