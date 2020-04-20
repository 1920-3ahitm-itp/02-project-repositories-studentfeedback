package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.Questionnaire;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO question (q_text,q_type,q_qn_id) VALUES (?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, question.getQ_text());
            statement.setString(2, question.getQ_type());
            statement.setInt(3, question.getQ_qn_id());


            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of QUESTION failed, no rows affected");
            }


            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    question.setQ_id(keys.getInt(1));
                } else {
                    throw new SQLException("Insert into QUESTION failed, no ID obtained");
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM question WHERE qn_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Delete from QUESTION failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Question> findAll() {

        List<Question> questionList = new ArrayList<>();


        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM question";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("Q_ID");
                String text = result.getString("Q_TEXT");
                String type = result.getString("Q_TYPE");
                int q_qn_id = result.getInt("Q_QN_ID");
                questionList.add(new Question(id,text,type,q_qn_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    @Override
    public Question findById(int id) {
        return null;
    }
}