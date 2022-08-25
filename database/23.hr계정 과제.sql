-- (Q1) country_id 별 지역 갯수를 구하여 출력 (locations)
select country_id, count(*) from locations group by country_id;


-- (Q2)작업자 중에서 급여를 가장 많이 받는 사람을 5명 출력하세요 (employees)
-- 1) SALARY 오름차순 정렬
select * from employees order by salary desc;
-- 2) 정렬된 테이블에 rownum rn을 부여한 후 TMP라 명명하고 TMP의 모든 항목(TMP.*) 가져오기
select TMP.*, rownum rn from (select * from employees order by salary desc)TMP;
-- 3) TMP의 모든 항목(TMP.*) 테이블에서 rn이 1 이상 3 이하인 값을 성, 이름, 월급을 불러오기
select first_name, last_name, salary from (select TMP.*, rownum rn from (select * from employees order by salary desc)TMP) where rn between 1 and 5;


-- (Q3)작업자 중에서 가장 오래 근무한 사람 3명을 출력하세요 (employees)
-- 1) HIRE_DATE 오름차순 정렬
select * from employees order by hire_date asc;
-- 2) 정렬된 테이블에 rownum rn을 부여한 후 TMP라 명명하고 TMP의 모든 항목(TMP.*) 가져오기
select TMP.*, rownum rn from (select * from employees order by hire_date asc)TMP;
-- 3) TMP의 모든 항목(TMP.*) 테이블에서 rn이 rn이 1 이상 3 이하인 데이터의 성, 이름, 고용일을 불러오기
select first_name, last_name, hire_date from (select TMP.*, rownum rn from (select * from employees order by hire_date asc)TMP) where rn between 1 and 3;


-- (Q4)작업 이력 중에서 가장 오랜 기간동안 작업한 사람의 ID를 출력하세요 (JOB_HISTORY)
-- 1) END_DATE에서 START_DATE를 차이를 오름차순 정렬
select * from job_history order by end_date - start_date desc;
-- 2) 정렬된 테이블에 rownum rn을 부여한 후 TMP라 명명하고 TMP의 모든 항목(TMP.*) 가져오기
select TMP.*, rownum rn from(select * from job_history order by end_date - start_date desc)TMP;
-- 3) TMP의 모든 항목(TMP.*) 테이블에서 rn이  rn이 1인 데이터의 성, 이름,  불러오기
select employee_id, (end_date - start_date) 근속기간 from(select TMP.*, rownum rn from(select * from job_history order by end_date - start_date desc)TMP) where rn = 1;


-- (Q5) JOB_ID별 평균, 최대, 최소 급여를 출력하세요 (EMPLOYEES)
select job_id, avg(salary), max(salary), min(salary) from employees group by job_id;


-- (Q6) 작업자를 급여 순서대로 순위를 매겨서 출력(전체 / 부서별)
-- 작업자 급여 높은순 (전체)
-- 1) 급여 오름차순 정렬
select * from employees order by salary desc;
-- 2) 정렬된 테이블에 rownum rn을 부여한 후 TMP라 명명하고 TMP의 모든 항목(TMP.*) 가져오기
select TMP.*, rownum rn from(select * from employees order by salary desc)TMP;
-- 3) TMP의 모든 항목(TMP.*) 테이블 출력
select first_name, last_name, salary, rn 순위 from (select TMP.*, rownum rn from(select * from employees order by salary desc)TMP);

--  작업자 급여 높은순 (부서별) -> 분석함수
select employees.*, rank() over(partition by department_id order by salary desc)부서별순위 from employees;
