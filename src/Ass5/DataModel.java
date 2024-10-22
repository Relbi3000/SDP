package Ass5;

public class DataModel {
    private String data;

    public DataModel() {
        this.data = "Initial Data";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void appendData(String moreData) {
        this.data = this.data + " | " + moreData;
    }
}
