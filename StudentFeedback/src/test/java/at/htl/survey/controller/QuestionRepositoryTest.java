package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.Questionnaire;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.db.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryTest {

    @Test
    void save() {
        QuestionRepository questionRepository = new QuestionRepository();

        Question question = new Question(1, "Wie gefällt dir der Unterricht des Lehrers?", "TEXT", 2);
        questionRepository.save(question);

        Table table = new Table(Database.getDataSource(), "Question");

        Assertions.assertThat(table).row(0)
                .value("q_text").isEqualTo("Wie gefällt dir der Unterricht des Lehrers?")
                .value("q_type").isEqualTo("TEXT")
                .value("q_qn_id").isEqualTo(2);


    }

    @Test
    void delete() {
        QuestionRepository questionRepository = new QuestionRepository();

        Table table = new Table(Database.getDataSource(), "Question");

        int rowsBefore = table.getRowsList().size();
        questionRepository.delete(1);
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