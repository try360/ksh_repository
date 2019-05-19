conn ksh/123;

select * from ALL_COL_COMMENTS where table_name = 'PWRITING';

show user;

create sequence auto_increment increment by 1 start with 1000000;
drop sequence num_inc;

create table pmember 
(
num number(11) unique, -- 오토 시퀀스로
ID varchar2(50) primary key,
password varchar2(10),
email varchar2(20) unique,
mr_date date default sysdate
);

drop table pmember;

select * from pmember;

insert into pmember values(1,'fany305','ghks1217','fany305@naver.com',sysdate)
delete from pmember where num=41;
----------글쓰기 테이블-------------------------------
create sequence seq_board increment by 1 start with 1;

drop sequence seq_board;

select seq_board.nextval from dual;

drop table pwriting cascade constraints; -- 참조 조건 고려 후 테이블 삭제

create table pwriting 
(
w_no number(35) primary key,
ID varchar2(50),
title varchar2(50),
model_name varchar2(35),
image_name varchar2(100),
thumbnail_name varchar2(100),
content varchar2(1000),
rate number(15),
viewcnt number(35),
w_date date default sysdate,
rev_date date 
);

alter session set nls_timestamp_format = 'yyyy-mm-dd';

commit;

select * from pwriting;

truncate table pwriting;

select * from pwriting;

insert into pwriting values(seq_board.nextval,'레이너','테스트 제목','LG-gram','사진 이름','섬네일 이름','내용 집어넣기 테스트',5,0,sysdate,sysdate);

 delete from pwriting where w_no=241;
 
 alter table pwriting rename column num to w_no;
 
 Select w_no, id, title, content, w_date, viewcnt from pwriting where w_no=111;
 
 update pwriting set title='제목 수정', model_name='ㅋㅋㅋㅋ', content= 'ㅎㅎㅎㅎㅎㅎㅎ' where w_no=162
---------------- 댓글 관련 테이블      ----------------------------------------------------------
  create sequence seq_reply increment by 1 start with 1;
  
  create table reply(
  reply_no number(35) primary key, -- 오토 시퀀스로
  writing_no number(35) constraint fk_writing_no references pwriting(w_no) on delete cascade, 
  -- 댓글이 달릴 게시글의 번호, 약식으로 table 생성시 외래키 만들기
  reply_id varchar2(50),
  reply_comment varchar2(500),
  design_score number(3),
  prr_score number(3),
  durablity_score number(3),
  reply_date date default sysdate
  )
  
  alter table reply add constraint fk_writing_no foreign key (writing_no) references pwriting(w_no) on delete cascade;
  
  drop table reply;
  
  select * from reply;
  
  truncate table reply;
-------------------------------------------------------------------------------------------------  
  --페이징 처리에 필요한 쿼리
 	select * from tb_write ORDER BY idx DESC LIMIT #{offset}, #{noOfRecords}; -- 이 것은 Mysql 구뮨이다
 	
 	SELECT * FROM ( 
                        SELECT  
                               m.*, 
                               FLOOR((ROWNUM - 1)/10 + 1) page 
                        FROM ( 
                                 SELECT * FROM pwriting  
                        ORDER BY w_no desc
                             ) m 
                      ) 
              WHERE page = 3;
 	--?는 끊어주는 레코드 수
 	
    ------------ 오라클용 페이징 처리------
      	SELECT count(*) FROM (
					SELECT
					m.*,
					FLOOR((ROWNUM - 1)/10 + 1) page
					FROM (
					SELECT * FROM pwriting
					WHERE title like '%'||'글 제목'||'%' or
							id like '%'||'글 제목'||'%'
				 			OR content like '%'||'글 제목'||'%'
					ORDER BY w_no desc, w_date desc  
					) m
			)
		WHERE page =1;
              
     -----검색 쿼리-----------------------------        

     SELECT count(*) FROM pwriting
		WHERE id like '%'||''||'%'or
				title like '%'||'글 제목'||'%' or
	        content like '%'||''||'%'
		ORDER BY w_no desc, w_date desc        
		
	------------------------------------
	SELECT count(*) FROM pwriting
					WHERE id like '%'||#{id}||'%' or
					      title like '%'||#{title}||'%' or
				 		  content like '%'||#{content}||'%'
					ORDER BY w_no desc, w_date desc  	
        --------------------------      
					  SELECT count(*) FROM pwriting
		WHERE 
				title like '%'||'글 제목'||'%' 
	       
		ORDER BY w_no desc, w_date desc     
           --------------------------------------------------
              SELECT * FROM (
					SELECT
					m.*,
					FLOOR((ROWNUM - 1)/10 + 1) page
					FROM (
					SELECT * FROM pwriting
					ORDER BY w_no desc, w_date desc
					) m
				)
				WHERE page =1;
		 -------- --------------------------------------------------
		SELECT * FROM (
					SELECT
					m.*,
					FLOOR((ROWNUM - 1)/10 + 1) page
					FROM (
					SELECT * FROM pwriting
					WHERE 1=1
					and id = 'fany305'
							
					ORDER BY w_no desc, w_date desc  
					) m
			)
		WHERE page =2;
		------------------------------------------------
		SELECT count(*) FROM pwriting 
		where 1=1
			and id like '%'||'fany305'||'%'
		ORDER BY w_no desc, w_date desc              
          ---------------------------------------------------
          select writing_no, count(writing_no) from reply group by writing_no    
              