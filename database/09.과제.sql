/*
과제
    다음 정보를 저장할 수 있도록 테이블을 생성하고 데이터 추가 구문을 만들어보세요.
    
    <테이블 요구사항>
    - 고객 테이블 생성(customer)
    - 컬럼 정보
        - 고객번호 : 숫자로 구성되어 있으며 반드시 입력되어야 하고 중복이 불가능. 시퀀스로 자동 부여되도록 구현
        - 고객아이디 : 영문+숫자로 구성된 8~20자 데이터이며, 반드시 입력되어야 하고 중복이 불가능
        - 고객전화번호 : 010-XXXX-XXXX으로 구성된 데이터이며, 반드시 입력되어야 하고 중복이 불가능
        - 등록일 : 첫 구매일자를 저장하기 위한 컬럼이며, 날짜 형식(YYYY-MM-DD)으로 저장됨. 반드시 입력되어야 함
        - 최종 구매일 : 마지막 구매일자를 저장하기 위한 컬럼이며 등록일과 형식이 같다.
        - 마일리지 : 회원이 물건을 구매하면 적립금을 표시하기 위한 컬럼이며, 0이상으로 설정하며, 없을 수도 있다.
        - 고객 등급 : 고객의 구매수준에 따라 변경 가능한 등급이며 다음과 같이 설정한다.
            - 일반, VIP, VVIP, 플래티넘 중 한 가지로 설정 가능하다.
    <시퀀스 요구사항>
    - 시퀀스 생성(customer_seq)
    - 기본 옵션으로 생성
    
    <회원 정보>
        - 아이디 : testuser1 , 전화번호 : 010-1212-3434, 등록일 : 2022-01-01, 최종구매일 : 2022-03-11, 마일리지 : 5500, 등급 : VIP
        - 아이디 : testuser2 , 전화번호 : 010-2323-4545, 등록일 : 2020-05-11, 최종구매일 : 2022-01-30, 마일리지 : 7200, 등급 : VVIP
        - 아이디 : testuser3 , 전화번호 : 010-3434-5656, 등록일 : 2021-11-26, 최종구매일 : 2021-12-25, 마일리지 : 30000, 등급 : 플래티넘
        - 아이디 : testuser4 , 전화번호 : 010-4545-6767, 등록일 : 2022-02-03, 최종구매일 : 2022-03-15, 마일리지 : 500, 등급 : 일반
        - 아이디 : testuser5 , 전화번호 : 010-5656-7878, 등록일 : 2021-12-31, 최종구매일 : 2022-01-31, 마일리지 : 800, 등급 : 일반
*/

-- 시퀀스 생성
create sequence customer_seq;

-- 시퀀스 삭제
drop sequence customer_seq;

-- 테이블 생성
create table customer (
customer_num number not null unique,
customer_id varchar2(60) not null unique check(regexp_like(customer_id, '^[a-z0-9]{8,20}$')),
--customer_tel char(13) not null unique check(regexp_like(customer_tel, '^010-[0-9]{4}-[0-9]{4}$')),
customer_tel char(13) not null unique check(regexp_like(customer_tel, '^010-\d{4}-\d{4}$')),
customer_registration char(10) not null check(regexp_like(customer_registration, '^(19|20)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$')),
customer_purchase char(10) check(regexp_like(customer_purchase, '^(19|20)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$')),
customer_point number default 0 check(customer_point >= 0),
customer_lv varchar2(12) default '일반' not null check(customer_lv in ('일반', 'VIP', 'VVIP', '플래티넘'))
);

-- 테이블 삭제
drop table customer;

-- 회원 정보
insert into customer(customer_num, customer_id, customer_tel, customer_registration, customer_purchase, customer_point, customer_lv) 
    values(customer_seq.nextval, 'testuser1','010-1212-3434', '2022-01-01', '2022-03-11', 5500, 'VIP');
    
insert into customer(customer_num, customer_id, customer_tel, customer_registration, customer_purchase, customer_point, customer_lv) 
    values(customer_seq.nextval, 'testuser2','010-2323-4545', '2020-05-11', '2022-01-30', 7200, 'VVIP');
    
insert into customer(customer_num, customer_id, customer_tel, customer_registration, customer_purchase, customer_point, customer_lv) 
    values(customer_seq.nextval, 'testuser3','010-3434-5656', '2021-11-26', '2021-12-25', 30000, '플래티넘');
    
insert into customer(customer_num, customer_id, customer_tel, customer_registration, customer_purchase, customer_point, customer_lv) 
    values(customer_seq.nextval, 'testuser4','010-4545-6767', '2022-02-03', '2022-03-15', 500, '일반');
    
insert into customer(customer_num, customer_id, customer_tel, customer_registration, customer_purchase, customer_point, customer_lv) 
    values(customer_seq.nextval, 'testuser5','010-5656-7878', '2021-12-31', '2022-01-31', 800, '일반');

-- 최종 저장
commit;

-- 출력
select * from customer;
