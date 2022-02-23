package epam.advanced.practice3.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangedOpsIntegerSet implements IntegerSet, Iterable<Integer> {
    public static void main(String[] args) {
        System.out.println("First example");
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        set.add(1, 5);
        for(Integer el : set) {
            System.out.println(el);
        }
        System.out.println("Second example");
        RangedOpsIntegerSet set2 = new RangedOpsIntegerSet();
        set2.add(1, 5);
        set2.add(9, 11);
        for(Integer el : set2){
            System.out.println(el);
        }
        System.out.println("Third example");
        RangedOpsIntegerSet set3 = new RangedOpsIntegerSet();
        set3.add(1, 15);
        set3.remove(3, 12);
        for(Integer el : set3){
            System.out.println(el);
        }
    }
    private Node head;

    @Override
    public boolean add(Integer number) {
        if (head == null) {
            head = new Node(number);
            return true;
        }
        if (search(number) != null)
            return false;

        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new Node(number);
        return true;
    }

    public Integer search(Integer element) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.equals(element)) {
                return cur.data;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean remove(Integer element) {
        if (head == null)
            throw new IllegalCallerException("Set is empty");
        if (head.data.equals(element)) {
            head = head.next;
            return true;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data.equals(element)) {
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean add(int fromInclusive, int toExclusive) {
        boolean anyAdded = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            anyAdded =(add(i) || anyAdded);
        }
        return anyAdded;
    }

    @Override
    public boolean remove(int fromInclusive, int toExclusive) {
        boolean anyRemoved = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            anyRemoved = remove(i) || anyRemoved;
        }
        return anyRemoved;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    @Override
    public int size() {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    class IteratorImpl implements Iterator<Integer> {
        private Node node = new Node(null, head);

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                node = node.next;
                return node.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            RangedOpsIntegerSet.this.remove(node.data);
        }
    }

    private static class Node {
        Integer data;
        Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Integer data) {
            this(data, null);
        }
    }
}
