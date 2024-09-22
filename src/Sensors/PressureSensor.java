package Sensors;

import java.util.Arrays;

public class PressureSensor extends Sensor {

    public PressureSensor() {
        super("Pressure");
    }

    @Override
    public void dataDisplay(){
        System.out.print("P: ");
        for(double pr : getData()){
            System.out.print(pr + " ");
        }
    }
}
