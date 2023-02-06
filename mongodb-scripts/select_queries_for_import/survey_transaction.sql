-- txn_details table
SELECT t.txn_id as id, t.unit_id as unitId, u.title as unitName, t.survey_id as surveyId, t.survey_title as surveyName,
t.chrono_order_tag as chronoOrderTagId, s.session_linked as sessionLinked, s.date_created as dateCreated,
t.date_submitted as dateSubmitted, t.suspicious_txn as isSuspicious
 FROM txn_details t join unit u on t.unit_id = u.id
 join survey_transaction s on t.txn_id = s.id
 where t.unit_id = 598;

-- fields
SET @@group_concat_max_len = 2048;
SET @sql = NULL;
SELECT
GROUP_CONCAT(DISTINCT CONCAT(
  'SUM(
  CASE WHEN name = "', name, '" THEN value ELSE 0 END)
  AS ', replace(name, '-', '_'))
)
INTO @sql
FROM survey_transaction_fields order by name;

SET @sql = CONCAT('SELECT survey_transaction_id as id, ', @sql,
  ' FROM survey_transaction_fields where survey_transaction_id=293115 GROUP BY survey_transaction_id');
SELECT @sql;

--to execute from cmd:
--PREPARE stmt FROM @sql;
--EXECUTE stmt;
--DEALLOCATE PREPARE stmt;

-- composed pivot select
SELECT survey_transaction_id as id, SUM(
  CASE WHEN name = "BE" THEN value ELSE 0 END)
  AS BE,SUM(
  CASE WHEN name = "BS" THEN value ELSE 0 END)
  AS BS,SUM(
  CASE WHEN name = "CB" THEN value ELSE 0 END)
  AS CB,SUM(
  CASE WHEN name = "CE" THEN value ELSE 0 END)
  AS CE,SUM(
  CASE WHEN name = "CENG" THEN value ELSE 0 END)
  AS CENG,SUM(
  CASE WHEN name = "EE" THEN value ELSE 0 END)
  AS EE,SUM(
  CASE WHEN name = "FR" THEN value ELSE 0 END)
  AS FR,SUM(
  CASE WHEN name = "OU-SA" THEN value ELSE 0 END)
  AS OU_SA,SUM(
  CASE WHEN name = "PB-TECH" THEN value ELSE 0 END)
  AS PB_TECH,SUM(
  CASE WHEN name = "PPST-AVG" THEN value ELSE 0 END)
  AS PPST_AVG,SUM(
  CASE WHEN name = "RDM-R" THEN value ELSE 0 END)
  AS RDM_R,SUM(
  CASE WHEN name = "RSS" THEN value ELSE 0 END)
  AS RSS,SUM(
  CASE WHEN name = "SCS-AVG" THEN value ELSE 0 END)
  AS SCS_AVG,SUM(
  CASE WHEN name = "SEL-TECH" THEN value ELSE 0 END)
  AS SEL_TECH,SUM(
  CASE WHEN name = "SES" THEN value ELSE 0 END)
  AS SES,SUM(
  CASE WHEN name = "SES-AVG" THEN value ELSE 0 END)
  AS SES_AVG,SUM(
  CASE WHEN name = "SMEB" THEN value ELSE 0 END)
  AS SMEB,SUM(
  CASE WHEN name = "SS-REL" THEN value ELSE 0 END)
  AS SS_REL,SUM(
  CASE WHEN name = "SSS-AVG" THEN value ELSE 0 END)
  AS SSS_AVG,SUM(
  CASE WHEN name = "TS-REL" THEN value ELSE 0 END)
  AS TS_REL FROM survey_transaction_fields GROUP BY survey_transaction_id

-- responses
SELECT survey_transaction_id as id,
JSON_ARRAYAGG(JSON_OBJECT('questionId',  qt.question_id, 'questionText', q.text, 'responseScore', r.score, 'response', r.text)) as responses
from
question_transaction qt join question q on qt.question_id = q.id
join response_option r on qt.response = r.id
where survey_transaction_id in (293115, 389192)
group by survey_transaction_id;
