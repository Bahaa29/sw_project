package GoFo;

import java.util.Vector;

public class Playground_Owner extends User{
    //private Vector<Playground> myplaygrounds;
    void Add_playground_request(Playground play){
        myplaygrounds.addElement(play);
    }
    void set_available_hours(String hours){

    }
    String view_booking(){
        return null;
    }
    String Check_money(){
        return null;
    }
}
