package lab2;

 class FileStudentFactory implements StudentFactory{
    @Override
    public FileStudent createStudent(String firstName, String lastName, int coursePoints) {
        return new FileStudent(5, firstName,lastName,coursePoints);
    }
}
