package pl.coderslab.evv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.Genre;
import pl.coderslab.evv.entity.Type;

@Repository
public	interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
