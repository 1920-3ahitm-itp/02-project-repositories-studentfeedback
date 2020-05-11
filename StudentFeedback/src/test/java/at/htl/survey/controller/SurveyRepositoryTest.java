package at.htl.survey.controller;

import at.htl.survey.database.SqlRunner;
import at.htl.survey.model.Questionnaire;
import at.htl.survey.model.Survey;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.db.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SurveyRepositoryTest {

    @Test
    @Order(1)
    void save() {
        // arrange - given
        SurveyRepository surveyRepository = new SurveyRepository();
        Survey survey = new Survey(1, "Thomas Stütz",1, new Date(2020-04-18));

        // act - when
        surveyRepository.save(survey);

        // assert - then
        Table table = new Table(Database.getDataSource(), "survey");
        Assertions.assertThat(table).row(0)
                .value("q_creator").isEqualTo("Thomas Stütz")
                .value("s_id_id").isEqualTo(1)
                .value("s_date").isEqualTo(2020-04-18);

        // Datenbank initalisieren
        //SqlRunner.run();
    }

    @Test
    @Order(2)
    void insert() {
        QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();

        Questionnaire questionnaire = new Questionnaire(9, "Blablabla");

        Table table = new Table(Database.getDataSource(), "Questionnaire");

        int rowsBefore = table.getRowsList().size();
        questionnaireRepository.insert(questionnaire);
        int rowsAfter = table.getRowsList().size();


        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);
    }

    @Test
    @Order(3)
    void delete() {

        QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();

        Questionnaire questionnaire = new Questionnaire(9, "Blablabla");
        questionnaireRepository.insert(questionnaire);
        Table table = new Table(Database.getDataSource(), "Questionnaire");

        int rowsBefore = table.getRowsList().size();
        questionnaireRepository.delete(rowsBefore-1);
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