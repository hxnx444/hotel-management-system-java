package Hotel;

/*
 The Receptionist class represents a staff member who manages check-ins.
 It inherits common attributes from the User class and adds shift details.
 */
public class Receptionist extends User {

    // Specific field for Receptionist (e.g., "Morning", "Night")
    private String shift;

    // Constructor: Initializes the Receptionist using the parent User constructor
    public Receptionist(int id, String name, String shift) {
        super(id, name);    // Pass ID and Name to the User class
        this.shift = shift; // Set the Receptionist-specific shift
    }

    /*
     Displays information specific to a Receptionist.
     This overrides the abstract method defined in the User class.
     */
    @Override
    public void displayInfo() {
        System.out.println("Receptionist: " + name + " | Shift: " + shift);
    }

    // Simulates the action of checking in a guest
    // Association
    //Definition: Two classes communicate or interact with each other, but neither "owns" the other. They are just colleagues.
    public void checkInGuest(Guest c) {

        System.out.println("Receptionist " + name + " is checking in " + c.getName());
    }
}