package epam.advanced.practice3.median_queue;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MedianQueue implements Iterable<Integer>{
    public static void main(String[] args) {
        var queue = new MedianQueue();
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(10);
        queue.offer(8);
        queue.offer(1);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println(queue.median());
    }

    private Node head;

    public void offer(Integer element) {
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

    public Integer poll() {
        if (head == null)
            throw new IllegalCallerException("Queue is empty");
        Integer oldHeadData = head.data;
        head = head.next;
        return oldHeadData;
    }

    public Integer peek() {
        return head.data;
    }

    public int size() {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

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

    public Integer median(){
        var array = toArray();
        Arrays.sort(array);
        int medianIndex = (size()-1)/2;
        return array[medianIndex];
    }

    public Integer[] toArray(){
        Integer[] array = new Integer[size()];
        int index = 0;
        for(var sell : this){
            array[index] = sell;
            index++;
        }
        return array;
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
