-- 오라클 학습용 계정인 HR 계정 활성화

-- 관리자 계정으로 진행하는 내용
select username from dba_users;

alter user hr identified by hr;     -- 비밀번호 지정
alter user hr account unlock;       -- 계정 잠금 해제


-- hr계정으로 진행하는 내용
select * from tab;

select * from regions;

select * from countries;