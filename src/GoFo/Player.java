package GoFo;

import java.util.Scanner;
import java.util.Vector;

public class Player extends User {

    public void book_playground(Vector<Booking_Struct> ADD,Vector<Playground> All,Vector<User> all_users)
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
        float total=0;
        for (int i=0;i<All.size();i++)
        {
            if(All.elementAt(i).getName().equalsIgnoreCase(playground_name))
            {
                total=All.elementAt(i).getPrice_per_hour();
            }
        }
        total*=hour_book;
        obj.setTotal(total);
        for(int i=0;i<ADD.size();i++)
        {
            if(ADD.size()==0)
            {
                pay(total,all_users,name,playground_owner_name);
                ADD.add(obj);
            }
            else
            {
                boolean flag=check_available_timeslot(date,ADD,All,playground_owner_name,playground_name,hour_book);
                if(flag)
                {
                    pay(total,all_users,name,playground_owner_name);
                    ADD.add(obj);
                }
                else
                    System.out.println("u cant booking in this day for this playground");
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
    public boolean pay(float amount,Vector<User> all_users,String player_name,String owner_Name)
    {
        float price=0;
        boolean flag=false;
        for(int i=0;i<all_users.size();i++)
        {
            if(all_users.elementAt(i).getName().equalsIgnoreCase(player_name))
            {
                price=all_users.elementAt(i).wallet.getBalance();
                if(price>=amount) {
                    System.out.println("ok");
                    all_users.elementAt(i).wallet.setBalance(price-amount);
                    flag=true;
                }
                else
                    flag=false;
            }
        }
        for(int i=0;i<all_users.size();i++)
        {
            if(all_users.elementAt(i).getName().equalsIgnoreCase(owner_Name))
            {
                all_users.elementAt(i).wallet.setBalance(all_users.elementAt(i).wallet.getBalance()+amount);
            }

        }
        return flag;
    }
    public void send_invitation(String player_email)
    {

    }
    public void cancel_booking(String playground_name, String date, Vector<Booking_Struct> all_bookings)
    {
        for (int i = 0; i < all_bookings.size(); i++)
        {
            if (all_bookings.elementAt(i).getPlayground_name().equalsIgnoreCase(playground_name) && all_bookings.elementAt(i).getDate().equalsIgnoreCase(date));
        }
    }
    public void show_all_playgrounds(Vector<Playground> All)
    {
        for(int i=0;i<All.size();i++)
        {
            System.out.println(All.elementAt(i).getName()+"-");
        }
    }

}
