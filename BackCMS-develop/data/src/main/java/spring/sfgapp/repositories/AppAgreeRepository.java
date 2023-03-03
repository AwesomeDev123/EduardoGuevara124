package spring.sfgapp.repositories;
import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.AppAgree;
import java.util.List;

public interface AppAgreeRepository  extends CrudRepository<AppAgree,Long> {
}
