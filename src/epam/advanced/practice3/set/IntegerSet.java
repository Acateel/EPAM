package epam.advanced.practice3.set;

import java.util.Iterator;

public interface IntegerSet {
    boolean add(Integer number);
    boolean remove(Integer number);
    boolean add(int fromInclusive, int toExclusive);
    boolean remove(int fromInclusive, int toExclusive);
    Iterator<Integer> iterator();
    int size();
}
