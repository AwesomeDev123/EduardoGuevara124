package spring.sfgapp.map;

import spring.sfgapp.entity.AppOpt;
import spring.sfgapp.services.CrudService;

import java.util.List;
import java.util.Set;

public class OptionMapService extends AbstractMapService<AppOpt,Long> implements CrudService<AppOpt, Long> {


    @Override
    public Set<AppOpt> findAll() {
        return null;
    }

    @Override
    public List<AppOpt> lfindAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(AppOpt object) {

    }

    @Override
    public AppOpt save(AppOpt object) {
        return null;
    }

    @Override
    public AppOpt findById(Long id ) {
        return null;
    }
}
