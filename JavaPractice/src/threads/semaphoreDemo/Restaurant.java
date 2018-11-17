package threads.semaphoreDemo;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore demo example from Java Language features book
 */
public class Restaurant {
    private final Semaphore tables;

    public Restaurant(int tablesCount) {
        // Create a semaphore using number of tables we have
        this.tables = new Semaphore(tablesCount);
    }

    public void getTable(int customerID) {
        try {
            System.out.println("Customer #" + customerID
                    + " is trying to get a table.");
            // Acquire a permit for a table
            tables.acquire();
            System.out.println("Customer #" + customerID + " got a table.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void returnTable(int customerID) {
        System.out.println("Customer #" + customerID + " returned a table.");
        tables.release();
    }

    public static void main(String[] args) {
        // Create a restaurant with two dining tables
        Restaurant restaurant = new Restaurant(2);
        // Create five customers
        for (int i = 1; i <= 5; i++) {
            RestaurantCustomer c = new RestaurantCustomer(restaurant, i);
            c.start();
        }
    }
}

class RestaurantCustomer extends Thread {
    private final Restaurant restaurant;
    private final int customerID;
    private static final Random random = new Random();

    public RestaurantCustomer(Restaurant restaurant, int customerID) {
        this.restaurant = restaurant;
        this.customerID = customerID;
    }

    @Override
    public void run() {
        restaurant.getTable(this.customerID); // Get a table
        try {
// Eat for some time. Use number between 1 and 30 seconds
            int eatingTime = random.nextInt(30) + 1;
            System.out.println("Customer #" + this.customerID
                    + " will eat for " + eatingTime + " seconds.");
            Thread.sleep(eatingTime * 1000);
            System.out.println("Customer #" + this.customerID
                    + " is done eating.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            restaurant.returnTable(this.customerID);
        }
    }
}