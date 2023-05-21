package ispit;

public class Concert extends Event implements EventPromoter{
    private Band playingband;
    private String[] songList;

    public Concert(String ime, String location, String date, Band playingband, String[] songList) {
        super(ime, location, date);
        this.playingband = playingband;
        this.songList = songList;
    }

    public Band getPlayingband() {
        return playingband;
    }

    public void setPlayingband(Band playingband) {
        this.playingband = playingband;
    }

    public String[] getSongList() {
        return songList;
    }

    public void setSongList(String[] songList) {
        this.songList = songList;
    }

    @Override
    public void printEventPoster() {
        int i=1;
        System.out.println("Event date: "+ getDate());
        System.out.println("Band: "+getPlayingband().getBandName());
        System.out.println("Song list for this concert is:");
        for(String s:songList){
            System.out.println("Song "+i+": "+songList[i-1]);
            i++;
        }
    }
}
