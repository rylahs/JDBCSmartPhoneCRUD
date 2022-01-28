# 연산이 필요 없다고 판단 되는 것은 문자열로 처리
DROP TABLE IF EXISTS MEMBER;
CREATE TABLE MEMBER(
ID VARCHAR(15) PRIMARY KEY, # ID
PASSWD VARCHAR(15) NOT NULL,
MEM_EMAIL VARCHAR(30) NOT NULL UNIQUE,
MEM_PHONE VARCHAR(13) NOT NULL UNIQUE,
MEM_NAME VARCHAR(10),
MEM_ADDR VARCHAR(50)
);

insert into MEMBER
values ("asdf1234", "asdf4321", "asdf1234@gmail.com", "010-123-4567", "김민우", "대구광역시 서구 내당동");
insert into MEMBER
values ("qwer1234", "qwer4321", "qwer1234@gmail.com", "010-111-2222", "서민우", "대구광역시 중구 내당동");
insert into MEMBER
values ("zxcv1234", "zxcv4321", "zxcv1234@gmail.com", "010-333-4444", "최민우", "대구광역시 동구 내당동");
insert into MEMBER
values ("rtyu1234", "rtyu4321", "rtyu1234@gmail.com", "010-555-6666", "최민우", "대구광역시 동구 내당동");
insert into MEMBER
values ("uiop1234", "uiop4321", "uiop1234@gmail.com", "010-777-8888", "주민우", "대구광역시 달서구 내당동");
insert into MEMBER
values ("kkkk1234", "kkkk4321", "kkkk1234@gmail.com", "010-999-0000", "배민우", "대구광역시 달성군 내당동");

insert into MEMBER(ID, PASSWD, MEM_EMAIL, MEM_PHONE, MEM_NAME, MEM_ADDR)
values ("asdf1111", "asdf2222", "asdf1111@naver.com", "010-5555-1111", "김민식", "서울시");