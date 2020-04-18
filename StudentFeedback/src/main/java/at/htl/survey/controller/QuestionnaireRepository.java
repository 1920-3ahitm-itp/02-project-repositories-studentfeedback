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


    try (Connection conn = DriverManager.getConnection(URL,USERNAME, PASSWORD)) {

      String sql = "INSERT INTO questionnaire (qn_description) " +
              "VALUES (?)";
      try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1,questionnaire.getQn_description());
        pstmt.executeUpdate();

      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
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
