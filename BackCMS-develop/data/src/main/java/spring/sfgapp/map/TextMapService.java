package spring.sfgapp.map;

import spring.sfgapp.entity.AppTxt;
import spring.sfgapp.services.CrudService;

import java.util.List;
import java.util.Set;

public class TextMapService extends AbstractMapService<AppTxt,Long> implements CrudService<AppTxt, Long> {
    @Override
    public Set<AppTxt> findAll() {
        return super.findAll();
    }

    @Override
    public List<AppTxt> lfindAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(AppTxt object) {

    }

    @Override
    public AppTxt save(AppTxt object) {
        return super.save(object);
    }

    @Override
    public AppTxt findById(Long id ) {
        return super.findById(id);
    }
}
