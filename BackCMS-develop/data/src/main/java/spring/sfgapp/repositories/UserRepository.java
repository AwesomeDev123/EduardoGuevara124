package spring.sfgapp.repositories;
import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
/*    User findByLastName(String lastName);
    List<User> findAllByLastNameLike(String lastName);
    User<User> findById(Long id);*/
}
