SELECT c.itemid, c.name, c.[path], c.type, COUNT(c.itemid)
FROM Catalog c
    INNER JOIN ExecutionLogStorage e ON c.itemid = e.reportid
WHERE c.type = 2
    AND c.NAME NOT LIKE 'H!_%' ESCAPE '!'
    AND e.timestart > DATEADD(DAY, -30, GETDATE())
GROUP BY c.itemid, c.name, c.type, c.[path]
ORDER BY COUNT(c.itemid) DESC