package at.htl.survey.model;

public class S_Transaction {

    private int t_id;
    private String t_transactionscode;
    private String t_password;
    private boolean t_is_used;
    private int t_s_id;

    public S_Transaction(int t_id, String t_transactionscode, String t_password, boolean t_is_used, int t_s_id) {
        this.t_id = t_id;
        this.t_transactionscode = t_transactionscode;
        this.t_password = t_password;
        this.t_is_used = t_is_used;
        this.t_s_id = t_s_id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_transactionscode() {
        return t_transactionscode;
    }

    public void setT_transactionscode(String t_transactionscode) {
        this.t_transactionscode = t_transactionscode;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public boolean isT_is_used() {
        return t_is_used;
    }

    public void setT_is_used(boolean t_is_used) {
        this.t_is_used = t_is_used;
    }

    public int getT_s_id() {
        return t_s_id;
    }

    public void setT_s_id(int t_s_id) {
        this.t_s_id = t_s_id;
    }
}
