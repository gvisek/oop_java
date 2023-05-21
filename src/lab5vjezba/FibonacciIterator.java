package lab5vjezba;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private int counter;
    private int i;
    private int first;
    private int second;
    public FibonacciIterator(int counter) {
        if(counter<0) throw new IllegalArgumentException();
        this.counter = counter;
        i=0;
        first=0;
        second=1;
    }

    @Override
    public boolean hasNext() {
        if(i<counter) return true;
        return false;
    }

    @Override
    public Integer next() {
        if(!hasNext())
            throw new NoSuchElementException();
        int temp=first;
        if(i==0){i++; return first;}
        else if (i==1){i++; return second;}
        temp+=second;
        first=second;
        second=temp;
        i++;
        return temp;
    }
}
