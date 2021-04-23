import java.util.NoSuchElementException;
import java.util.Scanner;

public class Person {

    private String name;
    private String lastname;
    private String patronymic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

//Parse string of FIO

    public Person(String fio) {

        String[] items = fio.split(" ");

        switch (items.length) {
            case 0:
                throw new NoSuchElementException("You don't enter your FIO");
            case 1:
                throw new NoSuchElementException("Please, enter your name and patronymic");
            case 2:
                throw new NoSuchElementException("Please, enter your patronymic");
        }

        this.lastname = items[0];
        this.name = items[1];
        this.patronymic = items[2];
    }


    //Print initials
    public void printFIO(String fio) {

        String lName = fio.split(" ")[0];
        String name = fio.split(" ")[1].substring(0,1);
        String pat = fio.split(" ")[2].substring(0,1);

        if(fio.split(" ")[2] == "\n") throw new NullPointerException("Exception: name or patronymic  is null!");

        System.out.println(lName + " " + name + "." + pat + ".");

    }

    public static void main (String[] args) {

        System.out.println("Please, enter your FIO:");
        Scanner str = new Scanner(System.in);
        String fio = str.nextLine();
        Person person = new Person(fio);
        person.printFIO(fio);

    }

    }





