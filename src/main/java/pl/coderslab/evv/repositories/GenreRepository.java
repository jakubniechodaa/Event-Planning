package pl.coderslab.evv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.Artist;
import pl.coderslab.evv.entity.Genre;

@Repository
public	interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
