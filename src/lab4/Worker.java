package lab4;

public class Worker {
    private String id;
    private String name;
    private int yearOfExperience;

    public Worker(String id, String name, int yearOfExperience) {
        super();
        this.id = id;
        this.name = name;
        this.yearOfExperience = yearOfExperience;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getYearOfExperience() {
        return yearOfExperience;
    }
}
