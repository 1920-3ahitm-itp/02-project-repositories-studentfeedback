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
   VALUES ('Der Lehrer ist humorvoll - fröhlich', 'MULTIPLE', 2);
INSERT INTO question (q_text, q_type, q_qn_id)
   VALUES ('Der Lehrer ist hilfsbereit - unterstützend', 'MULTIPLE', 3);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('Der Lehrer ist freundlich', 'MULTIPLE', 4);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('Der Lehrer ist engagiert - aktiv', 'MULTIPLE', 5);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('Der Lehrer ist verständnisvoll - rücksichtsvoll', 'MULTIPLE', 6);



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
    VALUES ('völlig zu',4,3);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',3,3);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',2,3);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',1,3);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('völlig zu',4,4);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',3,4);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',2,4);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',1,4);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('völlig zu',4,5);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',3,5);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',2,5);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',1,5);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('völlig zu',4,6);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher zu',3,6);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('eher nicht zu',2,6);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('überhaupt nicht zu',1,6);


/*
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
   VALUES ('',,);
*/


--MULTIPLE WITH SMILEYS
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('Wie zufrieden bist du mit deinem LEHRER insgesamt', 'MULTIPLE', 7);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('sehr zufrieden',5,7);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('zufrieden',4,7);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('mittelmäßig',3,7);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('unzufrieden',2,7);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('sehr unzufrieden',1,7);


--TEXT QUESTIONS
/*welcher text muss übergeben werden ao_text?
  und welcher Wert hat dieser übergebene Text  ao_value?
*/

INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('An diesem Lehrer gefällt mir', 'TEXT', 8);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('An diesem Lehrer stört mich', 'TEXT', 9);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('', 0, 8);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('', 0, 9);
