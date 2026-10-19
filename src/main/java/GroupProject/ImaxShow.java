/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

/**
 * Represents an IMAX show with special screen and sound system.
 */
public class ImaxShow extends Show implements Borrowable {

    /** IMAX screen size description. */
    private String screenSize;

    /** IMAX sound system type. */
    private String soundSystem;
    
    private int capacity = 60;
    private int bookedCount = 0;


    /** Default constructor. */
    public ImaxShow() {
        super();
    }

    /**
     * Creates an IMAX show.
     *
     * @param title       show title
     * @param showId      unique ID
     * @param available   availability
     * @param screenSize  screen type
     * @param soundSystem sound system description
     */
    public ImaxShow(String title, Integer showId, boolean available,
                    String screenSize, String soundSystem) {

        super(title, showId, available);
        this.screenSize = screenSize;
        this.soundSystem = soundSystem;
    }

    // Getters and setters
    public String getScreenSize() { return screenSize; }
    public void setScreenSize(String screenSize) { this.screenSize = screenSize; }

    public String getSoundSystem() { return soundSystem; }
    public void setSoundSystem(String soundSystem) { this.soundSystem = soundSystem; }

    /**
     * Books the show if available.
     *
     * @param customer booking customer
     */
    @Override
    public void checkOut(Customer customer) {
    if (bookedCount >= capacity)
        throw new IllegalStateException("Show is fully booked");
    bookedCount++;
   }


    /**
     * Returns the show.
     *
     * @param customer returning customer
     */
    @Override
    public void checkIn(Customer customer) {
        setAvailable(true);
    }

    /** Displays IMAX details. */
    @Override
    public void displayDetails() {
        System.out.println("IMAX Show:");
        System.out.println("Title: " + getTitle());
        System.out.println("ID: " + getShowId());
        System.out.println("Available: " + isAvailable());
        System.out.println("Screen: " + screenSize);
        System.out.println("Sound: " + soundSystem);
        System.out.println();
    }
}
