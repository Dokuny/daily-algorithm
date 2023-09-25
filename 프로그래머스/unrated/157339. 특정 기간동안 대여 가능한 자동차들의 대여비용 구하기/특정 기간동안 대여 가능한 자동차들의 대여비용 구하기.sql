-- 코드를 입력하세요

# SELECT car_id from car_rental_company_rental_history where end_date >= '2022-11-01' and start_date <= '2022-11-30' group by car_id;



select c.car_id, c.car_type, Floor(c.daily_fee * ((100 - p.discount_rate) / 100) * 30) as fee  from car_rental_company_car as c 
join car_rental_company_discount_plan  as p 
on c.car_type = p.car_type and p.duration_type = '30일 이상' 
where c.car_id not in(SELECT car_id from car_rental_company_rental_history where end_date >= '2022-11-01' and start_date <= '2022-11-30' group by car_id) 
and c.daily_fee * ((100 - p.discount_rate) / 100) * 30 between 500000 and 1999999 
and c.car_type in ('세단','SUV')
order by fee desc, c.car_type asc, c.car_id desc;
