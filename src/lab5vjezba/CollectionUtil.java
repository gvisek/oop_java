package lab5vjezba;

import java.util.Collection;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class CollectionUtil {
    public static <T> T myFilterReduce(Collection<T> coll, T init, Predicate<T> pred, BinaryOperator<T> op){
        T temp=null;
        boolean flag=true;
        if(coll.isEmpty()) return init;
        for(T t:coll){
            if(pred.test(t)){
                if(flag){
                    temp=t;
                    flag=false;
                }
                else temp=op.apply(temp, t);
            }
        }
        return op.apply(init, temp);
    }
}
