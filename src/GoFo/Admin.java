package GoFo;

import java.util.Scanner;
import java.util.Vector;

public class Admin extends User
{
    int choice;
    Scanner scan = new Scanner(System.in);
    /**
     * Approve playground function
     * This function let the admin approve the waiting playgrounds
     * @param ALL This Vector Store All Playgrounds In the System
     */
    public void Approve_playground(Vector<Playground> ALL)
    {
        System.out.println("Waiting playgrounds that need to approve");
        for (int i = 0; i < ALL.size(); i++)
        {
            if (ALL.elementAt(i).getStatus().equalsIgnoreCase("waiting"))
                System.out.println((i+1) + " - playground name:  " + ALL.elementAt(i).getName() + " - owner: " + ALL.elementAt(i).getOwner());

        }

        System.out.println("Enter number of playground you want to choose: ");
        choice = scan.nextInt();
        ALL.elementAt(choice-1).setStatus("approved");
        System.out.println("This playground approved successfully");
    }

    public void suspend_playground(Vector<Playground> ALL)
    {

    }
    public void delete_playground(Vector<Playground> ALL)
    {
        
    }
}
