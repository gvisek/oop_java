package lab2;

 class DatabaseStudent extends Student{
    private String studentId;
    public DatabaseStudent(String studentId,String firstName, String lastName, int coursePoints) {
        super(firstName, lastName, coursePoints);
        this.studentId=studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return getFirstName()+" "+getLastName()+": "+getCoursePoints()+", studentId: "+studentId;
    }
}
