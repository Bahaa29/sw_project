package GoFo;
import java.util.Scanner;
import java.util.Vector;
public class GUI {
    private Vector<User> all_users;
    private Vector<Playground> all_playground;
    Scanner int_scan ;
    Scanner string_scan ;
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
        all_users.push_back(temp);
        if(Type=="PlaygroundOwner")
        {
            System.out.println("welcome to playground system");
            Playground_Owner owner;
            String tem="1-add playground request \n2-set available hours \n3-view booking \n4-check money";
            System.out.println(tem);
            int choice;
            int_scan = new Scanner(System.in);
            choice = int_scan.nextInt();
            if (choice >= 1 || choice <=4)
            {
                switch (choice){
                    case 1:
                        //add playground request
                        break;
                    case 2:
                        //et available hours
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

    public void MainMenu()
    {
        String msg = "Welcome To GoFo App\n1-Sign In\n2-Register\nYour Choice: ";
        System.out.println(msg);
        int choice;
        int_scan = new Scanner(System.in);
        choice = int_scan.nextInt();
        if (choice >= 1 || choice <=2)
        {
            switch (choice){
                case 1:
                    //Sign In
                    SignIn();
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
