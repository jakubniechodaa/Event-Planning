package pl.coderslab.evv.repositories;

import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.Event;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Repository
public	class EventRepositoryImpl implements EventCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Event findByIdWithAuthors(long id){
        Event event = entityManager.find(Event.class, id);
        Hibernate.initialize(event.getArtists());
        return event;
        //jednak nie uzywam, bo cos nie dziala. zrobilem @ManyToMany (fetch = FetchType.EAGER)
    }

}
