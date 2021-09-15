package kolekcije;

import java.util.Iterator;

public class DoubleLinkedListIterator<T> implements Iterator<T> {

    private ListNode<T> currentNode;

    public DoubleLinkedListIterator(DoubleLinkedList<T> list){
        currentNode = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T element = currentNode.getElement();
        currentNode = currentNode.getNext();
        return element;
    }
}
