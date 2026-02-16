package Hotel;

/*
 The Guest class represents a customer staying at the hotel.
 It inherits common attributes (id, name) from the User class
 *and adds specific contact information.
 */
public class Guest extends User {

    // specific field for Guest
    private String phone;

    // Constructor: Initializes the Guest using the parent User constructor
    public Guest(int id, String name, String phone) {
        super(id, name);    // Pass ID and Name to the User class
        this.phone = phone; // Set the Guest-specific phone number
    }

    /*
     Displays information specific to a Guest.
     This overrides the abstract method defined in the User class.
     */
    @Override
    public void displayInfo() {

        System.out.println("Guest: " + name + " | Phone: " + phone);
    }
}