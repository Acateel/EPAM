package epam.advanced.practice2.queue;

import epam.advanced.task01.path2.Container;

public interface Queue extends Container {

    // Appends the specified element to the end.
    void enqueue(Object element);

    // Removes the head.
    Object dequeue();

    // Returns the head.
    Object top();

}
