package spring.sfgapp.map;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.sfgapp.entity.User;
import spring.sfgapp.services.UserService;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class UserMapService extends AbstractResponseMapService<User, Long> implements UserService {


    @Override
    public void deleteById(Long id) { }
    @Override
    public User save(User object) {
        return super.save(object);
    }
    @Override
    public void delete(User object) { }
    @Override
    public User findById(Long id ) {
        return super.findById(id);
    }
    @Override
    public List<User> lFindAll() {
        return null;
    }
    @Override
    public List<User> lfindById(String Id) {
        return null;
    }

    @Override
    public Set<User> findAll() { return null;  }

    @Override
    public List<User> lfindAll() {
        return null;
    }
}
