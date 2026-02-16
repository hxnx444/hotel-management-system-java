package Hotel;

/*
The Admin class represents a manager or administrator of the hotel.
It inherits common attributes (id, name) from the User class
and adds a specific department field.
*/
public class Admin extends User {

    // Specific field for Admin (e.g., "Management", "IT")
    private String department;

    /* Constructor: Initializes the Admin using the parent User constructor */
    public Admin(int id, String name, String department) {
        super(id, name);              // Pass ID and Name to the User class
        this.department = department; // Set the Admin-specific department
    }

    /*
    Displays information specific to an Administrator.
    This overrides the abstract method defined in the User class.
    */
    @Override
    public void displayInfo() {
        System.out.println("Administrator: " + name + " | Dept: " + department);
    }
}
