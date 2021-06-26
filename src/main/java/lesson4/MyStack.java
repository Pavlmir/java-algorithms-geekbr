package lesson4;

import lesson3.Link;

public class MyStack<T> {
    private Link<T> top;


    public MyStack() {
        this.top = null;
    }

    public void push(T that) {
        Link<T> temp = new Link<>(that);
        temp.setNext(top);
        this.top = temp;
    }

    public T pop() {
        T temp = top.getValue();
        top = top.getNext();
        return temp;
    }

    public T peek() {
        return top.getValue();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void print() {
        Link<T> temp = top;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.getValue());
            if (temp.getNext() != null) {
                System.out.print(",");
            }
            temp = temp.getNext();
        }
        System.out.print("]\n");
    }

}
