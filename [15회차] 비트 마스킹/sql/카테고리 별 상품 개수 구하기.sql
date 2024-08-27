select left(product_code, 2) as category, count(*) from product
 group by category
 order by product_code;