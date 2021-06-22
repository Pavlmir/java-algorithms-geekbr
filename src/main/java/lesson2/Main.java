package lesson2;

import java.util.Arrays;

public class Main {
    static long timeSortBubbles = 0;
    static long timeSortArray = 0;
    static long timeSortSelect = 0;
    static long timeSortInsert = 0;

    public static void main(String[] args) {
        task21(); // реализуйте массив
        task22(); // реализуйте линейный и двоичный поиск
        task23(); // выполните сортировку с помощью метода sort()
        task24(); // реализуйте алгоритм сортировки пузырьком
        task25(); // реализуйте алгоритм сортировки методом выбора
        task26(); // реализуйте алгоритм сортировки методом вставки
    }

    static void task21() {
        System.out.println("\nЗадание 2.1");
        int[] ints = Util.getRandomIntArray(10, 100, 20);
        System.out.println(ints[3]);
        long startTime = System.nanoTime();
        int[] copyInts = Arrays.copyOf(ints, ints.length);
        Arrays.sort(ints);
        long endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(copyInts));
        System.out.println("\nВремя выполнения: " + endTime / 1000000);
    }

    static void task22() {
        System.out.println("\nЗадание 2.2");
        int[] ints = Util.getRandomIntArray(0, 10, 20);
        int key = Util.getRandom(0, 10);
        System.out.println("Исходный массив:\n");
        System.out.println(Arrays.toString(ints));
        System.out.println("Ключ поиска: " + key);
        long startTime = System.nanoTime();
        lineFind(ints, key);
        long endTime = System.nanoTime() - startTime;
        System.out.println("\nВремя выполнения: " + endTime / 1000000);
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        startTime = System.nanoTime();
        binaryFind(ints, key);
        endTime = System.nanoTime() - startTime;
        System.out.println("\nВремя выполнения: " + endTime / 1000000);
    }

    static void task23() {
        System.out.println("Задание 2.3");
        int[] ints = Util.getRandomIntArray(0, 4000, 400);
        long startTime = System.nanoTime();
        Arrays.sort(ints);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время сортировки - " + endTime);
    }

    static void task24() {
        System.out.println("Задание 2.4");
        int[] ints = Util.getRandomIntArray(0, 4000, 400);
        System.out.println(Arrays.toString(ints));
        System.out.println(ints);
        long startBubblesSort = System.nanoTime();
        sortBubble(ints);
        timeSortBubbles = System.nanoTime() - startBubblesSort;
        System.out.println(Arrays.toString(ints));
        ints = Util.getRandomIntArray(0, 4000, 400);
        long startArraySort = System.nanoTime();
        Arrays.sort(ints);
        timeSortArray = System.nanoTime() - startArraySort;
        System.out.println("Сортировка пузырьком - " + timeSortBubbles);
        System.out.println("сортировка Array.sort - " + timeSortArray);
    }

    static void task25() {
        int[] ints = Util.getRandomIntArray(0, 4000, 400);
        System.out.println(Arrays.toString(ints));
        long startSelectSort = System.nanoTime();
        sortSelect(ints);
        timeSortSelect = System.nanoTime() - startSelectSort;
        System.out.println(Arrays.toString(ints));
        System.out.println("Сортировка пузырьком \t\t" + timeSortBubbles);
        System.out.println("сортировка Array.sort \t\t" + timeSortArray);
        System.out.println("сортировка выбором \t\t\t" + timeSortSelect);
    }

    static void task26() {
        int[] ints = Util.getRandomIntArray(0, 4000, 400);
        System.out.println(Arrays.toString(ints));
        long startInsertSort = System.nanoTime();
        sortInsert(ints);
        timeSortInsert = System.nanoTime() - startInsertSort;
        System.out.println(Arrays.toString(ints));
        System.out.println("Сортировка пузырьком \t\t" + timeSortBubbles);
        System.out.println("сортировка Array.sort \t\t" + timeSortArray);
        System.out.println("сортировка выбором \t\t\t" + timeSortSelect);
        System.out.println("сортировка вставкой \t\t" + timeSortInsert);
    }

    static void sortInsert(int[] arr) {
        int key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void sortSelect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    pos = j;
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
        }
    }

    static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    static void lineFind(int[] arr, int key) {
        System.out.println("Линейный поиск\nВхождения (индекс элемента):");
        boolean findOk = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                findOk = true;
                System.out.print("\t" + i);
            }
        }
        if (!findOk)
            System.out.println("Вхождений нет");
    }

    static void binaryFind(int arr[], int key) {
        System.out.println("Бинарный поиск\n\tВхождения:");
        boolean findOk = false;
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == key) {
                findOk = true;
                boolean isForward = true;
                int tmp = middleIndex;
                for (int i = 0; i < 2; i++) {
                    while ((middleIndex >= 0) && (middleIndex < arr.length) && (arr[middleIndex] == key)) {
                        System.out.print("\t" + middleIndex);
                        if (isForward)
                            middleIndex++;
                        else
                            middleIndex--;
                    }
                    isForward = false;
                    middleIndex = tmp - 1;
                    if (middleIndex < 0)
                        return;
                }
                return;
            } else if (arr[middleIndex] < key)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > key)
                lastIndex = middleIndex - 1;
        }
        System.out.println("Вхождений нет");
    }
}
