package lab5vjezba;

import java.util.*;

class LabTask {
    public static Collection<Zapis> readData() {
        Scanner sc=new Scanner(System.in);
        Set<Zapis> set=new TreeSet<>();
        while(!sc.hasNext("quit")){
            String[] logs=sc.nextLine().split("#");
            Zapis zapis=new Zapis(logs[0], Integer.parseInt(logs[1]));
            if(set.contains(zapis))set.remove(zapis);
            set.add(zapis);
        }
        return set;
    }
}
