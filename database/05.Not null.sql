/*
    테이블 제약조건(table constraint)
    - 데이터 저장, 수정 등에 반영할 특이사항에 대한 조건
    - Not Null : 필수 데이터를 지정하는 조건
    - Unique : 중복을 금지하는 조건
    - Check : 원하는 값의 형태를 지정하는 조건
*/

-- 예제 1) oop.method4

-- 테이블 생성
create table menu (
name varchar2(60) not null unique,
--type varchar2(9) not null check(regexp_like(type, '(음료|디저트)'),
type varchar2(9) not null check(type in ('음료', '디저트')), -- 음료 또는 디저트만 들어갈 수 있도록 제한
price number not null check(price >= 0),
--event char(1) check(event in ('Y'))
event char(1) check(event = 'Y') -- 주의 : 오라클에서는 ==로 문자열의 같음을 비교한다
);

-- 데이터 입력
--insert into menu(name, type, price, event) values(null, null, null, null);
insert into menu(name, type, price, event) values('아메리카노', '음료', '2500', 'Y');
--insert into menu(name, type, price, event) values('모라카떼', '음료', '3500', null);
insert into menu(name, type, price, event) values('모라카떼', '음료', '3500');

-- 최종 저장
commit;

