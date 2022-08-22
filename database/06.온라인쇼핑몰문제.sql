-- 예제 2) oop.method6

-- 테이블 생성
create table item (
name varchar2(30) not null unique,
type varchar2(6) not null check(type in ('주류', '과자')),
price number not null check(price >= 0),
early char(1) check(upper(early) = 'Y'),    -- 대소문자를 무시하기 위해 모두 대문자로 변환(upper)
event char(1) check(upper(event) = 'Y')
);

-- 데이터 입력
insert into item(name, type, price, early, event) values('참이슬후레쉬', '주류', 1200, 'y', 'y');

--insert into item(name, type, price, delivery, event) values('클라우드맥주', '주류', 3000, null, 'Y');
insert into item(name, type, price, event) values('클라우드맥주', '주류', 3000, 'Y');

insert into item(name, type, price, event) values('바나나킥', '과자', 1500, 'y');

insert into item(name, type, price, early) values('허니버터칩', '과자', 2000, 'y');

-- 최종 저장
commit;

-- 출력
select * from item;

-- 테이블 제거
drop table item;

