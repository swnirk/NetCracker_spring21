import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class CopyDoc {

    public void findWord(String fileWay) throws IOException {

        String word = "java";
        int count = 0;
        List<String> lines = Files.readAllLines(Paths.get(fileWay), StandardCharsets.UTF_8);
        //StringJoiner joiner = new StringJoiner(" ");
        for (String s : lines) {
            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                    if (words[i].equalsIgnoreCase(word)) {
                        count++;
                        System.out.println("COUNT OF WORD <JAVA> = " + count);
                    }
                    if(count == 3) break;
                    //String res = String.join(" ", lines);
                    System.out.println(words[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //documentation
        Path documentation = Paths.get("C:\\Users\\79651\\Desktop\\standard-names.txt");
        //copy documentation to file
        Path copyFile = Files.copy(documentation, Paths.get("C:\\Users\\79651\\Desktop\\copyDoc.txt"));

        //print file, while count of word "java" != 3
        CopyDoc find = new CopyDoc();
        find.findWord("C:\\Users\\79651\\Desktop\\copyDoc.txt");
    }
}
