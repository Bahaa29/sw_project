package GoFo;

public class User
{
    private int id ;
    private String name,pass,email,phone,d_loc,type;
    private ewallet wallet;
    public void set_id(int ID)
    {
        id =ID;
    }
    public void set_name(String Name)
    {
        name =Name;
    }
    public void set_pass(String password)
    {
         pass=password;
    }
    public void set_email(String Email)
    {
        email =Email;
    }
    public void set_phone(String Phone)
    {
        phone =Phone;
    }
    public void set_loc(String locaton)
    {
        d_loc =locaton;
    }
    public void set_type(String TYPE)
    {
        type =TYPE;
    }
    //GETTER
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getD_loc() {
        return d_loc;
    }

    public String getType() {
        return type;
    }
}