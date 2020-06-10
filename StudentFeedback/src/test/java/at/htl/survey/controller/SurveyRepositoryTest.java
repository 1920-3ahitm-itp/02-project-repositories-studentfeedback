package at.htl.survey.controller;

import at.htl.survey.database.SqlRunner;
import at.htl.survey.model.Question;
import at.htl.survey.model.Questionnaire;
import at.htl.survey.model.Survey;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.db.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SurveyRepositoryTest {

    SurveyRepository surveyRepository = new SurveyRepository();
    QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();

    @Test
    @Order(1)
    void save() {




        //java.sql.Date date = java.sql.Date.valueOf("2010-02-29");

        // Date date = new Date(2020,1,1);
//        Date date = null;
//        try {
//            date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-08");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Survey survey = new Survey(1L, "Thomas Stütz", questionnaireRepository.findById(1), new Date());
        surveyRepository.save(survey);

        Table table = new Table(Database.getDataSource(), "Survey");


        java.sql.Date date = new java.sql.Date(survey.getsDate().getTime());
        Date d2 = (Date) table.getRow(0).getValuesList().get(3).getValue();
        Assertions.assertThat(table).row(0)
                .value("s_creator").isEqualTo("Thomas Stütz")
                .value("s_qn_id").isEqualTo(1)
                .value("s_date").isEqualTo(date);

    }

    @Test
    @Order(2)
    void insert() {
        QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();

        Questionnaire questionnaire = new Questionnaire(9L, "De");

        Table table = new Table(Database.getDataSource(), "Questionnaire");

        int rowsBefore = table.getRowsList().size();
        questionnaireRepository.insert(questionnaire);
        int rowsAfter = table.getRowsList().size();


        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);
    }

    @Test
    @Order(3)
    void delete() {

        SurveyRepository surveyRepository = new SurveyRepository();

        Survey survey = new Survey(1L, "Thomas Stütz", questionnaireRepository.findById(1), new Date());
        surveyRepository.insert(survey);
        Table table = new Table(Database.getDataSource(), "Survey");

        int rowsBefore = table.getRowsList().size();
        surveyRepository.delete(rowsBefore-1);
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

        String [] expected = {String.valueOf(questionnaire.getQnId()), questionnaire.getQnDescription()};
        String [] actual = {
                table.getRow(1).getValuesList().get(0).getValue().toString(),
                table.getRow(1).getValuesList().get(1).getValue().toString()
        };

        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);
    }
}