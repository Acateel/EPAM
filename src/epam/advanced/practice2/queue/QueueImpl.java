package epam.advanced.practice2.queue;

import epam.advanced.practice2.data.City;
import epam.advanced.practice2.data.CityHelper;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        try {
            City[] cities = (City[]) CityHelper.readToXml(CityHelper.getPathXmlFile());
            for (City city : cities) {
                queue.enqueue(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading finish");
        System.out.println(queue);

        System.out.println("Dequeue\n" + queue.dequeue());
        System.out.println("Top\n" + queue.top());
        System.out.println("Size -> " + queue.size());

        var iterator = queue.iterator();
        while(iterator.hasNext()){
            City city = (City) iterator.next();
            System.out.println(city.getName());
            if(city.getName().equals("Canada")){
                System.out.println("Delete Canada");
                iterator.remove();
            }
        }

        try {
            CityHelper.writeToJsonIterator(queue.iterator(), CityHelper.getPathJsonFile());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private Node head;

    @Override
    public void enqueue(Object element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node end = head;
            while (end.next != null) {
                end = end.next;
            }
            end.next = new Node(element);
        }
    }

    @Override
    public Object dequeue() {
        if (head == null)
            throw new IllegalCallerException("Queue is empty");
        Object oldHeadData = head.data;
        head = head.next;
        return oldHeadData;
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
                QueueImpl.this.dequeue();
            }
            Node cur = head;
            while (cur.next != null) {
                if (cur.next.data.equals(node.data)) {
                    cur.next = cur.next.next;
                    return;
                }
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
