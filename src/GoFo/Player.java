package GoFo;

import java.util.Scanner;
import java.util.Vector;

public class Player extends User {

    public void book_playground(Vector<Booking_Struct> ADD)
    {
        Booking_Struct obj=new Booking_Struct();
        Scanner scan=new Scanner(System.in);
        Scanner int_scan=new Scanner(System.in);
        System.out.println("enter the playground name");
        String playground_name = scan.nextLine();
        obj.setPlayer_name(playground_name);
        System.out.println("enter the number of hours u want to book");
        int hour_book = int_scan.nextInt();
        obj.setHours(hour_book);
        System.out.println("enter the data");
        String date =scan.nextLine();
        obj.setDate(date);
        System.out.println("enter your name");
        String name =scan.nextLine();
        obj.setPlayer_name(name);
        System.out.println("enter the playground_owner_name");
        String playground_owner_name =scan.nextLine();
        obj.setPlayground_owner(playground_owner_name);
        for(int i=0;i<ADD.size();i++)
        {
            if(ADD.size()==0)
            {
                ADD.add(obj);
            }
            else
            {

            }
        }
    }
    public String display_nearest_playground()
    {
        return null;
    }
    public String display_playground(String location)
    {
        return null;
    }
    public String display_nearest_playground(String date, String hours)
    {
        return null;
    }
    public boolean check_available_timeslot(String Date,Vector<Booking_Struct> ADD,Vector<Playground> All,String playground_owner, String playground_name,int hours)
    {
        int counter=0;
        for(int i=0;i< ADD.size();i++)
        {

            if(ADD.elementAt(i).getPlayground_name().equalsIgnoreCase(playground_name) && ADD.elementAt(i).getPlayground_owner().equalsIgnoreCase(playground_owner )&& ADD.elementAt(i).getDate().equalsIgnoreCase(Date))
            {
                counter+=ADD.elementAt(i).getHours();
            }
        }
        int available_hours=0;
        for(int i=0;i<All.size();i++)
        {
            if(All.elementAt(i).getName().equalsIgnoreCase(playground_name)&& All.elementAt(i).getOwner().equalsIgnoreCase(playground_owner))
            {
                available_hours=All.elementAt(i).getAvailable_hours();
            }

        }
        int def=available_hours-counter;
        if(def==0 || def< hours)
            return  false;
        else
            return  true;

    }
    public void pay(float amount)
    {

    }
    public void send_invitation(String player_email)
    {

    }
    public void cancel_booking(String playground_name, String date)
    {

    }
    public void show_all_playgrounds()
    {

    }

}
