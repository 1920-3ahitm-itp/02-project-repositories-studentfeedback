package at.htl.survey.model;

public class Answer {

    private int a_id;
    private int a_t_id;
    private int a_q_id;
    private int  a_s_id;
    private String a_answer_text;

    public Answer(int a_id, int a_t_id, int a_q_id, int a_s_id, String a_answer_text) {
        this.a_id = a_id;
        this.a_t_id = a_t_id;
        this.a_q_id = a_q_id;
        this.a_s_id = a_s_id;
        this.a_answer_text = a_answer_text;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getA_t_id() {
        return a_t_id;
    }

    public void setA_t_id(int a_t_id) {
        this.a_t_id = a_t_id;
    }

    public int getA_q_id() {
        return a_q_id;
    }

    public void setA_q_id(int a_q_id) {
        this.a_q_id = a_q_id;
    }

    public int getA_s_id() {
        return a_s_id;
    }

    public void setA_s_id(int a_s_id) {
        this.a_s_id = a_s_id;
    }

    public String getA_answer_text() {
        return a_answer_text;
    }

    public void setA_answer_text(String a_answer_text) {
        this.a_answer_text = a_answer_text;
    }
}
