-- 조회(Select)
-- - 저장되어있는 데이터를 가져오도록 지시하는 명령
-- - SELECT 항목 FROM 테이블

-- 테이블 준비
drop table product;
create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('과자','아이스크림','주류','사탕')),
price number,
made date,
expire date
);

insert into product values(1, '스크류바', '아이스크림', 1200, '2020-05-01', '2020-10-01');
insert into product values(2, '마이쮸', '사탕', 900, '2020-01-01', '2021-01-01');
insert into product values(3, '초코파이', '과자', 3000, '2020-01-01', '2021-01-01');
insert into product values(4, '맛동산', '과자', 2200, '2020-02-01', '2020-10-20');
insert into product values(5, '참이슬', '주류', 1000, '2020-01-05', '2020-04-05');
insert into product values(6, '처음처럼', '주류', 1000, '2020-03-15', '2020-08-15');
insert into product values(7, '바나나킥', '과자', 1500, '2020-05-03', '2020-06-03');
insert into product values(8, '빠삐코', '아이스크림', 1000, '2019-12-01', '2020-06-01');
insert into product values(9, '멘토스', '사탕', 1200, '2020-03-20', '2020-12-31');
insert into product values(10, '오레오', '과자', 2100, '2019-06-01', '2020-06-01');

commit;

-- 전체 조화
select * from product;

-- 와일드카드(*)는 모든 항목을 의미
-- 항목을 일부만 선택해서 가져올 수 있다
select no, name, type, price, made, expire from product;

select name, price from product;


-- 데이터 필터링 조건 설정 (자바의 IF문)

-- 1) 숫자 조건 설정

-- (Q) 2000원 이하의 상품만 조회
select * from product where price <= 2000;

-- (Q) 1000원 이상 2000원 이하인 상품만 조회
select * from product where price >= 1000 and price <= 2000;    -- 오라클에서는 자바의 &&(and)를 and로, ||(or)을 or로 쓴다
select * from product where price between 1000 and 2000;

-- (Q) 1000원인 상품
select * from product where price = 1000;       -- 오라클에서는 자바의 ==(같다)를 =로 쓴다

-- (Q) 1000원이 아닌 상품
select * from product where price != 1000;      -- 오라클에서는 자바의 !=(다르다)는 동일한 기호를 사용한다
select * from product where price <> 1000;      -- 또는 <>(다르다) 사용


-- 2) 문자열 조건 설정

-- (Q) 과자만 조회
select * from product where type = '과자';

-- (Q) 아이스크림과 과자만 조회
-- (1) type = '아이스크림' or type = '과자'
select * from product where type = '아이스크림' or type = '과자';
-- (2) type in ('아이스크림', '과자')
select * from product where type in ('아이스크림', '과자');

-- 유사 검색
-- (Q) '바'로 시작하는 상품 조회 - Java의 .contains
-- like는 %를 "있어도 되고 없어도 되는 값"으로 인식한다
select * from product where name like '바%';
-- instr은 지정한 글자가 항목의 몇 번째 위치에 시작하는지 반환 (인덱스가 1부터 시작 <-> Java는 0)
select * from product where instr(name, '바') = 1;

-- (Q) '바'가 포함된 상품 조회 - Java의 .startWith
select * from product where name like '%바%';
-- instr 이용
select * from product where instr(name, '바') > 0;

-- (Q) '바'로 끝나는 상품 조회 - Java의 .endWith
select * from product where name like '%바';
-- instr 이용
-- length(테이블칼럼) : 테이블칼럼에 들어간 문자열의 길이
select * from product where instr (name, '바') = length(name);

-- 문자열 유사 검색에서는 시작 검사(앞글자 검사)는 like가 좋고 나머지는 instr()이 좋다 -> like와 instr의 성능 비교


-- 3) 날짜 조건 설정
-- 문자열처럼 사용할 수 도 있고,계산도 가능, 범위 표현도 가능
-- extract : 날짜에서만 사용 가능, 원하는 요소 추출
-- (Q) 제조년도가 2020년인 상품을 조회
select * from product where extract(year from made) = 2020;

-- (Q) 여름(6,7,8월)에 생산한 제품을 조회
select * from product where extract(month from made) in (6, 7, 8);
select * from product where extract(month from made) = 6 or extract(month from made) = 7 or extract(month from made) = 8;
select * from product where extract(month from made) between 6 and 8;   -- extract한 값이 6에서 8 사이인지

select * from product where made like '%/06/%' or made like '%/07/%' or made like '%/08/%';

select * from product where to_char(made, 'mm') in('06', '07', '08');

-- 정규표현식
select * from product where regexp_like(to_char(made, 'mm'), '(06|07|08)');

-- 2019년 6월 1일부터 2019년 8월 31일까지 조회
-- hh24 : 24시간 방식 시간 / mi : 분 / ss : 초
select * from product where made >= to_date('2019-06-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss') 
    and made <= to_date('2019-08-31 23:59:59', 'yyyy-mm-dd hh24 : mi : ss');

select * from product where made between to_date('2019-06-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss') 
    and to_date('2019-08-31 23:59:59', 'yyyy-mm-dd hh24:mi:ss');
    

-- 정렬
-- - 데이터를 원하는 기준에 맞게 재배치하는 것
-- - 오름차순(ascending, asc), 내림차순(descending, desc)
-- - 오라클은 키워드로 정렬을 수행
-- - 데이터를 조회할 때 여러 개가 나오면 반드시 정렬을 해야 한다

select * from product order by no asc;  

-- (Q) 가격이 저렴한/비싼 상품 순으로 출력
-- 1) 싼 가격 순
select * from product order by price asc;
-- 2) 비싼 가격 순 -> 가격이 같다면 no가 빠른 순으로 정렬
select * from product order by price desc, no asc;  -- order by는 1번만 쓰고 ,로 연결

-- (Q) 이름 순으로 출력
select * from product order by name asc;
-- 같은 이름이면 no가 빠른 순으로 정렬
select * from product order by name asc, no asc;

-- (Q) 제조일 순 / 최신 제조 순으로 출력
-- 1) 제조일 순
select * from product order by made asc;
-- 2) 최신 제조 순
select * from product order by made desc;

-- (Q) 유통기한이 짧은 순으로 출력
select no, name, type, price, made, expire, expire-made from product;

select product.*, expire-made from product;
select product.*, expire-made from product order by expire-made asc;
select product.*, expire-made "유통기한" from product order by "유통기한" asc;

select * from product order by (expire - made) asc;

-- (주의사항) 
-- 정렬은 항상 제일 마지막에 와야 한다 (데이터가 정해져야 정렬이 가능하기 때문)
-- (예시) 2000원 이하인 상품들을 이름순으로 정렬
select * from product where price < 2000 order by name asc; -- 정렬(order by name asc)을 가장 마지막에