package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.Survey;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SurveyRepository implements Persistent<Survey>{

    private DataSource dataSource = Database.getDataSource();
    @Override
    public void save(Survey survey) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE survey  SET s_creator=?, s_qn_id=?, s_date=? WHERE s_id=  " + survey.getS_id();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, survey.getS_creator());
            statement.setInt(2, survey.getS_qn_id());
            statement.setDate(3, (Date) survey.getS_date());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of SURVEY failed, no rows affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Survey survey) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO survey (s_creator,s_qn_id,s_date) VALUES (?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, survey.getS_creator());
            statement.setInt(2, survey.getS_qn_id());
            statement.setDate(3, (Date) survey.getS_date());///!!!


            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of SURVEY failed, no rows affected");
            }


            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    survey.setS_id(keys.getInt(1));
                } else {
                    throw new SQLException("Insert into SURVEY failed, no ID obtained");
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM survey WHERE s_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Delete from SURVEY failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Survey> findAll() {


        List<Survey> surveyList = new ArrayList<>();


        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM survey";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int s_id = result.getInt("s_id");
                String s_creator = result.getString("s_creator");
                int s_qn_id = result.getInt("s_qn_id");
                Date s_date = result.getDate("s_date");
                surveyList.add(new Survey(s_id,s_creator,s_qn_id,s_date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return surveyList;
    }

    @Override
    public Survey findById(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM survey WHERE s_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();



            while (result.next()) {

                return new Survey(result.getInt("s_id"), result.getString("s_creator"), result.getInt("s_qn_id"), result.getDate("s_date"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
