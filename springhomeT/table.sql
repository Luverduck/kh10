drop table member;
create table member(
member_id varchar2(20) primary key
check(regexp_like(member_id, '^[a-z0-9-_]{5,20}$')),
member_pw varchar2(16) not null
--check(regexp_like(member_pw, '^[a-zA-Z0-9!@#$]{8,16}$')),
check(
    regexp_like(member_pw, '^[a-zA-Z0-9!@#$]{8,16}$')
    and
    regexp_like(member_pw, '[a-z]')
    and
    regexp_like(member_pw, '[A-Z]')
    and
    regexp_like(member_pw, '[0-9]')
    and
    regexp_like(member_pw, '[!@#$]')
),
member_nick varchar2(30) not null unique
check(regexp_like(member_nick, '^[가-힣][가-힣0-9]{0,9}$')),
member_birth date not null,
member_tel char(11)
check(regexp_like(member_tel, '^010[0-9]{8}$')),
member_email varchar2(100)
check(regexp_like(member_email, '@')),
member_post varchar2(6)
check(regexp_like(member_post, '^[0-9]{5,6}$')),
member_base_address varchar2(150),
member_detail_address varchar2(150),
member_point number default 0 not null
check(member_point >= 0),
member_grade varchar2(9) default '일반' not null
check(member_grade in ('일반', 'VIP', '관리자')),
member_join date default sysdate not null,
member_login date
);

-- 게시판
CREATE TABLE board (
	board_no number primary key,
	board_writer references member(member_id) on delete set null,
	board_title varchar2(300) not null,
	board_content varchar2(4000) not null,
	board_writetime date default sysdate not null,
	board_updatetime date,
	board_read number default 0 not null check(board_read >= 0),
	board_like number default 0 not null check(board_like >= 0),
	board_head varchar2(6) check(board_head in('정보', '유머', '공지'))
);
CREATE SEQUENCE board_seq;

-- 테이블에 계층형 게시판 항목을 추가
alter table board add board_group number;
alter table board add board_parent references board(board_no);
alter table board add board_depth number;

update board set board_group = board_no;
update board set board_depth = 0;
commit;

alter table board modify board_group not null;
alter table board modify board_depth not null;

-- 계층형 더미 데이터 구문
truncate table board;
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(1, null, '첫 번째 글', 'hello1234', '테스트', 1, null, 0);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(2, null, '두 번째 글', 'hello1234', '테스트', 2, null, 0);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(3, null, '세 번째 글', 'hello1234', '테스트', 3, null, 0);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(4, null, '네 번째 글', 'hello1234', '테스트', 4, null, 0);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(5, null, '다섯 번째 글', 'hello1234', '테스트', 3, 3, 1);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(6, null, '여섯 번째 글', 'hello1234', '테스트', 3, 3, 1);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(7, null, '일곱 번째 글', 'hello1234', '테스트', 3, 5, 2);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(8, null, '여덟 번째 글', 'hello1234', '테스트', 3, 6, 2);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(9, null, '아홉 번째 글', 'hello1234', '테스트', 9, null, 0);
insert into board(board_no, board_head, board_title, board_writer, board_content, board_group, board_parent, board_depth) values(10, null, '열 번째 글', 'hello1234', '테스트', 9, 9, 1);
commit;

-- 댓글
create table reply(
reply_no number primary key,
reply_content varchar2(3000) not null,
reply_writetime date default sysdate not null,
reply_writer references member(member_id) on delete set null,
reply_origin references board(board_no) on delete cascade
);
create sequence reply_seq;

alter table reply add 
reply_blind char(1) check(reply_blind = 'Y');

-- 좋아요 테이블
drop table member_board_like;
create table member_board_like (
member_id references member(member_id) on delete cascade not null,
board_no references board(board_no) on delete cascade not null,
like_time date default sysdate not null,
primary key(member_id, board_no)
);


-- 파일 테이블
create table attachment(
attachment_no number primary key,
attachment_name varchar2(256) not null,
attachment_type varchar2(30) not null,
attachment_size number not null check(attachment_size >= 0),
attachment_time date default sysdate not null
);

create sequence attachment_seq;

-- 게시판 첨부파일 테이블
create table board_attachment(
board_no references board(board_no) 
				on delete cascade not null,
attachment_no references attachment(attachment_no) 
				on delete cascade not null,
primary key(board_no, attachment_no)
);

-- 게시글번호 + 첨부파일 뷰
create view board_attachment_view as
select 
    B.board_no, A.*
from 
    board_attachment B inner join attachment A
    on B.attachment_no = A.attachment_no;











