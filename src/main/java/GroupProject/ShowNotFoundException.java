/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package GroupProject;

/**
 * Exception thrown when a show cannot be found in the catalog.
 */
public class ShowNotFoundException extends Exception {

    /** Default constructor. */
    public ShowNotFoundException() {
        super();
    }

    /**
     * Creates the exception with a custom message.
     *
     * @param message error message
     */
    public ShowNotFoundException(String message) {
        super(message);
    }
}
