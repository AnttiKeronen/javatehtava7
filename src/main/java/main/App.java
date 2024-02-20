package main;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Gifu gifu = new Gifu();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Tervetuloa Gifu-järjestelmään");

        do {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, " +
                    "5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, " +
                    "8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Anna kurssin nimi: ");
                    scanner.nextLine();
                    String courseName = scanner.nextLine();
                    System.out.print("Anna kurssin ID: ");
                    String courseID = scanner.nextLine();
                    System.out.print("Anna kurssin maksimi opiskelijamäärä: ");
                    int maxStudents = scanner.nextInt();
                    gifu.addCourse(new CourseImpl(courseName, courseID, maxStudents));
                    break;
                case 2:
                    System.out.print("Anna opiskelijan nimi: ");
                    scanner.nextLine();
                    String studentName = scanner.nextLine();
                    System.out.print("Anna opiskelijan opiskelijanumero: ");
                    String studentID = scanner.nextLine();
                    gifu.addStudent(new StudentImpl(studentName, studentID));
                    break;
                case 3:
                    gifu.listCourses();
                    break;
                case 4:
                    gifu.listStudents();
                    break;
                case 5:
                    gifu.listCourses();
                    System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                    int courseNumber = scanner.nextInt();
                    gifu.listStudents();
                    System.out.print("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero: ");
                    int studentNumber = scanner.nextInt();
                    gifu.addStudentToCourse(gifu.getStudents().get(studentNumber), gifu.getCourses().get(courseNumber));
                    break;
                case 6:
                    gifu.listCourses();
                    System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero: ");
                    int courseNumberToGrade = scanner.nextInt();
                    Course selectedCourse = gifu.courses.get(courseNumberToGrade);
                    for (Student student : gifu.students) {
                        System.out.print("Anna arvosana opiskelijalle " + student.getStudentID() + " " + student.getStudentName() + ": ");
                        int grade = scanner.nextInt();
                        gifu.setGradeForStudent(student, selectedCourse, grade);
                    }
                    break;
                case 7:
                    gifu.listCourses();
                    System.out.print("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                    int courseNumberToList = scanner.nextInt();
                    gifu.listStudentsInCourse(gifu.courses.get(courseNumberToList));
                    break;
                case 8:
                    gifu.listStudents();
                    System.out.print("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero: ");
                    int studentNumberToGradeList = scanner.nextInt();
                    gifu.listStudentGrades(gifu.students.get(studentNumberToGradeList));
                    break;
                case 9:
                    gifu.listAllGrades();
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
