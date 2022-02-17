package epam.advanced.practice2.stack;

import epam.advanced.task01.path2.Container;

public interface Stack extends Container {

    // Pushes the specified element onto the top.
    void push(Object element);

    // Removes and returns the top element.
    Object pop();

    // Returns the top element.
    Object top();

}
