import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrintByMyself {

        public static void main(String[] args) throws IOException {

            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\79651\\IdeaProjects\\ProgrammPrint\\src\\PrintByMyself.java"), StandardCharsets.UTF_8);

            for (String s: lines) {
                System.out.println(s);
            }
        }
}
