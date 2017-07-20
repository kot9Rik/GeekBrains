/**
 * Java. Level 1. Lesson 1. Example of homework
 *
 * @author Aleksandr Vvedenskiy
 * @version dated Jul 20, 2017
 */
 
 class Lesson1 {

    public static void main(String[] args){
        System.out.println(calc(2, 5, 20, 2));
		System.out.println(checkSum(7, 5));
		checkPosOrNeg(10);
		System.out.println(isNeg(10));
		isName("Vasya");
		year(2004);  //Leap-year
		year(2800);  //Leap-year
		year(2100);  //Not leap-year
    }
	
	/**
     * 2. Создать переменные всех пройденных типов данных,
     *    и инициализировать их значения.
     */
	static void createAllVariable() {
		byte a = 11;
		short b = -2456;
		int c = 65432;
		long d = 56743L;
		float e = -123.2f;
		double f = 15.72775;
		boolean g = true;
		char h = 'A';
		String i = "Hello!";
	}
	
	/**
     * 3. Написать метод вычисляющий выражение a * (b + (c / d)) и 
	 *    возвращающий результат,где a, b, c, d – входные параметры
     *    этого метода.
     */
	static int calc(int a, int b, int c, int d) {
	    if (d == 0) return 0;  //division on 0
		return a * (b + (c / d));
	}
	
	/**
     * 4. Написать метод, принимающий на вход два числа, и проверяющий,
     *	  что их сумма лежит в пределах от 10 до 20(включительно), 
	 *    если да – вернуть true, в противном случае – false.
     */
	static boolean checkSum(int a, int b) {
		return ((a + b) >= 10 && (a + b) <= 20); 
	}
	
	/**
     * 5. Написать метод, которому в качестве параметра передается целое число,
     *    метод должен напечатать в консоль положительное ли число передали,
     *	  или отрицательное; Замечание: ноль считаем положительным числом.
     */
	static void checkPosOrNeg(int a) {
		if (a >= 0) System.out.println(a + " it is positive");
		else System.out.println(a + " it is negative");
	}
	
	/**
     * 6. Написать метод, которому в качестве параметра передается целое число,
     *	  метод должен вернуть true, если число отрицательное.
     */
	static boolean isNeg(int a) {
        return (a < 0);
	}	
	
	/**
     * 7. Написать метод, которому в качестве параметра передается строка,
     *    обозначающая имя, метод должен вывести в консоль
	 *    сообщение «Привет, указанное_имя!».
     */
	static void isName(String name) {
		System.out.println("Hello, " + name + "!");
	}
	
	/**
     * 8. * Написать метод, который определяет является ли год високосным,
     *  	и выводит сообщение в консоль. Каждый 4-й год является високосным,
	 *      кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
	static void year(int a) {
	    if (((a % 400) == 0 && (a % 100) == 0) 
			  || ((a % 4) == 0 && (a % 100) != 0))  
             System.out.println("Leap-year"); 
	    else System.out.println("Not leap-year");	
	}
 }