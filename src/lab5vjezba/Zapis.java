package lab5vjezba;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

class Zapis implements Comparable<Zapis>{
    String ime;
    Integer bodovi;

    public Zapis(String ime, Integer bodovi) {
        this.ime = ime;
        this.bodovi = bodovi;
    }

    public String toString() {
        return this.ime + ":" + this.bodovi;
    }

    @Override
    public int compareTo(Zapis o) {
        return this.ime.compareTo(o.ime);
    }

    // Dovršiti

}
