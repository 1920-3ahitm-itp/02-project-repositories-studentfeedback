package at.htl.survey.model;

public class Questionnaire {

    private int qn_id;
    private String qn_descripton;

    public Questionnaire(int qn_id, String qn_description) {
        this.qn_id = qn_id;
        this.qn_descripton = qn_description;
    }

    public int getQn_id() {
        return qn_id;
    }

    public void setQn_id(int qn_id) {
        this.qn_id = qn_id;
    }

    public String getQn_description() {
        return qn_descripton;
    }

    public void setQn_description(String qn_description) {
        this.qn_descripton = qn_description;
    }
}
