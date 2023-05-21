package ispit;

public class Manager extends Person{
    private Band managingBand;

    public Manager(String name, String country, int age, Band managingBand) {
        super(name, country, age);
        this.managingBand = managingBand;
    }
    public void kickBandMember(Musician musician){
        Musician[] temp=new Musician[managingBand.getBandMembers().length-1];
        int i=0;
        for(Musician m:managingBand.getBandMembers()){
            if(m!=musician){
                temp[i]=m;
                i++;
            }
        }
        managingBand.setBandMembers(temp);
    }
}
