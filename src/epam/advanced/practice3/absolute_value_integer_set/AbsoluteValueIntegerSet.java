package epam.advanced.practice3.absolute_value_integer_set;

import java.util.*;

public class AbsoluteValueIntegerSet implements Set<Integer> {
    public static void main(String[] args) {
        AbsoluteValueIntegerSet set = new AbsoluteValueIntegerSet();
        set.add(8);
        set.add(6);
        set.add(10);
        set.add(7);
        set.add(7);
        set.add(9);
        set.remove(6);
        set.remove(10);
        var list = new ArrayList<Integer>();
        for (int i = 6; i < 12; i++) {
            list.add(i);
        }
        set.addAll(list);
        for (var sell : set) {
            System.out.println(sell);
        }
    }

    private Node head;

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

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
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
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        if (isEmpty()) {
            head = new Node(integer);
            return true;
        }
        if (Math.abs(head.data) == Math.abs(integer))
            return false;
        if (Math.abs(head.data) > Math.abs(integer)) {
            head = new Node(integer, head);
            return true;
        }
        Node cur = head;
        while (cur.next != null) {
            if (Math.abs(cur.next.data) == Math.abs(integer)) {
                return false;
            }
            if (Math.abs(cur.next.data) > Math.abs(integer)) {
                cur.next = new Node(integer, cur.next);
                return true;
            }
            cur = cur.next;
        }
        cur.next = new Node(integer);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            throw new IllegalCallerException("List is empty");
        if (head.data.equals(o)) {
            head = head.next;
            return true;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data.equals(o)) {
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public Integer search(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o))
                return current.data;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean anyAdded = false;
        for (var sell : c) {
            anyAdded = add(sell) || anyAdded;
        }
        return anyAdded;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
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
