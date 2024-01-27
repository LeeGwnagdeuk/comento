SET @requestID = 0;
SET @userID = 0;

INSERT INTO statistc.requestInfo (requestID, requestCode, userID, createDate)
SELECT 
    @requestID := (@requestID + 1) AS requestID,
    CASE ROUND(RAND())
        WHEN 0 THEN 'L'
        ELSE 'O'
    END AS requestCode,
    LPAD(@userID := (@userID % 31) + 1, 4, '0') AS userID,
    DATE_FORMAT(DATE_ADD('2023-01-01 00:00:00', INTERVAL FLOOR(RAND() * ((365*24*60) - 1 + 1)) MINUTE), '%Y%m%d%H%i') AS createDate
FROM 
    (SELECT @requestID := 0, @userID := 0) r,
    -- 이 부분을 수정하여 원하는 만큼의 데이터를 생성
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) t1,
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) t2,
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) t3,
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) t4,
    (SELECT 1 UNION ALL SELECT 2) t5;