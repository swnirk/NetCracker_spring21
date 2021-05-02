import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Person {

    private LocalDate bDay;


    public LocalDate getBDay() {
        return bDay;
    }

    public void setBDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "bDay=" + bDay +
                '}';
    }

    public String stringOfBDay(LocalDate bDay) {

        String stringDate;
        int year = bDay.getYear();
        int month = bDay.getMonthValue();
        int day = bDay.getDayOfMonth();

        switch (month) {

            case 1: {
                stringDate = String.format("%d января %d года", day, year);
                break;
            }
            case 2: {
                stringDate = String.format("%d февраля %d года", day, year);
                break;
            }
            case 3: {
                stringDate = String.format("%d марта %d года", day, year);
                break;
            }
            case 4: {
                stringDate = String.format("%d апреля %d года", day, year);
                break;
            }
            case 5: {
                stringDate = String.format("%d май %d года", day, year);
                break;
            }
            case 6: {
                stringDate = String.format("%d июня %d года", day, year);
                break;
            }
            case 7: {
                stringDate = String.format("%d июля %d года", day, year);
                break;
            }
            case 8: {
                stringDate = String.format("%d августа %d года", day, year);
                break;
            }
            case 9: {
                stringDate = String.format("%d сентября %d года", day, year);
                break;
            }
            case 10: {
                stringDate = String.format("%d октября %d года", day, year);
                break;
            }
            case 11: {
                stringDate = String.format("%d ноября %d года", day, year);
                break;
            }
            case 12: {
                stringDate = String.format("%d декабря %d года", day, year);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }

        return stringDate;
    }

    public static void main(String[] args) {

        Person per = new Person();
        System.out.println("Please, enter your B-day:");
        Scanner str = new Scanner(System.in);
        String bDay = str.nextLine();

        try {
            DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-M-dd");
            LocalDate data1 = LocalDate.parse(bDay, format1);
            System.out.println(per.stringOfBDay(data1));
        } catch (Exception data) {

            DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate data2 = LocalDate.parse(bDay, format2);
            System.out.println(per.stringOfBDay(data2));
        }
    }
}
