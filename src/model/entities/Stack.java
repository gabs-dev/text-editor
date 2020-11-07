package model.entities;

import model.exceptions.StackException;

public class Stack<T> {

    private class Node {
        T item;
        Node next;
    }

    private Node head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(T t) {
        if (t == null)
            throw new NullPointerException("The parameter can't be null.");
        else {
            Node node = new Node();
            node.item = t;
            node.next = head;
            head = node;
            size++;
        }
    }

    public T pop() throws StackException {
        if (isEmpty())
            throw new StackException("The Stack is empty!");
        else {
            T item = head.item;
            head = head.next;
            size--;
            return item;
        }
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public int size() {
        return this.size;
    }

}