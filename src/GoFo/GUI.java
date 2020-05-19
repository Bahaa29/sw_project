package GoFo;
import java.sql.Struct;
import java.util.Scanner;
import java.util.Vector;
import theleo.jstruct.Struct;
public class GUI {
    private Vector<User> all_users;
    private Vector<Playground> all_playground;
    public Vector<Booking_Struct> all_bookings;
    private String Current_User_type; //The Type of User has login now
    Scanner int_scan ;
    Scanner string_scan;
    Scanner float_scan;
    public boolean SignIn(String email,String Password){
        //Sign In
        for (int i=0 ; i<all_users.size();i++){
            if(all_users.elementAt(i).getEmail() == email && all_users.elementAt(i).getPass() == Password ){
                Current_User_type = all_users.elementAt(i).getType();
                return true;
            }
        }
        return false;
    }
    public void Register()
    {
        User temp = null;
        String tmp;int i;
        int_scan = new Scanner(System.in);
        string_scan = new Scanner(System.in);

        System.out.println("Enter Name: ");
        tmp = string_scan.nextLine();
        temp.set_name(tmp);
        i = int_scan.nextInt();
        temp.set_id(i);

        System.out.println("Enter Password: ");
        tmp = string_scan.nextLine();
        temp.set_pass(tmp);

        System.out.println("Enter Email: ");
        tmp = string_scan.nextLine();
        temp.set_email(tmp);

        System.out.println("Enter Default Location: ");
        tmp = string_scan.nextLine();
        temp.set_loc(tmp);

        System.out.println("Enter Phone: ");
        tmp = string_scan.nextLine();
        temp.set_phone(tmp);

        System.out.println("Enter Type: ");
        tmp = string_scan.nextLine();
        temp.set_type(tmp);

        all_users.addElement(temp);
    }

    public void MainMenu()
    {
        String msg = "Welcome To GoFo App\n1-Sign In\n2-Register\nYour Choice: ";
        System.out.println(msg);
        int choice;
        int_scan = new Scanner(System.in);
        string_scan = new Scanner(System.in);
        choice = int_scan.nextInt();
        if (choice >= 1 && choice <=2)
        {
            switch (choice){
                case 1:
                    //Sign In
                    String mail , pass;

                    //Take Email And Pass
                    System.out.println("Enter Email : ");
                    mail = string_scan.nextLine();
                    System.out.println("Enter Password : ");
                    pass = string_scan.nextLine();

                    //Send Them To Sign In
                    boolean loged = SignIn(mail,pass);

                    //After Sign In
                    if(loged){
                        if(Current_User_type=="PlaygroundOwner")
                        {
                            //Welcome
                            System.out.println("welcome to playground system");
                            Playground_Owner owner = null;

                            //Menu
                            String tem="1-add playground request \n2-set available hours \n3-view booking \n4-check money";
                            System.out.println(tem);
                            int_scan = new Scanner(System.in);
                            choice = int_scan.nextInt();

                            if (choice >= 1 || choice <=4)
                            {
                                Playground play = null;
                                float f;int i;String in;
                                switch (choice){
                                    case 1:
                                        //add playground request
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
                                        owner.Add_playground_request(all_playground ,play);
                                        //all_playground.addElement(play);
                                        break;
                                    case 2:
                                        //set available hours
                                        string_scan = new Scanner(System.in);
                                        int_scan = new Scanner(System.in);
                                        System.out.println("Enter available hours");
                                        i = int_scan.nextInt();
                                        owner.set_available_hours(i,all_playground);
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
