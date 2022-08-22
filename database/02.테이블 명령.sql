-- 포켓몬스터 테이블 생성
create table pocket_monster(    -- 오라클은 대소문자 구분 X -> _ 사용
no number(3),     -- 번호(no) : 숫자 3개 <- 자료형과 크기
name varchar2(21),   -- 이름(name) : 한글 7글자 <- UTF-8에서 한글 1글자는 3byte
type varchar2(9)   -- 속성(type) : 한글 3글자 ** varchar(variable character)
);

-- 테이블 변경
alter table pocket_monster modify(type varchar2(12));

-- 테이블 삭제
drop table pocket_monster;

/*
    문제
    다음 요구사항에 맞는 테이블을 생성하세요
    
    - 학생(Student) 정보를 저장할 테이블
    - 학생 정보는 학년, 반, 번호, 이름
    - 학년은 3학년까지 있습니다
    - 반은 15반까지 있습니다
    - 번호는 숫자 두 자리입니다
    - 이름은 주민등록 기준에 따릅니다
    - 컬럼명은 자유롭게 작성하세요
*/

create table student (
year number(1),     -- 학년 : 숫자 1자리
room number(2),     -- 반 : 숫자 2자리
no number(2),       -- 번호 : 숫자 2자리
name varchar2(21)   -- 이름 : 한글 7글자까지
);