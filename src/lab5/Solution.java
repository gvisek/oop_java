package lab5;

import java.util.*;
import java.util.function.*;

public class Solution {

    public static Predicate<Pokemon> pokemonWithAllMovesStrongerThan(int power){
        return (pokemon)->{
            for(Move m: pokemon.getMoves()){
                if(m.getPower()<power) return false;
            }
            return true;
        };
    }
    public static Predicate<Pokemon> pokemonWithSpecificMove(Move move){
        return (pokemon)->{
            for(Move m:pokemon.getMoves()){
                if(m.getName().equals(move.getName())) return true;
            }
            return false;
        };
    }
}
