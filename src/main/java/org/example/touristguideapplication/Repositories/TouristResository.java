package org.example.touristguideapplication.Repositories;

import org.example.touristguideapplication.Models.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// part 2: make use of the attraction attributes by making an ArrayList.
// Make getters and methods for the attraction list.
// methods: add, change, delete method.
@Repository
public class TouristResository {
    private List<TouristAttraction> attractions;

    // Make some attractions using the arrayList.
    public TouristResository() {
        attractions = new ArrayList<>(List.of(
                new TouristAttraction("The Glyptotek", "Paintings and Sculptures"),
                new TouristAttraction("WW2 Museum", "Old Weapons and Uniforms"),
                new TouristAttraction("Zoological Museum", "Animal Skeletons and Nature History"),
                new TouristAttraction("Botanical Garden", "Plants and Flowers for scientific research")
        ));
    }

    // Make getter for the ArrayList
    public List<TouristAttraction> getAttractions() {
        return attractions;
    }

    // Make getter for the name of an attraction
    public TouristAttraction getAttractionsWithName(String name) {
        for (TouristAttraction attName: attractions) {
            if (attName.getName().equalsIgnoreCase(name)) {
                return attName;
            }
        }
        return null;
    }

    // Make an add method for attraction
    public TouristAttraction addAttraction(TouristAttraction attraction) {
        for (TouristAttraction att: attractions) {
            if (att.getName().equalsIgnoreCase(attraction.getName())) {
                return null;
            }
        }
        attractions.add(attraction);
        return attraction;
    }

    // Make a change method for attraction
    public TouristAttraction changeAttraction(TouristAttraction attraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(attraction.getName())){
                attractions.set(i,attraction);
                return attraction;
            }
        }
        return null;
    }

    // Make a delete method for attraction
    public TouristAttraction deleteAttraction(String name) {
        TouristAttraction returnAttraction = null;
        for (TouristAttraction att: attractions) {
            if (att.getName().equalsIgnoreCase(name)){
                returnAttraction = att;
            }
        }
        if (returnAttraction != null){
            attractions.remove(returnAttraction);
        }
        return returnAttraction;
    }
}
