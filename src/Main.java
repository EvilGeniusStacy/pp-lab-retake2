import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataSet dataSet1 = new DataSet();
        dataSet1.addData(1.0);
        dataSet1.addData(2.0);
        dataSet1.addData(3.0);

        DataSet dataSet2 = new DataSet();
        dataSet2.addData(4.0);
        dataSet2.addData(5.0);
        dataSet2.addData(6.0);

        DataSet dataSet3 = new DataSet();
        dataSet3.addData(7.0);
        dataSet3.addData(8.0);
        dataSet3.addData(9.0);

        StatisticalOperationsImpl statisticalOperations = new StatisticalOperationsImpl();

        statisticalOperations.addDataSet(dataSet1);
        statisticalOperations.addDataSet(dataSet2);
        statisticalOperations.addDataSet(dataSet3);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu:");
        System.out.println("1. Dodaj nowy zbiór danych");
        System.out.println("2. Usuń istniejący zbiór danych");
        System.out.println("3. Wykonaj operacje statystyczne");
        System.out.println("4. Wyjdź");

        int choice = scanner.nextInt();

        while (choice != 4) {
            switch (choice) {
                case 1:
                    DataSet newDataSet = new DataSet();
                    System.out.println("Wprowadź liczby oddzielone przecinkami:");
                    String input = scanner.nextLine();
                    String[] numbers = input.split(",");
                    for (String number : numbers) {
                        newDataSet.addData(Double.parseDouble(number));
                    }
                    statisticalOperations.addDataSet(newDataSet);
                    System.out.println("Dodano nowy zbiór danych.");
                    break;
                case 2:
                    System.out.println("Wprowadź numer zbioru danych, który chcesz usunąć:");
                    int dataSetIndex = scanner.nextInt();
                    statisticalOperations.removeDataSet(dataSetIndex - 1);
                    System.out.println("Usunięto zbiór danych.");
                    break;
                case 3:
                    System.out.println("Wybierz operację:");
                    System.out.println("1. Średnia arytmetyczna");
                    System.out.println("2. Mediana");
                    System.out.println("3. Odchylenie standardowe");
                    int operationChoice = scanner.nextInt();
                    System.out.println("Wprowadź numer zbioru danych:");
                    int DataSetIndex = scanner.nextInt();
                    DataSet dataSet = statisticalOperations.getDataSets().get(DataSetIndex - 1);
                    double result = 0.0;
                    switch (operationChoice) {
                        case 1:
                            result = statisticalOperations.getMean(dataSet);
                            break;
                        case 2:
                            result = statisticalOperations.getMedian(dataSet);
                            break;
                        case 3:
                            result = statisticalOperations.getStandardDeviation(dataSet);
                            break;
                    }
                    System.out.println("Wynik: " + result);
                    break;
            }

            System.out.println("Menu:");
            System.out.println("1. Dodaj nowy zbiór danych");
            System.out.println("2. Usuń istniejący zbiór danych");
            System.out.println("3. Wykonaj operacje statystyczne");
            System.out.println("4. Wyjdź");

            choice = scanner.nextInt();
        }

        scanner.close();
    }
}