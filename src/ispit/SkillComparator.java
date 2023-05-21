package ispit;

import java.util.Comparator;

public class SkillComparator implements Comparator<Musician> {
    @Override
    public int compare(Musician o1, Musician o2) {
        if(o1.getSkill()<o2.getSkill()){
            return -1;
        }else if(o1.getSkill()==o2.getSkill()){
            return 0;
        }else return 1;
    }
}
