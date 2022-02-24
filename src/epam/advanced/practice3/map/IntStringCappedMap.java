package epam.advanced.practice3.map;

import java.util.*;

public class IntStringCappedMap implements Map<Integer, String> {
    public static void main(String[] args) {
        IntStringCappedMap map = new IntStringCappedMap(25);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(12, "Twelve");
        map.put(9, "Nine");
        map.put(1, "One");

        System.out.println(new TreeMap<>(map));
        //{1=One, 7=Seven, 8=Eight, 9=Nine, 12=Twelve}
    }
    private int capacity;
    private Node head;

    public IntStringCappedMap(int capacity) {
        this.capacity = capacity;
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
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public boolean containsKey(Object key) {
        Node cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Node cur = head;
        while (cur != null) {
            if (cur.value.equals(value)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String get(Object key) {
        Node cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String put(Integer key, String value) {
        if (value.length() > capacity)
            throw new IllegalArgumentException();
        if (get(key) != null) {
            return null;
        }
        if (head == null) {
            head = new Node(key, value);
            return head.value;
        } else {
            while (capacityProperty() + value.length() > capacity) {
                head = head.next;
            }
            Node end = head;
            while (end.next != null) {
                end = end.next;
            }
            end.next = new Node(key, value);
            return end.next.value;
        }
    }

    @Override
    public String remove(Object key) {
        if (get(key) == null) {
            return null;
        }
        Node cur = head;
        if (head.key == key) {
            var oldHeadValue = head.value;
            head = head.next;
            return oldHeadValue;
        }
        while (cur.next != null) {
            if (cur.next.key == key) {
                var oldCurrentValue = cur.next.value;
                cur.next = cur.next.next;
                return oldCurrentValue;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends String> m) {
        for(var sell : m.entrySet()){
            put(sell.getKey(), sell.getValue());
        }
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Set<Integer> keySet() {
        return null;
    }

    @Override
    public Collection<String> values() {
        return null;
    }

    @Override
    public Set<Entry<Integer, String>> entrySet() {
        return new AbstractSet<>() {
            @Override
            public Iterator<Entry<Integer, String>> iterator() {
                return new Iterator<>() {
                    private Node node = new Node(null, null, head);

                    @Override
                    public boolean hasNext() {
                        return node.next != null;
                    }

                    @Override
                    public Entry<Integer, String> next() {
                        if (hasNext()) {
                            node = node.next;
                            return new Entry<Integer, String>() {
                                @Override
                                public Integer getKey() {
                                    return node.key;
                                }

                                @Override
                                public String getValue() {
                                    return node.value;
                                }

                                @Override
                                public String setValue(String value) {
                                    return node.value = value;
                                }
                            };
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                };
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

    public int capacityProperty() {
        int property = 0;
        Node cur = head;
        while (cur != null) {
            property += cur.value.length();
            cur = cur.next;
        }
        return property;
    }

    private static class Node {
        Integer key;
        String value;
        Node next;

        public Node(Integer key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(Integer key, String value) {
            this(key, value, null);
        }
    }
}
