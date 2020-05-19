package GoFo;

import java.util.Vector;

public class Playground_Owner extends User{
    void Add_playground_request(Vector<Playground> ALL ,Playground play){
        ALL.addElement(play);
    }
    void set_available_hours(int hours ,String Playground_Name ,Vector<Playground> ALL){

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
