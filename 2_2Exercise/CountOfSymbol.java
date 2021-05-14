import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountOfSymbol {

    public void FindAndSum ( char sym,String fileWay) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWay));
        int symbol = bufferedReader.read();
        int count = 0;
        //while not end of file
        while (symbol != -1) {
            //transform to char
            char c = (char) symbol;
            //read symbol
            symbol = bufferedReader.read();
            //consider count of symbol
            if (c == sym) count++;
        }
        System.out.println("Count of symbol <e> = " + count);
    }

    public static void main (String[] args) throws IOException {

        System.out.println("Please, enter symbol: ");
        CountOfSymbol sym = new CountOfSymbol();
        Scanner c = new Scanner(System.in);
        String  symb = c.nextLine();
        sym.FindAndSum(symb.charAt(0),"C:\\Users\\79651\\Desktop\\findSymbol.txt");
    }
}
