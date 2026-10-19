/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GroupProject;

/**
 * Abstract base class representing any type of show.
 */
public abstract class Show implements Comparable<Show> {

    /** Title of the show. */
    private String title;

    /** Unique show ID. */
    private Integer showId;

    /** Availability status. */
    private boolean available;

    /** Default constructor. */
    public Show() {}

    /**
     * Main constructor.
     *
     * @param title     show title
     * @param showId    show ID
     * @param available availability
     */
    public Show(String title, Integer showId, boolean available) {
        this.title = title;
        this.showId = showId;
        this.available = available;
    }

    /**
     * Copy constructor.
     *
     * @param other another show
     */
    public Show(Show other) {
        this.title = other.title;
        this.showId = other.showId;
        this.available = other.available;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getShowId() { return showId; }
    public void setShowId(Integer showId) { this.showId = showId; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    /**
     * Compares shows alphabetically by title.
     *
     * @param other another show
     * @return comparison result
     */
    @Override
    public int compareTo(Show other) {
        if (other == null) return 1;
        if (title == null) return -1;
        if (other.title == null) return 1;
        return title.compareToIgnoreCase(other.title);
    }

    /**
     * Checks equality based on showId.
     *
     * @param obj another object
     * @return true if IDs match
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Show)) return false;

        Show o = (Show) obj;
        if (this.showId == null || o.showId == null) return false;
        return this.showId.equals(o.showId);
    }

    @Override
    public int hashCode() {
        return (showId == null) ? 0 : showId.hashCode();
    }

    /**
     * Returns string information about the show.
     *
     * @return string text
     */
    @Override
    public String toString() {
        return "Show{title='" + title + "', showId=" + showId +
                ", available=" + available + "}";
    }

    /**
     * Displays full show details.
     */
    public abstract void displayDetails();
}
