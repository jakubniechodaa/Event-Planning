package pl.coderslab.evv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.User;


@Repository
public	interface	UserRepository	extends	JpaRepository<User,	Long>	{
    User findByUsername (String username);
}
