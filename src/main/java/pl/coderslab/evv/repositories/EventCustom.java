package pl.coderslab.evv.repositories;

import pl.coderslab.evv.entity.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventCustom {

//    public List<Event> eventsGreaterThanToday(LocalDate date);
    public Event findByIdWithAuthors(long id);

}