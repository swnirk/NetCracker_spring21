import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeMyClassToBePersisted {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\79651\\Documents\\save");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        MyClassToBePersisted person = (MyClassToBePersisted) objectInputStream.readObject();

        System.out.println(person);
    }
}
