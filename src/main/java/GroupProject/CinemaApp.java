/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

/**
 * Main application for testing the cinema system.
 */
public class CinemaApp {

    /**
     * Program entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Cinema cinema = new Cinema();

        // Create shows
        Show show1 = new MovieShow("Inception", 1, true, "2D", 148);
        Show show2 = new MovieShow("Interstellar", 2, true, "3D", 169);
        Show show3 = new ImaxShow("Dune Part Two", 3, true, "IMAX 70mm", "Dolby Atmos");

        cinema.addShow(show1);
        cinema.addShow(show2);
        cinema.addShow(show3);

        // Create customers
        Customer c1 = new Customer(100, "Ali");
        Customer c2 = new Customer(101, "Sara");

        cinema.addCustomer(c1);
        cinema.addCustomer(c2);

        // Booking tests
        System.out.println("---- Booking tests ----");

        cinema.bookShow(1, 100, "A5", "2025-01-01", "2025-01-02");
        cinema.bookShow(1, 101, "A6", "2025-01-01", "2025-01-02");
        cinema.bookShow(99, 100, "B1", "2025-01-01", "2025-01-02");

        System.out.println();
        cinema.printCustomerBookings(100);
        System.out.println();
        cinema.printCustomerBookings(101);

        // Sorting
        System.out.println();
        cinema.sortShowsByTitle();
        cinema.printAllShows();

        // Test equals
        System.out.println();
        Show anotherShow = new MovieShow("Inception (copy)", 1, true, "2D", 148);
        System.out.println("show1 equals anotherShow? " + show1.equals(anotherShow));

        // Clone test
        System.out.println();
        Object clonedObj = c1.clone();
        if (clonedObj instanceof Customer) {
            Customer cloned = (Customer) clonedObj;
            System.out.println("Original: " + c1);
            System.out.println("Cloned: " + cloned);
        } else {
            System.out.println("Clone failed");
        }

        // Delete test
        System.out.println();
        System.out.println("Trying to delete customer 100:");
        cinema.deleteCustomer(100);

        // Return booking then delete again
        System.out.println();
        cinema.returnFirstBookingWithFine(100, "2025-01-05", 3);

        System.out.println();
        System.out.println("Trying to delete customer 100 again:");
        cinema.deleteCustomer(100);
    }
}
