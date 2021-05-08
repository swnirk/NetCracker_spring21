import java.io.Serializable;

public class MyClassToBePersisted implements Serializable {

    private static final long serialVersionUID = 1L;

    private String profile;
    private String group;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public MyClassToBePersisted (String profile, String group) {

        this.profile = profile;
        this.group = group;
    }

    @Override
    public String toString() {
        return "MyClassToBePersisted{" +
                "profile='" + profile + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
