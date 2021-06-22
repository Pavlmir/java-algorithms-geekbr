package lesson1;

public class Main {
    public static void main(String[] args) {
        Cat result = task13(); // Задание 1.3
        task14(); // Задание 1.4
    }

    private static Cat task13() {
        String catName = "Мурзик";
        int age = 7;
        return new Cat(catName, age);
    }

    private static void task14() {
        String catName = "Мурзик";
        int age = 7;
        Cat cat = new Cat(catName, age);
        System.out.print("cat - " + cat);

        Cat cat1 = task13();
        System.out.print("cat1 - " + cat1);

        long startTime = System.nanoTime();
        System.out.println("cat.equals(cat1)? " + (cat.equals(cat1)));
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения сравнения:" + endTime);
    }
}
