
select car_id, availability 
from (select car_id, "대여 가능" as availability
from car_rental_company_rental_history
where car_id not in (SELECT car_id
from car_rental_company_rental_history
where start_date <= "2022-10-16" and end_date >= "2022-10-16")
union
SELECT car_id,"대여중" as availability
from car_rental_company_rental_history
where start_date <= "2022-10-16" and end_date >= "2022-10-16") as v
order by car_id desc



