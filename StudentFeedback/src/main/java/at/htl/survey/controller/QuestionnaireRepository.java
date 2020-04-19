package at.htl.survey.controller;

import at.htl.survey.model.Question;
import at.htl.survey.model.Questionnaire;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static at.htl.survey.controller.Database.*;

public class QuestionnaireRepository implements Persistent<Questionnaire> {

    private DataSource dataSource = Database.getDataSource();

    @Override
    public void save(Questionnaire questionnaire) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE questionnaire SET qn_description=? WHERE qn_id=  " + questionnaire.getQn_id();

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
    public void delete(int id) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM questionnaire WHERE qn_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Delete from QUESTIONNAIRE failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insert(Questionnaire questionnaire) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO questionnaire (qn_description) VALUES (?)";

            PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, questionnaire.getQn_description());


          if (statement.executeUpdate() == 0) {
            throw new SQLException("Update of QUESTIONNAIRE failed, no rows affected");
          }


            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    questionnaire.setQn_id(keys.getInt(1));
                } else {
                    throw new SQLException("Insert into QUESTIONNAIRE failed, no ID obtained");
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findAll() {



        List<Questionnaire> questionnaireList = new ArrayList<>();


        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM questionnaire";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("QN_ID");
                String description = result.getString("QN_DESCRIPTION");
                questionnaireList.add(new Questionnaire(id,description));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionnaireList;
    }

    //SELECT * FROM questionnaire WHERE id=?
    //SELECT * FROM questionnaire
    @Override
    public Questionnaire findById(int id) {
        return null;
    }
}
