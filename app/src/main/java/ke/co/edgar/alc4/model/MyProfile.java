package ke.co.edgar.alc4.model;

public class MyProfile {
    String label, value;

    public MyProfile() {

    }

    public MyProfile(String label, String value) {
        this.value = value;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
