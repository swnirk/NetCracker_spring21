import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

public class Vectors implements Serializable {

    public void multOnScalar(double[] vector, double value) {

        for (int i = 0; i < vector.length; i++)
            vector[i] = vector[i]*value;
    }

    public double[] sumTwoVectors(double[] vector1, double[] vector2) {

        if (vector1.length != vector2.length) System.out.println("Can't sum vectors!");

        double[] sum = new double[0];
        for (int i = 0; i < vector1.length; i++)
            sum[i] = vector1[i] + vector2[i];

        return sum;
    }

    public double scalarMult (double[] vector1, double[] vector2) {

        if (vector1.length != vector2.length) System.out.println("Can't multiply vectors!");
        double scalar = 0d;
        for(int i = 0; i < vector1.length; i++)
            scalar = scalar + vector1[i]*vector2[i];

        return scalar;
    }

    public void outputVector(Vector<Integer> v, OutputStream out) throws IOException {

        String vector = v.toString();
        byte[] bytes = vector.getBytes(StandardCharsets.UTF_8);
        out.write(bytes);
    }

    public Vector inputVector(InputStream in) throws IOException {

        return readVector(new InputStreamReader(in));
    }

    public void writeVector(Vector v, Writer out) throws IOException {

        String bytes = "";
        for (int i = 0; i < v.size(); i++)
            bytes += v.get(i).toString() + " ";
        System.out.println(bytes);
        out.write(bytes.toCharArray(), 0, bytes.toCharArray().length);
    }

    Vector readVector(Reader in) throws IOException {

        Vector v = new Vector();
        StreamTokenizer st = new StreamTokenizer(in);
        st.parseNumbers();
        while(st.nextToken() != StreamTokenizer.TT_EOF) {
           v.add(st.nval);
        }
        return v;
    }

    public static void main (String[] args) throws IOException {

        Vectors obj = new Vectors();
        String v = "1 4 6 3";

        FileOutputStream fs1 = new FileOutputStream("C:\\Users\\79651\\Documents\\vectorcopy1.bin");
        DataOutputStream ds1 = new DataOutputStream(fs1);

        Vector vector1 = obj.inputVector(new ByteArrayInputStream(v.getBytes()));
        obj.outputVector(vector1,ds1);

        FileOutputStream fs2 = new FileOutputStream("C:\\Users\\79651\\Documents\\vectorcopy2.bin");
        DataOutputStream ds2 = new DataOutputStream(fs2);

        Vector vector2 = obj.readVector(new InputStreamReader(new ByteArrayInputStream(v.getBytes())));
        obj.outputVector(vector2,ds2);
    }
}
