package pl.coderslab.evv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.evv.entity.*;
import pl.coderslab.evv.repositories.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/event")
public class EventController {

    private final UserRepository userRepository;
    private final ArtistRepository artistRepository;
    private final EventRepository eventRepository;
    private final GenreRepository genreRepository;
    private final VenueRepository venueRepository;
    private final TypeRepository typeRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public EventController(UserRepository userRepository, ArtistRepository artistRepository, EventRepository eventRepository, GenreRepository genreRepository, VenueRepository venueRepository, TypeRepository typeRepository, CommentRepository commentRepository) {
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


    @ModelAttribute("pastEvents")
    public List<Event> getPastEvents(){
        return eventRepository.findPast();
    }

    @RequestMapping("/past")
    public String past(Model model) {
        //model.addAttribute("eventz",)
        return "events/past";
    }

    @RequestMapping(value = "/all/{id}")
    public String showAll(@PathVariable long id, Model model) {
        //Venue v = venueRepository.findById(id);
        List<Event> venueEv = eventRepository.findEventsByVenueId(id);
        model.addAttribute("venueEvents", venueEv);
        System.out.println(venueEv);
        return "/events/clubs";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "events/form";
    }

    @PostMapping("/added")
    public String processForm(@Valid Event event, BindingResult result, Model model) {
        model.addAttribute("event", event);
        if (result.hasErrors()) {
            return "events/form";
        }
        System.out.println(event.getDate());
        eventRepository.save(event);
        return "events/added";
    }

    @RequestMapping(value = "/details/{id}")
    public String showDetails(@PathVariable long id, Model model) {
        Event event = eventRepository.findByIdWithAuthors(id);
        model.addAttribute("event", event);
        model.addAttribute("eventVenue", event.getVenue());
        Venue venue = event.getVenue();
        City city = venue.getCity();
        model.addAttribute("city", city);
        model.addAttribute("eventArtists", event.getArtists());
        model.addAttribute("eventGenres", event.getGenres());
        return "events/details";
    }
    @GetMapping(value = "/details/{id}/comments")
    public String showDetailComments(@PathVariable long id, Model model) {
        List<Comment> byId = commentRepository.findCommentsByEventId(id);
        model.addAttribute("commenta", byId);
        Event event = eventRepository.findByIdWithAuthors(id);
        model.addAttribute("event", event);
        model.addAttribute("eventVenue", event.getVenue());
        Venue venue = event.getVenue();
        City city = venue.getCity();
        model.addAttribute("city", city);
        model.addAttribute("eventArtists", event.getArtists());
        model.addAttribute("eventGenres", event.getGenres());

        Comment comment = new Comment();
        model.addAttribute("comment", comment);

        return "events/detailcomment";
    }

    @RequestMapping(value = "/details/{id}/addedcomments", method = {RequestMethod.POST, RequestMethod.GET})
    public String processCommentForm(@Valid Comment comment, BindingResult result, Model model, @PathVariable long id) {
        //model.addAttribute("commenta", comment);
        List<Comment> byId = commentRepository.findCommentsByEventId(id);
        model.addAttribute("commenta", byId);
        if (result.hasErrors()) {
            Event event = eventRepository.findByIdWithAuthors(id);
            model.addAttribute("event", event);
            model.addAttribute("eventVenue", event.getVenue());
            Venue venue = event.getVenue();
            City city = venue.getCity();
            model.addAttribute("city", city);
            model.addAttribute("eventArtists", event.getArtists());
            model.addAttribute("eventGenres", event.getGenres());
            return "events/detailcomment";
        }
        Event event = eventRepository.findByIdWithAuthors(id);
        model.addAttribute("event", event);
        model.addAttribute("eventVenue", event.getVenue());
        Venue venue = event.getVenue();
        City city = venue.getCity();
        model.addAttribute("city", city);
        model.addAttribute("eventArtists", event.getArtists());
        model.addAttribute("eventGenres", event.getGenres());
        commentRepository.save(comment);

        return "events/detailcommentadded";
    }

    @RequestMapping("/today")
    public String processTodayEvents(Model model) {
        List<Event> today = eventRepository.findFromTill();
        model.addAttribute("today", today);

        return "events/today";
    }


}
