package at.htl.survey.model;

public class Questionnaire {

    private Question question;
    private String answer;
    private Teacher teacher;
    private String subject;

    public Questionnaire(Question  question, String answer, Teacher teacher, String  subject) {
        this.question = question;
        this.answer = answer;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
