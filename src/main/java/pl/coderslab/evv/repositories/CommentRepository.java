package pl.coderslab.evv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.evv.entity.City;
import pl.coderslab.evv.entity.Comment;

import java.util.List;

@Repository
public	interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByEventId(long id);

}
