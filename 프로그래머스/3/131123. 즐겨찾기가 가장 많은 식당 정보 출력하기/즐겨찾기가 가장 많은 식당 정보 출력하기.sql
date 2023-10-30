

select food_type, rest_id, rest_name, favorites
from rest_info
where favorites in (select max(favorites) from rest_info group by food_type)
group by food_type
order by food_type desc;






# 은돼지 식당, 스시사카우스, 애플우스,만정 , 따따따띠뜨