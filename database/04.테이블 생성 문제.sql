-- 예제 1) : oop.basic2 문제를 DB로 만들기
-- 테이블 만들기
create table fifa (
rank number,        -- 따로 크기를 적지 않으면 30자리로 설정
nation varchar(30),
score number(*,2)   -- *를 입력시 임의의 자릿수로 설정
);

-- 데이터 입력
insert into fifa(rank, nation, score) values (1, '브라질', 1828.45);
insert into fifa(rank, nation, score) values (2, '벨기에', 1823.42);
insert into fifa(rank, nation, score) values (3, '프랑스', 1786.15);

-- 최종 저장
commit;

-- 데이터 전부 조회
select * from fifa;

-- 테이블 삭제
drop table fifa;

-- 롤백
rollback;

-- 예제 2) : oop.basic3 문제를 DB로 만들기
/*  
    (참고)
    - 문자열은 char(고정)과 varchar2(가변)가 존재한다
    - char는 무조건 지정된 크기를 꽉 채워서 저장 (무조건), 속도 매우 빠름
    - varchar2는 최대 크기만 지키고 내부에서 자유롭게 사용, 효율성이 좋음(가변 문자열)

    - 통신사에 6개(SK,KT,LG,SK알뜰폰,KT알뜰폰,LG알뜰폰) 중 하나만 나오게 하거나 값에 양수만 나오도록??
    - 테이블 생성
    - 영어는 1글자에 1byte, 한글은 1글자에 2byte(UTF-8는 3byte)
    - number는 여유를 두어 자릿수를 제한하지 않아도 됨

    - 테이블에 들어갈 값의 형태를 check 조건을 설정하여 지정할 수 있다
    - in이라는 기호가 있으면 우측에 있는 값 중 하나에 해당된다는 뜻
*/
create table telecom (  
telname varchar2(2) check(telname in('SK', 'KT', 'LG')),    -- SK, KT, LG 중에서만 가능
telplan varChar(60),    
telbill number(6) check(telbill >= 0),      -- 0 이상
teldata number(3) check(teldata >= 0),      -- 0 이상
telcall number(4) check(telcall >= 0),      -- 0 이상
telsms number(4) check(telsms >= 0)         -- 0 이상
);

-- 데이터 입력
insert into telecom (telname, telplan, telbill, teldata, telcall, telsms) values ('SK', '5G언텍트 52', 52000, 200, 1000, 2000);
insert into telecom (telname, telplan, telbill, teldata, telcall, telsms) values ('KT', '5G세이브', 45000, 100, 900, 1500);
insert into telecom (telname, telplan, telbill, teldata, telcall, telsms) values ('LG' ,'5G시그니처', 130000, 500, 2000, 2500);

-- 조건에 맞지 않는 데이터를 입력할 떼
insert into telecom (telname, telplan, telbill, teldata, telcall, telsms) values ('SK', '5G언텍트 52', -52000, 200, 1000, 2000);

-- 최종 저장
commit;

-- 데이터 전부 조회
select * from telecom;

-- 테이블 삭제
drop table telecom;

