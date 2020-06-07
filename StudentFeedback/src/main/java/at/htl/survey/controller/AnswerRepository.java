package at.htl.survey.controller;

import at.htl.survey.model.Answer;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class AnswerRepository implements Persistent<Answer>{

    private DataSource dataSource = Database.getDataSource();

    @Override
    public void save(Answer answer) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE answer SET  a_t_id=?, a_q_id=?, a_s_id=?, a_answer_text=? WHERE a_id=?  " + answer.getaId();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, answer.getS_transaction().gettId());
            statement.setLong(2,answer.getQuestion().getqId());
            statement.setLong(3, answer.getSurvey().getsId());
            statement.setString(4, answer.getAnswerText());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of ANSWER failed, no rows affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Answer answer) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO answer  (a_t_id, a_q_id, a_s_id, a_answer_text) VALUES (?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, answer.getA_t_id());
            statement.setInt(2, answer.getA_q_id());
            statement.setInt(3, answer.getA_s_id());
            statement.setString(4, answer.getA_answer_text());


            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of ANSWER failed, no rows affected");
            }


            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    answer.setA_id(keys.getInt(1));
                } else {
                    throw new SQLException("Insert into ANSWER failed, no ID obtained");
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM answer  WHERE a_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Delete from ANSWER failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Answer> findAll() {
        return null;
    }

    @Override
    public Answer findById(int id) {
        return null;
    }
}
