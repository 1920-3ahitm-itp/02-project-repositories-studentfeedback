package at.htl.survey.model;

import java.time.LocalDate;

public class Survey {


   private String s_creator;
   private int s_qn_id;
   private LocalDate s_date;
   private int a_id;

    public Survey(String s_creator, int s_qn_id, LocalDate s_date, int a_id) {
        this.s_creator = s_creator;
        this.s_qn_id = s_qn_id;
        this.s_date = s_date;
        this.a_id = a_id;
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

    public LocalDate getS_date() {
        return s_date;
    }

    public void setS_date(LocalDate s_date) {
        this.s_date = s_date;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }
}
