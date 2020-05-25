package GoFo;
import java.util.Vector;

public class User
{
    private int id ;
    private String name,pass,email,phone,d_loc,type;
    public eWallet wallet = new eWallet();
    //SETTER
    /**
     * Set ID Function
     * this function Just Set or update the value of the ID
     * @param ID value of the ID
     */
    public void set_id(int ID)
    {
        id =ID;
    }

    /**
     * Set_Name Function
     * this function Just Set or update the value of the Name
     * @param Name  value of the Name
     */
    public void set_name(String Name)
    {
        name =Name;
    }

    /**
     * Set_Password Function
     * this function Just Set or update the value of the password
     * @param password value of the password
     */
    public void set_pass(String password)
    {
         pass=password;
    }

    /**
     * Set_Email function
     * this function Just Set or update the value of the Email
     * @param Email value of the Email
     */
    public void set_email(String Email)
    {
        email =Email;
    }

    /**
     * Set_Phone Function
     * this function Just Set or update the value of the Phone
     * @param Phone value of the phone
     */
    public void set_phone(String Phone)
    {
        phone =Phone;
    }

    /**
     * set_loc function
     * this function Just Set or update the value of the Location
     * @param locaton value of the location
     */
    public void set_loc(String locaton)
    {
        d_loc =locaton;
    }

    /**
     * Set_Type function
     * this function Just Set or update the value of the Type
     * @param t value of the Type
     */
    public void set_type(String t)
    {
        type =t;
    }
    //GETTER

    /**
     * get_id function
     * @return the value of the ID
     */
    public int getId() {
        return id;
    }

    /**
     * get_name function
     * @return the value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * get_password function
     * @return the value of the password
     */
    public String getPass() {
        return pass;
    }

    /**
     * get_email function
     * @return the value of the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * get_phone
     * @return the value of the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * get_loc function
     * @return the value of the location
     */
    public String getD_loc() {
        return d_loc;
    }

    /**
     * get_type function
     * @return the value of the type
     */
    public String getType() {
        return type;
    }
}