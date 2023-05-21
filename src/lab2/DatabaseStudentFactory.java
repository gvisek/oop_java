package lab2;

class DatabaseStudentFactory implements StudentFactory{
    @Override
    public DatabaseStudent createStudent(String firstName, String lastName, int coursePoints) {
        return new DatabaseStudent("some id" ,firstName, lastName, coursePoints);
    }
}
