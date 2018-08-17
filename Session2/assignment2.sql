ALTER TABLE PRODUCT
ADD Timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;



LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/categoryData.txt' 
INTO TABLE CATEGORY
FIELDS TERMINATED BY '\t' 
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';

LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/userData.txt' 
INTO TABLE USER_
FIELDS TERMINATED BY '\t' 
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';


LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/shopperData.txt' 
INTO TABLE SHOPPER
FIELDS TERMINATED BY '\t' 
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';

LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/orderData.txt'
INTO TABLE ORDER_
FIELDS TERMINATED BY '\t' 
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';

LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/image_data.txt' 
INTO TABLE IMAGE
FIELDS TERMINATED BY '\t' 
LINES TERMINATED BY '\r\n';

LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/product_data.txt'
INTO TABLE PRODUCT
FIELDS TERMINATED BY '\t' 
LINES TERMINATED BY '\r\n'
(ProductID,Name,Brand,Cost,Quantity,Description)
SET Timestamp=CURRENT_TIMESTAMP;

LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/image_product.txt' 
INTO TABLE PRODUCT_IMAGE
FIELDS TERMINATED BY '\t' 
LINES TERMINATED BY '\r\n';



LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/product_category.txt' 
INTO TABLE PRODUCT_CATEGORY
FIELDS TERMINATED BY '\t' 
LINES TERMINATED BY '\r\n';

LOAD DATA INFILE 'D:/Assignments metacube/StoreFront Complete Partially/StoreFront Complete Partially/StoreFront Data/productOrder.txt' 
INTO TABLE PRODUCT_ORDER
FIELDS TERMINATED BY '\t' 
LINES TERMINATED BY '\r\n';

#Q2
SELECT PRODUCT.ProductID, Product.Name,Product.Cost AS price, category.Type AS category_title FROM PRODUCT 
LEFT JOIN product_category ON product.ProductID = product_category.ProductID
LEFT JOIN category ON category.CategoryID = product_category.CategoryID ORDER BY Timestamp;

#Q3
SELECT product.ProductID FROM product
WHERE product.ProductID NOT IN (
SELECT product.ProductID FROM product 
INNER JOIN product_image ON product.ProductID=product_image.ProductID);

#q4
SELECT c.Type,
IF (c.ParentCategory = 0, 'Top Category',c1.Type) AS ParentCategory
FROM CATEGORY c
LEFT JOIN CATEGORY c1
ON c.ParentCategory = c1.CategoryID ORDER BY ParentCategory;

#q5
SELECT CATEGORY.CategoryID,CATEGORY.Type, CATEGORY.ParentCategory FROM CATEGORY WHERE CATEGORY.CategoryID NOT IN 
(SELECT CATEGORY.ParentCategory FROM CATEGORY);


#Q6
SELECT Product.Name,Product.Cost AS price, Product.Description, category.Type AS category_title FROM PRODUCT  
LEFT JOIN product_category ON product.ProductID = product_category.ProductID
LEFT JOIN category ON category.CategoryID = product_category.CategoryID WHERE category.Type = 'Mobiles';

#Q7
SELECT * FROM product WHERE Quantity < 30 ;

#Q8
UPDATE PRODUCT SET QUANTITY = QUANTITY + 10 
WHERE 1;