package at.htl.survey.model;

public class Student {

    private int id;
    private String schoolClasses;

    public Student(int id, String schoolClasses) {
        this.id = id;
        this.schoolClasses = schoolClasses;
    }

    public String getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(String schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
