-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE))
FROM CAR_RENTAL_COMPANY_CAR crcc
where car_type = 'SUV'
;