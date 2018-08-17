package pl.coderslab.evv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.City;
import pl.coderslab.evv.entity.Genre;
import pl.coderslab.evv.entity.Venue;

@Repository
public	interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}
