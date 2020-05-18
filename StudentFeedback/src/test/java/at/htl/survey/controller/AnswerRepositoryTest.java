package at.htl.survey.controller;

import at.htl.survey.database.SqlRunner;
import at.htl.survey.model.Answer;
import at.htl.survey.model.Questionnaire;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.db.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AnswerRepositoryTest {
    @Test
    @Order(1)
    void save() {
        // arrange - given
        QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();
        Questionnaire questionnaire = new Questionnaire(1, "Questionnaire");

        // act - when
        questionnaireRepository.save(questionnaire);

        // assert - then
        Table table = new Table(Database.getDataSource(), "questionnaire");
        Assertions.assertThat(table).row(0)
                .value("qn_description").isEqualTo("Questionnaire");

        // Datenbank initalisieren
        //SqlRunner.run();
    }

    @Test
    @Order(2)
    void insert() {
        AnswerRepository answerRepository = new AnswerRepository();

        Answer answer = new Answer(10, 3, 4, 2, "Hallihallo");

        Table table = new Table(Database.getDataSource(), "Answer");

        int rowsBefore = table.getRowsList().size();
        answerRepository.insert(answer);
        int rowsAfter = table.getRowsList().size();


        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);
    }

    @Test
    @Order(3)
    void delete() {

        AnswerRepository answerRepositoryy = new AnswerRepository();

        Answer answer = new Answer(1, 3, 4, 1, "Hallihallo");
        answerRepositoryy.insert(answer);
        Table table = new Table(Database.getDataSource(), "Answer");

        int rowsBefore = table.getRowsList().size();
        answerRepositoryy.delete(answer.getA_id());
        int rowsAfter = table.getRowsList().size();

        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);

    }

    @Test
    @Order(4)
    void findAll() {
        QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();

        int findAllRows = questionnaireRepository.findAll().size();


        Table table = new Table(Database.getDataSource(), "Questionnaire");

        int tableRows = table.getRowsList().size();

        org.assertj.core.api.Assertions.assertThat(findAllRows).isEqualTo(tableRows);
    }

    @Test
    @Order(5)
    void findById() {
        QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();
        Table table = new Table(Database.getDataSource(), "Questionnaire");

        Questionnaire questionnaire = questionnaireRepository.findById(2);

        String [] expected = {String.valueOf(questionnaire.getQn_id()), questionnaire.getQn_description()};
        String [] actual = {
                table.getRow(1).getValuesList().get(0).getValue().toString(),
                table.getRow(1).getValuesList().get(1).getValue().toString()
        };

        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);
    }
}
