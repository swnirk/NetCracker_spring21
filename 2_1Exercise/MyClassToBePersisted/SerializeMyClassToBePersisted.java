import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeMyClassToBePersisted implements Serializable {

    public static void main(String[] args) throws IOException {

        String profile = "Lebedeva Irina";
        String group = "B01-902";

        MyClassToBePersisted person = new MyClassToBePersisted(profile, group);

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\79651\\Documents\\save");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(person);

        objectOutputStream.close();
    }


}
