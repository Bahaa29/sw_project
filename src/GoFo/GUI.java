package GoFo;
import java.sql.Struct;
import java.util.Scanner;
import java.util.Vector;
import theleo.jstruct.Struct;
public class GUI {
    private Vector<User> all_users;
    private Vector<Playground> all_playground;
    public Vector<Booking_Struct> all_bookings;
    Scanner int_scan ;
    Scanner string_scan;
    Scanner float_scan;
    public boolean SignIn(String email,String Password){
        return true;
    }
    public void Register(int ID, String Name,String Email,String Phone,String Default_Location,String Type,String password)
    {
        User temp = null;
        temp.set_name(Name);
        temp.set_id(ID);
        temp.set_pass(password);
        temp.set_email(Email);
        temp.set_loc(Default_Location);
        temp.set_phone(Phone);
        temp.set_type(Type);
        all_users.addElement(temp);
    }

    public void MainMenu()
    {
        String msg = "Welcome To GoFo App\n1-Sign In\n2-Register\nYour Choice: ";
        System.out.println(msg);
        int choice;
        int_scan = new Scanner(System.in);
        choice = int_scan.nextInt();
        if (choice >= 1 && choice <=2)
        {
            switch (choice){
                case 1:
                    //Sign In
                    boolean loged = SignIn();
                    //After Sign In
                    if(loged){
                        if(Type=="PlaygroundOwner")
                        {
                            System.out.println("welcome to playground system");
                            Playground_Owner owner = null;
                            String tem="1-add playground request \n2-set available hours \n3-view booking \n4-check money";
                            System.out.println(tem);
                            int_scan = new Scanner(System.in);
                            choice = int_scan.nextInt();
                            if (choice >= 1 || choice <=4)
                            {
                                Playground play = null;
                                float f;
                                switch (choice){
                                    case 1:
                                        //add playground request
                                        String in;

                                        string_scan = new Scanner(System.in);
                                        System.out.println("Enter playground name");
                                        in = string_scan.next();
                                        play.setName(in);
                                        System.out.println("Enter playground location");
                                        in = string_scan.next();
                                        play.setLocation(in);
                                        System.out.println("Enter playground size");
                                        choice = int_scan.nextInt();
                                        play.setSize(choice);

                                        play.setStatus("Waiting");
                                        System.out.println("Enter price per hour");
                                        float_scan = new Scanner(System.in);
                                        f = float_scan.nextFloat();
                                        play.setPrice_per_hour(f);
                                        System.out.println("Enter cancelation period");
                                        f = float_scan.nextFloat();
                                        play.setCancelation_period(f);
                                        owner.Add_playground_request(play);
                                        all_playground.addElement(play);
                                        break;
                                    case 2:
                                        //set available hours
                                        string_scan = new Scanner(System.in);
                                        System.out.println("Enter available hours");
                                        in = string_scan.next();
                                        play.setAvailable_hours(in);
                                        break;
                                    case 3:
                                        //view booking

                                        break;
                                    case 4:
                                        //check money
                                        break;
                                }
                            }
                            else
                            {
                                System.out.println("You Entered Wrong Choice");
                            }

                        }
                    }
                    break;
                case 2:
                    //Register
                    Register();
                    break;
            }
        }
        else
        {
            System.out.println("You Entered Wrong Choice");
        }

    }
}
