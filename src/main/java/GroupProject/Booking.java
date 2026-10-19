/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

/**
 * Represents a booking made by a customer for a show.
 * Stores seat information, dates, status, and late fine.
 */
public class Booking {

    /** The customer who made the booking. */
    private Customer customer;

    /** The show that was booked. */
    private Show show;

    /** Reserved seat number. */
    private String seatNumber;

    /** Date when the booking started. */
    private String dateBooked;

    /** Due date when the booking ends. */
    private String dueDate;

    /** Actual date the show was returned. */
    private String returnDate;

    /** Status of the booking (ACTIVE, RETURNED, LATE, CANCELLED). */
    private String status;

    /** Fine amount if returned late. */
    private Double fine;
    
    private boolean finePaid = false;


    /** Default constructor. */
    public Booking() {}

    /**
     * Creates a new booking with active status.
     *
     * @param customer     the customer making the booking
     * @param show         the booked show
     * @param seatNumber   reserved seat number
     * @param dateBorrowed starting date
     * @param dueDate      due date
     */
    public Booking(Customer customer, Show show,
                   String seatNumber, String dateBorrowed, String dueDate) {

        this.customer = customer;
        this.show = show;
        this.seatNumber = seatNumber;
        this.dateBooked = dateBorrowed;
        this.dueDate = dueDate;
        this.returnDate = null;
        this.status = "ACTIVE";
        this.fine = 0.0;
    }

    // Getters
    public Customer getCustomer() { return customer; }
    public Show getShow() { return show; }
    public String getSeatNumber() { return seatNumber; }
    public String getDateBorrowed() { return dateBooked; }
    public String getDueDate() { return dueDate; }
    public String getReturnDate() { return returnDate; }
    public String getStatus() { return status; }
    public Double getFine() { return fine; }

    /**
     * Returns the booking and updates status.
     *
     * @param returnDate the actual return date
     * @param daysLate   number of late days
     */
    public void returnBooking(String returnDate, int daysLate) {
        this.returnDate = returnDate;

        if (daysLate > 0) {
            this.status = "LATE";
            this.fine = calculateFine(daysLate);
        } else {
            this.status = "RETURNED";
            this.fine = 0.0;
        }
    }

    /** Cancels the booking without any fine. */
    public void cancel() {
        this.status = "CANCELLED";
        this.returnDate = dateBooked;
        this.fine = 0.0;
    }

    /**
     * Calculates the fine for late return.
     *
     * @param daysLate number of days late
     * @return fine value
     */
    public Double calculateFine(int daysLate) {
        Double rate = 10.0;
        return (daysLate > 0) ? daysLate * rate : 0.0;
    }
    
    public void payFine() {
      this.finePaid = true;
      this.status = "RETURNED";
    }


    /**
     * Returns formatted text describing the booking.
     *
     * @return booking details as a string
     */
    @Override
    public String toString() {
        return "Booking{" +
                "customer:" + customer.getName() +
                ", show:" + show.getTitle() +
                ", seat='" + seatNumber + '\'' +
                ", dateBooked='" + dateBooked + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", status='" + status + '\'' +
                ", fine=" + fine +
                '}';
    }
}
