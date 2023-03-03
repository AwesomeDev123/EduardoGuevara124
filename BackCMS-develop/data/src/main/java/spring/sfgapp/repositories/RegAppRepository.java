package spring.sfgapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.RegApp;
import spring.sfgapp.entity.RegUser;

import java.util.List;

public interface RegAppRepository extends CrudRepository<RegApp,Long> {
}
