package epam.advanced.practice6.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        return new Iterator<Integer>() {
            int index = 0;
            boolean even = false;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    int number = array[index];
                    if (even) {
                        index++;
                    }
                    even = !even;
                    return number;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return new Iterator<Integer>() {
            int index = 0;
            int three = 1;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    int number = array[index];
                    if (three == 3) {
                        index++;
                        three = 0;
                    }
                    three++;
                    return number;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return new Iterator<Integer>() {
            int index = 0;
            int three = 1;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                if(hasNext()) {
                    int number = array[index];
                    if (three == 5) {
                        index++;
                        three = 0;
                    }
                    three++;
                    return number;
                }
                else{
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        return () -> new Iterator<String>() {
            int indexColumns = 0;
            int indexRows = 0;

            @Override
            public boolean hasNext() {
                return indexColumns < columns.length;
            }

            @Override
            public String next() {
                String result = columns[indexColumns] + rows[indexRows];
                indexRows++;
                if(indexRows == rows.length){
                    indexColumns++;
                    indexRows = 0;
                }
                return result;
            }
        };
    }


}
