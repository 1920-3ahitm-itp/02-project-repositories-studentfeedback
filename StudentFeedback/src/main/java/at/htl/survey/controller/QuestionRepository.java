package at.htl.survey.controller;

import at.htl.survey.model.Questionnaire;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static at.htl.survey.controller.Database.*;


public class QuestionRepository implements Persistent<Questionnaire> {

    private DataSource dataSource = Database.getDataSource();


    public void save(Questionnaire questionnaire) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE questionnaire SET qn_discription=? WHERE qn_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, questionnaire.getQn_description());


            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of QUESTIONNAIRE failed, no rows affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Questionnaire findById(long id) {
        return null;
    }

}
