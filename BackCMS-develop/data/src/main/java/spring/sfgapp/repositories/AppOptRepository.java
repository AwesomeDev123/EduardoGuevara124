package spring.sfgapp.repositories;
import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.AppOpt;
import java.util.List;

public interface AppOptRepository extends CrudRepository<AppOpt,Long> {
}
