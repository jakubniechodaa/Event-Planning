package pl.coderslab.evv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.evv.entity.*;
import pl.coderslab.evv.repositories.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;


@Controller
@RequestMapping("/venue")
public class VenueController {

    private final CityRepository cityRepository;
    private final VenueRepository venueRepository;

    @Autowired
    public VenueController(CityRepository cityRepository, VenueRepository venueRepository) {
        this.cityRepository = cityRepository;
        this.venueRepository = venueRepository;
    }

    @Autowired
    Validator validator;

    @ModelAttribute("cities")
    public List<City> getCities(){
        return cityRepository.findAll();
    }

    @RequestMapping(value = "/all")
    public String showAll(Model model) {
        List<Venue> venues = venueRepository.findAll();

        model.addAttribute("venues", venues);

        return "places/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Venue venue = new Venue();
        model.addAttribute("venue", venue);
        return "places/form";
    }

    @PostMapping("/added")
    public String processForm(@Valid Venue venue, BindingResult result, Model model) {
        model.addAttribute("venue", venue);
        if (result.hasErrors()) {
            return "places/form";
        }
        venueRepository.save(venue);
        return "places/added";
    }



}
