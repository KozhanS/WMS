package Sensors;

import java.util.Arrays;

public class HumiditySensor extends Sensor {

    public HumiditySensor() {
        super("Humidity");
    }

    @Override
    public void dataDisplay(){
        System.out.print("H: ");
        for(double hum : getData()){
            System.out.printf("%.0f%% ", hum);
        }
    }
}
