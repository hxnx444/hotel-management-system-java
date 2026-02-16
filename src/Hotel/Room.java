package Hotel;


// EXPLANATION: THE INTERFACE (example for explaining :The Contract)

/* 1. WHAT IS IT? 'Comparable' is a built-in Java interface.
    Think of it as a strict rulebook or contract.
    The Rule: "Any class that implements me MUST have a method called 'compareTo'."

 2. SIGNING THE CONTRACT
   By writing 'implements Comparable<Room>', this class "signs" the contract.
  It promises Java: "I guarantee I will write a compareTo method."
  zsw*/
public class Room implements Comparable<Room> {

    //FIELDS (Attributes)
    private int roomNumber;
    private String type; // e.g., "Single", "Double", "Suite"
    private double price;
    private boolean isAvailable; // Tracks if the room is free (true) or booked (false)

    //CONSTRUCTOR
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true; // Default to available
    }

    //GETTERS
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // SETTERS
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    //DISPLAY METHOD
    public void displayRoom() {
        System.out.println("Room " + roomNumber + " [" + type + "] - $" + price + " - " + (isAvailable ? "Available" : "Booked"));
    }

    // 3. FULFILLING THE PROMISE (The Implementation)

    /* Because we wrote 'implements' at the top, we are FORCED to write this method.
     If we delete this, the code breaks because we broke the contract.

     This logic tells Java: "When you need to sort Rooms, look at the PRICE."*/
    @Override
    public int compareTo(Room other) {
        // Manual comparison logic (From Scratch):
        if (this.price > other.price) {
            return 1;  // Current room is more expensive (move it down)
        } else if (this.price < other.price) {
            return -1; // Current room is cheaper (move it up)
        } else {
            return 0;  // Prices are equal
        }
    }
}