package pl.coderslab.evv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.Event;
import pl.coderslab.evv.entity.User;
import pl.coderslab.evv.entity.Venue;

import java.sql.Date;
import java.util.List;


@Repository
public	interface EventRepository extends JpaRepository<Event, Long>, EventCustom {

    @Query(value = "SELECT * FROM events WHERE date >= CURDATE()  ORDER BY date ASC;", nativeQuery = true)
    List<Event> findAllGreater();

    @Query(value = "SELECT * FROM events WHERE date < CURDATE()  ORDER BY date ASC;", nativeQuery = true)
    List<Event> findPast();
    Event findEventById(long id);
    List <Event> findEventsByVenueId(long id);
    List <Event> findEventsByDate(Date date);
    public void deleteEventById(long id);

}
