package at.htl.survey.controller;

import at.htl.survey.database.SqlRunner;
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
class QuestionnaireRepositoryTest {

    QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();

  @Test
  @Order(1)
  void save() {
    // arrange - given

    Questionnaire questionnaire = new Questionnaire(1L, "Questionnaire");

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

    Questionnaire questionnaire = new Questionnaire(9L, "Blablabla");

    Table table = new Table(Database.getDataSource(), "Questionnaire");

    int rowsBefore = table.getRowsList().size();
    questionnaireRepository.insert(questionnaire);
    int rowsAfter = table.getRowsList().size();


    org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);
  }

  @Test
  @Order(3)
  void delete() {

    Questionnaire questionnaire = new Questionnaire(9L, "Blablabla");
    questionnaireRepository.insert(questionnaire);
    Table table = new Table(Database.getDataSource(), "Questionnaire");

    int rowsBefore = table.getRowsList().size();
    questionnaireRepository.delete(questionnaire.getQnId() );
    int rowsAfter = table.getRowsList().size();

    org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);

  }

  @Test
  @Order(4)
  void findAll() {

    int findAllRows = questionnaireRepository.findAll().size();


    Table table = new Table(Database.getDataSource(), "Questionnaire");

    int tableRows = table.getRowsList().size();

    org.assertj.core.api.Assertions.assertThat(findAllRows).isEqualTo(tableRows);
  }

  @Test
  @Order(5)
  void findById() {
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