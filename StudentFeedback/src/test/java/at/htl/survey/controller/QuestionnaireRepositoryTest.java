package at.htl.survey.controller;

import at.htl.survey.model.Questionnaire;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.db.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireRepositoryTest {

  static QuestionnaireRepository repo;

  @Test
  void save() {
    Questionnaire questionnaire = new Questionnaire(1, "Männlich");

    questionnaire.setQn_id(12);

    repo.save(questionnaire);
    Table table = new Table(Database.getDataSource(), "Questionnaire");

    assertThat(table).row(table.getRowsList().size() - 1)
            .value("Männlich").isEqualTo("watering pots, cookware, ...");

  }

  @Test
  void delete() {
  }

  @Test
  void findAll() {
  }

  @Test
  void findById() {
  }
}