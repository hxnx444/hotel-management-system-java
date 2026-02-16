package Hotel;

/*
The User class is an ABSTRACT parent class.
It serves as a template for specific users like Guest, Admin, or Receptionist.
"Abstract" means you cannot say 'new User()'; you must create a specific child class.
*/
public abstract class User {

    // Protected visibility allows child classes (Guest, Admin) to access these directly
    protected int id;
    protected String name;

    /* Constructor: Initializes the common attributes found in all users */
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter method to retrieve the user's name
    public String getName() {
        return name;
    }

    /*
    ABSTRACT METHOD (The Rule)
    This method has no body code here.
    It forces every child class to write their own specific version of displayInfo().
    */
    public abstract void displayInfo();
}