package lab5vjezba;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FactorialIterator implements Iterator<Integer> {
    private int counter;
    private int i;

    public FactorialIterator(int counter) {
        if(counter<0) throw new IllegalArgumentException();
        this.counter = counter;
        i=0;

    }

    @Override
    public boolean hasNext() {
        if(i<counter){return true;}
        return false;
    }
    private int factorial(int number){
        int temp=1;
        for(int i=1;i<=number;i++){
            temp*=i;
        }
        return temp;
    }
    @Override
    public Integer next() {
        if(!hasNext())
            throw new NoSuchElementException();
        i++;
        if(i-1==0) return 1;
        return factorial(i-1);
    }
}
