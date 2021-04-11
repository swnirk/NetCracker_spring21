import java.time.LocalDate;
import java.util.Arrays;

public class PersonFound {

    private int i = 0;
    private int max = 4;
    private Person[] manArray = new Person[max];

    public Person[] getArray() {
        return manArray;
    }

    public void setArray(Person[] array) {
        this.manArray = array;
    }

    public void add(Person person) {

        if (i < max)
            this.manArray[i] = person;

        else {
            max = max + 5;
            manArray = Arrays.copyOf(manArray, max);
            manArray[i] = person;
        }
        i++;
    }

    public int foundSurname(String surname) {

        for(int j = 0; j < i; j++) {
            if (manArray[j].getSurname().equalsIgnoreCase(surname))
                return j;
        }
        return -1;
    }

    public PersonFound foundAddress(String adr) {

        PersonFound personArray = new PersonFound();
        for(int j = 0; j < i; j++) {
            if(manArray[j].getAddress().getAdr().contains(adr))
              personArray.add(manArray[j]);
        }
        return personArray;
    }

    public  PersonFound foundBetweenDates(LocalDate first, LocalDate second) {

        PersonFound personArray = new PersonFound();
        for (int j = 0; j < i; j++) {
            if(first.compareTo(manArray[j].getDate()) <= 0 && second.compareTo(manArray[j].getDate()) >= 0)
                personArray.add(manArray[j]);
        }
        return personArray;
    }

    public Person foundTheOldest() {

        if(i > 0) {
            Person oldest = manArray[0];
            for(int j = 1; j < i; j++) {
                if(oldest.getDate().compareTo(manArray[j].getDate()) >= 0)
                    oldest = manArray[j];
            }
            System.out.println(oldest.getName() + " " + oldest.getSurname() + " " + oldest.getDate() + " " + oldest.getAddress());
            return oldest;
        }
        return null;
    }

    public Person foundTheYoungest() {

        if(i > 0) {
            Person youngest = manArray[0];
            for(int j = 1; j < i; j++) {
                if(youngest.getDate().compareTo(manArray[j].getDate()) <= 0)
                    youngest = manArray[j];
            }
            System.out.println(youngest.getName() + " " + youngest.getSurname() + " " + youngest.getDate() + " " + youngest.getAddress());
            return youngest;
        }
        return null;
    }

    public PersonFound foundSameStreet(String street) {

        PersonFound personArray = new PersonFound();
        for (int j = 0; j < i; j++) {
            if(manArray[j].getAddress().getStreet().equals(street))
                personArray.add(manArray[j]);
        }
        return personArray;
    }

    public Person get(int n) {
        return manArray[n];
    }


}