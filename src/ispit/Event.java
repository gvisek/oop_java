package ispit;

public abstract class Event {
    private String ime;
    private String location;
    private String date;

    public Event(String ime, String location, String date) {
        this.ime = ime;
        this.location = location;
        this.date = date;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
