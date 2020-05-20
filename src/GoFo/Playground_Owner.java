package GoFo;

import java.util.Scanner;
import java.util.Vector;

public class Playground_Owner extends User{
    void Add_playground_request(Vector<Playground> ALL ,Playground play){
        ALL.add(play);
    }
    void set_available_hours(int hours ,Vector<Playground> ALL){
        System.out.println("Enter Playground Name: ");
        Scanner scanner= new Scanner(System.in);
        String playground_name = scanner.nextLine();
        //The Rest Of the code

    }
    String view_booking(){
        return null;
    }
    String Check_money(){
        String msg;
        msg = "Your Balance Is : " + this.wallet.getBalance();
        return msg;
    }
}
