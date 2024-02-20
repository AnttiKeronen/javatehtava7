package main;

class StudentImpl implements Student {
    private String studentName;
    private String studentID;

    public StudentImpl(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    @Override
    public String getStudentName() {
        return studentName;
    }

    @Override
    public String getStudentID() {
        return studentID;
    }
}
