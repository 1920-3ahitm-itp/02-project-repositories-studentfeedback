package at.htl.survey.controller;

import at.htl.survey.model.AnswerOptions;
import at.htl.survey.model.Question;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerOptionsRepository implements Persistent<AnswerOptions> {

    private DataSource dataSource = Database.getDataSource();

    @Override
    public void save(AnswerOptions answerOptions) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE answer_option SET ao_text=?, ao_value=?, ao_q_id=?  WHERE ao_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, answerOptions.getAo_text());
            statement.setInt(2, answerOptions.getAo_value());
            statement.setInt(3, answerOptions.getAo_q_id());
            statement.setInt(4, answerOptions.getAo_id());



            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of ANSWER_OPTIONS failed, no rows affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(AnswerOptions answerOptions) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO answer_option (ao_text,ao_value,ao_q_id) VALUES (?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, answerOptions.getAo_text());
            statement.setInt(2, answerOptions.getAo_value());
            statement.setInt(3, answerOptions.getAo_q_id());


            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of ANSWER_OPTIONS failed, no rows affected");
            }


            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    answerOptions.setAo_id(keys.getInt(1));
                } else {
                    throw new SQLException("Insert into ANSWER_OPTIONS failed, no ID obtained");
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM answer_option WHERE ao_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Delete from answer_option failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<AnswerOptions> findAll() {

        List<AnswerOptions> anwerOptionList = new ArrayList<>();


        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM answer_option";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("AO_ID");
                String text = result.getString("AO_TEXT");
                int value = result.getInt("AO_VALUE");
                int ao_q_id = result.getInt("AO_Q_ID");
                anwerOptionList.add(new AnswerOptions(id,text,value,ao_q_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anwerOptionList;
    }

    @Override
    public AnswerOptions findById(int id) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM answer_option WHERE ao_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();



            while (result.next()) {

                return new AnswerOptions(result.getInt("AO_ID"), result.getString("AO_TEXT"), result.getInt("AO_VALUE"), result.getInt("AO_Q_ID"));
              
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
