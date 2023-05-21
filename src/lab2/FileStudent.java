package lab2;

 class FileStudent extends Student{
    private int lineNumber;
    public FileStudent(int lineNumber,String firstName, String lastName, int coursePoints) {
        super(firstName, lastName, coursePoints);
        this.lineNumber=lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return getFirstName()+" "+getLastName()+": "+getCoursePoints()+", lineNumber: "+lineNumber;
    }
}
