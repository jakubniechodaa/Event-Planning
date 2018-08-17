package pl.coderslab.evv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.Artist;
import pl.coderslab.evv.entity.Role;

@Repository
public	interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(String name);
}
