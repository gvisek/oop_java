package lab5;

import java.util.Comparator;
import java.util.function.*;

public class EdibleQualityChecker {
    public static Predicate<Edible> edibleNotOlderThanThatIsOfType(Integer maxAge, EdibleType type){
        return edible ->{
            if(edible.getAge()<=maxAge && edible.getType()==type) return true;
            return false;
        };
    }
    public static Comparator<Edible> maxAgeComparator(){
        return (e1, e2)->{
          return e1.getAge().compareTo(e2.getAge());
        };
    }
    public static Comparator<Edible> nameComparator(){
        return Comparator.comparing(Edible::getName);
    }

}
