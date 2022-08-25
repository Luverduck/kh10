------------------------------------------------------------------------------
-- HR 계정 문제
-- 1. country_id 별 지역 개수를 구하여 출력하세요
-- 2. 작업자 중에서 급여를 가장 많이 받는 사람을 5명 출력하세요
-- 3. 작업자 중에서 가장 오래 근무한 사람 3명 출력하세요
-- 4. 작업 이력 중에서 가장 오랜 기간동안 작업한 사람의 ID를 출력하세요
-- 5. JOB_ID별 평균, 최대, 최소 급여를 출력하세요
-- 6. 작업자를 급여순서대로 순위를 매겨서 출력(전체/직군(job_id)별)
------------------------------------------------------------------------------

--1.
select country_id, count(*) 개수 from locations group by country_id order by 개수 desc, country_id asc;

--2
select * from (select TMP.*, rownum rn from (select * from employees order by salary desc, employee_id asc)TMP) where rn between 1 and 5;

-- 3
select * from (select TMP.*, rownum rn from (select * from employees order by hire_date asc, employee_id asc)TMP) where rn between 1 and 3;

-- 4
select JH.*, (end_date - start_date + 1) 근무일수 from job_history JH;

select JH.*, (end_date - start_date + 1) 근무일수 from job_history JH where (end_date-start_date+1) = (select max(end_date - start_date + 1) from job_history);

select * from (select TMP.*, rownum rn from (select JH.*, (end_date - start_date + 1) 근무일수 from job_history JH order by 근무일수 desc)TMP) where rn = 1;

-- 5
select job_id, salary from employees;

select job_id, avg(salary) 평균, max(salary) 최대, min(salary) 최소 from employees group by job_id;

-- 6
select E.first_name, E.last_name, E.salary , rank() over(order by salary desc) 순위 from employees E;

select E.first_name, E.last_name, E.department_id, E.salary , rank() over(partition by department_id order by salary desc) 순위 from employees E;