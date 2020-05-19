package GoFo;

public class User
{
    private int id ;
    private string name,pass,email,phone,d_loc,type;
    private ewallet wallet;
    public void set_id(int ID)
    {
        id =ID;
    }
    public void set_name(string Name)
    {
        name =Name;
    }
    public void set_pass(string password)
    {
         pass=password;
    }
    public void set_email(string Email)
    {
        email =Email;
    }
    public void set_phone(string Phone)
    {
        phone =Phone;
    }
    public void set_loc(string locaton)
    {
        d_loc =locaton;
    }
    public void set_type(string TYPE)
    {
        typee =TYPE;
    }
    //GETTER
    public int getId() {
        return id;
    }

    public string getName() {
        return name;
    }

    public string getPass() {
        return pass;
    }

    public string getEmail() {
        return email;
    }

    public string getPhone() {
        return phone;
    }

    public string getD_loc() {
        return d_loc;
    }

    public string getType() {
        return type;
    }
}