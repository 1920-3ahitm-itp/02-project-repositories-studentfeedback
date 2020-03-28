CREATE  TABLE teacher {
        teacher_id INT NOT NULL GENERATED ALWAYS AS IDENTITY
        CONSTRAINT teacher_pk PRIMARY KEY,
        teacher_name VARCHAR(50),
        teacher_subject VARCHAR(50)
);

CREATE  TABLE survey {
        survey_id INT CONSTRAINT GENERATED ALWAYS AS IDENTITY
        CONSTRAINT survey_pk PRIMARY KEY,
        teacher_id INT CONSTRAINT survey_teacher_fk
            REFERENCES survey(teacher_id),
        survey_date DATE NOT NULL,
        class_name VARCHAR(50),
        subject VARCHAR(50)
);

}