/*
 DML
 CRUD
 
 C = insert
 R = select
 U = update
 D = delete
*/

#한줄주석
#insert
INSERT INTO 
	user_mst(
		user_code, 
		user_id, 
		user_password)
	VALUES(
	0, 
	'junil4', 
	'1234');
	
#컬럼명 생략 가능
INSERT INTO 
	user_mst
	VALUES(
	0, 
	'junil5', 
	'1234');
	
#데이터 여러개를 한번에 insert하는 방법
INSERT INTO 
	user_mst
	VALUES(
	0, 
	'junil6', 
	'1234'),
	(
	0,
	'junil7',
	'1234'),
	(
	0,
	'junil8',
	'1234');
	
#select

SELECT
	*
FROM
	user_mst
WHERE
#	user_code > 3 
#	AND user_code < 6;
#	user_id = 'junil';
#	user_id LIKE '%il%'; #%의 의미는 어떤것도 상관없다 (il만 포함하고있으면 앞뒤로 상관없다 검색해줘)
#	user_id IN('junil3', 'jinil4');
#	user_id = 'junil3'
#	OR user_id = 'junil4';

#where 서브쿼리
	user_id IN(
		select
			user_id
		from
			user_mst
		where
			user_code > 2
			AND user_code < 6
	);

#update
UPDATE
	user_mst
SET
	user_password = '2222',
	user_id = 'juni2222'
WHERE
	user_code = (
		SELECT
			user_code
		from
			user_mst
		where
			user_id = 'junil6'
	);
	
#delete

DELETE
FROM
	user_mst
WHERE
	user_code = 6;