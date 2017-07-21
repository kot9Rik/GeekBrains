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
     * 1. Õ Ø·ã åí ØáÖ¬á ÒÒç, ÆÖåÖá Þ ó ¬ ¦ñë ¨å ãÐçû ½ÔÖ¨ û·ãÐÖ Öå 0 ¦Ö 9,
     *    · ØÖÐíóÖë å¨Ðœ ¦ ¨åãÞ 3 ØÖØñåÆ· ç¬ ¦ åí ÷åÖ û·ãÐÖ. Ýá· Æ é¦Ö½ ØÖØñåÆ¨
     *    ÆÖÒØíœå¨á ¦ÖÐé¨Ô ãÖÖ¢ù·åí ¢ÖÐíõ¨ Ð· çÆ ó ÔÔÖ¨ ØÖÐíóÖë å¨Ð¨Ò û·ãÐÖ û¨Ò
     *    ó ¬ ¦ ÔÔÖ¨, ·Ð· Ò¨Ôíõ¨. ÝÖãÐ¨ ØÖ¢¨¦ñ ·Ð· ØáÖ·¬áñõ  ëñëÖ¦·åãÞ ó ØáÖã
     *    ®ÝÖëåÖá·åí ·¬áç ¨ù¨ á ó? 1 - ¦  / 0 - Ô¨å¯ (1 - ØÖëåÖá·åí, 0 - Ô¨å).
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
     * 2. * äÖó¦ åí Ò ãã·ë ·ó ãÐÖë
     *      String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     *      "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
     *      "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
     *      "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
     *      "potato"};
     *    Ýá· ó ØçãÆ¨ ØáÖ¬á ÒÒñ ÆÖÒØíœå¨á ó ¬ ¦ñë ¨å ãÐÖëÖ, ó Øá õ·ë ¨å Öåë¨å
     *    ç ØÖÐíóÖë å¨ÐÞ, ãá ëÔ·ë ¨å ¨¬Ö ã ó ¬ ¦ ÔÔñÒ ãÐÖëÖÒ · ãÖÖ¢ù ¨å
     *    Øá ë·ÐíÔÖ Ð· Öåë¨å·Ð ØÖÐíóÖë å¨Ðí. ©ãÐ· ãÐÖëÖ Ô¨ ç¬ ¦ ÔÖ, ÆÖÒØíœå¨á
     *    ØÖÆ óñë ¨å ¢çÆëñ ÆÖåÖáñ¨ ãåÖÞå Ô  ãëÖ·µ Ò¨ãå µ.
     *      apple - ó ¬ ¦ ÔÔÖ¨
     *      apricot - Öåë¨å ·¬áÖÆ 
     *      ap#############
     *    (15 ã·ÒëÖÐÖë, ûåÖ¢ñ ØÖÐíóÖë å¨Ðí Ô¨ ÒÖ¬ çóÔ åí ¦Ð·Ôç ãÐÖë )
     *    §ÐÞ ãá ëÔ¨Ô·Þ ¦ëçµ ãÐÖë ØÖã·ÒëÖÐíÔÖ, ÒÖéÔÖ ØÖÐíóÖë åíãÞ:
     *    str.charAt(0) - Ò¨åÖ¦ ë¨áÔ¨å char, ÆÖåÖáñ½ ãåÖ·å ë ãÐÖë¨ str Ô 
     *    Ø¨áëÖ½ ØÖó·¤··, ·¬á ¨Ò ¦Ö å¨µ ØÖá, ØÖÆ  ·¬áÖÆ Ô¨ Öå¬ ¦ ¨å ãÐÖëÖ,
     *    ·ãØÖÐíóç¨Ò åÖÐíÆÖ Ò Ð¨ÔíÆ·¨ ¢çÆëñ
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