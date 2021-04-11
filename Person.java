import java.time.LocalDate;
import java.util.*;

public class Person {

    private String name;
    private String surname;
    private LocalDate date;
    private Address address;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, String surname, LocalDate date, Address address) {

        this.name = name;
        this.surname = surname;
        this.date = date;
        this.address = address;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getSurname().equals(person.getSurname()) && getDate().equals(person.getDate()) && getAddress().equals(person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getDate(), getAddress());
    }

    public static void main (String[] args) {

        PersonFound manArray = new PersonFound();
        peoples(manArray);

        System.out.println("*** The oldest human:");
        manArray.foundTheOldest();

        System.out.println("*** The youngest human:");
        manArray.foundTheYoungest();

        System.out.println("*** Peoples, who burn between 1990.08.11 and 2001.05.06:");
        manArray = manArray.foundBetweenDates(LocalDate.of(1990, 8, 11), LocalDate.of(2001, 5, 06));
        showResult(manArray);

        System.out.println("*** Please, enter surname:");
        Scanner sur = new Scanner(System.in);
        String surname = sur.nextLine();
        int s = manArray.foundSurname(surname);
        System.out.println(manArray.get(s).getName() + " " + manArray.get(s).getSurname() + ": " + manArray.get(s).getDate() + " " + manArray.get(s).getAddress().getCountry() + " " + manArray.get(s).getAddress().getCity() + " " + manArray.get(s).getAddress().getStreet() + " " +  manArray.get(s).getAddress().getHouse());


        System.out.println("*** Please, enter Country, City, Street, house:");
        Scanner adr = new Scanner(System.in);
        String address = adr.nextLine();

        manArray = manArray.foundAddress(address);
        showResult(manArray);


        System.out.println("*** Please, enter street:");
        Scanner str = new Scanner(System.in);
        String street = str.nextLine();

        manArray = manArray.foundSameStreet(street);
        showResult(manArray);

    }

    private static void peoples(PersonFound manArray) {
        manArray.add(new Person("Kirill", "Abramov", LocalDate.of(1970, 3, 25), new Address("Russia, Dmitrov, Shkolnya, 40")));
        manArray.add(new Person("Ksenia", "Shirokova", LocalDate.of(2000, 5, 3), new Address("Russia, Izhevsk, Shkolnya, 30")));
        manArray.add(new Person("Ira", "Lebedeva", LocalDate.of(2001, 7, 21), new Address("Russia, Dolgoprydny, Pervomaiskya, 34")));
        manArray.add(new Person("Vika", "Uvarova", LocalDate.of(2001, 3, 18), new Address("Russia, Moscow, Tverskya, 76" )));
    }

    private static void showResult(PersonFound array) {
        for (int i = 0; i < array.getArray().length; i++) {

            System.out.println(array.get(i).getName() + " " + array.get(i).getSurname() + ": " + array.get(i).getDate() + " " + array.get(i).getAddress().getCountry() + " " + array.get(i).getAddress().getCity() + " " + array.get(i).getAddress().getStreet() + " " +  array.get(i).getAddress().getHouse());
        }
    }

}

