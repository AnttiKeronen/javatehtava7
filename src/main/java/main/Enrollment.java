package main;

public class Enrollment {
    private Student student;
    private Course course;
    private int grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = -1; 
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

