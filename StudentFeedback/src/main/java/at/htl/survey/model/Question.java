package at.htl.survey.model;

public class Question {

   private int q_id;
   private String q_text;
   private String q_type;
   private int q_qn_id;


    public Question(int q_id, String q_text, String q_type, int q_qn_id) {
        this.q_id = q_id;
        this.q_text = q_text;
        this.q_type = q_type;
        this.q_qn_id = q_qn_id;
    }

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getQ_text() {
        return q_text;
    }

    public void setQ_text(String q_text) {
        this.q_text = q_text;
    }

    public String getQ_type() {
        return q_type;
    }

    public void setQ_type(String q_type) {
        this.q_type = q_type;
    }

    public int getQ_qn_id() {
        return q_qn_id;
    }

    public void setQ_qn_id(int q_qn_id) {
        this.q_qn_id = q_qn_id;
    }
}
