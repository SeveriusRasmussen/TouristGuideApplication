package org.example.touristguideapplication.Controllers;

import org.example.touristguideapplication.Models.TouristAttraction;
import org.example.touristguideapplication.Services.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*; // * er for både RequestMapping og GetMapping

import java.util.List;

// Part 4: make the controller for the application
/*
Those @GetMapping's are for the application
so the browser can enter the address
Ex. localhost:8080 is the
*/
@Controller
@RequestMapping("Attractions")
public class TouristController {
    TouristService touristService = new TouristService();

    /*private TouristService touristService;

    public TouristSerController(TouristService touristService) {
        this.touristService = touristService;
    }*/

    @GetMapping("") //context root
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> attractionList = touristService.getAttractions();
        return new ResponseEntity<>(attractionList, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getAttraction(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.getAttractionWithName(name);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Does","Not Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction){
        TouristAttraction touristAttraction = touristService.addAttraction(attraction);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Attraction","Already Exists"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<TouristAttraction> changeAttraction(@RequestBody TouristAttraction attraction){
        TouristAttraction touristAttraction = touristService.changeAttraction(attraction);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Does","Not Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @GetMapping("delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.deleteAttraction(name);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Does","Not Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }
}
