package at.htl.survey.controller;

import at.htl.survey.model.Questionnaire;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.db.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireRepositoryTest {

  @Test
  void save() {
    QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();
    
    Questionnaire questionnaire = new Questionnaire(1, "Questionnaire");

    questionnaireRepository.save(questionnaire);
    Table table = new Table(Database.getDataSource(), "Questionnaire");

    Assertions.assertThat(table).row(0)
            .value("qn_description").isEqualTo("Questionnaire");
  }

  @Test
  void insert() {

  }

  @Test
  void delete() {

    QuestionnaireRepository questionnaireRepository = new QuestionnaireRepository();

    Questionnaire questionnaire = new Questionnaire(-1, "Blablabla");
    questionnaireRepository.save(questionnaire);
    Table table = new Table(Database.getDataSource(), "Questionnaire");

    int rowsBefore = table.getRowsList().size();
    questionnaireRepository.delete(-1);
    int rowsAfter = table.getRowsList().size();

    org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter+1);

  }

  @Test
  void findAll() {
  }

  @Test
  void findById() {
  }
}