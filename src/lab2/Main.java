package lab2;

public class Main {
    public static void main(String[] args){

        StudentFactory factory = new FileStudentFactory();
        System.out.println(factory.createStudent("Pero", "Perić", 3));

        factory = new DatabaseStudentFactory();
        System.out.println(factory.createStudent("Ana", "Anić", 5));

    }
}
