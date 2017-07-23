/**
 * Java. Level 1. Lesson 5. Example of homework
 *
 * @author Aleksandr Vvedenskiy
 * @version dated Jul 23, 2017
 */

class Lesson5 {
    public static void main(String[] args) {
    /**
     *  Создать массив из 5 сотрудников.
     */
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan Ivanovich","Expert",
            "IvanovII@mail.ru","985-123-12-12",2150,31);
        persArray[1] = new Person("Petrov Petr Petrovich","Director",
            "PetrovPP@mail.ru","910-345-34-34",4500,46);
        persArray[2] = new Person("Usov Artem Mihalych","Specialist",
            "UsovAM@mail.ru","926-567-56-56",1150,26);
        persArray[3] = new Person("Smirnova Alla Borisovna","BookKeeper",
            "SmirnovaAB@mail.ru","915-789-78-78",3000,42);
        persArray[4] = new Person("Gorohov Dmitriy Sergeevich","Consultant",
            "GorohovDS@mail.ru","911-901-90-90",1600,36);

    /**
     *  С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
     */
        System.out.println("-----------------Persons are more 40 years old.-----------------");
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                persArray[i].outputPerson();
                System.out.println();
            }	
        }
    }
}

    /**
     *  Создать класс "Сотрудник" с полями: ФИО, должность,
     *  email, телефон, зарплата, возраст.
     */
class Person {
    String fio;
    String position;
    String email;
    String phonenum;
    int cash;
    int age;

    /**
     *  Конструктор класса должен заполнять эти поля при создании объекта.
     */
    Person(String fio, String position, String email, String phonenum, int cash, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phonenum = phonenum;
        this.cash = cash;
        this.age = age;
    }

    /**
     *  Внутри класса «Сотрудник» написать метод, который
     *  выводит информацию об объекте в консоль.
     */
    void outputPerson() {
        System.out.println(fio);
        System.out.println(position);
        System.out.println(email);
        System.out.println(phonenum);
        System.out.println(cash);
        System.out.println(age);
    }
}