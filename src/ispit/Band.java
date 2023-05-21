package ispit;

import java.util.Arrays;

public class Band {
    private Musician[] bandMembers;
    private String bandName;

    public Band(Musician[] bandMembers, String bandName) {
        this.bandMembers = bandMembers;
        this.bandName = bandName;
    }

    public Musician[] getBandMembers() {
        return bandMembers;
    }

    public void setBandMembers(Musician[] bandMembers) {
        this.bandMembers = bandMembers;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
    public String printMembers(){
        StringBuilder sb=new StringBuilder();
        int i=0;
        for(Musician m:bandMembers){
            if (i == bandMembers.length-1) {
                sb.append((m.getName()));
            }
            else sb.append(m.getName()+", ");
            i++;
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Members of the band " +bandName+" are: "+ this.printMembers();
    }
}
