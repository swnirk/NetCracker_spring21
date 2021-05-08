import java.io.Serializable;
import java.util.Arrays;

public class ArrayVector implements Serializable {

    private static final long serialVersionUID = 1L;

    private double[] vector;

    public ArrayVector(double[] vector) {
        this.vector = vector;
    }

    public void set(double... elements) {
        this.vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = elements[i];
        }
    }

    public double[] get() {
        return vector;
    }

    public ArrayVector clone() {
        ArrayVector arrayVector = new ArrayVector(vector);
        arrayVector.set(vector);
        return arrayVector;
    }

    public int getSize() {
        return vector.length;
    }

    public void set(int index, double value) {

        if (index >= vector.length){
            double[] arrayVector = new double[index + 1];
            System.arraycopy(vector,0, arrayVector, 0, vector.length);
            for (int i = vector.length; i < index; i++)
                arrayVector[i] = 0d;
            arrayVector[index] = value;
            vector = arrayVector;
        }
        else if(index >= 0)
            vector[index] = value;
    }

    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= vector.length) throw new ArrayIndexOutOfBoundsException();
        return vector[index];
    }

    public double getMax() {

        if (vector.length >= 1) {
            double max = vector[0];
            for (int i = 0; i < vector.length; i++)
                max = Math.max(vector[i], max);
            return max;
        }
        return 0;
    }

    public double getMin() {
        if (vector.length >= 1) {
            double min = vector[0];
            for (int i = 0; i < vector.length; i++)
                min = Math.min(vector[i], min);
            return min;
        }
        return 0;
    }

    public void sortAscending() {
        Arrays.sort(vector);

    }

    public Object mult(double factor) {

        for (int i = 0; i < vector.length; i ++){
            vector[i] = vector[i]*factor;
        }
        return vector;
    }

    public ArrayVector sum(ArrayVector anotherVector) {

        for (int i = 0; i < Math.max(vector.length, anotherVector.getSize()); i++)
            vector[i] = vector[i] + anotherVector.get(i);
        return this;
    }

    public double scalarMult(ArrayVector anotherVector) {
        double scalar = 0d;
        for (int i = 0; i < Math.max(vector.length, anotherVector.getSize()); i++) {
            vector[i] = vector[i]*anotherVector.get(i);
            scalar = scalar + vector[i];
        }
        return scalar;
    }

    public double getNorm() {

        double scalar = 0d;
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * vector[i];
            scalar = scalar + vector[i];
        }
        return Math.sqrt(scalar);
    }
}
