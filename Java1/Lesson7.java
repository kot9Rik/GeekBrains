/**
 * Java. Level 1. Lesson 7. Example of homework
 *
 * @author Aleksandr Vvedenskiy
 * @version dated Jul 24, 2017
 */

import java.util.*;

class Lesson7 {

    public static void main(String[] args) {	
        System.out.println("Enter quantity of food in a plate");
        Scanner sc = new Scanner(System.in);
        Plate plate = new Plate(sc.nextInt());
        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Barsik", 30, 50, false);
        catArray[1] = new Cat("Murzik", 40, 40, false);
        catArray[2] = new Cat("Ryzhik", 30, 60, false);
        catArray[3] = new Cat("Murka",  20, 20, false);
        catArray[4] = new Cat("Pushok", 10, 30, false);
        System.out.println(plate);
        System.out.println();
        for (int i = 0; i < catArray.length; i++) {
            catArray[i].eat(plate);
            System.out.println(catArray[i].name + "; Appetite" + 
                catArray[i].full + "; Satiety " + catArray[i].satiety);	
            System.out.println(plate);	
            System.out.println();			
        }
    }
}

class Cat {
    String name;
    int appetite;
    int full;
    boolean satiety;
    Cat(String name, int appetite, int full, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.full = full;
        this.satiety = satiety;
    }
	
    void eat(Plate plate) {
        do {
            if (plate.food >= appetite && full > appetite) {
                System.out.println(name + ", appetite " + full + 
                    ". The cat eats " + appetite + ". Nyam-nyammm!!!");
                plate.decreaseFood(appetite);
                full -= appetite;
            } else if (plate.food >= full && full > 0) {
                System.out.println(name + ", appetite " + full +
                    ". The cat eats " + full + ". Nyam-nyammm!!!");
                plate.decreaseFood(full);
                full -= full;
                if (full <= 0) {
                    System.out.println("The cat is full!!!");
                    satiety = true;
                }
            }
            if (plate.food < appetite)
                break;
        } while (full != 0);
    }
}

class Plate {
    int food;
    Plate(int food) {
        this.food = food;
    }
	
    void decreaseFood(int food) {
        this.food -= food;
    }
	
    @Override
    public String toString() {
        return "In a plate: " + food;
    }
}