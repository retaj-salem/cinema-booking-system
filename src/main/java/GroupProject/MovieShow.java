/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

/**
 * Represents a standard movie show.
 */
public class MovieShow extends Show implements Borrowable {

    /** Movie type (2D, 3D, etc.). */
    private String movieType;

    /** Duration in minutes. */
    private int durationMinutes;
    
    private int capacity = 60;
    private int bookedCount = 0;


    /** Default constructor. */
    public MovieShow() {
        super();
    }

    /**
     * Creates a movie show.
     *
     * @param title            movie title
     * @param showId           unique ID
     * @param available        availability
     * @param movieType        type (2D/3D)
     * @param durationMinutes  duration in minutes
     */
    public MovieShow(String title, Integer showId, boolean available,
                     String movieType, int durationMinutes) {

        super(title, showId, available);
        this.movieType = movieType;
        this.durationMinutes = durationMinutes;
    }

    // Getters and setters
    public String getMovieType() { return movieType; }
    public void setMovieType(String movieType) { this.movieType = movieType; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    /**
     * Books the movie if available.
     *
     * @param customer customer booking the show
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
     * @param customer customer returning
     */
    @Override
    public void checkIn(Customer customer) {
        setAvailable(true);
    }

    /** Displays full movie details. */
    @Override
    public void displayDetails() {
        System.out.println("Movie Show:");
        System.out.println("Title: " + getTitle());
        System.out.println("ID: " + getShowId());
        System.out.println("Available: " + isAvailable());
        System.out.println("Type: " + movieType);
        System.out.println("Duration: " + durationMinutes);
        System.out.println();
    }
}
