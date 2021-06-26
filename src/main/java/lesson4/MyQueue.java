package lesson4;

import lesson3.Link;

public class MyQueue<T> {
    private Link<T> first;
    private Link<T> last;

    public MyQueue() {
        this.first = null;
        this.last = null;

    }

    public boolean isEmpty() {
        return last == null;
    }

    public void insert(T that) {
        Link<T> temp = new Link<>(that);
        if (this.isEmpty()) {
            last = temp;
            last.setNext(first);
            first = temp;
        } else {
            first.setNext(temp);
            first = first.getNext();
        }
    }

    public T pop() throws NullPointerException {
        if (!this.isEmpty()) {
            T temp = last.getValue();
            last = last.getNext();
            return temp;
        } else {
            throw new NullPointerException("MyQueue is empty");
        }
    }

    public T peek() {
        if (!this.isEmpty()) {
            return last.getValue();
        } else {
            return null;
        }
    }

    public void print() {
        Link<T> temp = last;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
}
