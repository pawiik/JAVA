package pl.edu.pwr.pdabrowski.lab02;

public class Measure {

    private String hour;
    private float pressure;
    private float temperature;
    private float humidity;

    public Measure(String hour, float pressure, float temperature, float humidity) {
        this.hour = hour;
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getHour() {
        return hour;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "hour='" + hour +
                ", pressure='" + pressure +
                ", temperature='" + temperature  +
                ", humidity='" + humidity  +
                '}';
    }
}
