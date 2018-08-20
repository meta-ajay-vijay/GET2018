#q1
use storefront;

DELIMITER $$
CREATE FUNCTION average(Sum INT)
    RETURNS FLOAT
BEGIN
RETURN(Sum/30);
END$$
DELIMITER $$;

DELIMITER $$

CREATE PROCEDURE getAverageSale
(
    IN  Month INT,
    IN  Year INT
)
BEGIN
SELECT 
    PRODUCTS_ORDERS.ProductID,
    MONTH(ORDERS.PlacedDate),
    COUNT(PRODUCTS.ProductID) AS TOTAL_PRODUCTS,
    average(SUM(PRODUCTS.Cost))
FROM
    PRODUCTS_ORDERS
        LEFT JOIN
    ORDERS ON ORDERS.OrderID = PRODUCTS_ORDERS.OrderID
        LEFT JOIN
    PRODUCTS ON PRODUCTS_ORDERS.ProductID = PRODUCTS.ProductID
WHERE
    YEAR(ORDERS.PlacedDate) = Year AND MONTH(ORDERS.PlacedDate) = Month
GROUP BY PRODUCTS.ProductID
ORDER BY PRODUCTS_ORDERS.ProductID;
END $$;
DELIMITER $$;
 

CALL getAverageSale(12,2018);

#q2

DELIMITER $$ 
   CREATE FUNCTION validate_date(start_date Date,end_date Date)
   RETURNS Date
   BEGIN
   DECLARE set_start_date Date;
   
       if (start_date < end_date)
           then
               return start_date;
               
       else
          SET set_start_date = CONCAT(DATE_FORMAT(end_date, '%Y-%m-'), '01');
           return set_start_date;
           
       END if;
   END$$
 
DELIMITER $$ 
CREATE PROCEDURE getOrder(
IN StartDate Date , 
IN LastDate Date 
)
BEGIN
DECLARE defaultStratDate date;
SET defaultStratDate = validate_date(StartDate,LastDate);
SELECT 
    PRODUCTS_ORDERS.OrderID,
    PRODUCTS_ORDERS.ProductID,
    ORDERS.PlacedDate,
    PRODUCTS_ORDERS.State
FROM
    PRODUCTS_ORDERS
        LEFT JOIN
    ORDERS ON PRODUCTS_ORDERS.OrderID = ORDERS.OrderID
WHERE
    ORDERS.PlacedDate BETWEEN startDate AND lastDate;
END $$
DELIMITER $$;



CALL getOrder('2018-08-12','2018-12-12');
