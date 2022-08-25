-- 뷰(View)
-- - 가상 테이블 혹은 논리 테이블이라 부름
-- - 객체로 분류됨
-- - 테이블을 원하는 형태로 바꿔서 보기 위해 사용
-- - create view 권한이 필요(관리자)

-- - 조회 전용이지만 insert, update, delete도 가능하긴 함

select * from exam;

-- 뷰 권한 부여
grant create view to khacademy;

-- 서술형 데이터로만 무언가를 하고 싶다면 where를 계속 추가해야 한다
create view essay as select * from exam where type = '서술형';

create or replace view essay as select * from exam where type = '서술형';

-- 뷰만 출력 -> 서술형만 나옴
select * from essay;

select * from essay where score < 60;

-- (ex) 연도, 월별 상품 제조 갯수?
-- select 연도, 갯수 from product group by 연도;
-- 1) 뷰를 만들 구문 생성
select 
    extract(year from made) 연, 
    extract(month from made) 월, 
    count(*) 갯수 
from product group by extract(year from made), extract(month from made)
order by extract(year from made),extract(month from made) asc;
-- 2) 뷰 생성
create or replace view status as
select 
    extract(year from made) 연, 
    extract(month from made) 월, 
    count(*) 갯수 
from product group by extract(year from made), extract(month from made)
order by extract(year from made),extract(month from made) asc;

select * from status;
