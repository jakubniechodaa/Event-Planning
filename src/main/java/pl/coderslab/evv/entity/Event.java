package pl.coderslab.evv.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 2)
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @NotNull
    private List<Artist> artists;

    @ManyToOne
    @NotNull
    private Venue venue;

    @NotNull
    @ManyToOne
    private Type type;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @NotNull
    private List<Genre> genres;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date date;
    private Date till;


//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany
//    @NotNull
//    private List<Comment> comments;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return String.format("event name: %s, venue: %s, date: %s, type: %s ", name, getVenue(), date, getType());
    }
}
