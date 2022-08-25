/*
    다음 요구사항에 맞는 테이블 구현 및 샘플 데이터 추가
    - 게시판(board) 테이블
    - 게시글번호(board_no) : 시퀀스로 자동 부여
    - 게시글제목(board_title) : 한글 100자 이내로 작성
    - 게시글내용(board_content) : 가능한 가장 큰 크기로 부여
    - 작성자(board_writer) : 글을 작성한 작성자 ID
        아이디는 자바 때 배운 형식으로 사용
        8~20글자 이내 영문 소문자로 시작하는 영어 + 숫자
    - 조회수(board_read) : 조회수 정보를 저장할 공간
    - 작성일(board_time) : YYYY-MM-DD 형태의 문자열 (길이가 고정이므로 char(10)으로 한다)
    
    (참고)
    - char의 최대 크기는 2000byte, varchar2는 4000byte
    - default는 미입력시 자동 설정될 값을 지정하는 조건
    - date는 시간을 저장하는 자료형(연, 월, 일, 시, 분, 초(.0 단위) 까지 저장)
    - 시간은 직접 작성해도 되지만 현재시각(sysdate) 키워드가 존재한다
*/



-- 시퀀스 생성
create sequence board_seq;

-- 테이블 생성
create table board (
board_no number not null unique,
board_title varchar2(300) not null check(regexp_like(board_title, '^[가-힣]{1,100}$')),
board_content varchar2(4000) not null,   -- 오라클 문자열 최대 크기 : 4000byte
board_writer varchar2(20) not null check(regexp_like(board_writer, '^[a-z][a-z0-9]{7,19}$')),
board_read number default 0 not null check(board_read >= 0),   -- default 0 : 미입력시 적용되는 값을 0으로 한다
board_time char(10) not null
--board_time date not null    -- date는 시간을 저장하는 자료형
);

-- 데이터 입력
insert into board(
    board_no, board_title, board_content, board_writer, board_time
) 
values(
    board_seq.nextval, '반가워요', '소통해요', 'test1234', '2022-08-22'
);

-- 테이블 삭제
drop table board;

-- 데이터 확인
select * from board;