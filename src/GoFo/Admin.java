package GoFo;

import java.security.AllPermission;
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
            if (ALL.elementAt(i).getStatus().equalsIgnoreCase("waiting") || ALL.elementAt(i).getStatus().equalsIgnoreCase("suspended"))
                System.out.println((i+1) + " - playground name:  " + ALL.elementAt(i).getName() + " - owner: " + ALL.elementAt(i).getOwner() + " - Status: " + ALL.elementAt(i).getStatus());
        }

        System.out.println("Enter ID of playground you want to choose: ");
        choice = scan.nextInt();
        ALL.elementAt(choice-1).setStatus("approved");
        System.out.println("This playground approved successfully");
    }

    /**
     * Suspend playground function
     * This function let the admin to suspend specific playground for some reason
     * @param ALL This Vector Store All Playgrounds In the System
     */
    public void suspend_playground(Vector<Playground> ALL)
    {
        for (int i = 0; i < ALL.size(); i++)
        {
            if (ALL.elementAt(i).getStatus().equalsIgnoreCase("approved"))
                System.out.println((i+1) + " - playground name:  " + ALL.elementAt(i).getName() + " - owner: " + ALL.elementAt(i).getOwner());

        }
        System.out.println("Enter ID of playground you want to suspend: ");
        choice = scan.nextInt();
        ALL.elementAt(choice-1).setStatus("suspended");
        System.out.println("This playground suspended successfully");
    }

    /**
     * Delete playground function
     * This function let the admin delete a playground completely
     * @param ALL This Vector Store All Playgrounds In the System
     */
    public void delete_playground(Vector<Playground> ALL)
    {
        for (int i = 0; i < ALL.size(); i++)
        {
            System.out.println((i+1) + " - playground name:  " + ALL.elementAt(i).getName() + " - owner: " + ALL.elementAt(i).getOwner());
        }
        System.out.println("Enter ID of playground you want to delete: ");
        choice = scan.nextInt();
        ALL.remove(choice-1);
    }
}
