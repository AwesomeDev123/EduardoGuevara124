package spring.sfgapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.AppMod;

import java.util.List;

public interface AppModRepository extends CrudRepository<AppMod, Long> {
    public List<AppMod> findByAppModName(String modName);
    public List<AppMod> findByAppModNameAndAppModIndex(String modName,String modIndex);
}

