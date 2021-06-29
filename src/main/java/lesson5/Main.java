package lesson5;

import java.util.*;

public class Main {
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }

        task51(); // приведите пример использования рекурсии.
        //task52(100, true); // реализуйте простой пример бесконечной рекурсии
        task52(100, false); // реализуйте простой пример обычной рекурсии с условием для выхода
        task53(); // приведите пример изображающий стек вызова и стек вызова с рекурсией.
        task54(); // реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию
        task55(array); // реализуйте алгоритм двоичного рекурсивного поиска на основе массива
        task56(array); // реализуйте алгоритм сортировки слиянием
    }

    private static void task51() {
        /*
        Факториал, Числа фибоначи. Поиск в древовидных структурах может
        быть реализован с помощью рекурсивного поиска, например поиск файлов в каталоге.
         */
    }

    public static byte task52(int n, boolean infinite) {
        System.out.println(n);
        if (!infinite && n == 0) {
            return -1;
        }
        return task52((n - 1), infinite);
    }

    private static void task53() {
         /*
        Пример стека вызовов с рекурсией - расчет факториала числа n.
        Для расчета по алгоритму factorial(n)=n*factorial(n-1) стек вызовов строится таким образом, что сначала
        считаются factorial(1)=1,factorial(2)=factorial(1)*2=1*2=2,factorial(3)=factorial(2)*3=2*3=6 и т.д. вплоть до
        factorial(n)
          */
    }

    private static void task54() {
        startTime = System.nanoTime();
        loop(5);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время цикла: " + endTime);

        startTime = System.nanoTime();
        recursion(5);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время рекурсии: " + endTime);
    }

    private static void task55(int[] array) {
        startTime = System.nanoTime();
        System.out.println(binarySearch(6, array));
        endTime = System.nanoTime() - startTime;
        System.out.println("Время бинарного поиска: " + endTime);

        startTime = System.nanoTime();
        System.out.println(binarySearchWithRecursion(6, array, 0, array.length - 1));
        endTime = System.nanoTime() - startTime;
        System.out.println("Время бинарного поиска c рекурсией: " + endTime);
    }

    private static void task56(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(arrayCopy));
        startTime = System.nanoTime();
        Arrays.sort(arrayCopy);
        endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("Время  Arrays.sort(): " + endTime);

        System.out.println(Arrays.toString(array));
        startTime = System.nanoTime();
        array = mergeSort(array);
        endTime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("Время  mergeSort(): " + endTime);

    }

    public static void loop(int n) {//цикл
        while (n < 5) {
            System.out.print(n++);
        }
    }

    public static int recursion(int n) {//рекурсия
        if (n == 5) {
            return -1;
        }
        System.out.print(n);

        return recursion(++n);
    }

    public static int binarySearch(int soughtNumber, int[] array) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (lastIndex + firstIndex) / 2;
            if (array[middleIndex] == soughtNumber) {
                return middleIndex;
            } else if (soughtNumber > array[middleIndex]) {
                firstIndex = middleIndex + 1;
            } else if (soughtNumber < array[middleIndex]) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int binarySearchWithRecursion(int soughtNumber, int[] array, int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex) {
            int middleIndex = (lastIndex + firstIndex) / 2;
            if (array[middleIndex] == soughtNumber) {
                return middleIndex;
            } else if (soughtNumber > array[middleIndex]) {
                return binarySearchWithRecursion(soughtNumber, array, middleIndex + 1, lastIndex);
            } else if (soughtNumber < array[middleIndex]) {
                return binarySearchWithRecursion(soughtNumber, array, firstIndex, middleIndex - 1);
            }
        }
        return -1;
    }

    public static int[] mergeSort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }
        int middle = length / 2;
        return merge(mergeSort(Arrays.copyOfRange(array, 0, middle)), mergeSort(Arrays.copyOfRange(array, middle, length)));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[(a.length + b.length)];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
