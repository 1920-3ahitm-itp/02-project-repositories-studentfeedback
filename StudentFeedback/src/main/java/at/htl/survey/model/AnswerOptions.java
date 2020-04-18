package at.htl.survey.model;

public class AnswerOptions {

   private int  ao_id;
   private String ao_text;
   private int ao_value;
   private int  ao_q_id;

    public AnswerOptions(int ao_id, String ao_text, int ao_value, int ao_q_id) {
        this.ao_id = ao_id;
        this.ao_text = ao_text;
        this.ao_value = ao_value;
        this.ao_q_id = ao_q_id;
    }

    public int getAo_id() {
        return ao_id;
    }

    public void setAo_id(int ao_id) {
        this.ao_id = ao_id;
    }

    public String getAo_text() {
        return ao_text;
    }

    public void setAo_text(String ao_text) {
        this.ao_text = ao_text;
    }

    public int getAo_value() {
        return ao_value;
    }

    public void setAo_value(int ao_value) {
        this.ao_value = ao_value;
    }

    public int getAo_q_id() {
        return ao_q_id;
    }

    public void setAo_q_id(int ao_q_id) {
        this.ao_q_id = ao_q_id;
    }
}
