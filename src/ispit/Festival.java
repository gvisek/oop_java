package ispit;

public class Festival extends Event implements EventPromoter{
    private Band[] bandList;

    public Festival(String ime, String location, String date, Band[] bandList) {
        super(ime, location, date);
        this.bandList = bandList;
    }

    public Band[] getBandList() {
        return bandList;
    }

    public void setBandList(Band[] bandList) {
        this.bandList = bandList;
    }

    @Override
    public void printEventPoster() {
        int i=1;
        System.out.println("Event date: "+ getDate());
        System.out.println("Band: "+getIme());
        System.out.println("Band list for the festival is:");
        for(Band b:bandList){
            System.out.println("Band "+i+": "+getBandList()[i-1].getBandName());
            i++;
        }
    }
}
