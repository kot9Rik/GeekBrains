/**
 * Java. Level 1. Lesson 2. Example of homework
 *
 * @author Aleksandr Vvedenskiy
 * @version dated Jul 21, 2017
 */
 
 import java.util.*;
 
 class Lesson2 {
	 
	 public static void main(String[] args){
		 invertArray();
		 fillArray();
		 changeArray();
		 fillDiagonal();
		 findMinMax();
	 }
	 
    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     *    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. 
     *    С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
	static void invertArray() {
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
		String str = "";
		for (int i = 0; i < a.length; i++) {
		    if (a[i] == 0) a[i] = 1;
			else a[i] = 0;
		} 
		for (int i = 0; i < a.length; i++) {
		    str = str + " " + a[i];	
		}
		System.out.println(str);
	}	
	
    /**
     * 2. Задать пустой целочисленный массив размером 8. 
     *    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
     */
	static void fillArray() {
		int[] arr = new int[8];
		String str = "";
		for (int i = 0, j = 0; i < arr.length; i++, j += 3) {
			arr[i] = j;
		}
		for (int i = 0; i < arr.length; i++) {
		    str = str + " " + arr[i];	
		}
		System.out.println(str);
	}
	
    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему
     *    циклом, и числа меньшие 6 умножить на 2.
     */
	static void changeArray() {
		int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 6) 
				a[i] = a[i] * 2;
		}
		System.out.println(Arrays.toString(a));
	}
	
    /**
     * 4. Создать квадратный двумерный целочисленный массив 
     *    (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
     *    заполнить его диагональные элементы единицами.
     */
	static void fillDiagonal() {
		int size = 5;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - i - 1] = 1;
        }
        for (int i = 0; i < size; i++)
            System.out.println(Arrays.toString(arr[i]));
	}
	
    /**
     * 5. ** Задать одномерный массив и найти в нем минимальный 
     *       и максимальный элементы (без помощи интернета).
     */
	static void findMinMax() {
		int[] a = {1, 5, 3, 2, -11, 4, 8, 9};
		int max = a[0], min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
			    max = a[i];
			if(a[i] < min)
				min = a[i];
		}
		System.out.println(" max " + max);
		System.out.println(" min " + min);			
	}
 }