package Hotel;

/*
  The Payment class handles the financial transaction logic.
  It verifies if the guest has provided enough cash and calculates change.
 */
public class Payment {

    private double totalAmount;
    private String method; // e.g., "Cash" or "Card"

    // Constructor: Sets the bill amount and payment type
    public Payment(double totalAmount, String method) {
        this.totalAmount = totalAmount;
        this.method = method;
    }

    /*
      Processes the payment by checking if the cash provided covers the total.
     Returns true if payment is successful, false if insufficient.
     */
    public boolean processPayment(double cashGiven) {
        if (cashGiven >= totalAmount) {
            System.out.println("Processing " + method + " payment...");
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }

    // Calculates and returns the change due to the guest
    public double calculateChange(double cashGiven) {

        return cashGiven - totalAmount;
    }
}