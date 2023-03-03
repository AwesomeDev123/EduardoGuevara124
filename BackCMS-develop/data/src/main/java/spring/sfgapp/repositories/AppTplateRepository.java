package spring.sfgapp.repositories;
import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.AppTplate;

import java.util.List;

public interface AppTplateRepository extends CrudRepository<AppTplate, Long> {
}

