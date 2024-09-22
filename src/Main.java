import Sensors.HumiditySensor;
import Sensors.PressureSensor;
import Sensors.Sensor;
import Sensors.TemperatureSensor;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double[] week1_temp = new double[]{12.3, 18.2, 19.3, 20.4, 22.25, 12.8, 20.3};
        double[] week1_pres = new double[]{100.82, 101.13, 100.90, 100.81, 101.46, 101.93, 101.08};
        double[] week1_hum = new double[]{67, 68, 81, 71, 58, 58, 55};

        double[] week2_temp = new double[]{10.34, 9.4, 9.32, 8.1, 8.25, 8.8, 7.0};
        double[] week2_pres = new double[]{101.45, 101.65, 101.94, 101.41, 101.70, 102.69, 102.34};
        double[] week2_hum = new double[]{73, 69, 77, 67, 78, 78, 63};

        double[] week_temp = week1_temp;
        double[] week_hum = week1_hum;
        double[] week_pres = week1_pres;

        Sensor Temp = new TemperatureSensor();
        Sensor Humidity = new HumiditySensor();
        Sensor Pressure = new PressureSensor();

        Temp.setData(week_temp);
        Pressure.setData(week_pres);
        Humidity.setData(week_hum);
        calculateAndPrintAll(new Sensor[]{Temp, Humidity, Pressure});

        //calculateAndPrintAll(new Sensor[]{Temp, Humidity, Pressure});

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Collect Data");
            System.out.println("2. Display Collected Data");
            System.out.println("3. Analyze Data");
            System.out.println("4. Exit");
            int action = scanner.nextInt();

                switch (action) {
                    case 1:
                        collectAll(new Sensor[]{Temp, Humidity, Pressure}, week_hum, week_pres, week_temp);
                        break;
                    case 2:
                        displayAll(new Sensor[]{Temp, Humidity, Pressure});
                        break;
                    case 3:
                        calculateAndPrintAll(new Sensor[]{Temp, Humidity, Pressure});
                        break;
                    case 4:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Invalid action.");
                }

        }

    }

    public static void calculateAndPrintAll(Sensor[] sensors) {
        for(Sensor sensor : sensors){
            System.out.println("-".repeat( 10 ) );
            sensor.dataAnalysisCalculate();
            sensor.dataAnalysisDisplay();
        }
    }
    public static void collectAll(Sensor[] sensors, double[] hum, double[] press, double[] temp) {
            sensors[0].setData(temp);
            sensors[1].setData(hum);
            sensors[2].setData(press);
    }
    public static void displayAll(Sensor[] sensors) {
        for(Sensor sensor : sensors){
            sensor.dataDisplay();
            System.out.println();
        }
    }
}
