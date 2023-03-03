package spring.sfgapp.repositories;
import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.AppImg;

import java.util.List;

public interface AppImgRepository extends CrudRepository<AppImg,Long> {
}
