package spring.sfgapp.springdatajpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.sfgapp.entity.User;
import spring.sfgapp.services.UserService;
import spring.sfgapp.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class UserSDJpaService implements UserService {
    private final UserRepository userRepository;
    public UserSDJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private static final Logger log = LoggerFactory.getLogger(UserSDJpaService.class);
    @Override
    public Set<User> findAll() {
        Set<User> userHashSet = new HashSet<>();
        userRepository.findAll().forEach(userHashSet::add);
        return userHashSet;
    }
    @Override
    public List<User> lfindAll() {
        return null;
    }
    @Override
    public List<User> lFindAll() {
        List<User> userListSet = new ArrayList<>();
        userRepository.findAll().forEach(userListSet::add);
        return userListSet;
    }
    @Override
    public List<User> lfindById(String Id) {
        return null;
    }
    @Transactional(readOnly=true)
    @Override
    public User findById(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }
    @Override
    public User save(User object) {
        return userRepository.save(object);
    }
    @Override
    public void delete(User object) { userRepository.delete(object); }
    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong); }

}


/*    @Override
    public Set<User> findAll() {
        Set<User> userHashSet = new HashSet<>();
        userRepository.findAll().forEach(userHashSet::add);
        return userHashSet;
    }*/
 /*      public UserResponseRest findAll() {
        log.info("Inicio metodo Buscar Todos Usuarios");
        UserResponseRest userResponseRest = new UserResponseRest();
        Set<User> userHashSet = new HashSet<>();

        try {
            userRepository.findAll().forEach(userHashSet::add);
            userResponseRest.getUserResponse().setUser(userHashSet);
            userResponseRest.setMetadata("Respuesta OK","000","Respuesta Exitosa");
        } catch (Exception e){
            userResponseRest.setMetadata("Respuesta NOT OK","100","Respuesta NO Exitosa");
            log.error("Error al consultar usuarios:",e.getMessage());
            e.getStackTrace();
        }

        return userResponseRest;
    }*/