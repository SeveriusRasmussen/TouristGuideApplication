package org.example.touristguideapplication.Models;

// part 1: Make attributes for the attractions.
// Attribut -> constructor -> getters
public class TouristAttraction {
    private String name;
    private String description;

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
