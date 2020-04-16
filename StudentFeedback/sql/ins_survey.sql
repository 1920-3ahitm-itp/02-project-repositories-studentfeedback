INSERT INTO questionnaire (qn_description)
   VALUES ('Schüler-Feedback männl.');
INSERT INTO questionnaire (qn_description)
   VALUES ('Schüler-Feedback weibl.');

-- q_type:
-- TEXT - MULTIPLE - SINGLE - NUMBER - YESNO

--MULTIPLE
INSERT INTO question (q_text, q_type, q_qn_id)
   VALUES ('Der Lehrer ist fair - gerecht', 'MULTIPLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)
   VALUES ('Der Lehrer ist humorvoll - fröhlich', 'MULTIPLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)
   VALUES ('Der Lehrer ist hilfsbereit - unterstützend', 'MULTIPLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('Der Lehrer ist freundlich', 'MULTIPLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('Der Lehrer ist engagiert - aktiv', 'MULTIPLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('Der Lehrer ist verständnisvoll - rücksichtsvoll', 'MULTIPLE', 1);


INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('völlig zu',4,1);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('eher zu',3,1);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('eher nicht zu',2,1);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('überhaupt nicht zu',1,1);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('völlig zu',4,2);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('eher zu',3,2);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('eher nicht zu',2,2);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('überhaupt nicht zu',1,2);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('völlig zu',1,3);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',2,3);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',4,3);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',4,3);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('völlig zu',1,4);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',1,4);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',3,4);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',2,4);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('völlig zu',3,5);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',2,5);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',2,5);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',2,5);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('völlig zu',1,6);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',1,6);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',1,6);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',4,6);


/*
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('',,);
*/
