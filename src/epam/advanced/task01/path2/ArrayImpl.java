package epam.advanced.task01.path2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");
        array.add("E");
        array.add("F");
        System.out.println("Array before:");
        System.out.println(array);
        System.out.println("Remove index 3");
        array.remove(3);
        System.out.println("Set index 0");
        array.set(0, "E");
        System.out.println(array);
        System.out.println("Get index 2: " + array.get(2));
        System.out.println("Index of D: " + array.indexOf("D"));
        System.out.println("Index of E: " + array.indexOf("E"));
        System.out.println("Size: " + array.size());

        System.out.println("Use iterator:");
        var iterator = array.iterator();
        while (iterator.hasNext()) {
            var element = iterator.next();
            if (element.equals("C")) {
                System.out.println("Remove element");
                iterator.remove();
            } else {
                System.out.println(element);
            }
        }
        System.out.println(array);

        array.clear();
        System.out.println("After Clear");
        System.out.println(array);
    }

    private Object[] objects = new Object[0];

    @Override
    public void add(Object element) {
        Object[] newObjects = new Object[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[newObjects.length - 1] = element;

        objects = newObjects;
    }

    @Override
    public void remove(int index) {
        Object[] newObjects = new Object[objects.length - 1];
        System.arraycopy(objects, 0, newObjects, 0, index);
        System.arraycopy(objects, index + 1, newObjects, index, newObjects.length - index);
        objects = newObjects;
    }

    @Override
    public void set(int index, Object element) {
        objects[index] = element;
    }

    @Override
    public Object get(int index) {
        return objects[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        objects = new Object[0];
    }

    @Override
    public int size() {
        return objects.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < objects.length; i++) {
            builder.append(objects[i]);
            if (i < objects.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImlp();
    }

    class IteratorImlp implements Iterator<Object> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < objects.length;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return objects[position++];
            } else
                throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            ArrayImpl.this.remove(--position);
        }
    }
}
