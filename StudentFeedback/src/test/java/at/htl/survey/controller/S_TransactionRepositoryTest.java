package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.Questionnaire;
import at.htl.survey.model.S_Transaction;
import at.htl.survey.model.Survey;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class S_TransactionRepositoryTest {

    SurveyRepository surveyRepository = new SurveyRepository();
    S_TransactionRepository s_transactionRepository = new S_TransactionRepository();

    @Test
    void save() {

        S_Transaction s_transaction = new S_Transaction(1L,"1234567ABC","iAn57Hde",false,surveyRepository.findById(1));
        s_transactionRepository.save(s_transaction);


        Table table = new Table(Database.getDataSource(), "s_transaction");

        Assertions.assertThat(table).row(0)
                .value("t_transactionscode").isEqualTo("1234567ABC")
                .value("t_password").isEqualTo("iAn57Hde")
                .value("t_is_used").isEqualTo(false)
                .value("t_s_id").isEqualTo(1);
    }

    @Test
    void insert() {

        S_Transaction s_transaction = new S_Transaction(1L,"1234567ABC","iAn57Hde",false,surveyRepository.findById(1));

        Table table = new Table(Database.getDataSource(), "s_transaction");

        int rowsBefore = table.getRowsList().size();
        s_transactionRepository.insert(s_transaction);
        int rowsAfter = table.getRowsList().size();


        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);
    }

    @Test
    void delete() {


        S_Transaction s_transaction = new S_Transaction(1L,"1234567ABC","iAn57Hde",false,surveyRepository.findById(1));
        s_transactionRepository.insert(s_transaction);
        Table table = new Table(Database.getDataSource(), "s_transaction");

        int rowsBefore = table.getRowsList().size();
        s_transactionRepository.delete(s_transaction.gettId());
        int rowsAfter = table.getRowsList().size();

        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);

    }

    @Test
    @Order(4)
    void findAll() {

        int findAllRows = s_transactionRepository.findAll().size();


        Table table = new Table(Database.getDataSource(), "S_Transaction");

        int tableRows = table.getRowsList().size();

        org.assertj.core.api.Assertions.assertThat(findAllRows).isEqualTo(tableRows);
    }

    @Test
    @Order(5)
    void findById() {
        Table table = new Table(Database.getDataSource(), "S_Transaction");

        S_Transaction s_Transaction = s_transactionRepository.findById(2);

        String [] expected = {
                String.valueOf(s_Transaction.gettId()),
                s_Transaction.gettTransactionscode(),
                s_Transaction.gettPassword(),
                String.valueOf(s_Transaction.getIsUsed()),
                String.valueOf(s_Transaction.getSurvey().getsId())
        };

        String [] actual = {
                table.getRow(1).getValuesList().get(0).getValue().toString(),
                table.getRow(1).getValuesList().get(1).getValue().toString(),
                table.getRow(1).getValuesList().get(2).getValue().toString(),
                table.getRow(1).getValuesList().get(3).getValue().toString(),
                table.getRow(1).getValuesList().get(4).getValue().toString(),

        };

        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);
    }

}