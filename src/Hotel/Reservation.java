package Hotel;

/*
 The Reservation class represents a booking made by a guest.
 It links a Guest to a Room and calculates the total cost based on the duration.
 */
public class Reservation {

    // Private fields to store reservation details
    private Guest guest;
    private Room room;
    private int nights;
    private double totalPrice;

    // Constructor: Initializes the reservation and automatically books the room
    public Reservation(Guest guest, Room room, int nights) {
        this.guest = guest; //Aggregation
        //Definition: One class "has" another class, but the child can exist independently.
        //If you destroy the parent, the child survives. This is a "weak" ownership.
        this.room = room;
        this.nights = nights;

        // Calculate the cost immediately upon creation
        this.totalPrice = calculateTotal();

        // Automatically mark the room as unavailable in the system
        room.setAvailable(false);
    }

    // Helper method to calculate cost (Price per night * Number of nights)
    private double calculateTotal() {
        return room.getPrice() * nights;
    }

    // Getter for the total price (needed for the Payment class)
    public double getTotalPrice() {
        return totalPrice;
    }

    /*
      Prints a formatted summary of the reservation details.
      Useful for showing the user what they are about to pay for.
     */
    public void showSummary() {
        System.out.println("\n--- RESERVATION SLIP ---");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room: " + room.getRoomNumber() + " (" + room.getType() + ")");
        System.out.println("Nights: " + nights);
        System.out.println("Total Due: $" + totalPrice);
        System.out.println("------------------------");
    }
}
