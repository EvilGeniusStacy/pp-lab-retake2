import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticalOperationsImpl implements StatisticalOperations {

    private List<DataSet> dataSets;

    public StatisticalOperationsImpl() {
        this.dataSets = new ArrayList<>();
    }

    public void addDataSet(DataSet dataSet) {
        dataSets.add(dataSet);
    }

    public void removeDataSet(int index) {
        dataSets.remove(index);
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    @Override
    public double getMean(DataSet dataSet) {
        double sum = 0.0;
        for (Double number : dataSet.data) {
            sum += number;
        }
        return sum / dataSet.size();
    }

    @Override
    public double getMedian(DataSet dataSet) {
        List<Double> sortedData = new ArrayList<>(dataSet.data);
        Collections.sort(sortedData);
        int middleIndex = sortedData.size() / 2;
        if (sortedData.size() % 2 == 0) {
            return (sortedData.get(middleIndex) + sortedData.get(middleIndex - 1)) / 2.0;
        } else {
            return sortedData.get(middleIndex);
        }
    }

    @Override
    public double getStandardDeviation(DataSet dataSet) {
        double mean = getMean(dataSet);
        double sumOfSquares = 0.0;
        for (Double number : dataSet.data) {
            sumOfSquares += Math.pow(number - mean, 2);
        }
        return Math.sqrt(sumOfSquares / (dataSet.size() - 1));
    }
}