import java.util.Arrays;
import java.util.Scanner;

public class CopyStudents {

    public static void main (String[] args) {

        T_Student studArray = new T_Student();

        //Add students to T_Student table

        studArray.add(new Data("Irina","Lebedeva", "'B01-902'",456, 1 ));
        studArray.add(new Data("Viktoriia","Uvarova", "'B01-903'",896, 10 ));
        studArray.add(new Data("KeyReal","Abramov", "'B01-902'",696, 5 ));

        //Define parametrs by which sort students

        System.out.println("Please, enter GroupID");
        Scanner grp = new Scanner(System.in);
        String group = grp.nextLine();

        System.out.println("Please, enter Dolg");
        Scanner dlg = new Scanner(System.in);
        int dolg = grp.nextInt();

        //Add sorted students to tGroupSelected table

        studArray = studArray.findStudent(group,dolg);
        T_Student tGroupSelected = new T_Student();
        System.arraycopy(studArray.getStudents(),0,tGroupSelected.getStudents(),0,3);

        for (int i = 0; i < tGroupSelected.getStudents().length; i++)
            System.out.println(tGroupSelected.get(i).getFirstName() + " " + tGroupSelected.get(i).getLastName() + " " +
                    tGroupSelected.get(i).getGroupID() + " " + tGroupSelected.get(i).getStudentID());
    }
}
