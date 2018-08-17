package pl.coderslab.evv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.evv.entity.City;
import pl.coderslab.evv.entity.Venue;
import pl.coderslab.evv.repositories.CityRepository;
import pl.coderslab.evv.repositories.VenueRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;


@Controller
@RequestMapping("/city")
public class CityController {

    private final CityRepository cityRepository;
    private final VenueRepository venueRepository;

    @Autowired
    public CityController(CityRepository cityRepository, VenueRepository venueRepository) {
        this.cityRepository = cityRepository;
        this.venueRepository = venueRepository;
    }

    @Autowired
    Validator validator;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        City city = new City();
        model.addAttribute("city", city);
        return "cities/form";
    }

    @PostMapping("/added")
    public String processForm(@Valid City city, BindingResult result, Model model) {
        model.addAttribute("city", city);
        if (result.hasErrors()) {
            return "cities/form";
        }
        cityRepository.save(city);
        return "cities/addedcity";
    }


}
