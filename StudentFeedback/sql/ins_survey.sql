--=============
--QUESTIONNAIRE
--=============

INSERT INTO questionnaire (qn_description)   -- id = 1
   VALUES ('Schüler-Feedback männl.');
INSERT INTO questionnaire (qn_description)   -- id = 2
   VALUES ('Schüler-Feedback weibl.');
INSERT INTO questionnaire (qn_description)   -- id = 3
   VALUES ('Rezepte-Quiz');

-- q_type (wird nur in Java als enum implementiert):
-- TEXT - MULTIPLE - SINGLE - NUMBER - YESNO

--=============
--QUESTION
--=============
--SINGLE
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 1
   VALUES ('Der Lehrer ist fair - gerecht', 'SINGLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 2
   VALUES ('Der Lehrer ist humorvoll - fröhlich', 'SINGLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 3
   VALUES ('Der Lehrer ist hilfsbereit - unterstützend', 'SINGLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 4
    VALUES ('Der Lehrer ist freundlich', 'SINGLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 5
    VALUES ('Der Lehrer ist engagiert - aktiv', 'SINGLE', 1);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 6
    VALUES ('Der Lehrer ist verständnisvoll - rücksichtsvoll', 'SINGLE', 1);

INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 7
   VALUES ('Die Lehrerin ist fair - gerecht', 'SINGLE', 2);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 8
   VALUES ('Die Lehrerin ist humorvoll - fröhlich', 'SINGLE', 2);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 9
   VALUES ('Die Lehrerin ist hilfsbereit - unterstützend', 'SINGLE', 2);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 10
    VALUES ('Die Lehrerin ist freundlich', 'SINGLE', 2);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 11
    VALUES ('Die Lehrerin ist engagiert - aktiv', 'SINGLE', 2);
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 12
    VALUES ('Die Lehrerin ist verständnisvoll - rücksichtsvoll', 'SINGLE', 2);

-- FREITEXT

INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 13
VALUES ('Wie macht man WanTan-Suppe?', 'TEXT', 3);

--=============
--ANSWER_OPTION
--=============
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


--SINGLE WITH SMILEYS
INSERT INTO question (q_text, q_type, q_qn_id)              -- id = 14
    VALUES ('Wie zufrieden bist du mit deinem LEHRER insgesamt?', 'SINGLE', 1);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('sehr zufrieden',5,14);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('zufrieden',4,14);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('mittelmäßig',3,14);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('unzufrieden',2,14);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('sehr unzufrieden',1,14);


--TEXT QUESTIONS
/*welcher text muss übergeben werden ao_text?
  und welcher Wert hat dieser übergebene Text  ao_value?
*/
/*
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('An diesem Lehrer gefällt mir', 'TEXT', 8);
INSERT INTO question (q_text, q_type, q_qn_id)
    VALUES ('An diesem Lehrer stört mich', 'TEXT', 9);

INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('', 0, 8);
INSERT INTO answer_option (ao_text, ao_value, ao_q_id)
    VALUES ('', 0, 9);
*/



--=============
--SURVEY
--=============

INSERT INTO survey (s_creator,s_qn_id,s_date)
    VALUES ('Thomas Stütz',1,'2020-04-18');

INSERT INTO survey (s_creator,s_qn_id,s_date)
VALUES ('Michael Holzmann',2,'2020-04-18');

INSERT INTO survey (s_creator,s_qn_id,s_date)
VALUES ('Robert Reder',3,'2020-04-18');
