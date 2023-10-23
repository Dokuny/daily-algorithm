-- 코드를 입력하세요
SELECT i.rest_id, i.rest_name,i.food_type,i.favorites,i.address,round(sum(r.review_score) / count(r.review_score),2) as score from rest_review as r 
join rest_info as i 
on r.rest_id = i.rest_id
where i.address like "서울%"
group by r.rest_id
order by score desc, i.favorites desc
