import java.util.Scanner;

public class Quadratic {

    public double a;
    public double b;
    public double c;
    public double x1, x2;


    public class Discrimenant{

        public double D;

        public double foundDisk() {

            /*A = Quadratic.this.a;
            B = Quadratic.this.b;
            C = Quadratic.this.c;*/

            return (D = b*b - 4*a*c);
        }

    }

    public double solve() {

        Discrimenant d = new Discrimenant();

        if(a == 0)
            System.out.println("It isn't quadratic equation!");

        else if(d.foundDisk() < 0)
            System.out.println("Can't found solve!");
        else {
            x1 = (-b + Math.sqrt(d.foundDisk())) / (2 * a);
            x2 = (-b - Math.sqrt(d.foundDisk())) / (2 * a);

            System.out.println("Answer: x1 = " + x1 + " x2 = " + x2);
        }

        return 0;

    }

    public static void main (String args[]) {

        Quadratic equation = new Quadratic();

        System.out.println("Please, enter coef");

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        equation.a = sc1.nextDouble();
        equation.b = sc2.nextDouble();
        equation.c = sc3.nextDouble();
        equation.solve();
    }




}
