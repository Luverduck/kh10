-- 삭제(delete)
-- - 기존에 등록한 데이터를 없애는 명령 (commit / rollback 필요)
-- - 대부분 PK를 이용한 단일 삭제로 처리한다

-- 롤백
rollback;

-- 테이블 출력
select * from product;

-- delete [from] 테이블 [조건]   -- from은 없어도 됨
delete product;

delete product where no = 1;
delete product where no = 12311;    -- 0개 행이 삭제됬다고 나오면 삭제가 진행되지 않은 것

-- (Q) 2020년 상반기에 제조된 상품 정보를 삭제
delete product where extract(year from made) = 2020 and extract(month from made) between 1 and 6;
-- 또는
delete product where regexp_like(to_char(made, 'yyyymm'), '20200[1-6]'); 
-- 또는
delete product where made between to_date('20200101000000', 'yyyymmddhh24miss') and to_date('20200630235959', 'yyyymmddhh24miss');

-- 오늘로부터 30일 전?
delete product where made between sysdate-30 and sysdate;
