package GoFo;

public class Booking_Struct
{
 private String player_name,playground_name,playground_owner;
 private int hours;
 private float total;
    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayground_name() {
        return playground_name;
    }

    public void setPlayground_name(String playground_name) {
        this.playground_name = playground_name;
    }

    public String getPlayground_owner() {
        return playground_owner;
    }

    public void setPlayground_owner(String playground_owner) {
        this.playground_owner = playground_owner;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
