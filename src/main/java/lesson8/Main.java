package lesson8;

import lesson7.Graph;

public class Main {
    public static void main(String[] args) {
        final int HASH_TABLE_SIZE = 20;
        MyArray myArray = new MyArray();

        task81(); // Приведите пример использование хеш-таблиц.
        task82(); // Приведите примеры ключей и коллизий.
        task83(); // Приведите примеры популярных и эффективных хеш-функций.
        task84(HASH_TABLE_SIZE, myArray); // реализуйте хеш-таблицу с помощью открытой адресации
        task85(HASH_TABLE_SIZE, myArray); // перестройте программный код
    }

    private static void task81() {
        /*
        распределение книг в библиотеке по тематическим каталогам,
        упорядочивание в словарях по первым буквам слов,
        шифрование специальностей в вузах и т.д.
         */
    }

    private static void task82() {
        /*
        В качестве ключа могут выступать:
        одно из полей записи данных в хеш-таблицу (наименование, тип объекта)
        пароль для хеширования паролей
        связка логин-пароль для хеширования паролей
        Коллизии могут появляться, когда математическая хеш-функция в результате обработки разных ключей выдает одинаковый
        байт-код:
        если хеш-функция определяется, как остаток от деления ключа на 10, то ключи 5, 15, 25, 35 и т.д. выдают одинаковые
        байт-коды (5), что является коллизией
       */
    }

    private static void task83() {
        /*
       Дайджест сообщения (MD)
       Безопасная хеш-функция (SHA)
       RIPEND — это аббревиатура для дайджеста сообщения оценки примитивов RACE.
       Джакузи - Это 512-битная хеш-функция на основе Advanced Encryption Standard (AES)
       */
    }

    private static void task84(int HASH_TABLE_SIZE, MyArray myArray) {
        int[] intArray = myArray.createIntArray(HASH_TABLE_SIZE / 2, 50);

        HashTable hashTable = new HashTable(HASH_TABLE_SIZE);

        for (int i : intArray) {
            hashTable.insertLinearProbing(new Item(i));
        }

        hashTable.display();

        System.out.println("------------");
        System.out.println(intArray[HASH_TABLE_SIZE / 4]);
        System.out.println(hashTable.findLinearProbing(intArray[HASH_TABLE_SIZE / 4]).getKey());

        System.out.println("------------");
        hashTable.popLinearProbing(intArray[HASH_TABLE_SIZE / 4]);
        hashTable.display();
    }

    private static void task85(int HASH_TABLE_SIZE, MyArray myArray) {

        int[] intArray = myArray.createIntArray(HASH_TABLE_SIZE / 2, 50);
        HashTable hashTable = new HashTable(HASH_TABLE_SIZE);

        for (int i : intArray) {
            hashTable.insertDoubleHash(new Item(i));
        }

        hashTable.display();

        System.out.println("------------");
        System.out.println(intArray[HASH_TABLE_SIZE / 4]);
        System.out.println(hashTable.findDoubleHash(intArray[HASH_TABLE_SIZE / 4]).getKey());

        System.out.println("------------");
        hashTable.popDoubleHash(intArray[HASH_TABLE_SIZE / 4]);
        hashTable.display();
    }

}
