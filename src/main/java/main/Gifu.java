package main;

import java.util.ArrayList;
import java.util.List;


interface Course {
    String getCourseName();
    String getCourseID();
}

interface Student {
    String getStudentName();
    String getStudentID();
}

class Enrollment {
    public Student student;
    public Course course;
    public int grade;

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

public class Gifu {
    public String university;
    public List<Course> courses;
    public List<Student> students;
    public List<Enrollment> enrollments;

    public Gifu(String university) {
        this.university = university;
        courses = new ArrayList<>();
        students = new ArrayList<>();
        enrollments = new ArrayList<>();
    
    }
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }

    public List<Course> getCourses() {
        return courses;
    }


    public List<Student> getStudents() {
        return students;
        
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void setStudents(List<Student> students) {
        this.students = students;

    }
    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudentToCourse(Student student, Course course) {
        enrollments.add(new Enrollment(student, course));
    }

    public void setGradeForStudent(Student student, Course course, int grade) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course)) {
                enrollment.setGrade(grade);
                break;
            }
        }
    }

    public void listCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ") " + courses.get(i).getCourseID() + " " + courses.get(i).getCourseName());
        }
    }

    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ") " + students.get(i).getStudentID() + " " + students.get(i).getStudentName());
        }
    }

    public void listStudentsInCourse(Course course) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().equals(course)) {
                System.out.println(enrollment.getStudent().getStudentID() + " " + enrollment.getStudent().getStudentName());
            }
        }
    }

    public void listStudentGrades(Student student) {
        System.out.println("Opiskelijan " + student.getStudentID() + " arvosanat:");
        boolean hasGrades = false;
        for (Course course : courses) {
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course)) {
                    if (enrollment.getGrade() != -1) {
                        System.out.println(course.getCourseID() + " " + course.getCourseName() +
                                ", arvosana: " + enrollment.getGrade());
                        hasGrades = true;
                    }
                    break;
                }
            }
        }
        if (!hasGrades) {
            System.out.println("Opiskelijalla ei ole arvosanoja.");
        }
    }

    public void listAllGrades() {
        System.out.println("Kaikkien kurssien opiskelijoiden arvosanat:");
        for (Course course : courses) {
            System.out.println(course.getCourseID() + " " + course.getCourseName());
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getCourse().equals(course)) {
                    System.out.println(enrollment.getStudent().getStudentID() + " " + enrollment.getStudent().getStudentName()
                            + ", arvosana: " + enrollment.getGrade());
                }
            }
            
        }
    }
}