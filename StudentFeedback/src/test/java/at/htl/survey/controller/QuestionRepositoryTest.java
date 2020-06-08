package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.Questionnaire;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.db.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryTest {

    @Test
    void save() {
        QuestionRepository questionRepository = new QuestionRepository();

        Questionnaire questionnaire = new Questionnaire(1L, "Questionnaire");
        Question question = new Question(1L, "Wie gefällt dir der Unterricht des Lehrers?", "TEXT", questionnaire);
        questionRepository.save(question);

        Table table = new Table(Database.getDataSource(), "Question");

        Assertions.assertThat(table).row(0)
                .value("q_text").isEqualTo("Wie gefällt dir der Unterricht des Lehrers?")
                .value("q_type").isEqualTo("TEXT")
                .value("q_qn_id").isEqualTo(1L);


    }

    @Test
    void insert() {
        QuestionRepository questionRepository = new QuestionRepository();

        Questionnaire questionnaire = new Questionnaire(1L, "Questionnaire");
        Question question = new Question(9L, "Blablabla", "Type", questionnaire);

        Table table = new Table(Database.getDataSource(), "Question");

        int rowsBefore = table.getRowsList().size();
        questionRepository.insert(question);
        int rowsAfter = table.getRowsList().size();


        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);
    }


    @Test
    void delete() {

        QuestionRepository questionRepository = new QuestionRepository();

        Questionnaire questionnaire = new Questionnaire(1L, "Questionnaire");
        Question question = new Question(9L, "Blablabla", "Text", questionnaire);
        questionRepository.insert(question);
        Table table = new Table(Database.getDataSource(), "Question");

        int rowsBefore = table.getRowsList().size();
        questionRepository.delete(question.getqId());
        int rowsAfter = table.getRowsList().size();

        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);


    }

    @Test
    void findAll() {
        QuestionRepository questionRepository = new QuestionRepository();
        Table table = new Table(Database.getDataSource(), "Question");

        int findAllRows = questionRepository.findAll().size();
        int tableRows = table.getRowsList().size();

        org.assertj.core.api.Assertions.assertThat(findAllRows).isEqualTo(tableRows);
    }

    @Test
    void findById() {
        QuestionRepository questionRepository = new QuestionRepository();
        Table table = new Table(Database.getDataSource(), "Question");

        Question question = questionRepository.findById(2);

        String [] actual = {String.valueOf(question.getqId()), question.getqText(),question.getqType(),String.valueOf(question.getQuestionnaire().getQnId())};
        String [] expected = {
                table.getRow(1).getValuesList().get(0).getValue().toString(),
                table.getRow(1).getValuesList().get(1).getValue().toString(),
                table.getRow(1).getValuesList().get(2).getValue().toString(),
                table.getRow(1).getValuesList().get(3).getValue().toString()
        };

        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);
    }
}
