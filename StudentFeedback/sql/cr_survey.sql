DROP TABLE answer;
DROP TABLE survey;
DROP TABLE answer_option;
DROP TABLE question;
DROP TABLE questionnaire;

CREATE TABLE questionnaire (
                    qn_id INT NOT NULL
                        CONSTRAINT QUESTIONNAIRE_PK PRIMARY KEY
                        GENERATED ALWAYS AS IDENTITY,
                    qn_description VARCHAR(200)
);

CREATE TABLE question (
                      q_id INT NOT NULL
                          CONSTRAINT QUESTION_PK PRIMARY KEY
                          GENERATED ALWAYS AS IDENTITY,
                      q_text VARCHAR(200),
                      q_type VARCHAR(20),
                      q_qn_id INT CONSTRAINT Q_QN_FK REFERENCES questionnaire(qn_id)
);

CREATE TABLE answer_option (
                      ao_id INT NOT NULL
                          CONSTRAINT ANSWER_OPTION_PK PRIMARY KEY
                          GENERATED ALWAYS AS IDENTITY,
                      ao_text VARCHAR(200),   -- zB "trifft zu", "trifft eher zu", ...
                      ao_value INTEGER,       -- zB 4 Punkte, 3 Punkte, 2 Punkte oder 1 Punkt
                      ao_q_id INT CONSTRAINT AO_Q_FK REFERENCES question(q_id)
);



CREATE TABLE survey (
                    s_id INT NOT NULL
                        CONSTRAINT SURVEY_PK PRIMARY KEY
                        GENERATED ALWAYS AS IDENTITY,
                    s_creator VARCHAR(100),
                    s_qn_id INT CONSTRAINT S_QN_FK REFERENCES questionnaire(qn_id),
                    s_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE answer (
                    a_id INT NOT NULL
                        CONSTRAINT ANSWER_PK PRIMARY KEY
                        GENERATED ALWAYS AS IDENTITY,
                    a_tan VARCHAR(50),
                    a_q_id INT CONSTRAINT A_Q_FK REFERENCES question(q_id),
                    a_s_id INT CONSTRAINT A_S_ID REFERENCES survey(s_id),
                    answer_text VARCHAR(200)
);

