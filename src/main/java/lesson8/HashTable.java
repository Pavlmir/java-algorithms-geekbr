package lesson8;

public class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int arrSize) {
        this.arrSize = arrSize;
        this.hashArr = new Item[arrSize];
        this.nonItem = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public int hashFuncDouble(int key) {
        return 5 - key % 5;
    }

    public void insertLinearProbing(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public void insertDoubleHash(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item findLinearProbing(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item findDoubleHash(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item popLinearProbing(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item popDoubleHash(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }


}