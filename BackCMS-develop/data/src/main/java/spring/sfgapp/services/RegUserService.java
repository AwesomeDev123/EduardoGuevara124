package spring.sfgapp.services;
import spring.sfgapp.entity.RegUser;
import java.util.List;
public interface RegUserService extends CrudService<RegUser,Long> {
    List<RegUser> findByIdUser(String id);
}
