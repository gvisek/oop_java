package lab5vjezba;

import org.jetbrains.annotations.NotNull;

import java.text.Collator;
import java.util.*;

public class MyPlayer extends Player implements Iterable<Game>{
    private Map<Game, ArrayList<Integer>> gameScores;
    protected MyPlayer(String name) {
        super(name);
        gameScores=new HashMap();
    }

    @Override
    void addGameScore(Game game, int score) {
        if(gameScores.containsKey(game)) gameScores.get(game).add(score);
        else{
            gameScores.put(game, new ArrayList<>());
            gameScores.get(game).add(score);
        }
    }

    @Override
    Iterable<Integer> getScores(Game game) {
        return gameScores.get(game);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Game)) return false;
        Game g=(Game) obj;
        if(this.getName().equals(g.getName()))return true;
        return false;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }


    @Override
    public Iterator<Game> iterator() {
        return gameScores.keySet().stream().sorted((s1,s2)->s1.getName().compareTo(s2.getName())).iterator();
    }


}
