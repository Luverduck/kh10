-- 분석 함수
-- - 단일행 함수와 집계 함수의 합성 형태
-- - 순위와 같이 전체를 보긴 하지만 표시는 행마다 하는 경우
-- - 함수 뒤에 over()를 붙이고 기준(분류, 정렬)을 제시
-- - 분류는 partition by 항목으로 작성
-- - 정렬은 order by 항목 asc/desc로 작성

-- 1) rank() over(분석기준)
-- (Q) product 상품 정보를 가격 순서대로 순위를 매겨 출력
--select product.*, rank() over(분석기준) "순위" from product;
--select product.*, rank() over(가격 내림차순) "순위" from product;
select product.*, rank() over(order by price desc) "순위" from product;
-- rownum과의 차이점 : 중복 순위가 존재한다

-- 2) partition by 항목
-- (Q) 상품 종류별 가격 순위를 구하여 출력 (partition by를 먼저)
select product.*, rank() over(partition by type order by price desc) from product;

