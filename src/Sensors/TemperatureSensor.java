package Sensors;

import java.util.Arrays;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor() {
        super("Temperature");
    }

    @Override
    public void dataDisplay(){
        System.out.print("T: ");
        for(double temp : getData()){
            System.out.print(temp + " ");
        }
    }
}
