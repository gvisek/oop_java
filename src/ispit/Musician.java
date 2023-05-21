package ispit;

public class Musician extends Person{
    private Integer skill;
    private BandPosition bandPosition;

    public Musician(String name, String country, int age,  BandPosition bandPosition, Integer skill) {
        super(name, country, age);
        this.skill = skill;
        this.bandPosition = bandPosition;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public BandPosition getBandPosition() {
        return bandPosition;
    }

    public void setBandPosition(BandPosition bandPosition) {
        this.bandPosition = bandPosition;
    }
    public void trainForOneYear(){
        skill++;
        setAge(getAge()+1);
    }
}
