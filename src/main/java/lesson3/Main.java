package lesson3;

import lesson2.Util;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] ints = Util.getRandomIntArray(10, 100, 20);
        System.out.println(Arrays.toString(ints));

        ArrayList<Integer> arrayList = task31(ints); // преобразования
        task32(arrayList); // реализуйте основные методы
        task33(); // реализуйте простой односвязный список
        LinkedList<Integer> linkedList = task34(arrayList); // реализуйте простой двусторонний список
        task35(linkedList); // реализуйте итератор

    }

    private static ArrayList<Integer> task31(int[] array) {
        System.out.println("\nЗадание 3.1\n");
        // Пример
        String[] myString = new String[] {"a", "b", "c"};

        long startTime = System.nanoTime();
        List<String> strList = Arrays.asList(myString);
        long endTime = System.nanoTime() - startTime;
        System.out.println(strList + " - преобразование массива в простой список заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        Collection strCollection = new ArrayList<String>();
        Collections.addAll(strCollection, myString);
        endTime = System.nanoTime() - startTime;
        System.out.println(strCollection + " - преобразование массива в коллекцию заняло " + endTime / 1000000 + " сек.");

        startTime = System.nanoTime();
        ArrayList<Integer> intsArrayList = new ArrayList<Integer>();
        for (int i: array) intsArrayList.add(i);
        endTime = System.nanoTime() - startTime;
        System.out.println(intsArrayList + " - преобразование массива в ArrayList заняло " + endTime / 1000000 + " сек.");

        return intsArrayList;
    }

    private static void task32(ArrayList arrayList) {
        System.out.println("\nЗадание 3.2\n");
        long startTime = System.nanoTime();
        arrayList.get(Util.getRandom(0, arrayList.size() - 1));
        long endTime = System.nanoTime() - startTime;
        System.out.println("getting time: " + endTime / 1000000);

        startTime = System.nanoTime();
        arrayList.remove(Util.getRandom(0, arrayList.size() - 1));
        endTime = System.nanoTime() - startTime;
        System.out.println("removing time: " + endTime / 1000000);

        startTime = System.nanoTime();
        arrayList.add(Util.getRandom(0, arrayList.size() - 1));
        endTime = System.nanoTime() - startTime;
        System.out.println("adding time: " + endTime / 1000000);
    }

    private static void task33() {
        System.out.println("\nЗадание 3.3\n");
        SinglelinkedList<String> singlelinkedList = new SinglelinkedList<>();

        // Добавление новых элементов
        singlelinkedList.insert("One");
        singlelinkedList.insert("Two");
        singlelinkedList.insert("Three");

        // Вывод односвязного списка в консоль
        singlelinkedList.display();

        // Поиск элемента
        System.out.println(singlelinkedList.find("One"));

        // Удаление первого элемента
        singlelinkedList.deleteFirst();
        singlelinkedList.display();

        // Удаление всех элементов
        while (!singlelinkedList.isEmpty()) {
            singlelinkedList.deleteFirst();
        }
        singlelinkedList.display();
        System.out.println(singlelinkedList.isEmpty());
    }

    private static LinkedList<Integer> task34(ArrayList arrayList) {
        System.out.println("\nЗадание 3.4\n");
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        System.out.println("LinkedList: " + linkedList);
        long startTime = System.nanoTime();
        linkedList.get(Util.getRandom(0, arrayList.size() - 1));
        long endTime = System.nanoTime() - startTime;
        System.out.println("getting time: " + endTime / 1000000);

        startTime = System.nanoTime();
        linkedList.remove(Util.getRandom(0, arrayList.size() - 1));
        endTime = System.nanoTime() - startTime;
        System.out.println("removing time: " + endTime / 1000000);

        startTime = System.nanoTime();
        linkedList.add(Util.getRandom(0, arrayList.size() - 1));
        endTime = System.nanoTime() - startTime;
        System.out.println("adding time: " + endTime / 1000000);

        startTime = System.nanoTime();
        linkedList.getFirst();
        endTime = System.nanoTime() - startTime;
        System.out.println("getting start: " + endTime / 1000000);

        startTime = System.nanoTime();
        linkedList.getLast();
        endTime = System.nanoTime() - startTime;
        System.out.println("getting start: " + endTime / 1000000);

        LinkedList<StringBuilder> myClassLinkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            myClassLinkedList.add(new StringBuilder());
        }
        return linkedList;
    }

    private static void task35(LinkedList linkedList) {
        System.out.println("\nЗадание 3.5\n");
        Iterator<Integer> iterator = linkedList.iterator();
        long startTime = System.nanoTime();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        long endTime = System.nanoTime() - startTime;
        System.out.println("iterator time: " + endTime / 1000000);
    }
}
