package lab2;

 class Student {
    private String firstName;
    private String lastName;
    private int coursePoints;

    public Student(String firstName, String lastName, int coursePoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.coursePoints = coursePoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCoursePoints() {
        return coursePoints;
    }

    public void setCoursePoints(int coursePoints) {
        this.coursePoints = coursePoints;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName+": "+coursePoints;
    }
}
