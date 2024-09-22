import Sensors.HumiditySensor;
import Sensors.PressureSensor;
import Sensors.Sensor;
import Sensors.TemperatureSensor;

import java.util.Scanner;

public class mainNew {
    public static void main(String[] args) {
        double[][] week1 = {
                {12.3, 18.2, 19.3, 20.4, 22.25, 12.8, 20.3}, // temp
                {100.82, 101.13, 100.90, 100.81, 101.46, 101.93, 101.08}, // pres
                {67, 68, 81, 71, 58, 58, 55}  // hum
        };

        Sensor[] sensors = {
                new TemperatureSensor(),
                new PressureSensor(),
                new HumiditySensor()
        };

        setDataForAll(sensors, week1);
        calculateAndPrintAll(sensors);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (showMenu(scanner)) {
                case 1 -> collectData(sensors, week1);
                case 2 -> displayAll(sensors);
                case 3 -> calculateAndPrintAll(sensors);
                case 4 -> {
                    System.out.println("Exiting");
                    return;
                }
                default -> System.out.println("Invalid action.");
            }
        }
    }

    private static int showMenu(Scanner scanner) {
        System.out.println("1. Collect Data");
        System.out.println("2. Display Collected Data");
        System.out.println("3. Analyze Data");
        System.out.println("4. Exit");
        return scanner.nextInt();
    }

    public static void calculateAndPrintAll(Sensor[] sensors) {
        for (Sensor sensor : sensors) {
            sensor.dataAnalysisCalculate();
            sensor.dataAnalysisDisplay();
        }
    }

    public static void collectData(Sensor[] sensors, double[][] data) {
        setDataForAll(sensors, data);
    }

    public static void setDataForAll(Sensor[] sensors, double[][] data) {
        for (int i = 0; i < sensors.length; i++) {
            sensors[i].setData(data[i]);
        }
    }

    public static void displayAll(Sensor[] sensors) {
        for (Sensor sensor : sensors) {
            sensor.dataDisplay();
            System.out.println();
        }
    }
}
