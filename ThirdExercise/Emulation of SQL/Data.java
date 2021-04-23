public class Data {

    private String firstName;
    private String lastName;
    private String groupID;
    private int studentID;
    private int dolg;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getDolg() {
        return dolg;
    }

    public void setDolg(int dolg) {
        this.dolg = dolg;
    }

    public Data(String firstName, String lastName, String groupID, int studentID, int dolg){

        this.firstName = firstName;
        this.lastName = lastName;
        this.groupID = groupID;
        this.studentID = studentID;
        this.dolg = dolg;
    }




}
