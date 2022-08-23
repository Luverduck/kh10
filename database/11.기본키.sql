-- 기본키(primary key)
-- 테이블을 대표하는 항목
-- not null + unique 항목 중에서만 설정 가능
-- 테이블당 하나만 존재

create table player(
player_id varchar2(30) primary key,
plyaer_job varchar2(12) not null,
player_level number default 1 not null
);

-- 테이블 삭제
drop table player;

-- 데이터 입력
insert into player(player_id, player_job, player_level) values(null, '엘프', 1);
insert into player(player_id, player_job, player_level) values(1, '엘프', 1);

-- 학생 테이블
create table exam(
year number,
room number,
no number,
name varchar2(21)not null,
primary key(year, room, no)     -- 복합키 : 여러 테이블 칼럼을 묶어서 primary key로 정함 (year + room + no로 대표항목 설정)
);

-- 테이블 삭제
drop table exam;

-- 데이터 입력
insert into exam(year, room, no, name) values(null, null, null, '테스트');
insert into exam(year, room, no, name) values(1, 1, 1, '피카츄');
insert into exam(year, room, no, name) values(1, 1, 2, '라이츄');

