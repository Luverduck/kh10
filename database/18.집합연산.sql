-- 집합 연산
-- - 결과 집합간의 계산
-- - 자바에서는 Set으로 집합 연산을 했었다
-- - 오라클에서는 결과 집합(Result Set)으로 한다
-- - 합집합, 교집합, 차집합

-- 차이를 만들기 위한 insert 구문
insert into exam values(17, '피카츄', '데이터베이스구현', '서술형', 85);
insert into exam values(18, '라이츄', '에스큐엘활용', '서술형', 76);
-- 최종 저장
commit;

-- 피카츄가 응시한 과목 (집합 A)
select subject from exam where student = '피카츄';              -- 중복 발생
select distinct subject from exam where student = '피카츄';     -- distinct : 중복 제거

-- 라이츄가 응시한 과목 (집합 B)
select distinct subject from exam where student = '라이츄';

-- 합집합 : A ∪ B (union, union all)
-- union : 중복 불가
-- union all : 중복 가능
select distinct subject from exam where student = '피카츄' 
union 
select distinct subject from exam where student = '라이츄';

-- 교집합 : A ∩ B (intersect) -> Java에서의 .retainAll
select distinct subject from exam where student = '피카츄' 
intersect 
select distinct subject from exam where student = '라이츄';

-- 차집합 : A - B or B - A (minus)
select distinct subject from exam where student = '피카츄' 
minus 
select distinct subject from exam where student = '라이츄';

