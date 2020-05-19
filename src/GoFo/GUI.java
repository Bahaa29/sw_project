package GoFo;
import java.util.Scanner;
import java.util.Vector;
public class GUI {
    private Vector<User> all_users;
    private Vector<Playground> all_playground;
    Scanner int_scan ;
    public boolean SignIn(String email,String Password){
        return true;
    }
    public void Register(int ID, String Name,String Email,String Phone,String Default_Location,String Type){ }
    public void MainMenu(){
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
