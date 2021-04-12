import java.util.Scanner;

public interface ThePriceIsRight {

    int setPrice(int price);
    void chekPrice(int price);
}

//realise of interface

class ThePriceIsRightImpl implements ThePriceIsRight {
  
  //set a price
    @Override
    public int setPrice(int price) {
        return price;
    }

  //chek a price
  
    @Override
    public void chekPrice(int price) {

        int priceNow = setPrice(1000);

        if (priceNow < price)
            System.out.println("lower");

        else if (priceNow > price)
            System.out.println("higher");

        else System.out.println("The price is right!");

    }
}

class InterfaceRun {

    public static void main (String[] args) {

    ThePriceIsRightImpl priceRun = new ThePriceIsRightImpl();

    System.out.println("Now price is " + priceRun.setPrice(1000));

    System.out.println("Please, enter your price");
    Scanner pr = new Scanner(System.in);
    int price = pr.nextInt();

    priceRun.chekPrice(price);

    }
}

