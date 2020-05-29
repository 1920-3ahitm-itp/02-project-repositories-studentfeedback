package at.htl.survey.model;

import java.time.LocalDate;
import java.util.Date;

public class Survey {

/*    private int s_id;
   private String s_creator;
   private int s_qn_id;
   private Date s_date;*/

    private Long sId;
    private String sCreator;
    private Questionnaire questionnaire;
    private Date sDate;


    public Survey(Long sId, String sCreator, Questionnaire questionnaire, Date sDate) {

        this.sId = sId;
        this.sCreator = sCreator;
        this.questionnaire = questionnaire;
        this.sDate = sDate;
    }
    public Survey(){

    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getsCreator() {
        return sCreator;
    }

    public void setsCreator(String sCreator) {
        this.sCreator = sCreator;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }
}
