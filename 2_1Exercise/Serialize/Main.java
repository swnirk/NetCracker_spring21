import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        double[] vec1 = {1,7,8,4};
        double[] v1 = {2,8,4,3};
        ArrayVector vect1 = new ArrayVector(v1);
        ArrayVector vector1 = new ArrayVector(vec1);
        FileOutputStream outputStream1 = new FileOutputStream("C:\\Users\\79651\\Documents\\save5");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(outputStream1);

        objectOutputStream1.writeObject(vector1.mult(6));
        objectOutputStream1.writeObject(vector1.sum(vect1));
        objectOutputStream1.writeObject(vector1.getMax());
        objectOutputStream1.writeObject(vector1.getMin());
        objectOutputStream1.writeObject(vector1.scalarMult(vect1));
        objectOutputStream1.writeObject(vector1.getNorm());

        objectOutputStream1.close();
    }

    }
