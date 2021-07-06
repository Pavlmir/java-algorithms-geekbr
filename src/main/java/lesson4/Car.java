package lesson4;

import java.util.Random;

public class Car {
    static final String[] MARKS = {"BMW", "MAZDA", "NISSAN", "AUDI"};
    static final int MAX_POWER = 200;


    private int power;
    private String mark;

    public Car(){
        Random random = new Random();
        power = random.nextInt(MAX_POWER);
        mark = MARKS[random.nextInt(MARKS.length)];
    }
    public void print(){
        System.out.println("The burn power is: " +  this.power + ". Burn type is: " + this.mark + ". " );
    }

    @Override
    public String toString() {
        return "Burns{" +
                "power=" + power +
                ", mark='" + mark + '\'' +
                '}';
    }
}
