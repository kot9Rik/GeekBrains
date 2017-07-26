/**
 * Java 2. Lesson 2. Example of homework
 *
 * @author Vvedenskiy Aleksandr
 * @version dated Jul 26, 2017
 */
 
import java.util.*;  
 
class Lesson2 {
    static final int SIZE = 4;
    static String line = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
	
    public static void main(String[] args) {
        System.out.println(line + "\n");	
        System.out.println("Сумма ровна " + calcArray(line));	 	
    }
	
    static float calcArray(String str) {
        float result = 0;
        String[][] array = new String[SIZE][SIZE];
        String[] lines = str.split("\n");
        if (lines.length != SIZE) {
            throw new ArrayIndexOutOfBoundsException("Не соответствует кол-во рядов!!!");
        }	
        for (int i = 0; i < lines.length; i++) {
            array[i] = lines[i].split(" ");
            System.out.println(Arrays.toString(array[i]));
            if (array[i].length != SIZE) {
                throw new ArrayIndexOutOfBoundsException("Не соответствует кол-во колонок!!!");
            }
        }
        for (String[] line : array) {
            for (String a : line) {
                try {
                    result = result + Integer.parseInt(a);
                } catch (NumberFormatException nfe) {
                    System.out.println("В массиве присутствует: \"" + a + "\" " + "\n" + "Массив должен состоять только из чисел!!! ");
                }
            }
        }
        return result/2;
    }
	
}