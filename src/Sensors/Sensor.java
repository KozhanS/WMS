package Sensors;

import java.util.Arrays;

public class Sensor
{
    private double[] data;
    private final String type;
    double sum =0, avg;

    public void setData(double[] inf){
        data = inf;
    }

    protected double[] getData(){
        return data;
    }

    public Sensor(String type){
        this.data = new double[]{};
        this.type = type;
    }

    public void dataDisplay(){
        for(double temp : data){
            System.out.print(temp + " ");
        }
    }



    public void dataAnalysisCalculate(){
        for(double temp : data){
            sum += temp;
        }
        avg = sum/(data.length);
    }

    public void dataAnalysisDisplay(){
        switch(type){
            case "Temperature":
                System.out.printf("Average week Temperature: %.2f\n", avg);
                sum =0;
                avg=0;
                break;
            case "Humidity":
                System.out.printf("Average week Humidity: %.0f%%\n", avg);
                sum =0;
                avg=0;
                break;
            case "Pressure":
                System.out.printf("Average week pressure: %.2f\n", avg);
                sum =0;
                avg=0;
                break;
        }
    }
}
