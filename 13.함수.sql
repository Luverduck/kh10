-- 함수(Function)
-- - Java 메소드처럼 input과 output이 존재하는 도구
-- - 함수의 처리 방식에 따라 여러가지로 구분된다

-- 듀얼 테이블 : 임시 계산 결과를 보관 및 출력할 수 있도록 구성된 내장 테이블
select * from dual;
select 1234+5678 from dual;

-- 단일 행 함수 (Single-row function) : 행별로 작업을 처리하는 함수
-- 테이블 조회시 추가하여 사용 가능 
select chr(65) from dual;   -- chr : ASCII 코드를 숫자로 변환
select ascii('A') from dual;

select lower('Hello') "결과" from dual;    --lower(문자열) : 해당 문자열을 모두 소문자로 변환

select product.*, lower(name) "소문자" from product;

select product.*, substr(name, 1, 1) "첫글자" from product;



-- 집계 함수 : 여러 데이터를 종합하여 결과를 만들어내는 함수
-- (대표) 합계, 평균, 최대. 최소, 갯수
-- 집계 함수는 항목이나 단일행 함수와 같이 사용할 수 없다

-- sum(항목) : 해당 항목의 합계를 구하는 함수
select sum(price) from product;
--select product.*, sum(price) from product;    다른 항목(product.*)과 같이 쓸 수 없음

-- avg(항목) : 해당 항목의 평균을 구하는 함수
select avg(price) "평균" from product;

-- max(항목) : 해당 항목 중 최대값을 구하는 함수
select max(price) "최대" from product;

-- min(항목) : 해당 항목 중 최소값을 구하는 함수
select min(price) "최소" from product;

-- count(항목) : 해당 항목의 갯수를 구하는 함수
select count(price) "갯수" from product;


-- (Q) product 테이블에서 가장 비싼 상품의 '이름'을 출력
-- 테이블 출력
select * from product;
-- 1) 최대값 찾기
select max(price) from product;
-- 2) 최대값인 물건 이름 찾기
select name from product where price = 3000;

-- 서브 쿼리(Sub Query) : 구문 여러 개를 순차적으로 실행하도록 구성한 것, 괄호 안의 내용이 먼저 실행
-- 두 구문을 합치기 (Sub Query)
select name from product where price = (
    select max(price) from product
);

-- 서브 쿼리 예제
-- (Q) 가장 최근에 만들어진 상품 정보 (product 테이블)
-- 테이블 출력 (확인용)
select * from product order by made desc;
-- 가장 최근에 만들어진 상품 정보
-- 1) 최신 날짜
select max(made) from product;
-- 2) 해당 상품 모든 정보 출력 (* = no, name, type, price, made, expire)
select * from product where made = (select max(made) from product);

-- (Q) 가장 포인트가 적은 고객의 아이디 (customer 테이블)
-- 테이블 출력 (확인용)
select * from customer order by customer_point asc;
-- 1) 가장 작은 포인트
select min(customer_point) from customer;
-- 2) 해당 고객 아이디 (id)
select customer_id from customer where customer_point = (select min(customer_point) from customer);