-- 테이블 이름 - member
-- 테이블 항목
-- - 회원 아이디 : member_id, 5 ~ 20자 영문 소문자, 숫자와 특수기호(_), (-)만 사용 가능
-- - 회원 비밀번호 : member_pw, 8~16자 영문 대 소문자, 숫자, 특수문자(!, @, #, $)를 사용
-- - 닉네임 : member_nick, 한글로 시작하며 한글 or 숫자 가능, 총 10자 이내
-- - 생년월일 : member_birth, YYYY-MM-DD, 날짜 형식
-- - 전화번호 : member_tel, 대시 제외하고 010XXXXXXXX 형태
-- - 이메일 : member_email, 100byte 이내, @ 반드시 포함
-- - 주소
--   - 우편 주소 : member_post, 5 ~ 6자리
--   - 기본 주소 : member_base_address, 한글 50자
--   - 상세 주소 : member_detail_address, 한글 50자
-- - 포인트 : member_point, 0 이상 설정
-- - 등급 : member_grade, 일반, VIP, 관리자 중 하나
-- - 가입일시 : member_join, 날짜이며 현재 시간으로 자동 설정
-- - 접속일시 : member_login, 로그인 할 때의 시간으로 자동 설정
-- ** 회원 아이디가 기본키
-- ** 전화번호, 이메일, 주소는 선택 입력 가능
-- ** 접속일시는 가입시 설정하지 않음

-- 테이블 생성
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
membeR_login date
);

-- 테이블 삭제
drop table member;

-- 최종 저장
commit;

-- 롤백
rollback;

-- 시험 입력
insert into member(member_id, member_pw, member_nick, member_birth, member_point, member_grade, member_join) 
values('myidis', 'mypwiswhat', '아프리칸', to_date('2021-03-22', 'yyyy-mm-dd'), 50000, '일반', sysdate);

insert into member(
                    member_id, 
                    member_pw, 
                    member_nick, 
                    member_birth, 
                    member_tel, 
                    member_email, 
                    member_post, 
                    member_base_address, 
                    member_detail_address, 
                    member_point, 
                    member_grade, 
                    member_join, 
                    member_login) 
            values(
                    'myidis4', 
                    'mypwiswhat@1A', 
                    '테스트2', 
                    to_date('2021-03-22', 'yyyy-mm-dd'), 
                    '01088882929', 
                    'tester@gmail.com', 
                    39660, 
                    '서울시', 
                    '관악구', 
                    30000, 
                    'VIP', 
                    sysdate, 
                    null
                    );