package GoFo;

import java.util.Scanner;
import java.util.Vector;

public class Playground_Owner extends User{
    /**
     * Add Playground Request Function
     * this function save a playground owner request to add new playground
     * @param ALL This Vector Store All Playgrounds In the System
     * @param play the playground info that the owner request to add
     */
    void Add_playground_request(Vector<Playground> ALL ,Playground play){
        ALL.add(play);
    }

    /**
     * set available hours function
     * this function change the available hours attribute for a stored playground
     * @param hours the values of available hour the owner want to change
     * @param ALL This Vector Store All Playgrounds In the System
     */
    void set_available_hours(int hours ,Vector<Playground> ALL){
        System.out.println("Enter Playground Name: ");
        Scanner scanner= new Scanner(System.in);
        String playground_name = scanner.nextLine();
        for (int i=0;i<ALL.size();i++){
            if (ALL.elementAt(i).getOwner().equalsIgnoreCase(this.getName()) && ALL.elementAt(i).getName().equalsIgnoreCase(playground_name)){
                ALL.elementAt(i).setAvailable_hours(hours);
            }
        }
        System.out.println("Available Hours Changed Successfully\n");
    }

    /**
     * View booking
     * This function print all bookings that owner's playgrounds had
     * @param All vector that contain all information about bookings
     * @return
     */
    String view_booking(Vector <Booking_Struct> All){
        for (int i = 0; i<All.size(); i++)
        {
            if (All.elementAt(i).getPlayground_owner().equalsIgnoreCase(this.getName()))
            {
                System.out.println((i+1) + "- Player name: " + All.elementAt(i).getPlayer_name() +
                        " & Playground name: " + All.elementAt(i).getPlayground_name() + " & " + All.elementAt(i).getHours() +
                        " hour(s) & total: " + All.elementAt(i).getTotal() + " & Date: " + All.elementAt(i).getDate());
            }
        }
        return null;
    }

    /**
     * Check Money Function
     * this function check the balance of playground owner to tell him how much he has
     * @return string contain a balance of his account
     */
    String Check_money(){
        String msg;
        msg = "Your Balance Is : " + this.wallet.getBalance();
        return msg;
    }
}
