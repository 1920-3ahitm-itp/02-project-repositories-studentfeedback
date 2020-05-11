package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.S_Transaction;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

public class S_TransactionRepositoryTest {
    @Test
    void save() {
        S_TransactionRepository s_transactionRepository = new S_TransactionRepository();

        S_Transaction s_transaction = new S_Transaction(1,"1234567ABC","iAn57Hde",false,1);
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
        S_TransactionRepository s_transactionRepository = new S_TransactionRepository();

        S_Transaction s_transaction = new S_Transaction(1,"1234567ABC","iAn57Hde",false,1);

        Table table = new Table(Database.getDataSource(), "s_transaction");

        int rowsBefore = table.getRowsList().size();
        s_transactionRepository.insert(s_transaction);
        int rowsAfter = table.getRowsList().size();


        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);
    }

    @Test
    void delete() {

        S_TransactionRepository s_transactionRepository = new S_TransactionRepository();

        S_Transaction s_transaction = new S_Transaction(1,"1234567ABC","iAn57Hde",false,1);
        s_transactionRepository.insert(s_transaction);
        Table table = new Table(Database.getDataSource(), "s_transaction");

        int rowsBefore = table.getRowsList().size();
        s_transactionRepository.delete(rowsBefore - 1);
        int rowsAfter = table.getRowsList().size();

        org.assertj.core.api.Assertions.assertThat(rowsBefore).isEqualTo(rowsAfter);


    }
}
