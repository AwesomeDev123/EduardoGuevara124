package spring.sfgapp.services;
import spring.sfgapp.entity.User;
import java.util.List;
public interface UserService extends CrudService<User, Long> {
    List<User> lFindAll();
    List<User> lfindById(String Id);
}

