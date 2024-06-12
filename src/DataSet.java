import java.util.ArrayList;
import java.util.List;

public class DataSet {

    List<Double> data;

    public DataSet() {
        this.data = new ArrayList<>();
    }

    public void addData(double number) {
        data.add(number);
    }

    public void removeData(int index) {
        data.remove(index);
    }

    public double getData(int index) {
        return data.get(index);
    }

    public int size() {
        return data.size();
    }
}
