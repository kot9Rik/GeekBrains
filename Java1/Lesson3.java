/**
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
     * 1. ՠط��� ��֬����, ������ 󠬠��련� �������֨ ����� �� 0 �� 9,
     *    � ��������М ������ 3 �����Ʒ 笠���� ��� �����. �� Ơ�ֽ �����ƨ
     *    ������� ����� ��֢���� ������ з �Ơ���֨ ��������Ш� ����� ���
     *    󠬠����֨, �з Ҩ����. ���Ш �֢��� �з ��ַ����� ���֦���� �����
     *    ��������� ���� ��� ��? 1 - �� / 0 - Ԩ� (1 - ��������, 0 - Ԩ�).
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
     * 2. * ����� Ҡ��� �� ����
     *      String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     *      "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
     *      "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
     *      "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
     *      "potato"};
     *    �� ����ƨ ��֬���� ������� 󠬠��련� �����, �����련� ����
     *    � ����������, ���Է련� ��� � 󠬠������ ������ � ��֢����
     *    ������� з ����� ����������. ��з ����� Ԩ 笠����, �������
     *    ��Ơ��련� ����� ������ ����� Ԡ ��ַ� Ҩ�堵.
     *      apple - 󠬠����֨
     *      apricot - ���� ����Ơ
     *      ap#############
     *    (15 �������, ��֢� ���������� Ԩ �֬ ��Ԡ�� �з�� ����)
     *    ��� ���ԨԷ� ��� ���� ����������, ����� �����������:
     *    str.charAt(0) - Ҩ�֦ ��Ԩ� char, ������ ��ַ� � ���� str Ԡ
     *    ب��ֽ ��󷤷�, ��ᠨ� �� 娵 ���, ��Ơ ����� Ԩ �嬠���� �����,
     *    ��������� ������ ҠШ��Ʒ� �����
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