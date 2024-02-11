package org.example.touristguideapplication.Services;

import org.example.touristguideapplication.Models.TouristAttraction;
import org.example.touristguideapplication.Repositories.TouristResository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
part 3: Make a 'Service' class
The service class is like controller but not in Spring Boot application.
The spring boot has their own controller which is the part 4.
The methods are like the Repository class, just simpler for the controller to use.
*/
@Service
public class TouristService {
    TouristResository touristResository = new TouristResository();

    public List<TouristAttraction> getAttractions() {
        return touristResository.getAttractions();
    }

    public TouristAttraction getAttractionWithName(String name) {
        return touristResository.getAttractionsWithName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return touristResository.addAttraction(attraction);
    }

    public TouristAttraction changeAttraction(TouristAttraction attraction) {
        return touristResository.changeAttraction(attraction);
    }

    public TouristAttraction deleteAttraction(String name) {
        return touristResository.deleteAttraction(name);
    }
}
