
#q1
SELECT t.ProductID,t.Name,t.CategoryCount FROM(
SELECT PRODUCTS.ProductID, PRODUCTS.Name, COUNT(ProductS.ProductID) AS CategoryCount FROM PRODUCTS
LEFT JOIN PRODUCTS_CATEGORIES
ON
PRODUCTS.ProductID = PRODUCTS_CATEGORIES.ProductID 
LEFT JOIN CATEGORIES
ON
PRODUCTS_CATEGORIES.CategoryID = CATEGORIES.CategoryID
GROUP BY PRODUCTS.ProductID
)as t 
WHERE t.CategoryCount > 1;


#q2

select count(ProductID) AS TotalProducts, 
CASE
   WHEN PRODUCTS.Cost <= 100 AND PRODUCTS.Cost > 0 THEN '0-100'
   WHEN PRODUCTS.Cost <= 500 AND PRODUCTS.Cost >= 101 THEN '101-500'
   WHEN PRODUCTS.Cost >= 500 THEN 'Above 500'
END AS Ranges
FROM PRODUCTS GROUP BY Ranges;

#q3
SELECT CategoryID, COUNT(ProductID) AS TotalProducts
FROM PRODUCTS_CATEGORIES 
Group By CategoryID;






