-- 그룹(Group)
-- - 통계에서 많이 사용되는 기법
-- - OO별 이라는 단어가 들어가는 작업을 처리할 때 사용

-- 1) group by 항목
-- (Q) 상품 분류별 개수
-- (참고) count(type)은 type이 null이 아닌 경우만 세고, count(*)은 전부다 센다
select * from product;
--select type, count(type) from product 타입별;
select type, count(type) from product group by type;
--select type, name, count(type) from product group by type, name;

-- 정렬까지
select type, count(type) 갯수 from product group by type order by 갯수 asc;

-- (Q) 상품군별 가격 평균 출력, 최대값, 최소값 출력
select type, avg(price) "평균", max(price) "최대값", min(price) "최소값" from product group by type;

-- 그룹의 성립 조건 설정 : having
-- (참고) where는 개별 데이터 필터링 조건이다

-- (Q) 최소값이 1000원이 넘는 그룹을 출력
select type, avg(price) "평균", max(price) "최대값", min(price) "최소값" from product group by type having min(price) >= 1000;
			
