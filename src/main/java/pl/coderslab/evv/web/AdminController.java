package pl.coderslab.evv.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.evv.entity.*;
import pl.coderslab.evv.repositories.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final ArtistRepository artistRepository;
    private final EventRepository eventRepository;
    private final GenreRepository genreRepository;
    private final VenueRepository venueRepository;
    private final TypeRepository typeRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public AdminController(UserRepository userRepository, ArtistRepository artistRepository, EventRepository eventRepository, GenreRepository genreRepository, VenueRepository venueRepository, TypeRepository typeRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.artistRepository = artistRepository;
        this.eventRepository = eventRepository;
        this.genreRepository = genreRepository;
        this.venueRepository = venueRepository;
        this.typeRepository = typeRepository;
        this.commentRepository = commentRepository;
    }



    @Autowired
    Validator validator;

    @ModelAttribute("artists")
    public List<Artist> getArtists(){
        return artistRepository.findAll();
    }

    @ModelAttribute("genres")
    public List<Genre> getGenres(){return genreRepository.findAll();}

    @ModelAttribute("venues")
    public List<Venue> getVenues(){
        return venueRepository.findAll();
    }

    @ModelAttribute("types")
    public List<Type> getTypes(){
        return typeRepository.findAll();
    }

    @ModelAttribute("futureEvents")
    public List<Event> getGreaterEvents(){
        return eventRepository.findAllGreater();
    }

    @RequestMapping("/events")
    public String allEvents(Model model) {

        return "admin/eventstoedit";
    }

    @RequestMapping("/panel")
    public String panel(Model model) {

        return "admin/panel";
    }
    @GetMapping("/eventedit/{id}")
    public String editEvents(@PathVariable long id, Model model) {
        Event event = eventRepository.findEventById(id);
        model.addAttribute("event", event);
        return "admin/eventedit";
    }

    @PostMapping("/eventedited/{id}")
    public String processForm(@PathVariable long id, @Valid Event event, BindingResult result, Model model) {
        model.addAttribute("event", event);
        if (result.hasErrors()) {
            return "admin/eventedit";
        }
        System.out.println(event.getDate());
        eventRepository.save(event);
        return "admin/edited";
    }
    @GetMapping("/eventdelete/{id}")
    public String deleteEvents(@PathVariable long id, Model model) {
        Event event = eventRepository.findEventById(id);
        eventRepository.delete(event);
        return "redirect:/admin/events";
    }
}
