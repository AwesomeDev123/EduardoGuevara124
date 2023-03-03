package spring.sfgapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.AppTxt;

import java.util.List;

public interface AppTxtRepository  extends CrudRepository<AppTxt, Long> {
}
