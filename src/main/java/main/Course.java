package main;

class CourseImpl implements Course {
    private String courseName;
    private String courseID;
    private int maxStudents;

    public CourseImpl(String courseName, String courseID, int maxStudents) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.maxStudents = maxStudents;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public String getCourseID() {
        return courseID;
    }
    
    public int getMaxStudents() {
        return maxStudents;
    
    }
}
