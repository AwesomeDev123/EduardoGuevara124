package spring.sfgapp.services;
import spring.sfgapp.response.UserResponseRest;

/**
 * Created by jt on 7/21/18.
 */
public interface CrudResponseService<T, ID> {

    UserResponseRest findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
