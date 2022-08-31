INSERT INTO
	product_mst
VALUES(
	0,
	'스타벅스 블루 텀블러',
	1,
	28000),
	(
	0,
	'스타벅스 화이트 머그컵',
	2,
	15000),
	(
	0,
	'스타벅스 아이스 아메리카노',
	3,
	4000),
	(
	0,
	'스타벅스 블랙 머그컵',
	2,
	17000),
	(
	0,
	'스타벅스 핑크 텀블러',
	1,
	20000);
	
SELECT
	*
FROM
	product_mst	
WHERE
	product_price;
	
UPDATE
	product_mst
SET
	product_price = product_price + 10000
WHERE
	product_name LIKE '%텀블러';
	
SELECT
	*
FROM
	product_mst
WHERE
	product_price;
	
	
INSERT INTO 
	category_mst
VALUES (
	0,
	'텀블러'),
	(
	0,
	'머그컵'),
	(
	0,
	'음료');
	
SELECT
	pm.product_code,
	pm.product_name,
	pm.product_category,
	cm.category_name,
	pm.product_price
	
FROM
	product_mst pm
	LEFT OUTER JOIN category_mst cm ON(cm.category_code = pm.product_code);
	
INSERT INTO
	order_mst
	VALUES(
		0,
		4,
		6,
		NOW()
	);
	

SELECT
	om.order_code,
	om.order_user,
	um.user_id,
	om.order_product,
	pm.product_name,
	pm.product_category,
	cm.category_name,
	pm.product_price,
	om.order_datetime
FROM
	order_mst om
#	LEFT OUTER JOIN user_mst um ON(um.user_code = om.order_user)
#	LEFT OUTER JOIN product_mst pm ON(pm.product_code = om.order_product)
#	LEFT OUTER JOIN category_mst cm ON(cm.category_code = pm.product_category);
	INNER JOIN user_mst um ON(um.user_code = om.order_user)
	INNER JOIN product_mst pm ON(pm.product_code = om.order_product)
	INNER JOIN category_mst cm ON(cm.category_code = pm.product_category);
	
	# inner은 절대 null이 나올 수 없다. null의 값 까지 포함해서 조회하고싶다면 outer를 쓰는 것이 더 좋다.
	
WHERE
 om.order_code > 1
 AND pm.product_price > 20000;
	
DELETE
FROM
	user_mst
WHERE
	user_code = 4;