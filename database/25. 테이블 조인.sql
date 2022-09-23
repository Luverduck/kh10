-- 테이블 생성
CREATE TABLE teacher(
teacher_no NUMBER PRIMARY KEY,
teacher_name VARCHAR2(21) NOT NULL,
teacher_subject VARCHAR2(15) NOT NULL
);

CREATE TABLE pupil(
pupil_no NUMBER PRIMARY KEY,
pupil_name VARCHAR2(21) NOT NULL,
teacher_no REFERENCES teacher(teacher_no) ON DELETE CASCADE
);

INSERT INTO teacher VALUES(1, '피카츄', '전기학');
INSERT INTO teacher VALUES(2, '손오공', '에너지학');
INSERT INTO teacher VALUES(3, '홍길동', '전통학');

INSERT INTO pupil VALUES(1, '라이츄', 1);
INSERT INTO pupil VALUES(2, '파이리', 1);
INSERT INTO pupil VALUES(3, '꼬부기', 1);
INSERT INTO pupil VALUES(4, '야무차', 2);
INSERT INTO pupil VALUES(5, '부르마', 2);

-- 개별 테이블 조회
select * from teacher;
select * from pupil;

-- 테이블 관계
-- https://docs.sysout.co.kr/database/oracle/structure-query-language/user-query/table-join/equi-join

-- inner join : 매칭되는 데이터만 합쳐서 조회하는 기술(방향 없음)
-- teacher와 pupil을 inner join한 결과를 조회
-- 문제점 : 이름 충돌이 발생하는 컬럼이 있을 수 있다(와일드 카드(*) 사용 자제)
select * from teacher inner join pupil on teacher.teacher_no = pupil.teacher_no;
-- 해결책 
-- (1) 모든 컬럼을 직접 지정해서 조회 
select teacher.teacher_no, teacher.teacher_name, teacher.teacher_subject, pupil.pupil_no, pupil.pupil_name from teacher inner join pupil on teacher.teacher_no = pupil.teacher_no;

-- - 별칭 부여 (select에서 from 부분이 가장 먼저 해석되므로 별칭이 먼저 붙음)
select T.teacher_no, T.teacher_name, T.teacher_subject, P.pupil_no, P.pupil_name from teacher T inner join pupil P on T.teacher_no = P.teacher_no;

-- (2) 한 쪽은 전부, 나머지는 지정해서 조회
select T.*, P.pupil_no, P.pupil_name from teacher T inner join pupil P on T.teacher_no = P.teacher_no;

-- 테이블 조인 예제 : 댓글 조회시 작성자의 등급을 같이 출력
select R.*, M.member_nick, M.member_grade from reply R inner join member M on R.reply_writer = M.member_id;

-- outer join : 기준 테이블은 전부 다 조회하고 나머지는 매칭되는 데이터만 합치는 조회(방향 있음)
-- - full outer join : 양쪽 테이블에 있는 솔로 데이터까지를 모두 조회
select * from teacher T full outer join pupil P on T.teacher_no = P.teacher_no;
-- - left outer join : 왼쪽 테이블에 있는 솔로 데이터까지를 모두 조회
select * from teacher T left outer join pupil P on T.teacher_no = P.teacher_no;
-- - right outer join : 오른쪽 테이블에 있는 솔로 데이터까지를 모두 조회
select * from teacher T right outer join pupil P on T.teacher_no = P.teacher_no;

-- 최종 댓글에 등급과 닉네임을 붙여서 출력하는 구문 (회원 없는 경우를 고려)
select R.*, M.member_nick, M.member_grade from reply R left outer join member M on R.reply_writer = M.member_id;

-- 게시글 조회 시 게시글에 달린 댓글 개수를 같이 출력 (me)
-- 1) 원본글 번호(reply_origin)를 기준으로 원본글 당 댓글의 갯수 조회
select reply_origin, count(*) reply_count from reply group by reply_origin;
-- 2) 1)에서 조회한 필드와 BOARD 테이블을 게시글 번호(board_no)와 댓글 원본글 번호(reply_origin)로 outer join
select B.*, R.reply_count from board B right outer join (select reply_origin, count(*) reply_count from reply group by reply_origin) R on B.board_no = R.reply_origin;

-- 게시글 조회 시 게시글에 달린 댓글 개수를 같이 출력
-- 1) group by 
select 
    B.board_no, B.board_writer, B.board_head, B.board_title, B.board_content,
    B.board_read, B.board_writetime, B.board_updatetime, B.board_group,
    B.board_parent, B.board_depth, B.board_like,
    count(R.reply_no) reply_count
from board B left outer join reply R on B.board_no = R.reply_origin
group by B.board_no, B.board_writer, B.board_head, B.board_title, B.board_content,
    B.board_read, B.board_writetime, B.board_updatetime, B.board_group,
    B.board_parent, B.board_depth, B.board_like;
    
-- 2) 분석 함수 over() 사용 - order by / partition by
select distinct
    B.board_no, count(R.reply_no) over(partition by B.board_no) reply_count
from board B left outer join reply R on B.board_no = R.reply_origin;

commit;