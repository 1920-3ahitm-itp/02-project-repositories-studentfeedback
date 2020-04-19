package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.Questionnaire;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static at.htl.survey.controller.Database.*;


public class QuestionRepository implements Persistent<Question>  {


    private DataSource dataSource = Database.getDataSource();

    @Override
    public void save(Question question) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE question SET q_text=?, q_type=?, q_qn_id=?  WHERE q_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, question.getQ_text());
            statement.setString(2, question.getQ_type());
            statement.setInt(3, question.getQ_qn_id());
            statement.setInt(4, question.getQ_id());


            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of QUESTION failed, no rows affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Question question) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public Question findById(int id) {
        return null;
    }
}