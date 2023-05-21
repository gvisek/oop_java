package lab5;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Edible potato = new Edible(EdibleType.VEGETABLE, "Potato", 2);
        Edible kiwi = new Edible(EdibleType.FRUIT, "Kiwi", 3);

        List<Edible> edibles = new ArrayList<>(List.of(potato, kiwi));

        List<Edible> filteredEdibles = edibles.stream()
                .filter(EdibleQualityChecker.edibleNotOlderThanThatIsOfType(4, EdibleType.FRUIT))
                .collect(
                        Collectors.toList()
                );

        System.out.println(filteredEdibles); //[Edible{name='Kiwi'}]

        List<Edible> ediblesByName = new ArrayList<>(List.of(potato, kiwi));
        ediblesByName.sort(EdibleQualityChecker.nameComparator());
        System.out.println(ediblesByName); //[Edible{name='Kiwi'}, Edible{name='Potato'}]

        List<Edible> ediblesByAge = new ArrayList<>(List.of(potato, kiwi));
        ediblesByAge.sort(EdibleQualityChecker.maxAgeComparator());
        System.out.println(ediblesByAge); //[Edible{name='Potato'}, Edible{name='Kiwi'}]
    }
}
