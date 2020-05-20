package GoFo;

import java.util.Scanner;
import java.util.Vector;

public class Player extends User {
    /**
     * this function for make player able to book playground
     * @param ADD this a class for booking a make vector for this class to store the booking
     * @param All the vector to find all playground
     * @param all_users vector for all information of all user
     */
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

    /**
     * function to find all playground nearest player
     * @param ur_location the location of player
     * @param All vector of playground
     * @return the playground name
     */
    public String display_nearest_playground(String ur_location,Vector<Playground> All)
    {
        for(int i=0;i<All.size();i++)
        {
            if(All.elementAt(i).getLocation().equalsIgnoreCase(ur_location))
                return  All.elementAt(i).getName();
        }
        return null;

    }

    /**
     * function to show the playground by location
     * @param location the location of playgroun
     * @param All vector of all playground
     * @return the names of playground
     */
    public String display_playground(String location,Vector<Playground> All)
    {
        for(int i=0;i<All.size();i++)
        {
            if(All.elementAt(i).getLocation().equalsIgnoreCase(location))
                return  All.elementAt(i).getName();
        }
        return null;
    }

    /**
     * this function for find all playgrounds that have available hours for the player
     * @param hours the hours that player want
     * @param All vector of playground
     * @return name of playground
     */
    public String display_nearest_playground(int hours,Vector<Playground> All)
    {
        for(int i=0;i<All.size();i++)
        {
            if(All.elementAt(i).getAvailable_hours()>=hours)
                return  All.elementAt(i).getName();
        }
        return null;
    }

    /**
     * function to show all playground
     * @param All vector of all play ground
     */
    public void show_all_playgrounds(Vector<Playground> All)
    {
        for(int i=0;i<All.size();i++)
        {
            System.out.println(All.elementAt(i).getName()+"-");
        }
    }

    /**
     * check to find to check the available time for specific playground
     * @param Date the date that player want to check available_timeslot
     * @param ADD vector of booking for players
     * @param All vector of all playground
     * @param playground_owner
     * @param playground_name
     * @param hours the number of hours that i want check with
     * @return true(there are) false(no)
     */
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

    /**
     * function for pay the many to playground owner
     * @param amount the amount for booking this playground
     * @param all_users vector of all information of all user
     * @param player_name
     * @param owner_Name the playground owner name
     * @return true=have enough many, false=didn not have
     */
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


}
