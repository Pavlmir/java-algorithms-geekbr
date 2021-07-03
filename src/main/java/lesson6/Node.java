package lesson6;

public class Node {
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public Node(Person person) {
        this.person = person;
        rightChild = null;
        leftChild = null;
    }

    public Node() {

    }

    public void display() {
        System.out.println("Id: " + person.getId() + " Имя: " + person.getName() + " Возраст: " + person.getAge());
    }
}
