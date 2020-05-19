package GoFo;

public class Playground{
    private String name,location,available_hours,status;
    private int size;
    private float price_per_hour,cancelation_period;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailable_hours() {
        return available_hours;
    }

    public void setAvailable_hours(String available_hours) {
        this.available_hours = available_hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getPrice_per_hour() {
        return price_per_hour;
    }

    public void setPrice_per_hour(float price_per_hour) {
        this.price_per_hour = price_per_hour;
    }

    public float getCancelation_period() {
        return cancelation_period;
    }

    public void setCancelation_period(float cancelation_period) {
        this.cancelation_period = cancelation_period;
    }
}
