import java.util.Arrays;

public class T_Student {

    private int i = 0;
    private int max = 5;
    private Data[] students = new Data[max];

    public Data[] getStudents() {
        return students;
    }

    public void setStudents(Data[] students) {
        this.students = students;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void add(Data person) {

        if (i < max)
            this.students[i] = person;

        else {
            max = max + 5;
            students = Arrays.copyOf(students, max);
            students[i] = person;
        }
        i++;
    }

    //Find students from specific group and with specific dolg

    public T_Student findStudent(String groupId, int dolg) {

        T_Student studentArray = new T_Student();
        for (int j = 0; j < i; j++) {
            if (students[j].getGroupID().equals(groupId) && students[j].getDolg() > dolg)
                studentArray.add(students[j]);
        }
        return studentArray;
    }

    //Return student for specific index
    public Data get(int n) {
        return students[n];
    }
}

