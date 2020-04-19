package at.htl.survey.controller;

import at.htl.survey.model.Questionnaire;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static at.htl.survey.controller.Database.*;

public class QuestionnaireRepository implements Persistent<Questionnaire>{

  private DataSource dataSource = Database.getDataSource();

  @Override
  public void save(Questionnaire questionnaire) {

    try (Connection connection = dataSource.getConnection()) {
      String sql = "UPDATE questionnaire SET qn_description=? WHERE qn_id=  "+ questionnaire.getQn_id();

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
      String sql = "DELETE FROM questionnaire WHERE qn_id=" + id;

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
  public List findAll() {
    return null;
  }

  @Override
  public Questionnaire findById(int id) {
    return null;
  }
}
