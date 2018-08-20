#inddexing from products

ALTER TABLE PRODUCTS ADD INDEX Product_Index(ProductID);
SHOW Index FROM PRODUCTS;

#indexing from category

ALTER TABLE CATEGORIES ADD INDEX Category_Index(CategoryID);
SHOW Index FROM CATEGORIES;


#indexing from product_category

ALTER TABLE PRODUCTS_CATEGORIES ADD INDEX Product_Categories_Index(CategoryID);
SHOW Index FROM PRODUCTS_CATEGORIES ;

#indexing in order table
ALTER TABLE ORDERS ADD INDEX Order_Index(OrderID);
SHOW Index FROM ORDERS ;

