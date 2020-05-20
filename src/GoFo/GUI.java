package GoFo;
import java.util.Scanner;
import java.util.Vector;

public class GUI {
    private Vector<User> all_users = new Vector<User>();
    private Vector<Playground> all_playground = new Vector<Playground>();
    public Vector<Booking_Struct> all_bookings = new Vector<Booking_Struct>();
    private String Current_User_type; //The Type of User has login now
    private Scanner int_scan ;
    private Scanner string_scan;
    private Scanner float_scan;
    private boolean SignIn(String email,String Password){
        //Sign In
        String m,p;
        for (int i=0 ; i<all_users.size();i++){
            m=all_users.elementAt(i).getEmail().toString();
            p=all_users.elementAt(i).getPass().toString();

            if(m.equalsIgnoreCase(email) && p.equalsIgnoreCase(Password))
            {
                Current_User_type = all_users.elementAt(i).getType();
                return true;
            }
        }
        return false;
    }
    private void Register()
    {
        User temp = new User();
        String tmp;int i;
        int_scan = new Scanner(System.in);
        string_scan = new Scanner(System.in);

        System.out.println("Enter Name: ");
        tmp = string_scan.nextLine();
        temp.set_name(tmp);

        System.out.println("Enter ID: ");
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
        temp.wallet = new eWallet();
        temp.wallet.setBalance(0);
        all_users.add(temp);
    }

    public void MainMenu()
    {
        boolean flag =true;
        while(flag){
            String msg = "Welcome To GoFo App\n1-Sign In\n2-Register\n3-Exit\nYour Choice: ";
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
                            if(Current_User_type.equalsIgnoreCase("PlaygroundOwner"))
                            {
                                //Welcome
                                System.out.println("welcome to playground system");
                                Playground_Owner owner = new Playground_Owner();

                                //Menu
                                String tem="1-add playground request \n2-set available hours \n3-view booking \n4-check money";
                                System.out.println(tem);
                                int_scan = new Scanner(System.in);
                                choice = int_scan.nextInt();

                                if (choice >= 1 && choice <=4)
                                {
                                    Playground play = new Playground();
                                    float f;int i;String in;
                                    switch (choice){
                                        case 1:
                                            //add playground request
                                            string_scan = new Scanner(System.in);
                                            System.out.println("Enter playground name");
                                            in = string_scan.nextLine();
                                            play.setName(in);
                                            System.out.println("Enter playground location");
                                            in = string_scan.next();
                                            play.setLocation(in);
                                            System.out.println("Enter playground size");
                                            choice = int_scan.nextInt();
                                            play.setSize(choice);

                                            play.setStatus("Waiting");
                                            play.setAvailable_hours(0);
                                            //get owner name from user vector
                                            for(i=0;i<all_users.size();i++){
                                                if(all_users.elementAt(i).getEmail().equalsIgnoreCase(mail)){
                                                    play.setOwner(all_users.elementAt(i).getName());
                                                }
                                            }
                                            System.out.println("Enter price per hour");
                                            float_scan = new Scanner(System.in);
                                            f = float_scan.nextFloat();
                                            play.setPrice_per_hour(f);
                                            System.out.println("Enter cancelation period");
                                            f = float_scan.nextFloat();
                                            play.setCancelation_period(f);

                                            owner.Add_playground_request(all_playground ,play);
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
                    case 3:
                        flag=false;
                        break;
                }
            }
            else
            {
                System.out.println("You Entered Wrong Choice");
            }
        }
    }
}
