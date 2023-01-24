#select id, title as name, parent_id as parent, system_setup_id as systemSetup, unit_type_id as `type`, subtype as subtype from unit;
mongoimport --uri "mongodb+srv://root:<password>@cluster0.wqnpn.mongodb.net/covitality?retryWrites=true&w=majority" --collection units --file units.json --jsonArray

#SELECT t.txn_id as id, t.unit_id as unitId, u.title as unitName, t.survey_id as surveyId, t.survey_title as surveyName,
#t.chrono_order_tag as chronoOrderTagId, s.session_linked as sessionLinked, s.date_created as dateCreated,
#t.date_submitted as dateSubmitted, t.suspicious_txn as isSuspicious
# FROM txn_details t join unit u on t.unit_id = u.id
# join survey_transaction s on t.txn_id = s.id
# where t.unit_id = 598 and t.txn_id = 293115;


mongoimport --uri "mongodb+srv://root:<password>@cluster0.wqnpn.mongodb.net/covitality?retryWrites=true&w=majority" --collection transactions --file 293115_txn.json --jsonArray