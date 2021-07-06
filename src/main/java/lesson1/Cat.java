package lesson1;

public class Cat {
    private final String name;
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Моё имя - " + this.name + ", мне - " + this.age + " лет\n";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Cat mc = (Cat) obj;
        return this.age == mc.age && this.name.equals(mc.name);
    }
}
