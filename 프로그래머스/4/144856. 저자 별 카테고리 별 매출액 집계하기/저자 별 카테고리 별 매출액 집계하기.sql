select a.author_id, a.author_name, b.category, sum(b.price * s.sales) as total_sales 
from book_sales s 
join book b join author a 
on s.book_id = b.book_id and b.author_id = a.author_id
where s.sales_date between "2022-01-01" and "2022-01-31"
group by b.author_id, b.category
order by author_id asc, category desc