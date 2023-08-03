select a1.machine_id,Round(AVG(a2.timestamp-a1.timestamp),3) As processing_time
FROM Activity a1
JOIN Activity a2
WHERE a1.machine_id=a2.machine_id and a1.process_id=a2.process_id and a1.activity_type='start' and a2.activity_type='end'
Group By a1.machine_id ;