package pl.coderslab.evv.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.evv.entity.Artist;
import pl.coderslab.evv.entity.Event;
import pl.coderslab.evv.entity.Venue;
import pl.coderslab.evv.repositories.EventRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private final EventRepository eventRepository;

    @Autowired
    public MainController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @ModelAttribute("futureEvents")
    public List<Event> getGreaterEvents(){
        return eventRepository.findAllGreater();
    }

    @RequestMapping("/")
    public String main(Model model) {
        //model.addAttribute("eventz",)
        return "index";
    }

    @RequestMapping("/allupcomming")
    public String mainallevents(Model model) {

        return "index2";
    }
}
