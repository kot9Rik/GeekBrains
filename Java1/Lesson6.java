/**
 * Java. Level 1. Lesson 6. Example of homework
 *
 * @author Aleksandr Vvedenskiy
 * @version dated Jul 24, 2017
 */
 
 public class Lesson6 {

    public static void main(String[] args) {
        int r = 165; //Run
        int s = 7; //Swim
        float j = 1.3F; //Jump
        Animal[] animal = new Animal[2];
        animal[0] = new Cat();
        animal[1] = new Dog(); 
        for (Animal an : animal) {
            System.out.println(an.voice());
            an.run(r);
            an.swim(s);
            an.jump(j);
        }
    }
}

abstract class Animal {

    protected String type;

    Animal() {
        type = "Animal";
    }

    abstract String voice();
	
    abstract void run(int r);
	
    abstract void swim(int s);
	
    abstract void jump(float j);
}

class Cat extends Animal {
	
    Cat() { 
        super();
        type = "Cat";
    }

    @Override
    String voice() {
        return "meow-meow";
    }
	
    @Override
    void run(int run) {
        int r = 200;
        if (run > r) {
            System.out.println("The cat has NOT run " + run + "m.");
        }
        else {
            System.out.println("The cat has run " + run + "m.");
        }
    }
	
    @Override
    void swim(int swim) {
        System.out.println("The cat can NOT swim ");
    }
	
    @Override
    void jump(float jump) {
        float j = 2.0F;
        if (jump > j) {
            System.out.println("The cat has NOT jump " + jump + "m.");
        }
        else {
            System.out.println("The cat has jump " + jump + "m.");
        }
    }
}

class Dog extends Animal {

    Dog() {
        super();
        type = "Dog";
    }

    @Override
    String voice() {
        return "wuf-wuf";
    }
	
    @Override
    void run(int run) {
        int r = 500;
        if (run > r) {
            System.out.println("The dog has NOT run " + run + "m.");
        }
        else {
            System.out.println("The dog has run " + run + "m.");
        }
    }
	
    @Override
    void swim(int swim) {
        int s = 10;
        if (swim > s) {
            System.out.println("The dog has NOT swim " + swim + "m.");
        }
        else {
            System.out.println("The dog has swim " + swim + "m.");
        }
    }
	
    @Override
    void jump(float jump) {
        float j = 0.5F;
        if (jump > j) {
            System.out.println("The dog has NOT jump " + jump + "m.");
        }
        else {
            System.out.println("The dog has jump " + jump + "m.");
        }
    }
}