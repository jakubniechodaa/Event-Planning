package pl.coderslab.evv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.evv.entity.Artist;
import pl.coderslab.evv.entity.City;
import pl.coderslab.evv.repositories.ArtistRepository;
import pl.coderslab.evv.repositories.CityRepository;
import pl.coderslab.evv.repositories.VenueRepository;

import javax.validation.Valid;
import javax.validation.Validator;


@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Autowired
    Validator validator;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "artists/form";
    }

    @PostMapping("/added")
    public String processForm(@Valid Artist artist, BindingResult result, Model model) {
        model.addAttribute("artist", artist);
        if (result.hasErrors()) {
            return "artists/form";
        }
        artistRepository.save(artist);
        return "artists/added";
    }


}
