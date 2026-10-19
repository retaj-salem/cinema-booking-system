/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

/**
 * Represents items that can be booked and returned.
 */
public interface Borrowable {

    /**
     * Books the show for a customer.
     *
     * @param customer the customer who is booking
     * @throws IllegalStateException if the show is not available
     */
    void checkOut(Customer customer) throws IllegalStateException;

    /**
     * Returns the show for a customer.
     *
     * @param customer the customer returning the show
     */
    void checkIn(Customer customer);
}
