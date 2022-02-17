package epam.advanced.practice2.stack;

import epam.advanced.practice2.data.City;
import epam.advanced.practice2.data.CityHelper;
import epam.advanced.practice2.queue.QueueImpl;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack{
    public static void main(String[] args) {
        Stack stack = new StackImpl();
        try {
            City[] cities = (City[]) CityHelper.readToXml(CityHelper.getPathXmlFile());
            for (City city : cities) {
                stack.push(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading finish");
        System.out.println(stack);

        System.out.println("Pop\n" + stack.pop());
        System.out.println("Top\n" + stack.top());
        System.out.println("Size -> " + stack.size());

        var iterator = stack.iterator();
        while(iterator.hasNext()){
            City city = (City) iterator.next();
            System.out.println(city.getName());
            if(city.getName().equals("Canada")){
                System.out.println("Delete Canada");
                iterator.remove();
            }
        }

        try {
            CityHelper.writeToJsonIterator(stack.iterator(), CityHelper.getPathJsonFile());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private Node head;

    @Override
    public void push(Object element) {
        head = new Node(element, head);
    }

    @Override
    public Object pop() {
        if(head==null)
            throw new IllegalCallerException("Stack is empty");
        var data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public Object top() {
        return head.data;
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
            if (node.data.equals(head.data)) {
                StackImpl.this.pop();
            }
            Node cur = head;
            while (cur.next != null) {
                if (cur.next.data.equals(node.data)) {
                    cur.next = cur.next.next;
                    return;
                }
                cur = cur.next;
            }
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
