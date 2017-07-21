﻿/**
 * Java. Level 1. Lesson 3. Example of homework
 *
 * @author Aleksandr Vvedenskiy
 * @version dated Jul 21, 2017
 */
 
 import java.util.*;
 
 class Lesson3 {

    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Make a choice:\n"+
                "1. Guess the Number\n2. Guess the Word\n3. Exit\n: ");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    guessTheNumber();
                    break;
                case "2":
                    guessTheWord();
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * 1. Написать программу, которая загадывает случайное число от 0 до 9,
     *    и пользователю дается 3 попытки угадать это число. При каждой попытке
     *    компьютер должен сообщить больше ли указанное пользователем число чем
     *    загаданное, или меньше. После победы или проигрыша выводится запрос
     *    «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
     */
    static void guessTheNumber() {
        String repeat = "0";
        do {
            int count = 0;
            int guess = -1;
            int number = random.nextInt(10);
            while (count < 3 && guess != number) {
                System.out.print(
                    "Guess [" + (count + 1) + "] the number (0..9): ");
                try {
                    guess = sc.nextInt();
                    if (number == guess) {
                        System.out.println("You won!");
                    } else {
                        System.out.println("Your number is " + ((guess < number)?
                            "greater" : "less."));
                        count++;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Input Mismatch Exception!");
                    sc.next();
                }
            }
            if (count == 3)
                System.out.println("You lost!");
            System.out.print("Repeat the game?\n[1 - yes / 0 - no]: ");
            repeat = sc.next();
        } while (repeat.equals("1"));
    }

    /**
     * 2. * Создать массив из слов
     *      String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     *      "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
     *      "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
     *      "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
     *      "potato"};
     *    При запуске программы компьютер загадывает слово, запрашивает ответ
     *    у пользователя, сравнивает его с загаданным словом и сообщает
     *    правильно ли ответил пользователь. Если слово не угадано, компьютер
     *    показывает буквы которые стоят на своих местах.
     *      apple – загаданное
     *      apricot - ответ игрока
     *      ap#############
     *    (15 символов, чтобы пользователь не мог узнать длину слова)
     *    Для сравнения двух слов посимвольно, можно пользоваться:
     *    str.charAt(0) - метод вернет char, который стоит в слове str на
     *    первой позиции, играем до тех пор, пока игрок не отгадает слово,
     *    используем только маленькие буквы
     */
    static void guessTheWord() {
        String[] words = {
            "apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String guess = null;
        String word = words[random.nextInt(words.length)];
        System.out.println(Arrays.toString(words));
        do {
            System.out.print("Guess the word: ");
            guess = sc.next();
            for (int i = 0; i < 15; i++)
                System.out.print(
                    (i < word.length() && i < guess.length() 
                        && word.charAt(i) == guess.charAt(i))?
                    word.charAt(i) : ((word.equals(guess))? "" : "#"));
            System.out.println();
        } while (!word.equals(guess));
    }
	
 }