import java.lang.reflect.Array;
import java.util.*;

public class AnalysisOfStrings {

    private String string1;
    private String string2;

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    //Find elements in both strings
    public List<String> inBothStrings(String string1, String string2) {

        List<String> similar = new ArrayList<>();

        String[] str1 = string1.split(" ");
        String[] str2 = string2.split(" ");

        for(int i = 0; i < str1.length; i++) {

            for(int j = 0; j < str2.length; j++) {

                if (str1[i].equals(str2[j])) similar.add(str1[i]);
            }
        }
        return similar;
    }

    //Find elements in only first string
    public List<String> inOneString (String string1, String string2) {

        String[] str1 = string1.split(" ");
        String[] str2 = string2.split(" ");
        List<String> onlyOne = new ArrayList<>(Arrays.asList(str1));

        for(int i = 0; i < onlyOne.size(); i++) {

            for(int j = 0; j < str2.length; j++) {

                if (onlyOne.get(i).equals(str2[j])) onlyOne.remove(onlyOne.get(i));
            }
        }
        return onlyOne;
    }

    public List<String> inFirstOrSecondString (String string1, String string2) {

        String[] str1 = string1.split(" ");
        String[] str2 = string2.split(" ");
        Set<String> elements = new HashSet<String>();
        Collections.addAll(elements, str1);
        Collections.addAll(elements, str2);
        List<String> listElements = new ArrayList<>();
        listElements.addAll(elements);
        return listElements;
    }

    //Print elements in normal order
    public void normalPrint(List<String> list) {

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    //Print elements in back order
    public void backPrint(List<String> list){

        for (int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(i));
    }

    public static void main (String[] args) {

        String string1 = "a r h ^ [";
        String string2 = "g u a ^ [ ";
        AnalysisOfStrings test = new AnalysisOfStrings();
        test.normalPrint(test.inBothStrings(string1,string2));
        System.out.println("*****************************************");
        test.backPrint(test.inBothStrings(string1,string2));
        System.out.println("*****************************************");
        test.normalPrint(test.inOneString(string1,string2));
        System.out.println("*****************************************");
        test.backPrint(test.inOneString(string1,string2));
        System.out.println("*****************************************");
        test.normalPrint(test.inFirstOrSecondString(string1,string2));


        float f=0;
    }
}

