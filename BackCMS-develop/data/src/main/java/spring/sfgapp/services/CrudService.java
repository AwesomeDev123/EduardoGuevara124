package spring.sfgapp.services;
import java.util.List;
import java.util.Set;

/**
 * Created by jt on 7/21/18.
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    List<T> lfindAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
