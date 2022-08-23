-- Top N Query
-- - 데이터를 원하는 갯수만큼 끊어서 조회하는 기법
-- - 페이지별로 데이터를 나누어서 보여줄 때 사용 (1p = 1~10번)
-- - rownum이라는 내장 도구를 사용할 줄 알아야 한다
--   - rownum은 정렬하면 원하는 결과가 나오지 않는다 (순서가 섞임)
--   - 즉, rownum은 가장 마지막에 부여해야 한다
--   - rownum은 반드시 1번부터 부여되어야 한다
-- 번호가 없는 테이블(item)에도 행 번호를 부여할 수 있다
select item.*, rownum from item;
select item.*, rownum from item where rownum <= 3;


-- (Q) 상품을 가격순으로 3개만 보여주세요 (테이블 product)
select product.*, rownum from product;
select product.*, rownum from product where rownum <= 3;

select product.*, rownum from product order by price desc;

-- 서브 쿼리를 이용해서 다음과 같이 구문 순서를 변경

-- 1. 가격이 비싼 순으로 정렬을 실행
select product.* from product order by price desc;

-- 2. rownum을 부여
--select TMP.*, rownum from (1번구문)TMP where rownum <= 3;

-- 1차 완성 -  1번 구문을 TMP라 부르고 TMP에 rownum 부여
select TMP.*, rownum from (select * from product order by price desc)TMP where rownum <= 3;

-- 2차 문제점 : 그 다음 3개를 보여줄 때?
select TMP.*, rownum from (select * from product order by price desc)TMP where rownum between 3 and 5;
-- 하나씩 번호를 부여하자마자 조건 검사를 수행하므로 결과가 나타나지 않음
-- 모든 번호를 부여한 후에 조건 검사를 시행하도록

-- 2차 문제점 해결 : rownum을 먼저 부여하고 조건으로 필터링 -> 서브쿼리 사용
--select (1차 완성 결과) where rownum between 3 and 5;
select * from (select TMP.*, rownum rn from (select * from product order by price desc)TMP) where rn between 3 and 5;

/* 공식
select * from (
    select TMP.*, rownum rn from (
        원하는 데이터 조회, 필터 및 정렬 구문
    )TMP
) where rn between 시작행번호 and 종료행번호;
*/

-- (Q) 게시판(board) 테이블에서 한 페이지당 5개씩 보여준다고 가정했을 때
-- 1페이지와 2페이지를 조회하는 구문을 각각 작성
-- 테이블 출력(확인용)
select * from board;
-- 1) board_no의 오름차순 정렬
select * from board order by board_no asc;
-- 2) 정렬된 필드를 TMP라 명명하고 여기에 rn이라 명명된 rownum을 부여
select TMP.*, rownum rn from (select * from board order by board_no desc)TMP;
-- 3) 정렬, rownum rn 부여가 끝난 필드에서 rn이 1에서 5인 값을 모두(*) 불러오기
select * from (select TMP.*, rownum rn from (select * from board order by board_no desc)TMP) where rn between 1 and 5;
-- 3) 정렬, rownum rn 부여가 끝난 필드에서 rn이 6에서 10인 값을 모두(*) 불러오기
select * from (select TMP.*, rownum rn from (select * from board order by board_no desc)TMP) where rn between 6 and 10;

-- (Q) 2020년에 만든 상품(product) 중에서 가장 최근에 만든 상품 3개를 조회
-- 테이블 출력(확인용)
select * from product;
-- 1) 생산일자(made) 내림차순 정렬
select * from product order by made desc;
-- 2) 정렬된 필드를 TMP라 명명하고 여기에 rn이라 명명된 rownum을 부여
select TMP.*, rownum rn from (select * from product order by made desc)TMP;
-- 3) 정렬, rownum rn 부여가 끝난 필드에서 rn이 3 이하인 값을 모두(*) 불러오기
select * from (select TMP.*, rownum rn from (select * from product order by made desc)TMP) where rn <= 3;

-- (Q) 3000원 미만인 과자와 아이스크림 중에서 가격이 저렴한 상품 2개만 조회 (product)
-- 테이블 출력(확인용)
select * from product;
-- 1) 가격(price) 오름차순 정렬
select * from product order by price asc;
-- 2) 정렬된 필드를 TMP라 명명하고 여기에 rn이라 명명된 rownum을 부여
select TMP.*, rownum rn from (select * from product order by price asc)TMP;
-- 3) 정렬, rownum rn 부여가 끝난 필드에서 rn이 2 이하인 값을 모두(*) 불러오기
select * from (select TMP.*, rownum rn from (select * from product order by price asc)TMP) where rn <= 2;
