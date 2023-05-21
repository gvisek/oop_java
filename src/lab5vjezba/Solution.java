package lab5vjezba;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.function.Predicate;

class Solution{

    public static Predicate<List<List<Integer>>> allDigitsMatch(double exemplar){
        return (al)->{
            for(List<Integer> list:al){
                if(list.get(1)!=((int)(exemplar*Math.pow(10, list.get(0)))%10)) return false;
            }
            return true;
        };
    }


    public static Predicate<List<List<Integer>>> allDigitsDefined(){
        return new Predicate<>() {
            ArrayList<Integer> al = new ArrayList<>();

            @Override
            public boolean test(List<List<Integer>> lists) {
                for (List<Integer> list : lists) {
                    al.add(list.get(0));
                }
                al.sort(Comparator.comparingInt(i -> i));
                for (int i = 1; i < al.size(); i++) {
                    if (al.get(i) - al.get(i - 1) != 1) return false;
                }
                return true;
            }
        };
    }

}