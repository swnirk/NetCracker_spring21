import java.util.Scanner;

public class PhoneNumber {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public PhoneNumber() {
        this.number = number;
    }

    public String changeNumber(String number) {

        //Discover format of phone number and transform to desired format

        String num = number.substring(0, 1);

        if (num.equals("+"))
            return String.format("%s(%s)-%s-%s", number.substring(0, number.length() - 10),
                        number.substring(number.length() - 10,number.length() - 7),
                        number.substring(number.length() - 7, number.length() - 4),
                        number.substring(number.length() - 4));


        else
            return String.format("+7%s-%s-%s", number.substring(1, 4),
                    number.substring(4, 7),
                    number.substring(7, 11));
    }

        public static void main (String[] args) {

            System.out.println("Please, enter your phone number:");
            Scanner str = new Scanner(System.in);
            String phone = str.nextLine();

            PhoneNumber number = new PhoneNumber();
            System.out.println(number.changeNumber(phone));



    }
}
