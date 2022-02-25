package epam.advanced.practice3.special_collections;

import java.util.*;

public class SpecialCollections implements Collection<String> {
    public static void main(String[] args) {
        SpecialCollections collections = new SpecialCollections();
        collections.add("first");
        collections.add("second");
        collections.add("added", 0);

        List<String> list = new ArrayList<>();
        list.add("Third");
        list.add("Forth");
        list.add("Fifth");
        collections.addAll(list);

        collections.remove("added");
        collections.removeOf(0);
        collections.set(6, "changed");
        for(var sell : collections){
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
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private Node node = new Node(null, head);

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public String next() {
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
    public boolean add(String s) {
        if (isEmpty()) {
            head = new Node(s, new Node(s));
        } else {
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = new Node(s, new Node(s));
        }
        return true;
    }

    public boolean add(String s, int index) {
        if (index > size() || index < 0) {
            return false;
        }
        if(index == 0){
            head = new Node(s, new Node(s, head));
            return true;
        }
        if(index % 2 == 1)
            index++;

        int currentIndex = 1;
        Node current = head;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        current.next = new Node(s, new Node(s, current.next));
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            throw new IllegalCallerException("List is empty");

        if (head.data.equals(o)) {
            head = head.next.next;
            return true;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data.equals(o)) {
                cur.next = cur.next.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean removeOf(int index){
        if (index >= size() || index < 0) {
            return false;
        }
        if(index < 2){
            head = head.next.next;
            return true;
        }
        if(index % 2 == 1)
            index--;

        int currentIndex = 1;
        Node current = head;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        current.next = current.next.next.next;
        return true;
    }

    public String get(int index){
        if(index >= size() || index < 0){
            return null;
        }
        int currentIndex = 0;
        Node current = head;
        while ( currentIndex != index){
            current = current.next;
            currentIndex++;
        }
        return current.data;
    }

    public boolean set(int index, String s){
        if(index >= size() || index < 0){
            return false;
        }
        if(index == 0){
            head.data = s;
            head.next.data = s;
            return true;
        }
        if(index % 2 == 1)
            index--;

        int currentIndex = 0;
        Node current = head;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        current.data = s;
        current.next.data = s;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        for(var sell : c){
            add(sell);
        }
        return true;
    }

    public boolean addAllOf(Collection<? extends String> c, int index){
        for(var sell : c){
            add(sell, index);
            index += 2;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    private static class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(String data) {
            this(data, null);
        }
    }
}
