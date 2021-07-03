package lesson6;

import lesson2.Util;

import java.util.Arrays;

public class Main {
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {
        int[] intArray = Util.getRandomIntArray(10, 100, 20);
        task61(); // Приведите пример использования древовидной структуры.
        tasks62_65();
        task66(intArray);
        task67(); // Приведите пример сбалансированного дерева и его применения.
    }

    private static void task61() {
        /*
        Иерархическая организационная структура компании.
        Упорядочивание информации с ее классификацией по типам (структуры данных и их связи/наследования в языке программирования)
        Хранение упорядоченных данных
         */
    }

    private static void tasks62_65() {
        Tree tree = new Tree();
        tree.insert(new Person(4, "Ivan", 35));
        tree.insert(new Person(2, "Sergey", 78));
        tree.insert(new Person(3, "Andrey", 24));
        tree.insert(new Person(5, "Sasha", 21));

        Node temp;

        System.out.println("Обход в порядке возрастанию ключей (id):");
        startTime = System.nanoTime();
        tree.traverseInOrder();
        endTime = System.nanoTime() - startTime;
        System.out.println("Обход в порядке возрастания ключей занял " + endTime + " нс");

        System.out.println("Префиксный обход:");
        startTime = System.nanoTime();
        tree.traversePreOrder();
        endTime = System.nanoTime() - startTime;
        System.out.println("Префиксный обход занял " + endTime + " нс");

        System.out.println("Постфиксный обход:");
        startTime = System.nanoTime();
        tree.traversePostOrder();
        endTime = System.nanoTime() - startTime;
        System.out.println("Постфиксный обход занял " + endTime + " нс");

        System.out.println("Элемент с минимальным ключом");
        startTime = System.nanoTime();
        temp = tree.min();
        endTime = System.nanoTime() - startTime;
        temp.display();
        System.out.println("Поиск элемента с минимальным ключом занял " + endTime + " нс");

        System.out.println("Элемент с максимальным ключом");
        startTime = System.nanoTime();
        temp = tree.max();
        endTime = System.nanoTime() - startTime;
        temp.display();
        System.out.println("Поиск элемента с максимальным ключом занял " + endTime + " нс");

        Tree treeCopy = new Tree();
        startTime = System.nanoTime();
        treeCopy.copyTree(tree);
        endTime = System.nanoTime() - startTime;
        System.out.println("Копирование бинарного дерева заняло " + endTime + " нс");

        startTime = System.nanoTime();
        treeCopy.delete(2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Удаление элемента заняло " + endTime + " нс");
        treeCopy.traverseInOrder();
    }

    private static void task66(int[] intArray) {
        int[] arrayCopy1 = Arrays.copyOf(intArray, intArray.length);
        int[] arrayCopy2 = Arrays.copyOf(intArray, intArray.length);
        int[] arrayCopy3 = Arrays.copyOf(intArray, intArray.length);
        int[] arrayCopy4 = Arrays.copyOf(intArray, intArray.length);
        int[] arrayCopy5 = Arrays.copyOf(intArray, intArray.length);

        System.out.println(Arrays.toString(intArray));

        MyHeap myHeap = new MyHeap();

        startTime = System.nanoTime();
        myHeap.sort(arrayCopy1);
        endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(arrayCopy1));
        System.out.println("Сортировка кучей заняла " + endTime + " нс");

        startTime = System.nanoTime();
        Arrays.sort(arrayCopy2);
        endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(arrayCopy2));
        System.out.println("Сортировка методом Arrays.sort() заняла " + endTime + " нс");

        MyArray myArray = new MyArray();

        startTime = System.nanoTime();
        myArray.insertionSort(arrayCopy3);
        endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(arrayCopy3));
        System.out.println("Сортировка вставками заняла " + endTime + " нс");

        startTime = System.nanoTime();
        myArray.bubbleSort(arrayCopy4);
        endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(arrayCopy4));
        System.out.println("Сортировка пузырьком заняла " + endTime + " нс");

        startTime = System.nanoTime();
        myArray.selectionSort(arrayCopy5);
        endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(arrayCopy5));
        System.out.println("Сортировка выбором заняла " + endTime + " нс");
    }

    private static void task67() {
        /*
        Ввиду сбалансированности красно-черных деревьев и прочих сбалансированных двоичных поисковых деревьев, они
        используются для организации хранения данных в выделенных участках памяти / регистра процессора ПК при реализации
        программ в разных языках программирования.
         */
    }

}
