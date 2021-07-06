package lesson4;

import java.util.*;

public class Main {
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {
        List<Car> cars  = new LinkedList<>();
        MyStack<Integer> myStack = new MyStack<>();
        MyQueue<Integer> myQueue = new MyQueue<>();

        task41(cars); // реализуйте простой стек и его базовые методы
        task42(cars); // реализуйте простую очередь и его базовые методы
        task43(cars); // реализуйте простой дек и его базовые методы
        task44(); // реализуйте приоритетную очередь на основе ссылочных типов данных
        task45myStack(myStack); // реализуйте стек и очередь на базе связанного списка
        task45myQueue(myQueue);
    }

    private static void task41(List<Car> cars) {
        for (int i = 0; i < 15; i++) {
            cars.add(new Car());
        } // конец создания списка и вывод на экран всех элементов.
        for (Car b : cars) {
            b.print();
        }
        System.out.println("начало реализации стека и его базовых методов.");
        Stack<Car> burnsStack = new Stack<>();
        System.out.println("Добавление элемента в стек.");
        startTime = System.nanoTime();
        burnsStack.push(cars.get(0));
        endTime = System.nanoTime() - startTime;
        System.out.println("Время добавления элемента в стек: " + endTime / 1000000 + " сек.");
        for (int i = 1; i< cars.size(); i++){
            burnsStack.push(cars.get(i));
        }
        System.out.println("Удаление элемента");
        startTime = System.nanoTime();
        burnsStack.pop();
        endTime = System.nanoTime() - startTime;
        System.out.println("Время удаления элемента из стека: " + endTime / 1000000 + " сек.");

        System.out.println("Взятие элемента без удаления");
        startTime = System.nanoTime();
        burnsStack.peek();
        endTime = System.nanoTime() - startTime;
        System.out.println("Время взятия элемента из стека: " + endTime / 1000000 + " сек.");

        System.out.println("конец реализации стека и его базовых методов.");
    }

    private static void task42(List<Car> cars) {
        Car temp;
        startTime = System.nanoTime();
        Queue<Car> carsQueue = new LinkedList<>(cars);
        endTime = System.nanoTime() - startTime;
        System.out.println("Преобразование LinkedList в Linkedlist с интерфейсом Queue заняло " + endTime / 1000000 + " сек.");
        System.out.println(carsQueue);

        startTime = System.nanoTime();
        carsQueue.add(cars.get(0));
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода add() заняло " + endTime / 1000000 + " сек.");
        System.out.println(carsQueue);

        startTime = System.nanoTime();
        try {
            carsQueue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Очеред пустая");
        }
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода remove() заняло " + endTime / 1000000 + " сек.");
        System.out.println(carsQueue);

        startTime = System.nanoTime();
        carsQueue.poll();
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода poll() заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        temp = carsQueue.peek();
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода peek() заняло " + endTime / 1000000 + " сек.");
        System.out.println(temp);
    }

    private static void task43(List<Car> cars) {
        startTime = System.nanoTime();
        Deque<Car> calendarDeque = new LinkedList<>(cars);
        endTime = System.nanoTime() - startTime;
        System.out.println("Создание Deque из LinkedList заняло " + endTime / 1000000 + " сек.");
        System.out.println(calendarDeque);

        startTime = System.nanoTime();
        calendarDeque.addFirst(cars.get(1));
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода addFisrst() заняло " + endTime / 1000000 + " сек.");
        System.out.println(calendarDeque);

        startTime = System.nanoTime();
        calendarDeque.addLast(cars.get(2));
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода addLast() заняло " + endTime / 1000000 + " сек.");
        System.out.println(calendarDeque);

        startTime = System.nanoTime();
        calendarDeque.removeFirst();
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода removeFirst() заняло " + endTime / 1000000 + " сек.");
        System.out.println(calendarDeque);

        startTime = System.nanoTime();
        calendarDeque.removeLast();
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода removeLast() заняло " + endTime / 1000000 + " сек.");
        System.out.println(calendarDeque);

        while (!calendarDeque.isEmpty()) {
            calendarDeque.removeLast();
        }
        System.out.println(calendarDeque);
    }

    private static void task44() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        startTime = System.nanoTime();
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(100);
        priorityQueue.add(-1);
        priorityQueue.add(1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление 5 новых элементов в приоритетную очередь заняло " + endTime / 1000000 + " сек.");
        System.out.println(priorityQueue);


        while (!priorityQueue.isEmpty()) {
            startTime = System.nanoTime();
            System.out.println(priorityQueue.poll());
            endTime = System.nanoTime() - startTime;
            System.out.println("Вывод последнего элемента (метод poll()) занял " + endTime / 1000000 + " сек.");
        }
    }

    private static void task45myStack(MyStack<Integer> myStack) {
        startTime = System.nanoTime();
        myStack.push(10);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление первого элемента в MyStack заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myStack.push(5);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление нового элемента в MyStack заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myStack.push(1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление нового элемента в MyStack заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myStack.push(20);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление нового элемента в MyStack заняло " + endTime / 1000000 + " сек.");
        myStack.print();

        startTime = System.nanoTime();
        System.out.println(myStack.pop());
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода pop() MyStack заняло " + endTime / 1000000 + " сек.");
        myStack.print();

        startTime = System.nanoTime();
        System.out.println(myStack.peek());
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода peek() MyStack заняло " + endTime / 1000000 + " сек.");
        myStack.print();
    }
    private static void task45myQueue(MyQueue<Integer> myQueue) {
        int tempInt;

        startTime = System.nanoTime();
        myQueue.insert(1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление первого элемента в MyQueue заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myQueue.insert(2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление нового элемента в MyQueue заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myQueue.insert(3);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление нового элемента в MyQueue заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myQueue.insert(4);
        endTime = System.nanoTime() - startTime;
        System.out.println("Добавление нового элемента в MyQueue заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myQueue.print();
        endTime = System.nanoTime() - startTime;
        System.out.println("Вывод в консоль элементов MyQueue заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        myQueue.pop();
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода pop() MyQueue заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        tempInt = myQueue.peek();
        endTime = System.nanoTime() - startTime;
        System.out.println("Выполнение метода peek() MyQueue заняло " + endTime / 1000000 + " сек.");
        System.out.println(tempInt);
    }
}
