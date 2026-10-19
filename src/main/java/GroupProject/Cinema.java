/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Represents the cinema management system.
 * Stores shows and customers and handles booking operations.
 */
public class Cinema {

    /** List of all shows. */
    private final ArrayList<Show> catalog;

    /** Sorted set of customers. */
    private final TreeSet<Customer> customers;

    /** Default constructor. */
    public Cinema() {
        catalog = new ArrayList<>();
        customers = new TreeSet<>();
    }

    /**
     * Adds a new show to the cinema.
     *
     * @param show the show to add
     */
    public void addShow(Show show) {
        if (show != null) catalog.add(show);
    }

    /**
     * Adds a new customer.
     *
     * @param customer the customer to add
     */
    public void addCustomer(Customer customer) {
        if (customer != null) customers.add(customer);
    }

    /**
     * Finds a show by ID.
     *
     * @param showId show ID
     * @return the show
     * @throws ShowNotFoundException if not found
     */
    public Show findShowById(Integer showId) throws ShowNotFoundException {
        if (showId == null) throw new NullPointerException("Show id is null");

        for (Show s : catalog) {
            if (showId.equals(s.getShowId())) return s;
        }

        throw new ShowNotFoundException("Show with id " + showId + " not found");
    }

    /**
     * Finds a customer by ID.
     *
     * @param customerId customer ID
     * @return customer or null
     */
    public Customer findCustomerById(Integer customerId) {
        if (customerId == null) throw new NullPointerException("Customer id is null");

        for (Customer c : customers) {
            if (customerId.equals(c.getCustomerId())) return c;
        }

        return null;
    }

    /**
     * Books a show for a customer.
     *
     * @param showId       show ID
     * @param customerId   customer ID
     * @param seatNumber   seat number
     * @param dateBooked start date
     * @param dueDate      due date
     */
    public void bookShow(Integer showId,
                     Integer customerId,
                     String seatNumber,
                     String dateBorrowed,
                     String dueDate) {

    Show show = null;
    Customer customer = null;

    try {
        show = findShowById(showId);         // هنا ممكن يرمي خطأ
        customer = findCustomerById(customerId);

        if (customer == null)
            throw new NullPointerException("Customer not found");

        if (!(show instanceof Borrowable))
            throw new IllegalStateException("This show cannot be booked");

        Borrowable b = (Borrowable) show;
        b.checkOut(customer);                // لو فشل → يروح catch مباشرة

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        return;                              // أهم سطر → يمنع إضافة حجز فاشل
    }

    // إذا وصلنا هنا: معناها كل شيء نجح
    Booking booking = new Booking(customer, show, seatNumber, dateBorrowed, dueDate);
    customer.addBooking(booking);

    System.out.println("Booking created successfully:");
    System.out.println(booking);
}



    /**
     * Prints all bookings for a customer.
     *
     * @param customerId customer ID
     */
    public void printCustomerBookings(Integer customerId) {
        Customer c;

        try {
            c = findCustomerById(customerId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (c == null) {
            System.out.println("Customer not found");
            return;
        }

        System.out.println("Bookings for customer: " + c.getName());
        for (Booking b : c.getBookings()) System.out.println(b);
    }

    /** Sorts all shows by title. */
    public void sortShowsByTitle() {
        Collections.sort(catalog);
    }

    /** Prints all shows. */
    public void printAllShows() {
        System.out.println("Cinema catalog:");
        for (Show s : catalog) System.out.println(s);
    }

    /**
     * Deletes a customer if they have no active bookings.
     *
     * @param customerId customer ID
     * @return true if deleted
     */
    public boolean deleteCustomer(Integer customerId) {
        Customer customer;

        try {
            customer = findCustomerById(customerId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

        if (customer == null) {
            System.out.println("Customer not found");
            return false;
        }

        if (customer.hasActiveBookings()) {
            System.out.println("Cannot delete customer with active bookings");
            return false;
        }

        boolean removed = customers.remove(customer);
        if (removed) System.out.println("Customer deleted successfully");

        return removed;
    }

    /**
     * Returns the first active/late booking and calculates fine.
     *
     * @param customerId customer ID
     * @param returnDate actual return date
     * @param daysLate   late days
     */
    public void returnFirstBookingWithFine(Integer customerId,
                                           String returnDate,
                                           int daysLate) {

        Customer customer;

        try {
            customer = findCustomerById(customerId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        Booking target = null;
        for (Booking b : customer.getBookings()) {
            if ("ACTIVE".equalsIgnoreCase(b.getStatus()) ||
                "LATE".equalsIgnoreCase(b.getStatus())) {
                target = b;
                break;
            }
        }

        if (target == null) {
            System.out.println("No active bookings");
            return;
        }

        target.returnBooking(returnDate, daysLate);
        System.out.println("Booking returned. Fine = " + target.getFine());
    }
}
