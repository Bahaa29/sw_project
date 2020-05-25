package GoFo;
import java.util.Scanner;
import java.util.Vector;

public class GUI {
    private Vector<User> all_users = new Vector<User>();
    private Vector<Playground> all_playground = new Vector<Playground>();
    private Vector<Booking_Struct> all_bookings = new Vector<Booking_Struct>();
    private Vector<String> all_invitations=new Vector<String>();
    private String Current_User_type; //The Type of User has login now
    private String Current_User_name;
    private Scanner int_scan ;
    private Scanner string_scan;
    private Scanner float_scan;

    /**
     * Sign in function
     * This function to check the validation of users' and sign them in
     * @param email the email of the user that trying to sign in
     * @param Password the password of the user trying to sign in
     * @return true or false the status of the login operation
     */
    private boolean SignIn(String email,String Password){
        //Sign In
        String m,p;
        for (int i=0 ; i<all_users.size();i++){
            m=all_users.elementAt(i).getEmail().toString();
            p=all_users.elementAt(i).getPass().toString();

            if(m.equalsIgnoreCase(email) && p.equalsIgnoreCase(Password))
            {
                Current_User_type = all_users.elementAt(i).getType();
                Current_User_name = all_users.elementAt(i).getName();
                return true;
            }
        }
        return false;
    }
    /**
     * Register function
     * This function take user's information who enter the app for first time
     */
    private void Register()
    {
        User temp = new User();
        String tmp;
        int i;
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
    /**
     * Main menu function
     * This function let the user to register new account or sign in for existing one
     */
    public void MainMenu()
    {
        boolean flag =true;
        while(flag)
        {
            String msg = "Welcome To GoFo App\n1-Sign In\n2-Register\n3-Exit\nYour Choice: ";
            System.out.println(msg);
            int choice;
            int_scan = new Scanner(System.in);
            string_scan = new Scanner(System.in);
            choice = int_scan.nextInt();
            if (choice >= 1 && choice <=3)
            {
                switch (choice) {
                    case 1:
                        //Sign In
                        String mail, pass;

                        //Take Email And Pass
                        System.out.println("Enter Email : ");
                        mail = string_scan.nextLine();
                        System.out.println("Enter Password : ");
                        pass = string_scan.nextLine();

                        //Send Them To Sign In
                        boolean loged = SignIn(mail, pass);

                        //After Sign In
                        if (loged)
                        {
                            if (Current_User_type.equalsIgnoreCase("PlaygroundOwner")) {
                                boolean flag1 = true;

                                    //Welcome
                                    Playground_Owner owner = new Playground_Owner();
                                    for (int i = 0; i < all_users.size(); i++) {
                                        if (all_users.elementAt(i).getName().equalsIgnoreCase(Current_User_name)) {
                                            owner.set_name(all_users.elementAt(i).getName());
                                            owner.set_id(all_users.elementAt(i).getId());
                                            owner.set_email(all_users.elementAt(i).getEmail());
                                            owner.set_pass(all_users.elementAt(i).getPass());
                                            owner.set_phone(all_users.elementAt(i).getPhone());
                                            owner.set_loc(all_users.elementAt(i).getD_loc());
                                            owner.wallet.setBalance(all_users.elementAt(i).wallet.getBalance());
                                            owner.set_type(all_users.elementAt(i).getType());
                                        }
                                    }
                                    //Menu
                                while (flag1) {
                                    System.out.println("welcome to playground system");
                                String tem = "1-add playground request \n2-set available hours \n3-view booking \n4-check money \n5-Back";
                                    System.out.println(tem);
                                    int_scan = new Scanner(System.in);
                                    System.out.println("Your Choice: ");
                                    choice = int_scan.nextInt();

                                    if (choice >= 1 && choice <= 5) {
                                        Playground play = new Playground();
                                        float f;
                                        int i;
                                        String in;
                                        switch (choice) {
                                            case 1:
                                                //add playground request
                                                string_scan = new Scanner(System.in);
                                                System.out.println("Enter playground name");
                                                in = string_scan.nextLine();
                                                play.setName(in);
                                                System.out.println("Enter playground location");
                                                in = string_scan.nextLine();
                                                play.setLocation(in);
                                                System.out.println("Enter playground size");
                                                choice = int_scan.nextInt();
                                                play.setSize(choice);

                                                play.setStatus("Waiting");
                                                System.out.println("Enter playground Available Hours");
                                                choice = int_scan.nextInt();
                                                play.setAvailable_hours(choice);

                                                //get owner name from user vector
                                                for (i = 0; i < all_users.size(); i++) {
                                                    if (all_users.elementAt(i).getEmail().equalsIgnoreCase(mail)) {
                                                        play.setOwner(all_users.elementAt(i).getName());
                                                    }
                                                }
                                                System.out.println("Enter price per hour");
                                                float_scan = new Scanner(System.in);
                                                f = float_scan.nextFloat();
                                                play.setPrice_per_hour(f);

                                                owner.Add_playground_request(all_playground, play);
                                                break;
                                            case 2:
                                                //set available hours
                                                string_scan = new Scanner(System.in);
                                                int_scan = new Scanner(System.in);
                                                System.out.println("Enter available hours");
                                                i = int_scan.nextInt();
                                                owner.set_available_hours(i, all_playground);

                                                break;
                                            case 3:
                                                //view booking
                                                owner.view_booking(all_bookings);
                                                break;
                                            case 4:
                                                //check money
                                                String print = owner.Check_money();
                                                System.out.println(print);
                                                break;
                                            case 5:
                                                flag1 = false;
                                                break;
                                        }
                                    } else {
                                        System.out.println("You Entered Wrong Choice");
                                    }

                                }
                            }
                            else if (Current_User_type.equalsIgnoreCase("Admin"))
                            {
                                boolean flag3 = true;
                                Admin my_admin = new Admin();
                                for (int i = 0; i < all_users.size(); i++)
                                {
                                    if (all_users.elementAt(i).getName().equalsIgnoreCase(Current_User_name)) {
                                        my_admin.set_name(all_users.elementAt(i).getName());
                                        my_admin.set_id(all_users.elementAt(i).getId());
                                        my_admin.set_email(all_users.elementAt(i).getEmail());
                                        my_admin.set_pass(all_users.elementAt(i).getPass());
                                        my_admin.set_phone(all_users.elementAt(i).getPhone());
                                        my_admin.set_loc(all_users.elementAt(i).getD_loc());
                                        my_admin.wallet.setBalance(all_users.elementAt(i).wallet.getBalance());
                                        my_admin.set_type(all_users.elementAt(i).getType());
                                    }
                                }
                                while (flag3)
                                {
                                    System.out.println("Welcome to Admin system\n1- Approve playground\n2- Suspend playground\n3- Delete playground\n4-Back");
                                    System.out.println("Your Choice: ");
                                    choice = int_scan.nextInt();
                                    if (choice >= 1 && choice <= 4) {
                                        switch (choice) {
                                            case 1:
                                                my_admin.Approve_playground(all_playground);
                                                break;
                                            case 2:
                                                my_admin.suspend_playground(all_playground);
                                                break;
                                            case 3:
                                                my_admin.delete_playground(all_playground);
                                                break;
                                            case 4:
                                                flag3=false;
                                        }
                                    }
                                }

                            }
                            else if (Current_User_type.equalsIgnoreCase("Player"))
                            {
                                boolean flag2 = true;
                                Player my_player=new Player();
                                for (int i = 0; i < all_users.size(); i++)
                                {
                                    if (all_users.elementAt(i).getName().equalsIgnoreCase(Current_User_name)) {
                                        my_player.set_name(all_users.elementAt(i).getName());
                                        my_player.set_id(all_users.elementAt(i).getId());
                                        my_player.set_email(all_users.elementAt(i).getEmail());
                                        my_player.set_pass(all_users.elementAt(i).getPass());
                                        my_player.set_phone(all_users.elementAt(i).getPhone());
                                        my_player.set_loc(all_users.elementAt(i).getD_loc());
                                        my_player.wallet.setBalance(all_users.elementAt(i).wallet.getBalance());
                                        my_player.set_type(all_users.elementAt(i).getType());
                                        }
                                }
                                my_player.Show_Inbox(all_invitations);
                                while (flag2)
                                {
                                    System.out.println("Welcome to player system\n1- book_playground\n2- display_playground\n3- display_nearest_playground\n4- show_all_playgrounds\n5- send_invitation\n6-Back");
                                    System.out.println("Your Choice: ");
                                    choice = int_scan.nextInt();
                                    if (choice >= 1 && choice <= 8)
                                    {
                                        switch (choice) {
                                            case 1:
                                                my_player.book_playground(all_bookings, all_playground, all_users);
                                                break;
                                            case 2:
                                                System.out.println("enter the hours");
                                                int hours = int_scan.nextInt();
                                                my_player.display_nearest_playground(hours, all_playground);
                                                break;
                                            case 3:
                                                my_player.display_nearest_playground(all_playground);
                                                break;
                                            case 4:
                                                my_player.show_all_playgrounds(all_playground);
                                                break;
                                            case 5:
                                                System.out.println("enter the player email");
                                                String email = string_scan.nextLine();
                                                my_player.send_invitation(email, all_users,all_invitations);
                                            case 6:
                                                flag2=false;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        //Register
                        Register();
                        break;
                    case 3:
                        flag = false;
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
