package GoFo;

public class Booking_Struct
{
 private String player_name,playground_name,playground_owner;
 private int hours;
 private float total;
 private String date;

    /**
     * getPlayer_name function
     * @return the name of the player
     */
    public String getPlayer_name() {
        return player_name;
    }
    /**
     * setPlayer_name function
     * this function set the value of the player name
     * @param player_name the value of the player name
     */
    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }
    /**
     * getPlayground_name function
     * @return the name of the playground
     */
    public String getPlayground_name() {
        return playground_name;
    }
    /**
     * setPlayground_name
     * his function set the value of the playground name
     * @param playground_name the value of the playground name
     */
    public void setPlayground_name(String playground_name) {
        this.playground_name = playground_name;
    }
    /**
     * getPlayground_owner function
     * @return the value of playground owner name
     */
    public String getPlayground_owner() {
        return playground_owner;
    }
    /**
     * setPlayground_owner function
     * this function set the value of the playground_owner attribute
     * @param playground_owner value of playground owner name
     */
    public void setPlayground_owner(String playground_owner) {
        this.playground_owner = playground_owner;
    }
    /**
     * getHours function
     * @return the value of hours attribute
     */
    public int getHours() {
        return hours;
    }

    /**
     * setHours function
     * @param hours value of the hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * getTotal function
     * get the value of the total attribute
     * @return total value
     */
    public float getTotal() {
        return total;
    }

    /**
     * setTotal function
     * @param total value that set or updated by
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * setDate function
     * set or update the value of the date
     * @param date value of the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getDate function
     * @return the value of the date
     */
    public String  getDate() {
        return date;
    }

}
