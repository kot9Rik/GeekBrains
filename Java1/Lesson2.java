/**
 * Java. Level 1. Lesson 2. Example of homework
 *
 * @author Aleksandr Vvedenskiy
 * @version dated Jul 20, 2017
 */
 
 class Lesson2 {
	 
	 public static void main(String[] args){
		 invertArray();
	 }
	 
	/**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * 	  Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. 
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
		System.out.print(str);
	}	
	
 }