# -- 코드를 입력하세요
SELECT a.apnt_no , p.pt_name , p.pt_no ,d.mcdp_cd, d.dr_name , a.apnt_ymd
FROM APPOINTMENT AS a JOIN PATIENT AS p JOIN DOCTOR AS d 
on a.pt_no = p.pt_no and d.dr_id = a.mddr_id 
where a.apnt_cncl_yn = 'N' and a.mcdp_cd = 'CS' and DATEDIFF('2022-04-13', a.apnt_ymd) = 0
order by a.apnt_ymd asc

# SELECT APNT_NO, PT_NAME, APPOINTMENT.PT_NO, APPOINTMENT.MCDP_CD, DR_NAME, APNT_YMD
# FROM APPOINTMENT, PATIENT, DOCTOR
# WHERE APPOINTMENT.PT_NO = PATIENT.PT_NO AND APPOINTMENT.MDDR_ID = DOCTOR.DR_ID
# AND DATEDIFF('2022-04-13', APNT_YMD) = 0 AND APNT_CNCL_YN = 'N' AND APPOINTMENT.MCDP_CD = 'CS'
# ORDER BY APNT_YMD ASC