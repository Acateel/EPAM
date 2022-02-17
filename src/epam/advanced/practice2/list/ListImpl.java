package epam.advanced.practice2.list;

import epam.advanced.practice2.data.City;
import epam.advanced.practice2.data.CityHelper;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListImpl implements List {
    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        City china = new City();
        try {
            City[] cities = (City[]) CityHelper.readToXml(CityHelper.getPathXmlFile());
            for (City city : cities) {
                list.addFirst(city);
                if (Objects.equals(city.getName(), "China")) {
                    china = city;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading finish");
        System.out.println(list);

        System.out.println("Add last");
        list.addLast(new City());
        System.out.println(list);

        System.out.println("Remove first and last");
        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        System.out.println("First");
        System.out.println(list.getFirst());

        System.out.println("Last");
        System.out.println(list.getLast());

        System.out.println("Search");
        System.out.println(list.search(china));
        System.out.println("Search");
        System.out.println(list.search(new City()));

        System.out.println("Remove china");
        System.out.println((list.remove(china) ? "true" : "false"));
        System.out.println("Remove russia");
        System.out.println((list.remove(new City("Russia", 0,0)) ? "true" : "false"));
        System.out.println(list);

        System.out.println("Size -> " + list.size());

        var iterator = list.iterator();
        while (iterator.hasNext()){
            City city = (City)iterator.next();
            System.out.println(city.getName());
            if(city.getName().equals("Canada")){
                System.out.println("Delete Canada");
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private Node head;

    @Override
    public void addFirst(Object element) {
        if (head == null) {
            head = new Node(element);
        } else {
            head = new Node(element, head);
        }
    }

    @Override
    public void addLast(Object element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = new Node(element);
        }
    }

    @Override
    public void removeFirst() {
        if (head == null)
            throw new IllegalCallerException("List is empty");
        head = head.next;
    }

    @Override
    public void removeLast() {
        if (head == null)
            throw new IllegalCallerException("List is empty");
        else if (head.next == null) {
            head = null;
        } else {
            Node preLast = head;
            while (preLast.next.next != null)
                preLast = preLast.next;
            preLast.next = null;
        }
    }

    @Override
    public Object getFirst() {
        if (head == null)
            throw new IllegalCallerException("List is empty");
        return head.data;
    }

    @Override
    public Object getLast() {
        if (head == null)
            throw new IllegalCallerException("List is empty");
        Node last = head;
        while (last.next != null)
            last = last.next;
        return last.data;
    }

    @Override
    public Object search(Object element) {
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
    public boolean remove(Object element) {
        if (head == null)
            throw new IllegalCallerException("List is empty");
        if (getFirst().equals(element)) {
            removeFirst();
            return true;
        }
        if (getLast().equals(element)) {
            removeLast();
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
    public void clear() {
        head = null;
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

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        Node cur = head;
        while (cur != null) {
            string.append(cur.data.toString());
            if (cur.next != null) {
                string.append(", ");
            }
            cur = cur.next;
        }
        string.append("]");
        return string.toString();
    }

    class IteratorImpl implements Iterator<Object> {
        private Node node = new Node(null, head);

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                node = node.next;
                return node.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            ListImpl.this.remove(node.data);
        }
    }

    private static class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this(data, null);
        }
    }
}
