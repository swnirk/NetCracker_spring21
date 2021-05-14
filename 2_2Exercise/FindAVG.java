import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindAVG {

    public void readNumbers(String fileWay) throws IOException {

        Path path = Paths.get(fileWay);
        String[] numbers = Files.readString(path).split("\s");
        int[] intNumbers = new int[numbers.length];
        for(int i = 0; i < intNumbers.length; i++)
            intNumbers[i] = Integer.parseInt(numbers[i]);

        System.out.println("Average of full array: " + AVG(intNumbers, intNumbers[0], 1, 0, intNumbers.length));
        System.out.println("Average of second half array: " + AVG(intNumbers, intNumbers[0], 1, intNumbers.length / 2, intNumbers.length / 2));
        System.out.println("Average of third quarter array: " + AVG(intNumbers, intNumbers[0], 1, (int) ((float) intNumbers.length * (2 / 3)), intNumbers.length / 4));
    }

    static private float AVG(int[] numbers, float average, int count, int from, int res) {
        if (count >= res)
            return average;
        float nextAverage = ((average * count) + (float) numbers[count]) / (float) (count + 1);
        return AVG(numbers, nextAverage, count + 1, from, res);
    }


    public static void main(String[] args) throws IOException {

        int[] dataInt = {1, 7, 6, 8};
        //FileWriter writer = new FileWriter("C:\\Users\\79651\\Desktop\\array.txt");
        Path path = Paths.get("C:\\Users\\79651\\Desktop\\array.txt");
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < dataInt.length; i++) {
            numbers.append(dataInt[i]);
            numbers.append(' ');
        }
        Files.write(path, numbers.toString().getBytes());
         FindAVG avg = new FindAVG();
         avg.readNumbers("C:\\Users\\79651\\Desktop\\array.txt");
    }
}
