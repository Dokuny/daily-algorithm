SELECT h.history_id,
    floor(case when datediff(h.end_date,h.start_date)+1 < 7 then (datediff(h.end_date,h.start_date)+1) * c.daily_fee
               else (datediff(h.end_date, h.start_date)+1) * (c.daily_fee * ((100 - p.discount_rate) / 100)) 
          end
     ) as fee

from car_rental_company_rental_history as h 
    join car_rental_company_car as c 
    join car_rental_company_discount_plan as p
    on h.car_id = c.car_id and c.car_type = p.car_type and c.car_type = '트럭'
    where p.duration_type = (case when datediff(h.end_date,h.start_date)+1 >= 90 then '90일 이상'
                                 when datediff(h.end_date,h.start_date)+1 >= 30 then '30일 이상'   
                                when datediff(h.end_date,h.start_date)+1 >= 7 then '7일 이상'
                             end
                            )
                            or datediff(h.end_date,h.start_date)+1 < 7
                            group by h.history_id
                            order by fee desc, h.history_id desc

                            ;