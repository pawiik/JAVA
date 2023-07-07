package pl.edu.pwr.pdabrowski.lab02;

import java.util.ArrayList;
import java.util.List;


public class DataAnalizer {

    public static List<String> calculate(List<Measure> data){
        double temperature = 0;
        double pressure = 0;
        double humidity = 0;

        for (Measure m : data) {
            temperature += m.getTemperature();
            pressure += m.getPressure();
            humidity += m.getHumidity();
        }

        temperature /= data.size();
        pressure /= data.size();
        humidity /= data.size();

        List<String> map = new ArrayList<>();

        map.add("Average temperature = " +  temperature);
        map.add("Average pressure = " + pressure);
        map.add("Average humidity = " + humidity);

        return map;
    }
}
