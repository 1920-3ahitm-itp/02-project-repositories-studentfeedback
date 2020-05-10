package at.htl.survey.model;

import java.time.LocalDate;
import java.util.Date;

public class Survey {


    private int s_id;
   private String s_creator;
   private int s_qn_id;
   private Date s_date;


    public Survey(int s_id,String s_creator, int s_qn_id, Date s_date) {
        this.s_creator = s_creator;
        this.s_qn_id = s_qn_id;
        this.s_date = s_date;
        this.s_id = s_id;
    }

    public String getS_creator() {
        return s_creator;
    }

    public void setS_creator(String s_creator) {
        this.s_creator = s_creator;
    }

    public int getS_qn_id() {
        return s_qn_id;
    }

    public void setS_qn_id(int s_qn_id) {
        this.s_qn_id = s_qn_id;
    }

    public Date getS_date() {
        return s_date;
    }

    public void setS_date(Date s_date) {
        this.s_date = s_date;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }
}
