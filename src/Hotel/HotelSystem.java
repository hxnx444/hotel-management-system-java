package Hotel;

/*
  The HotelSystem class acts as the central manager.
  It holds the lists of rooms and reservations and performs
  key operations like sorting and searching.
 */
public class HotelSystem {

    // --- FROM SCRATCH DATA STRUCTURES ---
    // We cannot use ArrayList, so we use standard fixed-size arrays.
    // We assume a maximum of 100 rooms and 100 reservations for this assignment.
    private Room[] rooms = new Room[100];
    private int roomCount = 0; // Tracks how many rooms are actually in the array

    private Reservation[] reservations = new Reservation[100]; //Composition

    //Definition: One class owns another exclusively.
    // The child cannot exist without the parent. If the parent is destroyed, the child is destroyed too.
    // This is "strong" ownership.
    private int reservationCount = 0; // Tracks how many reservations are made

    // Adds a new room object to the array manually
    public void addRoom(Room r) {
        if (roomCount < rooms.length) {
            rooms[roomCount] = r; // Put the room in the next empty slot
            roomCount++;          // Increase the counter
        } else {
            System.out.println("Error: Hotel is full, cannot add more rooms.");
        }
    }

    /*
      Sorts the rooms from cheapest to most expensive using Bubble Sort.
      This is a manual implementation and works on the standard array.
     */
    public void sortRoomsByPrice() {
        // We use 'roomCount' instead of 'rooms.length' because the array might
        // have empty null slots at the end that we shouldn't touch.
        int n = roomCount;

        // Outer Loop: Controls the number of passes through the list
        for (int i = 0; i < n - 1; i++) {

            // Inner Loop: Compares adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                // Get the two rooms (using array index)
                Room room1 = rooms[j];
                Room room2 = rooms[j + 1];

                // If current room is more expensive than the next, swap them
                if (room1.getPrice() > room2.getPrice()) {
                    rooms[j] = room2;
                    rooms[j + 1] = room1;
                }
            }
        }

        // Print the sorted list to the console
        System.out.println("\nRooms Sorted by Price");
        for (int i = 0; i < roomCount; i++) {
            rooms[i].displayRoom();
        }
    }

    /*
      Search 1: Search by Room Number (Linear Search).
      Iterates through the valid part of the array to find a specific ID.
     */
    public Room searchRoom(int roomNumber) {
        // Standard loop from 0 to roomCount
        for (int i = 0; i < roomCount; i++) {
            // Check if the current room's number matches the input
            if (rooms[i].getRoomNumber() == roomNumber) {
                return rooms[i]; // Found match, return immediately
            }
        }
        return null; // End of list reached, nothing found
    }

    /*
      Search 2: Search by Type (Method Overloading).
      Prints all rooms that match the requested type (e.g., "Single").
     */
    public void searchRoom(String type) {
        System.out.println("\nSearching for: " + type + " ---");
        boolean found = false;

        for (int i = 0; i < roomCount; i++) {
            // equalsIgnoreCase handles "single", "Single", and "SINGLE"
            if (rooms[i].getType().equalsIgnoreCase(type)) {
                rooms[i].displayRoom();
                found = true;
            }
        }

        if (!found) System.out.println("No rooms of type " + type + " found.");
    }

    // Adds a completed reservation to the history array
    public void addReservation(Reservation res) {
        if (reservationCount < reservations.length) {
            reservations[reservationCount] = res;
            reservationCount++;
        } else {
            System.out.println("Error: Reservation log is full.");
        }
    }
}