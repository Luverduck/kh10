-- 외래키 (Foreign key)
-- - 특정 테이블간의 종속 관계를 설정하기 위한 항목
-- - ex) 회원과 배송지, 회원과 상품 구매 이력
-- - 컬럼명 references 참조테이블(참조컬럼) [삭제옵션]
-- - 삭제 옵션
-- - 1) 미설정시 상위 테이블 데이터 삭제 불가
-- - 2) on delete set 데이터 
--      - 상위 테이블 삭제시 하위 테이블을 지정한 값으로 설정 (일반적으로 null 사용)
-- - 3) on delete cascasde
--      - 상위 테이블 삭제시 연결된 데이터 모두 삭제

-- 회원 테이블
create table client(
client_id varchar2(20) primary key,
client_pw varchar2(16) not null,
client_point number,
client_join date
);

-- 회원 테이블 삭제
drop table client;

-- 관심분야 테이블
create table interest(
-- - 컬럼명 references 참조테이블(참조컬럼) [삭제옵션]
--client_id client 테이블의 client_id를 쳐다보겠습니다,
client_id references client(client_id) on delete cascade,
keyword varchar2(60) not null,
-- 같은 회원에 대해 같은 관심사가 여러 개 등록되지 않도록
primary key(client_id, keyword)
);

-- 관심분야 테이블
drop table interest;

-- 외래키 설정시 상위 테이블에 없는 데이터는 하위 테이블에 추가할 수 없다
insert into client(client_id, client_pw, client_point, client_join) values('aaa', 'aaa', 0, sysdate);
insert into interest(client_id, keyword) values('aaa', '전자제품');

select * from interest;

-- 회원 탈퇴
delete client where client_id = 'aaa';

-- 회원이 상품을 구매할 경우의 구매 테이블
-- 회원이 상품을 장바구니에 담을 겨웅의 장바구니 테이블
-- - 외래키의 역할 : 존재하지 않는 회원이 구매하는 것을 방지 (무결성)
create table buy(
client_id references client(client_id) on delete set null,
product_no references product(no),
cnt number default 1 not null,
when date default sysdate not null
);

-- 테이블 삭제
drop table buy;

insert into buy(client_id, product_no) values('aaa', 3);

select * from buy;

delete product where no = 3;

-- 장바구니 테이블
create table basket(
client_id references client(client_id) on delete cascade not null,
product_no references product(no) not null,
cnt number default 1 not null,
when date default sysdate not null
);

-- 테이블 삭제
drop table basket;

insert into client(client_id, client_pw, client_point, client_join) values('bbb', 'bbb', 0, sysdate);
insert into basket(client_id, product_no) values('bbb', 4);

select * from basket;

-- 회원 탈퇴
delete client where client_id = 'bbb';