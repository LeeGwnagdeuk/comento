SET @userID = 0;

INSERT INTO statistc.user (userID, HR_ORGAN, USERNAME)
SELECT 
    LPAD(@userID := (@userID + 1), 4, '0') AS userID,
    CASE FLOOR(RAND() * 5)
        WHEN 0 THEN 'Sales'
        WHEN 1 THEN 'Marketing'
        WHEN 2 THEN 'HR'
        WHEN 3 THEN 'Development'
        ELSE 'Support'
    END AS HR_ORGAN,
    CONCAT('User', LPAD(@userID, 3, '0')) AS USERNAME
FROM 
    (SELECT @userID := 0) r,
    (SELECT 1 UNION ALL SELECT 2) t1,
    (SELECT 1 UNION ALL SELECT 2) t2,
    (SELECT 1 UNION ALL SELECT 2) t3,
    (SELECT 1 UNION ALL SELECT 2) t4,
    (SELECT 1 UNION ALL SELECT 2) t5
