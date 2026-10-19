/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

import java.util.ArrayList;

/**
 * Represents a customer registered in the cinema system.
 * Each customer can have multiple bookings.
 */
public class Customer implements Cloneable, Comparable<Customer> {

    /** Unique customer ID. */
    private Integer customerId;

    /** Customer name. */
    private String name;

    /** List of all bookings made by the customer. */
    private ArrayList<Booking> bookings;

    /** Default constructor. */
    public Customer() {
        bookings = new ArrayList<>();
    }

    /**
     * Creates a customer with an id and name.
     *
     * @param customerId unique ID
     * @param name       customer name
     */
    public Customer(Integer customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    // Getters and setters
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Booking> getBookings() { return bookings; }

    /**
     * Adds a booking to the customer's list.
     *
     * @param booking the booking to add
     */
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    /**
     * Checks if the customer has any active or late bookings.
     *
     * @return true if active or late bookings exist
     */
    public boolean hasActiveBookings() {
        for (Booking b : bookings) {
            if ("ACTIVE".equalsIgnoreCase(b.getStatus()) ||
                "LATE".equalsIgnoreCase(b.getStatus())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a shallow copy of the customer object.
     *
     * @return a cloned customer
     */
    @Override
    public Object clone() {
        try {
            Customer copy = (Customer) super.clone();
            copy.bookings = new ArrayList<>(this.bookings);
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Compares customers based on IDs.
     *
     * @param other another customer
     * @return comparison result
     */
    @Override
    public int compareTo(Customer other) {
        return this.customerId.compareTo(other.customerId);
    }

    /**
     * Returns a simple string representation.
     *
     * @return text version of the customer
     */
    @Override
    public String toString() {
        return "Customer: id=" + customerId + ", name=" + name;
    }
    
   @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer other = (Customer) o;
    return customerId != null && customerId.equals(other.customerId);
}

@Override
public int hashCode() {
    return customerId != null ? customerId.hashCode() : 0;
}
 
    
}
