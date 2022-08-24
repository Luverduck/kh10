-- 시퀀스 생성
create sequence exam_seq;

-- 테이블 생성
create table exam (
exam_id number not null,
student varchar2(21) not null check(regexp_like(student, '^[가-힣]{2,7}$')),
subject varchar2(60) not null check(regexp_like(subject, '^[가-힣]{2,20}$')),
type varchar2(30) not null check(regexp_like(type, '^[가-힣]{2,10}$')),
score number(3) not null check(score between 0 and 100)
);

-- 테이블 삭제
drop table exam;

-- 데이터 입력
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '프로그래밍언어활용', '서술형', 55);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '프로그래밍언어활용', '문제해결시나리오', 95);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '네트워크프로그래밍구현', '서술형', 60);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '피카츄', '네트워크프로그래밍구현', '평가자체크리스트', 51);

insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '프로그래밍언어활용', '서술형', 80);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '프로그래밍언어활용', '문제해결시나리오', 52);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '네트워크프로그래밍구현', '서술형', 58);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '라이츄', '네트워크프로그래밍구현', '평가자체크리스트', 80);

insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '프로그래밍언어활용', '서술형', 54);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '프로그래밍언어활용', '문제해결시나리오', 81);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '네트워크프로그래밍구현', '서술형', 44);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '파이리', '네트워크프로그래밍구현', '평가자체크리스트', 76);

insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '프로그래밍언어활용', '서술형', 100);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '프로그래밍언어활용', '문제해결시나리오', 60);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '네트워크프로그래밍구현', '서술형', 51);
insert into exam(exam_id, student, subject, type, score) values(exam_seq.nextval, '꼬부기', '네트워크프로그래밍구현', '평가자체크리스트', 72);

-- 최종 저장
commit;

-- 테이블 출력(확인용)
select * from exam;


-- (Q) 학생별 평균점수를 구하여 출력	
select student, avg(score) "평균" from exam group by student order by avg(score) desc;


-- (Q) 과목별 평균점수를 구하여 출력		
select subject, avg(score) "평균" from exam group by subject order by subject asc;


-- (Q) 평가유형별 평균점수를 구하여 출력			
select type, avg(score) "평균" from exam group by type order by type desc;


-- (Q) 학생별 최고, 최저점을 구하여 출력		
select student, max(score) 최고점, min(score) 최저점 from exam group by student order by student asc;


-- (Q) 과목별 최고, 최저점을 구하여 출력		
select subject, max(score) 최고점, min(score) 최저점 from exam group by subject order by student asc;


-- (Q) 유형별 최고, 최저점을 구하여 출력	
select type, max(score) 최고점, min(score) 최저점 from exam group by type order by type asc;


-- (Q) 과목별 평균 60점 미만 학생의 수를 구하여 출력
-- 1) '학생별 평균 점수가 60점 미만인 학생'에 대한 서브 쿼리
select student, subject, avg(score) 평균 from exam group by student, subject having avg(score) < 60;
-- 2) 해당 조건을 만족하는 학생 수 카운트
select subject, count(*) 인원수 from (select student, subject, avg(score) 평균 from exam group by student, subject having avg(score) < 60) group by subject;


-- (Q) 과목별 평균 90점 이상 학생의 수를 구하여 출력
-- 1) '과목별 평균 점수가 90점 이상인 학생'에 대한 서브 쿼리
select student, subject, avg(score) 평균 from exam group by student, subject having avg(score) > 90;
-- 2) 해당 조건을 만족하는 학생 수 카운트
select student, count(*) 인원수 from (select student, subject, avg(score) 평균 from exam group by student, subject having avg(score) > 90) group by student;

-- (Q) 평균이 높은 학생을 3등까지만 출력	-> Top N Query
-- 1) 학생별로 평균 성적이 높은 순서대로 정렬
select student, avg(score) 평균 from exam group by student order by 평균 desc;
-- 2) 정렬된 필드를 TMP라 명명하고 여기에 rn이라 명명된 rownum을 부여
select TMP.*, rownum rn from(select student, avg(score) 평균 from exam group by student order by 평균 desc)TMP;
-- 3) 정렬, rownum rn 부여가 끝난 필드에서 rn이 3 이하인 값을 모두(*) 불러오기
select * from (select TMP.*, rownum rn from(select student, avg(score) 평균 from exam group by student order by 평균 desc)TMP) where rn between 1 and 3;

